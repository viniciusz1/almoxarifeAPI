package br.senai.sc.almoxarife.model.teste;

import br.senai.sc.almoxarife.model.dao.PedidoDAO;
import br.senai.sc.almoxarife.model.dao.ProdutoDAO;
import br.senai.sc.almoxarife.model.entities.Pedido;
import br.senai.sc.almoxarife.model.entities.Status;

import java.util.Date;

public class TesteProduto {
    public static void main(String[] args) {
//        new PedidoDAO().buscarPedidosProfessor("vinicius@gmail.com");
//        new PedidoDAO().buscarPedidoPorCodigo(3);
//        new PedidoDAO().buscarPedidosPorStatus(Status.AGUARDANDO);
        new PedidoDAO().buscarPedidosEntradaPorData(new Date());
    }

}
