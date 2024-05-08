package com.ubc.biblioteca.controllers;

import com.ubc.biblioteca.models.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final Aluno alunoModel = new Aluno();

    @PostMapping("/cadastrar")
    @ResponseBody
    public String cadastrarAluno(@RequestParam String nome, @RequestParam String rgm) {
        try {
            alunoModel.cadastrar(nome, rgm);
            return "Aluno cadastrado com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar aluno!";
        }
    }

    @GetMapping("/listar")
    @ResponseBody
    public String listarAlunos() {
        try {
            alunoModel.listarAlunos();
            return "Lista de alunos exibida com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao listar alunos!";
        }
    }
}