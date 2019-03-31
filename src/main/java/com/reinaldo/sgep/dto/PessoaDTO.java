package com.reinaldo.sgep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reinaldo.sgep.domain.Pessoa;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class PessoaDTO implements Serializable {

    private Integer id ;

    @NotEmpty(message = "O nome é obrigatório")
    @Length(min=4, max = 80, message = "O nome deve conter entre 4 e 80 caracteres")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
