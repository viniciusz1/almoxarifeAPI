package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Pedido;
import br.senai.sc.almoxarife.model.entities.Produto;
import br.senai.sc.almoxarife.model.entities.Status;
import br.senai.sc.almoxarife.model.factory.ConexaoFactory;
import br.senai.sc.almoxarife.model.factory.StatusFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDAO {
    private Connection conn;
    public PedidoDAO() {
        this.conn = new ConexaoFactory().conectaBD();
    }
    //PROBLEMA: PARA PEGAR UM PEDIDO, TEM QUE DAR JOIN ENTRE PEDIDOPRODUTO, PRODUTO
    public ArrayList<Pedido> buscarTodosPedidos(){
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        String sql = "select * from pedido";
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = prtm.executeQuery()) {
                while (resultSet.next()) {
                    listaDePedidos.add(extrairObjetoPedido(resultSet));
                }
                return listaDePedidos;
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL! listaDePedidos");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL! listaDePedidos");
        }
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

    public Pedido buscarPedidoPorCodigo(int codigo) {
        String query = "select * from pedido where codigo = ?";
        try (PreparedStatement prtm = conn.prepareStatement(query)) {
            prtm.setInt(1, codigo);
            try (ResultSet resultSet = prtm.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjetoPedido(resultSet);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL!");
        }
        throw new RuntimeException("Algo deu ruim!");
    }

    public ArrayList<Pedido> buscarPedidoPorStatus(Status status){
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        String query = "select * from pedido where status = ?";
        try (PreparedStatement prtm = conn.prepareStatement(query)) {
            prtm.setInt(1, status.ordinal());
            try (ResultSet resultSet = prtm.executeQuery()) {
                if (resultSet.next()) {
                    listaDePedidos.add(extrairObjetoPedido(resultSet));
                }
                return listaDePedidos;
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL!");
        }
    }

    public ArrayList<Pedido> buscarPedidoEntradaPorData(Date data){
        String query = "select * from pedido where dataEntrada = ?";
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        try (PreparedStatement prtm = conn.prepareStatement(query)) {
            prtm.setDate(1, (java.sql.Date) data);
            try (ResultSet resultSet = prtm.executeQuery()) {
                if (resultSet.next()) {
                    listaDePedidos.add(extrairObjetoPedido(resultSet));
                }
                return listaDePedidos;

            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL!");
        }
    }

    public ArrayList<Pedido> buscarPedidoDevolucaoPorData(Date data){
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        String query = "select * from pedido where dataDevolucao = ?";
        try (PreparedStatement prtm = conn.prepareStatement(query)) {
            prtm.setDate(1, (java.sql.Date) data);
            try (ResultSet resultSet = prtm.executeQuery()) {
                if (resultSet.next()) {
                    listaDePedidos.add(extrairObjetoPedido(resultSet));
                }
                return listaDePedidos;
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL!");
        }
    }
    public void inserirPedidoDB(Pedido pedido){
    //mais complexo
    }

}
