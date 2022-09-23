package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Pedido;
import br.senai.sc.almoxarife.model.entities.Produto;
import br.senai.sc.almoxarife.model.entities.Status;
import br.senai.sc.almoxarife.model.factory.StatusFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private Connection conn;

    //PROBLEMA: PARA PEGAR UM PEDIDO, TEM QUE DAR JOIN ENTRE PEDIDOPRODUTO, PRODUTO
    public ArrayList<Pedido> buscarTodosPedidos(){
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        String sql = "select * from pedido";
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = prtm.executeQuery()) {
                while (resultSet.next()) {
                    listaDePedidos.add(extrairObjetoPedido(resultSet));
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL! listaDePedidos");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL! listaDePedidos");
        }
        return listaDePedidos;
    }

    public Pedido extrairObjetoPedido(ResultSet resultSet){
        try{
            return new Pedido(
                    resultSet.getInt("codigo"),
                    resultSet.getString("usuarioEmail"),
                    resultSet.getDate("dataEntrega"),
                    resultSet.getDate("dataDevolucao"),
                    new StatusFactory().getStatus(resultSet.getInt("status")),
                    (List) resultSet.getArray("produtos")
            );
        }catch(Exception e){
            throw new RuntimeException("Erro ao extrair o pedido! extrairObjetoPedido");
        }
    }

    public Pedido buscarPedidoPorCodigo() {
        String query = "select * from pedido where codigo = ?";
        return null;
    }

    public Pedido buscarPedidoPorStatus(){
        String query = "select * from pedido where status = ?";
        return null;
    }

    public Pedido buscarEntradaPorData(){
        String query = "select * from pedido where dataEntrada = ?";
        return null;
    }

    public Pedido BuscarDevolucaoPorData(){
        String query = "select * from pedido where dataDevolucao = ?";
        return null;
    }
    public void inserirPedidoDB(Pedido pedido){
    //mais complexo
    }

}
