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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
    return ninjaService.criarNinja(ninja) ;
    }

    //Mostrar todos os Ninjas   (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarPorId(@PathVariable Long id){
        return ninjaService.listarPorId(id);
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
