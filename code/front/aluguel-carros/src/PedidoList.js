import { useEffect, useState } from "react";
import api from "./api";

const PedidosList = () => {
    const [pedidos, setPedidos] = useState([]);

    useEffect(() => {
        api.get("/pedidos")
            .then(response => setPedidos(response.data))
            .catch(error => console.error("Erro ao buscar pedidos", error));
    }, []);

    return (
        <div>
            <h2>Lista de Pedidos</h2>
            <ul>
                {pedidos.map(pedido => (
                    <li key={pedido.id}>{pedido.cliente.nome} - {pedido.status}</li>
                ))}
            </ul>
        </div>
    );
};

export default PedidosList;
