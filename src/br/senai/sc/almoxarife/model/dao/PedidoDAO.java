package br.senai.sc.almoxarife.model.dao;

public class PedidoDAO {

    public Pedido buscarTodosPedidos(){
        String query = "select * from pedidos";
    }

    public Pedido buscarPedidoPorCodigo() {
        String query = "select * from pedidos where codigo = ?";
    }

    public Pedido buscarPedidoPorStatus(){
        String query = "select * from pedidos where status = ?";
    }

    public Pedido buscarEntradaPorData(){
        String query = "select * from pedidos where dataEntrada = ?";
    }

    public Pedido BuscarDevolucaoPorData(){
        String query = "select * from pedidos where dataDevolucao = ?";
    }
    public void inserirPedidoDB(Pedido pedido){
        pedido.status =
    }

}
