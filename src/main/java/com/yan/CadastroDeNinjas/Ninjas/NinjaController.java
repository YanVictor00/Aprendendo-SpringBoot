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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
    return ninjaService.criarNinja(ninja) ;
    }

    //Mostrar todos os Ninjas   (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable Long id){
        return ninjaService.listarPorId(id);
    }

    //Alterar dados do Ninja    (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninja     (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
         ninjaService.deletarNinja(id);
    }

}
