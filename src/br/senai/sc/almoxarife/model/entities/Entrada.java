package br.senai.sc.almoxarife.model.entities;

import java.util.Date;
import java.util.List;

public class Entrada {
    private Integer codigo, quantidade, codigoProduto;
    private Date data;
    private List produtos;

    public Entrada(Integer codigo, Integer quantidade, Integer codigoProduto, Date data, List produtos) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.codigoProduto = codigoProduto;
        this.data = data;
        this.produtos = produtos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List getProdutos() {
        return produtos;
    }

    public void setProdutos(List produtos) {
        this.produtos = produtos;
    }
}
