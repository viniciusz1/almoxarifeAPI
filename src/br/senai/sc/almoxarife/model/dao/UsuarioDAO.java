package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Entrada;
import br.senai.sc.almoxarife.model.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;

    public void inserirEntrada(){
        String query = "insert into usuario(email, nome, usuario, senha, telefone, nivelAcesso) values(?,?,?,?,?,?)";
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
                    resultSet.getString("telefone"),
                    resultSet.getInt("nivelAcesso")
            );
        }catch(Exception e){
            throw new RuntimeException("Erro ao extrair o pedido! extrairObjetoUsuario");
        }
    }
}
