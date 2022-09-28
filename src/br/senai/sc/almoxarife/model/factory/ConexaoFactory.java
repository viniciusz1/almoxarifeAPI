package br.senai.sc.almoxarife.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private final String URL = "jdbc:mysql://localhost:3306/livraria";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    public Connection conectaBD() {
        try {
            return DriverManager.getConnection(URL, USERNAME,PASSWORD);
        }catch (Exception erro){
            throw  new RuntimeException("Erro na conexão");
        }
    }
}
