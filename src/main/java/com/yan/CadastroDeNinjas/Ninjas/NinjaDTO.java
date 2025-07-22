package com.yan.CadastroDeNinjas.Ninjas;

import com.yan.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private String altura;
    private String imgUrl;
    private MissoesModel missoes;




}
