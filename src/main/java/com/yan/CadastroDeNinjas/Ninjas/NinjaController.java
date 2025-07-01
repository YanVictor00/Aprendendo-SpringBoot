package com.yan.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    //CRUD

    //Adicionar Ninja   (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
    return "NINJA CRIADO";
    }

    //Mostrar todos os Ninjas   (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "MOSTRAR TODOS NINJAS";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/todosID")
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
