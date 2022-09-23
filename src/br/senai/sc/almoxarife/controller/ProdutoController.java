package br.senai.sc.almoxarife.controller;

import br.senai.sc.almoxarife.model.entities.Produto;
import br.senai.sc.almoxarife.model.service.ProdutoService;

import java.util.ArrayList;

public class ProdutoController {
    public void inserir(Produto produto){
        new ProdutoService().inserir(produto);
    }

    public ArrayList<Produto> buscarTodosProdutos(){
        return  new ProdutoService().buscarTodosProdutos();
    }

    public Produto buscarProdutoPorCodigo(int cpf){
        return new ProdutoService().buscarProdutoPorCodigo(cpf);
    }

    public Produto adicionarQuantidadeProduto(int codigo, int qtd){
        return  new ProdutoService().adicionarQuantidadeProduto(codigo, qtd);
    }
}
