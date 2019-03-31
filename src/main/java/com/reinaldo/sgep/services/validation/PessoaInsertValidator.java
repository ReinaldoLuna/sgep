package com.reinaldo.sgep.services.validation;

import com.reinaldo.sgep.domain.Pessoa;
import com.reinaldo.sgep.dto.PessoaDTO;
import com.reinaldo.sgep.repositories.PessoaRepository;
import com.reinaldo.sgep.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert, PessoaDTO> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void initialize(PessoaInsert ann) {
    }

    @Override
    public boolean isValid(PessoaDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Pessoa aux = pessoaRepository.findByEmail(objDto.getEmail());

        if (aux != null) {
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}