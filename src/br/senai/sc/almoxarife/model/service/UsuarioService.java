package br.senai.sc.almoxarife.model.service;

import br.senai.sc.almoxarife.model.dao.UsuarioDAO;
import br.senai.sc.almoxarife.model.entities.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    public void inserir(Usuario usuario){
        new UsuarioDAO().inserirUsuario(usuario);
    }

    public ArrayList<Usuario> buscarTodosUsuarios(){
        return new UsuarioDAO().buscarTodosUsuarios();
    }

    public void atualizarUsuario(String email, Usuario usuarioAtualizado){
        new UsuarioDAO().atualizarUsuario(email, usuarioAtualizado);
    }

}
