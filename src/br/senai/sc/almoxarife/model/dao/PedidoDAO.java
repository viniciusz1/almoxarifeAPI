package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Produto;

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

    public Pedido buscarDevolucaoPorData(){
        String query = "select * from pedidos where dataDevolucao = ?";
    }

    public void inserirPedidoDB(Pedido pedido){
        Status statusPedido = pedido.getStatus();
        statusPedido = "AguardandoEntrega";
        String query = "insert into pedido values(?,?,?,?)";
        for(Produto produto : pedido.listaProdutos){
            String query = "insert into pedidoProdutos(codigo, quantidade, pedidoCodigo, produtoCodigo) values (?,?,?,?)";
        }
    }
    public void editarPedidosDB(){
        String query = "update pedidoProdutos set (codigo, quantidade, pedidoCodigo, produtoCodigo) values (?,?,?,?)";
    }

}
