package com.si.safe_share.resource.form;

import com.si.safe_share.model.Carrinho;
import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.Produto;
import com.si.safe_share.repository.ClienteRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

@Getter
public class CarrinhoForm {
    private Set<Produto> produtos;
    private Integer cliente;

//    public Carrinho toModel(CarrinhoForm carrinhoForm) {
//
//        Optional<Cliente> clienteOpt = clienteRepository.findById(carrinhoForm.getCliente());
//        Cliente cliente = clienteOpt.get();
//
//        Carrinho carrinho = Carrinho.builder()
//                .cliente(cliente)
//                .produtos(carrinhoForm.getProdutos())
//                .build();
//        return carrinho;
//    }

    public Carrinho toModelUpdated(Carrinho carrinhoAntigo, Carrinho carrinhoNovo) {
        carrinhoAntigo.setCliente(carrinhoNovo.getCliente());
        carrinhoAntigo.setProdutos(carrinhoNovo.getProdutos());
        Carrinho carrinhoAtualizado = carrinhoAntigo;
        return carrinhoAtualizado;
    }

}
