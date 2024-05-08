package com.ubc.biblioteca.controllers;

import com.ubc.biblioteca.models.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final Emprestimo emprestimoModel = new Emprestimo();

    @PostMapping("/emprestar")
    @ResponseBody
    public String realizarEmprestimo(@RequestParam int idLivro, @RequestParam int idAluno, @RequestParam String dataRetirada) {
        try {
            LocalDate dataRetiradaFormatted = LocalDate.parse(dataRetirada);
            emprestimoModel.emprestimo(idLivro, idAluno, dataRetiradaFormatted);
            return "Empréstimo realizado com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao realizar empréstimo!";
        }
    }

    @PostMapping("/devolver")
    @ResponseBody
    public String realizarDevolucao(@RequestParam int idLivro, @RequestParam int idAluno, @RequestParam String dataRetirada, @RequestParam String dataDevolucao) {
        try {
            LocalDate dataRetiradaFormatted = LocalDate.parse(dataRetirada);
            LocalDate dataDevolucaoFormatted = LocalDate.parse(dataDevolucao);
            emprestimoModel.devolucao(idLivro, idAluno, dataRetiradaFormatted, dataDevolucaoFormatted);
            return "Devolução realizada com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao realizar devolução!";
        }
    }

    @GetMapping("/listar")
    @ResponseBody
    public String listarEmprestimos() {
        try {
            emprestimoModel.listarEmprestimos();
            return "Lista de empréstimos exibida com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao listar empréstimos!";
        }
    }
}
