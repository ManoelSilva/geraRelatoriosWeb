/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbcliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;

    @Id
    private Integer id;
    @NotEmpty
    private String nome;
    private EstadosEnum estados;
    private SexoEnum sexo;
    private TipoClienteEnum tipoCliente;
    private boolean habilitado;
    private String cidade;
    private String plano;
    private boolean tier1;
    private String bairro;
    private String rua;
    private String cep;
    private BigInteger telefone;
    private BigInteger telefoneDois;
    @Column(unique = true)
    @Email
    private String email;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String rg;
    private String complemento;
    private String Obs;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cliente")
    private List<OS> ordens;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "cliente")
    private List<Equipamento> equipamentos;

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public boolean isTier1() {
        return tier1;
    }

    public void setTier1(boolean tier1) {
        this.tier1 = tier1;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
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

    @Enumerated(EnumType.STRING)
    public EstadosEnum getEstados() {
        return estados;
    }

    @Enumerated(EnumType.STRING)
    public void setEstados(EstadosEnum estados) {
        this.estados = estados;
    }

    @Enumerated(EnumType.STRING)
    public SexoEnum getSexo() {
        return sexo;
    }

    @Enumerated(EnumType.STRING)
    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    @Enumerated(EnumType.STRING)
    public TipoClienteEnum getTipoCliente() {
        return tipoCliente;
    }

    @Enumerated(EnumType.STRING)
    public void setTipoCliente(TipoClienteEnum tipoCliente) {
        this.tipoCliente = tipoCliente;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public List<OS> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<OS> ordens) {
        this.ordens = ordens;
    }

}
