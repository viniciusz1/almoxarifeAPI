package br.senai.sc.almoxarife.model.service;

import br.senai.sc.almoxarife.model.dao.ProdutoDAO;
import br.senai.sc.almoxarife.model.entities.Produto;

import java.util.ArrayList;

public class ProdutoService {

    public void inserir(Produto produto){
        new ProdutoDAO().inserirProduto(produto);
    }

    public ArrayList<Produto> buscarTodosProdutos(){
        return  new ProdutoDAO().buscarTodosProdutos();
    }

    public Produto buscarProdutoPorCodigo(int cpf){
        return new ProdutoDAO().buscarProdutoPorCodigo(cpf);
    }

    public Produto adicionarQuantidadeProduto(int codigo, int qtd){
        return  new ProdutoDAO().adicionarQuantidadeProduto(codigo, qtd);
    }

}
