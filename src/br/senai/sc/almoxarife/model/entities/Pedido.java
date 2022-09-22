package br.senai.sc.almoxarife.model.entities;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Integer codigo;
    private String nomeProfessor, usuarioEmail;
    private Date dataEntrega, dataDevolucao;
    private Status status;
    private List usuario;
    private List produtos;

    public Pedido(Integer codigo, String nomeProfessor, String usuarioEmail, Date dataEntrega, Date dataDevolucao, Status status, List usuario, List produtos) {
        this.codigo = codigo;
        this.nomeProfessor = nomeProfessor;
        this.usuarioEmail = usuarioEmail;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.usuario = usuario;
        this.produtos = produtos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List getUsuario() {
        return usuario;
    }

    public void setUsuario(List usuario) {
        this.usuario = usuario;
    }

    public List getProdutos() {
        return produtos;
    }

    public void setProdutos(List produtos) {
        this.produtos = produtos;
    }
}
