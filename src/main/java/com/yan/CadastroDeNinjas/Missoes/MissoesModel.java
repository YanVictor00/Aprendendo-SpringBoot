package com.yan.CadastroDeNinjas.Missoes;

import com.yan.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;
    private NinjaModel ninja;



    public MissoesModel(Long id, String nome, String rank){
        this.id = id;
        this.nome = nome;
        this.rank = rank;
    }
    public MissoesModel(){}
}
