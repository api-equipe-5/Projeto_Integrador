package com.si.safe_share.resource.form;

import com.si.safe_share.model.Carrinho;
import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.Pedido;
import com.si.safe_share.repository.CarrinhoRepository;
import com.si.safe_share.repository.ClienteRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class PedidoForm {
    private Integer cliente;
    private Integer carrinho;
    private BigDecimal valorTotal;



//    public Pedido toModel(PedidoForm pedidoForm) {
//        Optional<Cliente> clienteEncontradoOpt = clienteRepository.findById(pedidoForm.getCliente());
//        Cliente cliente = clienteEncontradoOpt.get();
//
//        Optional<Carrinho> carrinhoEncontradoOpt = carrinhoRepository.findById(pedidoForm.getCliente());
//        Carrinho carrinho = carrinhoEncontradoOpt.get();
//
//        Pedido pedido = Pedido.builder()
//                .cliente(cliente)
//                .dataDoPedido(LocalDateTime.now())
//                .carrinho(carrinho)
//                .build();
//        return pedido;
//    }
//
//    public Pedido toModelUpdated(Pedido pedidoAntigo, Pedido pedidoNovo) {
//        pedidoAntigo.setCliente(pedidoNovo.getCliente());
//        pedidoAntigo.setCarrinho(pedidoNovo.getCarrinho());
//        pedidoAntigo.setDataDoPedido(LocalDateTime.now());
//        Pedido pedidoAtualizado = pedidoAntigo;
//        return pedidoAtualizado;
//    }

}
