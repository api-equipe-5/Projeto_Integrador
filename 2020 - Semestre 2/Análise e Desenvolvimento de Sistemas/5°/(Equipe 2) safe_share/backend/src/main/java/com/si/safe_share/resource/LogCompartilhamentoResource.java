package com.si.safe_share.resource;

import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.Empresa;
import com.si.safe_share.model.LogCompartilhamento;
import com.si.safe_share.repository.ClienteRepository;
import com.si.safe_share.repository.EmpresaRepository;
import com.si.safe_share.repository.LogCompartilhamentoRepository;
import com.si.safe_share.resource.form.LogCompartilhamentoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class LogCompartilhamentoResource {
    @Autowired
    LogCompartilhamentoRepository logCompartilhamentoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping("/log-compartilhamento")
    public LogCompartilhamento salva(@RequestBody LogCompartilhamentoForm logCompartilhamentoForm) {

        Optional<Cliente> cliente = clienteRepository.findById(logCompartilhamentoForm.getCliente());
        Optional<Empresa> empresa = empresaRepository.findById(logCompartilhamentoForm.getEmpresa());

        LogCompartilhamento logCompartilhamento = LogCompartilhamento.builder()
                .cliente(cliente.get())
                .dadoCompartilhado("Teste")
                .dataDeInicio(logCompartilhamentoForm.getDataDeInicio())
                .dataFinal(logCompartilhamentoForm.getDataFinal())
                .empresa(empresa.get())
                .build();

        return logCompartilhamentoRepository.save(logCompartilhamento);
    }

    @GetMapping("/log-cliente/{id}")
    public  List<LogCompartilhamento> buscaLogPorCliente(@PathVariable(value = "id") Integer id) {
        return logCompartilhamentoRepository.findByCliente_Id(id);
    }

    @GetMapping("/log-compartilhamento/{id}")
    public Optional<LogCompartilhamento> buscaPorId(@PathVariable(value = "id") Integer id) {
        return logCompartilhamentoRepository.findById(id);
    }

    @PutMapping("/log-compartilhamento/{id}")
    public LogCompartilhamento atualiza(@PathVariable(value = "id") Integer id,
                                        @RequestBody LogCompartilhamentoForm logCompartilhamentoForm) {

        Optional<LogCompartilhamento> logCompartilhamentoAntigoOpt = logCompartilhamentoRepository.findById(id);
        LogCompartilhamento logCompartilhamentoAntigo = new LogCompartilhamento();
        LogCompartilhamento logCompartilhamentoNovo = logCompartilhamentoForm.toModel(logCompartilhamentoForm);

        logCompartilhamentoAntigo.setCliente(logCompartilhamentoNovo.getCliente());
        logCompartilhamentoAntigo.setEmpresa(logCompartilhamentoNovo.getEmpresa());
        logCompartilhamentoAntigo.setDadoCompartilhado(logCompartilhamentoNovo.getDadoCompartilhado());
        logCompartilhamentoAntigo.setDataDeInicio(logCompartilhamentoNovo.getDataDeInicio());
        logCompartilhamentoAntigo.setDataFinal(logCompartilhamentoNovo.getDataFinal());

        LogCompartilhamento logCompartilhamentoAtualizado = logCompartilhamentoAntigo;
        return logCompartilhamentoRepository.save(logCompartilhamentoAtualizado);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/log-compartilhamentos")
    public List<LogCompartilhamento> lista() {
        return logCompartilhamentoRepository.findAll();
    }
}
