package br.senai.sc.almoxarife.controller;

import br.senai.sc.almoxarife.model.dao.UsuarioDAO;
import br.senai.sc.almoxarife.model.entities.Usuario;
import br.senai.sc.almoxarife.model.entities.nivelAcesso;
import br.senai.sc.almoxarife.model.service.UsuarioService;

import java.util.ArrayList;
import java.util.Collection;

public class UsuarioController {

    public void cadastrar(String email, String nome, String usuarioNome, String senha, nivelAcesso nivelAcesso, String confSenha){
        UsuarioService service = new UsuarioService();
        Usuario usuario = Usuario.inserir(email, nome, usuarioNome, senha, nivelAcesso, confSenha);
        service.inserir(usuario);
    }

    public ArrayList<Usuario> buscarTodosUsuarios(){
        return new UsuarioService().buscarTodosUsuarios();
    }

    public void atualizarUsuario(String email, Usuario usuarioAtualizado){
        new UsuarioService().atualizarUsuario(email, usuarioAtualizado);
    }



}
