package com.reinaldo.sgep.services;

import com.reinaldo.sgep.domain.ExperienciaProfissional;
import com.reinaldo.sgep.domain.Pessoa;
import com.reinaldo.sgep.dto.ExperienciaProfissionalDTO;
import com.reinaldo.sgep.repositories.ExperienciaProfissionalRepository;
import com.reinaldo.sgep.repositories.PessoaRepository;
import com.reinaldo.sgep.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaProfissionalService {

    @Autowired
    private ExperienciaProfissionalRepository repository;

    @Autowired
    private PessoaService pessoaService;

    public ExperienciaProfissional find(Integer id) {
        Optional<ExperienciaProfissional> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + ", Tipo: " + ExperienciaProfissional.class.getName()));

    }

    public List<ExperienciaProfissional> findAll() {
        return repository.findAll();
    }

    @Transactional
    public ExperienciaProfissional insert(ExperienciaProfissional obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public ExperienciaProfissional update(ExperienciaProfissional obj) {
        ExperienciaProfissional newObj = this.find(obj.getId());
        this.updateData(newObj, obj);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.find(id);
        repository.deleteById(id);
    }

    private void updateData(ExperienciaProfissional newObj, ExperienciaProfissional obj) {
        newObj.setEmpresa(obj.getEmpresa());
        newObj.setAtividades(obj.getAtividades());
        newObj.setPessoa(obj.getPessoa());
    }

    public ExperienciaProfissional fromDTO(ExperienciaProfissionalDTO objDto) {
        Pessoa pessoa = pessoaService.find(objDto.getPessoa_id());
        ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional(null, objDto.getEmpresa(), objDto.getAtividades(), pessoa);
        return experienciaProfissional;
    }

}
