package com.reinaldo.sgep.dto;

import com.reinaldo.sgep.domain.Pessoa;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class PessoaDTO implements Serializable {

    private Integer id ;

    @NotEmpty(message = "O nome é obrigatório")
    @Length(min=4, max = 80, message = "O nome deve conter entre 4 e 80 caracteres")
    private String nome;

    private String data_nascimento;
    private String email;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.data_nascimento = pessoa.getData_nascimento();
        this.email = pessoa.getEmail();
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
}
