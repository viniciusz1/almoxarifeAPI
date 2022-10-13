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
    public ProdutoDAO() {
        this.conn = new ConexaoFactory().conectaBD();
    }
    public ArrayList<Produto> buscarTodosProdutos() {
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        String sql = "select * from produto";
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

    public Produto adicionarQuantidadeProduto(int codigo, int qtd){
        String query = "?";
        return null;
    }

    public void inserirProduto(Produto produto){
        String query = "insert into produto(nome,quantidadeTotal,quantidadeReservada," +
                "classificacao,localidade,opcaoUso,descricao,imagem) values (?,?,?,?,?,?,?,?)";

        try(PreparedStatement pstm = conn.prepareStatement(query)) {
            System.out.println("1");
            pstm.setString(1, produto.getNome());
            System.out.println("2");
            pstm.setInt(2, produto.getQuantidadeTotal());
            System.out.println("3");
            pstm.setInt(3, produto.getQuantidadeReservada());
            System.out.println("4");
            pstm.setString(4, produto.getClassificacao());
            System.out.println("5");
            pstm.setString(5, produto.getLocalidade());
            System.out.println("6");
            pstm.setString(6, produto.getOpcaoUso());
            System.out.println("7");
            pstm.setString(7, produto.getDescricao());
            System.out.println("8");
            pstm.setString(8, produto.getImagem());
            System.out.println("9");

            try {
                System.out.println("Ali");
                pstm.execute();
                System.out.println("Depois");
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Erro na preparação do comando SQL - InserirProduto");
        }
        System.out.println("Cadastro chegou ao fim");
    }

    public void atualizarProduto(Integer codigo, Produto produtoAtualizado){
        String query = "update produto set nome = ?, quantidadeTotal = ?," +
                "quantidadeReservada = ?, classificacao = ?,localidade = ?" +
                ",opcaoUso = ?,descricao = ?,imagem = ?) values (?,?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setString(1, produtoAtualizado.getNome());
            pstm.setInt(2, produtoAtualizado.getQuantidadeTotal());
            pstm.setInt(3, produtoAtualizado.getQuantidadeReservada());
            pstm.setString(4, produtoAtualizado.getClassificacao());
            pstm.setString(5, produtoAtualizado.getLocalidade());
            pstm.setString(6, produtoAtualizado.getOpcaoUso());
            pstm.setString(7, produtoAtualizado.getDescricao());
            pstm.setString(8, produtoAtualizado.getImagem());
            try {
                pstm.execute();
            }catch (Exception e){
                throw new RuntimeException("Erro na execução do comando SQL - atualizarProduto");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do comando SQL - atualizarProduto");
        }
        System.out.println("Produto Atualizado");
    }

}
