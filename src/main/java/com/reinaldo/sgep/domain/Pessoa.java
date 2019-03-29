package com.reinaldo.sgep.domain;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id ;
    private String nome;
    private Integer data_nascimento;
    private String email;

    public Pessoa(){
    }

    public Pessoa(Integer id, String nome, Integer data_nascimento, String email) {
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

    public Integer getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Integer data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
