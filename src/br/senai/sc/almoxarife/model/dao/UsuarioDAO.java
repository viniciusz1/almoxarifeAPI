package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Entrada;
import br.senai.sc.almoxarife.model.entities.Usuario;
import br.senai.sc.almoxarife.model.factory.ConexaoFactory;
import br.senai.sc.almoxarife.model.factory.nivelAcessoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;
    public UsuarioDAO() {
        this.conn = new ConexaoFactory().conectaBD();
    }

    public void inserirUsuario(Usuario usuario){
        String query = "insert into usuario(email, nome, usuario, senha, nivelAcesso) values(?,?,?,?,?)";
    }

    public ArrayList<Usuario> buscarTodosUsuarios(){
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
        String sql = "select * from entrada";
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = prtm.executeQuery()) {
                while (resultSet.next()) {
                    listaDeUsuarios.add(extrairObjetoUsuario(resultSet));
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL! listaDeUsuarios");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL! listaDeUsuarios");
        }
        return listaDeUsuarios;
    }

    public Usuario extrairObjetoUsuario(ResultSet resultSet){
        try{
            return new Usuario(
                    resultSet.getString("email"),
                    resultSet.getString("nome"),
                    resultSet.getString("usuario"),
                    resultSet.getString("senha"),
                    new nivelAcessoFactory().getNivelAcesso(resultSet.getInt("nivelAcesso"))
            );
        }catch(Exception e){
            throw new RuntimeException("Erro ao extrair o pedido! extrairObjetoUsuario");
        }
    }

    public void atualizarUsuario(String email, Usuario usuarioAtualizado){
        // email, nome, usuario, senha, telefone, nivelAcesso
        String sqlCommand = "UPDATE usuario set " +
                "email = ?, nome = ?, usuario = ?, " +
                "senha = ?, nivelAcesso = ? where email = ?";

        try(PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setString(1, usuarioAtualizado.getEmail());
            pstm.setString(2, usuarioAtualizado.getNome());
            pstm.setString(3, usuarioAtualizado.getUsuario());
            pstm.setString(4, usuarioAtualizado.getSenha());
            pstm.setInt(5, usuarioAtualizado.getNivelAcesso().ordinal());
            pstm.setString(6, email);
            try {
                pstm.execute();
            }catch (Exception e){
                throw new RuntimeException("Erro na execução do comando SQL - LivroUpdate");
            }
        }catch (Exception e){
            throw new RuntimeException("Erro na preparação do comando SQL - LivroUpdate");
        }
        System.out.println("Usuario Atualizado");
    }

}
