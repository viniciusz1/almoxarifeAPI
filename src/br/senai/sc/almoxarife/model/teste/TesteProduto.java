package br.senai.sc.almoxarife.model.teste;

import br.senai.sc.almoxarife.model.dao.PedidoDAO;
import br.senai.sc.almoxarife.model.dao.ProdutoDAO;

public class TesteProduto {
    public static void main(String[] args) {
        new PedidoDAO().buscarPedidosProfessor("vinicius@gmail.com");
    }

}
