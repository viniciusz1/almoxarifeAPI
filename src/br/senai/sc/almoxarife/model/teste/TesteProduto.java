package br.senai.sc.almoxarife.model.teste;


import br.senai.sc.almoxarife.model.dao.ProdutoDAO;
import br.senai.sc.almoxarife.model.entities.Produto;

public class TesteProduto {
    public static void main(String[] args) {
        new ProdutoDAO().inserirProduto(new Produto(1,15, 5, "Fusivel",
                "Eletrica", "sla", "Descartavel", "Ele queima", "n tem"));
//        System.out.println(new ProdutoDAO().buscarTodosProdutos());
    }



}
