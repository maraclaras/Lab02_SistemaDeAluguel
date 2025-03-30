package com.aluguelcarro.demospring;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String matricula;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    
    @Enumerated(EnumType.STRING)
    private Proprietario proprietario; // CLIENTE, EMPRESA, BANCO
}

enum Proprietario {
    CLIENTE, EMPRESA, BANCO
}
