package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Produto;

public class ProdutoDAO {
    public Produto buscarTodosProdutos(){
        String query = "select * from produtos";
        return null;
    }

    public Produto buscarProdutoPorCodigo(){
        String query = "select * from produtos where codigo = ?";
        return null;
    }
    public Produto adicionarQuantidadeProduto(){
        String query = "?";
        return null;
    }
    public void inserirProduto(){
        String query = "insert into produtos(codigo,nome,quantidadeTotal,quantidadeReservada," +
                "classificacao,localidade,opcaoUso,descricao,imagem) values (?,?,?,?,?,?,?,?,?)";
    }

}
