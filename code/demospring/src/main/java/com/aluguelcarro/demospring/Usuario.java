package com.aluguelcarro.demospring;
public import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String profissao;
    private String entidadeEmpregadora;
    private Double rendimento;
    private String email;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario; // CLIENTE, AGENTE
}

enum TipoUsuario {
    CLIENTE, AGENTE
}
 Usuario {
    
}
