/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.entidade;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author maria.sousa9
 */
@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Fornecedor extends Pessoa {

    private String cnpj;
    private String inscricaoEstadual;

    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String inscricaoEstadual, String nome, String email, String telefone) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }


}
