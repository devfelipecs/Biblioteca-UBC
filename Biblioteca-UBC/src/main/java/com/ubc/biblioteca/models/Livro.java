// Classe para os livros da biblioteca
package com.ubc.biblioteca.models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ubc.biblioteca.Conexao;

public class Livro{
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private int paginas;
    private int quantidade;

    public Livro() {}

    public void cadastrarLivro(String titulo, String autor, String editora, int paginas, int quantidade) throws SQLException, ClassNotFoundException {
        Conexao connect = new Conexao();
        Connection con = connect.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("INSERT INTO livros (titulo , autor, editora, paginas, quantidade) VALUES ('" + titulo + "', '" + autor + "', '" + editora + "', " + paginas + ", " + quantidade+ ")");

        System.out.println("\nLivro cadastrado com sucesso!\n");

    }

    public void listarInfo() throws SQLException {
        Conexao connect = new Conexao();
        Connection con = connect.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM livros");
        while (rs.next()) {
            System.out.println("Informações do Livro:");
            System.out.println("Título - " + rs.getString("titulo"));
            System.out.println("Autor - " + rs.getString("autor"));
            System.out.println("Editora - " + rs.getString("editora"));
            System.out.println("Páginas - " + rs.getString("paginas"));
            System.out.println("Quantidade Disponível - " + rs.getString("quantidade") + "\n");
        }
    }


}

