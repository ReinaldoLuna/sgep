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

        Pessoa p1 = new Pessoa(null, "Reinaldo", 1992, "lunajf18@gmail.com");
        Pessoa p2 = new Pessoa(null, "Maria", 1980, "maria@gmail.com");

        ExperienciaProfissional e1 = new ExperienciaProfissional(null, "Bahamas", "Caixa", p1);
        ExperienciaProfissional e2 = new ExperienciaProfissional(null, "Almaviva", "Representante de atendimento", p2);
        ExperienciaProfissional e3 = new ExperienciaProfissional(null, "Lojas Americanas", "Estoquista", p1);
        ExperienciaProfissional e4 = new ExperienciaProfissional(null, "C&A", "Caixa", p1);
        ExperienciaProfissional e5 = new ExperienciaProfissional(null, "Santa Casa", "Enfermeira", p2);
        ExperienciaProfissional e6 = new ExperienciaProfissional(null, "Santa Casa", "Enfermeira chefe", p2);
        ExperienciaProfissional e7 = new ExperienciaProfissional(null, "Magazine Luiza", "Gerente", p1);

        p1.getExperienciasProfissionais().addAll(Arrays.asList(e1,e3,e4,e7));
        p2.getExperienciasProfissionais().addAll(Arrays.asList(e2,e5,e6));

        categoriaRepository.saveAll(Arrays.asList(p1, p2));
        experienciaProfissionalRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7));
    }
}
