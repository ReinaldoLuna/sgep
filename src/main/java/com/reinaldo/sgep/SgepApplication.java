package com.reinaldo.sgep;

import com.reinaldo.sgep.domain.ExperienciaProfissional;
import com.reinaldo.sgep.domain.Pessoa;
import com.reinaldo.sgep.repositories.ExperienciaProfissionalRepository;
import com.reinaldo.sgep.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SgepApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository categoriaRepository;

    @Autowired
    private ExperienciaProfissionalRepository experienciaProfissionalRepository;

    public static void main(String[] args) {
        SpringApplication.run(SgepApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa(null, "Reinaldo", "25/08/1992", "lunajf18@gmail.com");
        Pessoa p2 = new Pessoa(null, "Maria", "12/01/1990", "maria@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana", "19/12/1999", "ana@gmail.com");
        Pessoa p4 = new Pessoa(null, "Carlos", "29/05/1979", "carlos@gmail.com");
        Pessoa p5 = new Pessoa(null, "Marcia", "21/07/2002", "marcia@gmail.com");
        Pessoa p6 = new Pessoa(null, "Carolina", "01/03/1988", "carolina@gmail.com");
        Pessoa p7 = new Pessoa(null, "André", "22/09/1995", "andre@gmail.com");
        Pessoa p8 = new Pessoa(null, "Jorge", "07/02/1970", "jorge@gmail.com");

        ExperienciaProfissional e1 = new ExperienciaProfissional(null, "Bahamas", "Caixa", p1);
        ExperienciaProfissional e2 = new ExperienciaProfissional(null, "Almaviva", "Representante de atendimento", p2);
        ExperienciaProfissional e3 = new ExperienciaProfissional(null, "Lojas Americanas", "Estoquista", p1);
        ExperienciaProfissional e4 = new ExperienciaProfissional(null, "C&A", "Caixa", p1);
        ExperienciaProfissional e5 = new ExperienciaProfissional(null, "Santa Casa", "Enfermeira", p2);
        ExperienciaProfissional e6 = new ExperienciaProfissional(null, "Santa Casa", "Enfermeira chefe", p2);
        ExperienciaProfissional e7 = new ExperienciaProfissional(null, "Magazine Luiza", "Gerente", p1);

        p1.getExperienciasProfissionais().addAll(Arrays.asList(e1,e3,e4,e7));
        p2.getExperienciasProfissionais().addAll(Arrays.asList(e2,e5,e6));

        categoriaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
        experienciaProfissionalRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7));
    }
}
