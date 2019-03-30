package com.reinaldo.sgep.services;

import com.reinaldo.sgep.domain.Pessoa;
import com.reinaldo.sgep.repositories.PessoaRepository;
import com.reinaldo.sgep.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa find(Integer id){
        Optional<Pessoa> obj = pessoaRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
        + ", Tipo: " + Pessoa.class.getName()));

    }

    public Pessoa insert(Pessoa obj){
        obj.setId(null);
        return pessoaRepository.save(obj);
    }

}
