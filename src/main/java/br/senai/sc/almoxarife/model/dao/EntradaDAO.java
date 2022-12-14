package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Entrada;
import br.senai.sc.almoxarife.model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO {
    private Connection conn;
    public EntradaDAO() {
        this.conn = new ConexaoFactory().conectaBD();
    }

    public void inserirEntrada(Entrada entrada){
        String query = "insert into entrada(quantidade, data, produtoCodigo) values(?,?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, entrada.getQuantidade());
            pstm.setObject(2, entrada.getData());
            pstm.setInt(3, entrada.getCodigoProduto());
            try {
                pstm.execute();
            }catch (Exception e){
                throw new RuntimeException("Erro na execução do comando SQL - inserirEntrada");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do comando SQL - inserirEntrada");
        }
        System.out.println("Entrada Criada");
    }

    public ArrayList<Entrada> buscarTodasEntradas(){
        ArrayList<Entrada> listaDeEntradas = new ArrayList<>();
        String sql = "select * from entrada";
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = prtm.executeQuery()) {
                while (resultSet.next()) {
                    listaDeEntradas.add(extrairObjetoEntrada(resultSet));
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL! listaDeEntradas");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL! listaDeEntradas");
        }
        return listaDeEntradas;
    }

    public Entrada extrairObjetoEntrada(ResultSet resultSet){
        try{
            return new Entrada(
                    resultSet.getInt("codigo"),
                    resultSet.getInt("quantidade"),
                    resultSet.getInt("produtoCodigo"),
                    resultSet.getDate("data")
            );
        }catch(Exception e){
            throw new RuntimeException("Erro ao extrair o pedido! extrairObjetoEntrada");
        }
    }


}
