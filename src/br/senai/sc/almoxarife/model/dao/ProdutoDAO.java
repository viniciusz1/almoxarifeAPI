package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Produto;
import br.senai.sc.almoxarife.model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    public ArrayList<Produto> buscarTodosProdutos(){
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        ConexaoFactory conexao = new ConexaoFactory();
        Connection connection = conexao.conectaBD();
        String query = "select * from produtos";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultset = statement.executeQuery();

        while (resultset != null && resultset.next()) {
            listaDeProdutos.add(extrairObjetoProduto(resultset));
        }

        return null;
    }

    public Produto extrairObjetoProduto(ResultSet resultset){
        try{
            return new Produto(resultset.getInt("codigo"),
                    resultset.getInt("quantidadeTotal"),
                    resultset.getInt("quantidadeReservada"),
                    resultset.getString("nome"),
                    resultset.getString("classificacao"),
                    resultset.getString("localidade"),
                    resultset.getString("opcaoUso"),
                    resultset.getString("descricao"),
                    resultset.getString("imagem"));
        }catch (Exception e) {
            throw new RuntimeException("Erro ao extrair o objeto!");
        }

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
