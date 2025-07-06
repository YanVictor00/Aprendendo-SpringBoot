package com.yan.CadastroDeNinjas.Missoes;
import com.yan.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    //MOSTRAR
    public List<MissoesModel> mostrarMissoes(){
        return missoesRepository.findAll();
    }

    //CRIAR
    public MissoesModel mostrarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //DELETAR


    //ATUALIZAR




}
