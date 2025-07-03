package com.yan.CadastroDeNinjas.Ninjas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;
    //CRUD

    //Adicionar Ninja   (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
    return "NINJA CRIADO";
    }

    //Mostrar todos os Ninjas   (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "TODOS OS POR ID NINJAS";
    }

    //Alterar dados do Ninja    (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "NINJAS ALTERADOS";
    }

    //Deletar Ninja     (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "NINJA DELETADO POR ID";
    }

}
