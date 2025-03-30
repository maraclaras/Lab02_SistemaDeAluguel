
package com.aluguelcarro.demospring;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoAluguelRepository pedidoRepository;

    public List<PedidoAluguel> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoAluguel> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public PedidoAluguel criarPedido(PedidoAluguel pedido) {
        pedido.setStatus(StatusPedido.PENDENTE);
        pedido.setDataPedido(java.time.LocalDate.now());
        return pedidoRepository.save(pedido);
    }

    public PedidoAluguel atualizarPedido(Long id, PedidoAluguel pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setStatus(pedidoAtualizado.getStatus());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void cancelarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
