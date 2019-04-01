package com.reinaldo.sgep.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ExperienciaProfissionalDTO implements Serializable {

    @NotEmpty(message = "Campo obrigatorio")
    private String empresa;

    @NotEmpty(message = "Campo obrigatorio")
    private String atividades;

   @NotNull(message = "Este campo não pode ser nulo")
    private Integer pessoa_id;


    public ExperienciaProfissionalDTO(String empresa, String atividades, Integer pessoa_id) {
        this.empresa = empresa;
        this.atividades = atividades;
        this.pessoa_id = pessoa_id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public Integer getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Integer id_pessoa) {
        this.pessoa_id = id_pessoa;
    }
}
