package com.ubc.biblioteca.controllers;

import com.ubc.biblioteca.models.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/livro")
public class LivroController {

    private final Livro livroModel = new Livro();

    @PostMapping("/cadastrar")
    @ResponseBody
    public String cadastrarLivro(@RequestParam String titulo, @RequestParam String autor, @RequestParam String editora, @RequestParam int paginas, @RequestParam int quantidade) {
        try {
            livroModel.cadastrarLivro(titulo, autor, editora, paginas, quantidade);
            return "Livro cadastrado com sucesso!";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "Erro ao cadastrar livro!";
        }
    }

    @GetMapping("/listar")
    @ResponseBody
    public String listarLivros() {
        try {
            livroModel.listarInfo();
            return "Lista de livros exibida com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao listar livros!";
        }
    }
}
