package com.reinaldo.sgep.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nome;
    private String data_nascimento;
    private String email;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<ExperienciaProfissional> experienciasProfissionais = new ArrayList<>();

    public Pessoa(){
    }

    public Pessoa(Integer id, String nome, String data_nascimento, String email) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
