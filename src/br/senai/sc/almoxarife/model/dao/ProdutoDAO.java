package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Produto;
import br.senai.sc.almoxarife.model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
    private Connection conn;
    public ArrayList<Produto> buscarTodosProdutos() {
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        String sql = "select * from produtos";
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = prtm.executeQuery()) {
                while (resultSet.next()) {
                    listaDeProdutos.add(extrairObjetoProduto(resultSet));
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL! buscarTodosProdutos");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL! buscarTodosProdutos");
        }
        return listaDeProdutos;
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
            throw new RuntimeException("Erro ao extrair o produto! extrairObjetoProduto");
        }

    }

    public Produto buscarProdutoPorCodigo(int codigoProduto){
        String sql = "select * from produto where codigo = ?";
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            prtm.setInt(1, codigoProduto);
            try (ResultSet resultSet = prtm.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjetoProduto(resultSet);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL! buscarProdutoPorCodigo");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL! buscarProdutoPorCodigo");
        }
        throw new RuntimeException("Algo deu ruim! buscarProdutoPorCodigo");
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
