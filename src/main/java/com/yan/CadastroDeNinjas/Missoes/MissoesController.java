package com.yan.CadastroDeNinjas.Missoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    //MOSTRAR TODAS AS MISSOES
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.mostrarMissoes();
    }

    //MOSTRAR MISSEOS POR ID
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.mostrarMissoesPorId(id);
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
