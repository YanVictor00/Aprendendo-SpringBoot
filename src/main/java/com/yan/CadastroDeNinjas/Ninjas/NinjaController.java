package com.yan.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de Boas Vindas", description = "Essa rota manda uma mensagem de Boas Vindas para o usuário que acessar ela")
    public String boasVindas(){
        return "Olá! Seja bem vindo a minha primeita rota!";
    }

    //CRUD
    //Adicionar Ninja   (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo Ninja", description = "Cria um novo Ninja e insere no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Ninja")
    })
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
    @Operation(summary = "Lista o Ninja por ID", description = "Rota lista ninja pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
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
    @Operation(summary = "Altera o Ninja por ID", description = "Rota altera ninja pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possível alterar")
    })
    public ResponseEntity<?> alterarNinjaPorID(
            @Parameter(description = "Usuario manda o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do Ninja Atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){

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
