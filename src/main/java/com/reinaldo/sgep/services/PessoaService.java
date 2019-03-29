package com.reinaldo.sgep.services;

import com.reinaldo.sgep.domain.Pessoa;
import com.reinaldo.sgep.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscar(Integer id){
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.orElse(null);
    }
}
