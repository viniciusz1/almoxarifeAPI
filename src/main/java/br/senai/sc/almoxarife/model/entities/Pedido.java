package br.senai.sc.almoxarife.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Integer codigo;
    private String  usuarioEmail;
    private Date dataEntrega, dataDevolucao;
    private Status status;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Pedido(Integer codigo, String usuarioEmail, Date dataEntrega, Date dataDevolucao, Status status, ArrayList produtos) {
        this.codigo = codigo;
        this.usuarioEmail = usuarioEmail;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.produtos = produtos;
    }
    public Pedido(){

    };

    public Pedido(Integer codigo, String usuarioEmail, Date dataEntrega, Date dataDevolucao, Status status) {
        this.codigo = codigo;
        this.usuarioEmail = usuarioEmail;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", usuarioEmail='" + usuarioEmail + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", dataDevolucao=" + dataDevolucao +
                ", status=" + status +
                ", produtos=" + produtos +
                '}';
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public List getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
}
