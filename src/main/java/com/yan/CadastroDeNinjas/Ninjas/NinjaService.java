package com.yan.CadastroDeNinjas.Ninjas;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;


    // LISTAR TODOS OS NINJAS
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // LISTAR POR ID
    public NinjaModel listarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // CRIAR UM NOVO NINJA
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // DELETAR NINJA
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    //ATUALIZAR NINJA

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){

        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        } else {
            return null;
        }

    }

}
