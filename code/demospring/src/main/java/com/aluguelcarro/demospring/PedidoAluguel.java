package com.aluguelcarro.demospring;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoAluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Usuario cliente;

    @ManyToOne
    private Automovel automovel;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status; // PENDENTE, APROVADO, CANCELADO

    private LocalDate dataPedido;
    private Double valorTotal;
}

enum StatusPedido {
    PENDENTE, APROVADO, CANCELADO
}
