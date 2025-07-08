package com.yan.CadastroDeNinjas.Ninjas;

import com.yan.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Email",unique = true)
    private String email;


    @Column(name = "Idade")
    private int idade;

    @Column(name = "Rank")
    private String rank;

    @Column(name = "Altura")
    private String altura;

    @Column(name = "Imagem")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;


}
