/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbfornecedor")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String nome;
    private EstadosEnum estados;
    private boolean habilitado;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private BigInteger telefone;
    private BigInteger telefoneDois;
    @Column(unique = true)
    @Email
    private String email;
    @Column(unique = true)
    private String cnpj;
    private String razaoSocial;
    private String complemento;
    private String Obs;
    @Column(unique = true, name = "IE")
    private BigInteger ie;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Enumerated(EnumType.STRING)
    public EstadosEnum getEstados() {
        return estados;
    }

    @Enumerated(EnumType.STRING)
    public void setEstados(EstadosEnum estados) {
        this.estados = estados;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
    }

    public BigInteger getTelefoneDois() {
        return telefoneDois;
    }

    public void setTelefoneDois(BigInteger telefoneDois) {
        this.telefoneDois = telefoneDois;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public BigInteger getIe() {
        return ie;
    }

    public void setIe(BigInteger ie) {
        this.ie = ie;
    }

}
