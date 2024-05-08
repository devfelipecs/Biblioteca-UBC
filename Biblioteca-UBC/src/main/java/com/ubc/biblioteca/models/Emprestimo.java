// Classe para pegar e devolver os livros da biblioteca
package com.ubc.biblioteca.models;

import com.ubc.biblioteca.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private int id_livro;
    private int id_aluno;
    private LocalDate data_retirada;
    private LocalDate data_devolucao;

    public Emprestimo() {}

    public void emprestimo(int id_livro, int id_aluno, LocalDate data_retirada) throws SQLException {
        Conexao connect = new Conexao();
        Connection con = connect.getConnection();
        Statement stmt = con.createStatement();

        try {
            stmt.execute("INSERT INTO emprestimos (id_livro , id_aluno, data_retirada) VALUES (" + id_livro + ", " + id_aluno + ", '" + data_retirada + "')");
            stmt.execute("UPDATE livros SET quantidade = quantidade + 1 WHERE id = " + id_livro);

            System.out.println("\nEmpréstimo feito com sucesso!\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void devolucao(int id_livro, int id_aluno, LocalDate data_retirada, LocalDate data_devolucao) throws SQLException {
        Conexao connect = new Conexao();
        Connection con = connect.getConnection();
        Statement stmt = con.createStatement();
        try {
            stmt.executeUpdate("UPDATE emprestimos SET data_devolucao = '" + data_devolucao + "' WHERE id_livro = " + id_livro + " AND id_aluno = " + id_aluno + " AND data_retirada = '" + data_retirada + "'");
            stmt.execute("UPDATE livros SET quantidade = quantidade + 1 WHERE id = " + id);

            System.out.println("\nDevolução feita com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void listarEmprestimos() throws SQLException {
        Conexao connect = new Conexao();
        Connection con = connect.getConnection();
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM emprestimos");
        while (resultSet.next()) {
            System.out.println("Informações do Emprestimo:");
            System.out.println("ID Livro - " + resultSet.getString("id_livro"));
            System.out.println("ID Aluno - " + resultSet.getString("id_aluno"));
            System.out.println("Data Retirada - " + resultSet.getString("data_retirada"));
            System.out.println("Data Devolucao - " + resultSet.getString("data_devolucao"));
        }
    }

}





