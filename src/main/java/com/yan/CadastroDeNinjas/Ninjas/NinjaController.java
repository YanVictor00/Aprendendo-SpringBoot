package com.yan.CadastroDeNinjas.Ninjas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    //CRUD

    //Adicionar Ninja   (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja)
    {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com sucesso! " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getId());
    }

    //Mostrar todos os Ninjas   (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarPorId(id);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body( "Ninja com o ID: " + id + " não existe!");
        }
    }

    //Alterar dados do Ninja    (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        if (ninjaService.atualizarNinja(id, ninjaAtualizado) != null){
            NinjaDTO ninjaNovo = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaNovo);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID: " + id + " não existe!");
        }

    }

    //Deletar Ninja     (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        if (ninjaService.listarPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " deletado com sucesso! ");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Ninja com ID: " + id + " não existe ou já foi deletado.");
        }
    }

}
