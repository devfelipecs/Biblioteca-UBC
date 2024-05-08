package com.ubc.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("ALL")
public class Conexao {
    private final String url = "jdbc:mysql://localhost:3306/jdbc-biblioteca" /*Ajuste de acordo com o banco de dados*/;
    private final String usuario = "root" /*Digite aqui o nome de usuario do seu banco de dodos*/;
    private final String senha = "senha" /*Digite aqui a senha de acesso do banco de dados*/;

    private Connection con;

    public Connection getConnection() {

        try {
            if(con == null){
                con = DriverManager.getConnection(url, usuario, senha);
                return con;
            } else {
                return con;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
