// Classe para cadastrar e remover alunos
package com.ubc.biblioteca.models;

import com.ubc.biblioteca.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aluno{
    private int id;
    private String nome;
    private String rgm;

    public Aluno() {}

    public void cadastrar(String nome, String rgm) throws SQLException {
        Conexao connect = new Conexao();
        Connection con = connect.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("INSERT INTO alunos (nome,rgm) VALUES ('" + nome + "', '" + rgm + "')");

        System.out.println("\nAluno cadastrado com sucesso!\n");

    }

    public void listarAlunos() throws SQLException {
        Conexao connect = new Conexao();
        Connection con = connect.getConnection();
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM alunos");
        while (resultSet.next()) {
            System.out.println("Informações do Aluno:");
            System.out.println("Nome - " + resultSet.getString("nome"));
            System.out.println("RGM - " + resultSet.getString("rgm") + "\n");
        }
    }
}
