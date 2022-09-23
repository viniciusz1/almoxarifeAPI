package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Entrada;

public class EntradaDAO {
    public void inserirEntrada(){
        String query = "insert into entradas(codigo, quantidade, data, nomeProduto) values(?,?,?,?)";
    }

    public Entrada buscarTodasEntradas(){
        String query = "select * from entrada";
        return null;
    }


}
