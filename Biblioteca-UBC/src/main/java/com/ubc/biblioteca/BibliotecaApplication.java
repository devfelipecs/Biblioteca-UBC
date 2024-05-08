package com.ubc.biblioteca;

import com.ubc.biblioteca.Conexao;
import com.ubc.biblioteca.models.Emprestimo;
import com.ubc.biblioteca.models.Livro;
import org.springframework.boot.SpringApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);


	}

}
