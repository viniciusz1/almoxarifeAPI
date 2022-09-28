package br.senai.sc.almoxarife.model.teste;

import br.senai.sc.almoxarife.model.dao.UsuarioDAO;
import br.senai.sc.almoxarife.model.entities.Usuario;
import br.senai.sc.almoxarife.model.factory.nivelAcessoFactory;

public class TesteUsuario {
    public static void main(String[] args) {
//        new UsuarioDAO().inserirUsuario(new Usuario("abc", "abc", "abc", "abc",
//                new nivelAcessoFactory().getNivelAcesso(1)));
        System.out.println(new UsuarioDAO().buscarTodosUsuarios());
    }
}
