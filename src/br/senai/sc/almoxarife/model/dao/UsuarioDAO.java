package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Entrada;

public class UsuarioDAO {
    public void inserirEntrada(){
        String query = "insert into usuario(email, nome, usuario, senha, telefone, nivelAcesso) values(?,?,?,?,?,?)";
    }

    public Entrada buscarTodasEntradas(){
        String query = "select * from entrada";
        return null;
    }
}
