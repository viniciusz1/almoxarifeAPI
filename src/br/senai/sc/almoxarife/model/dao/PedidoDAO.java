package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Pedido;

public class PedidoDAO {

    public Pedido buscarTodosPedidos(){
        String query = "select * from pedido";
        return null;
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
