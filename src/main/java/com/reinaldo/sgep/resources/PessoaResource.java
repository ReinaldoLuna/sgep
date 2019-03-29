package com.reinaldo.sgep.resources;

import com.reinaldo.sgep.domain.Pessoa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> listar() {

        Pessoa p1 = new Pessoa(1, "Reinaldo", 1992, "lunajf18@gmail.com");
        Pessoa p2 = new Pessoa(2, "Maria", 1966, "maria@gmail.com");

        List<Pessoa> lista = new ArrayList<>();

        lista.add(p1);
        lista.add(p2);

        return lista;
    }

}
