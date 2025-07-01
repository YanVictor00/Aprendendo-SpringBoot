package com.yan.CadastroDeNinjas.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    //  GET -- MANDAR UMA REQUISIÇÃO PARA MOSTRAR MISSÕES
    @GetMapping("/listar")
    public String listarMissao(){
        return "MISSÕES LISTADA COM SUCESSO";
    }

    //  POST -- MANDAR UMA REQUISIÇÃO PARA CRIAR/MANDAR MISSÃO
    @PostMapping("/criar")
    public String criarMissao(){
        return "MISSÃO CRIADA COM SUCESSO";
    }
    //  PUT -- MANDAR UMA REQUISIÇÃO PARA ALTERAR/COLOCAR MISSÃO
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "MISSÃO ALRETADA COM SUCESSO";
    }

    //  DELETE -- MANDAR UMA REQUISIÇÃO PARA DELETAR MISSÃO
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "MISSÃO DELETADA COM SUCESSO";
    }

}
