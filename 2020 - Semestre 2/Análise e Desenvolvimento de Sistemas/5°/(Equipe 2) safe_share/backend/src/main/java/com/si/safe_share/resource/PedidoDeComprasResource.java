package com.si.safe_share.resource;

import com.si.safe_share.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PedidoDeComprasResource {

    @Autowired
    ComprasRepository comprasRepository;

    @GetMapping("/produtos-clientes")
    public List<Pedido> lista() {
        return comprasRepository.findCompras();
    }

}
