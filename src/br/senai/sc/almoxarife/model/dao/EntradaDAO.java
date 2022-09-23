package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Entrada;
import br.senai.sc.almoxarife.model.entities.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO {
    private Connection conn;

    public void inserirEntrada(){
        String query = "insert into entradas(codigo, quantidade, data, nomeProduto) values(?,?,?,?)";
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
                    resultSet.getDate("data"),
                    (List) resultSet.getArray("produtos")
            );
        }catch(Exception e){
            throw new RuntimeException("Erro ao extrair o pedido! extrairObjetoEntrada");
        }
    }


}
