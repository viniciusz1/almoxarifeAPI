package br.senai.sc.almoxarife.model.entities;

public class pedidosProdutos {
    private Integer codigo, quantidade, pedidoCodigo, produtoCodigo;

    public pedidosProdutos(Integer codigo, Integer quantidade, Integer pedidoCodigo, Integer produtoCodigo) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.pedidoCodigo = pedidoCodigo;
        this.produtoCodigo = produtoCodigo;
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

    public Integer getPedidoCodigo() {
        return pedidoCodigo;
    }

    public void setPedidoCodigo(Integer pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }

    public Integer getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(Integer produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }
}
