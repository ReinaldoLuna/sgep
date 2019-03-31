package com.reinaldo.sgep.services;

import com.reinaldo.sgep.domain.Pessoa;
import com.reinaldo.sgep.dto.PessoaDTO;
import com.reinaldo.sgep.repositories.PessoaRepository;
import com.reinaldo.sgep.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + ", Tipo: " + Pessoa.class.getName()));

    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return pessoaRepository.save(obj);
    }

    public Pessoa update(Pessoa obj) {
        Pessoa newObj = this.find(obj.getId());
        this.updateData(newObj, obj);
        return pessoaRepository.save(obj);
    }

    public void delete(Integer id) {
        this.find(id);
        pessoaRepository.deleteById(id);
    }

    public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return pessoaRepository.findAll(pageRequest);
    }


    public Pessoa fromDTO(PessoaDTO objDto) {
        return new Pessoa(objDto.getId(), objDto.getNome(), objDto.getData_nascimento(), objDto.getEmail());
    }

    private void updateData(Pessoa newObj, Pessoa obj) {
        newObj.setNome(obj.getNome());
        newObj.setData_nascimento(obj.getData_nascimento());
        newObj.setEmail(obj.getEmail());
    }

}
