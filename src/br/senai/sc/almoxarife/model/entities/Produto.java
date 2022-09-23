package br.senai.sc.almoxarife.model.entities;

public class Produto {
    private Integer codigo, quantidadeTotal, quantidadeReservada;
    private String nome, classificacao, localidade, opcaoUso, descricao, imagem;

    public Produto(Integer codigo, Integer quantidadeTotal, Integer quantidadeReservada, String nome, String classificacao, String localidade, String opcaoUso, String descricao, String imagem) {
        this.codigo = codigo;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeReservada = quantidadeReservada;
        this.nome = nome;
        this.classificacao = classificacao;
        this.localidade = localidade;
        this.opcaoUso = opcaoUso;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Integer getQuantidadeReservada() {
        return quantidadeReservada;
    }

    public void setQuantidadeReservada(Integer quantidadeReservada) {
        this.quantidadeReservada = quantidadeReservada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getOpcaoUso() {
        return opcaoUso;
    }

    public void setOpcaoUso(String opcaoUso) {
        this.opcaoUso = opcaoUso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
