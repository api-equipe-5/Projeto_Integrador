package com.si.safe_share.resource;

import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.ConfiguracaoCompartilhamento;
import com.si.safe_share.model.Chaves;
import com.si.safe_share.repository.ClienteRepository;
import com.si.safe_share.repository.ConfiguracaoCompartilhamentoRepository;
import com.si.safe_share.repository.ContainerDeChavesRepository;
import com.si.safe_share.resource.form.ConfiguracaoCompartilhamentoForm;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.io.IOException;
import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

@RestController
@RequestMapping(value = "/api")
public class ConfiguracaoCompartilhamentoResource {

    Logger logger = LoggerFactory.getLogger(ConfiguracaoCompartilhamentoResource.class);

    @Autowired
    ConfiguracaoCompartilhamentoRepository configuracaoCompartilhamentoRepository;
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContainerDeChavesRepository containerRepository;

    @PostMapping("/configuracaoCompartilhamento")
    @Transactional
    public ConfiguracaoCompartilhamento salva(
            @RequestBody ConfiguracaoCompartilhamentoForm compartilhamentoForm) throws NoSuchPaddingException,
                                                                                       NoSuchAlgorithmException,
                                                                                       InvalidKeyException,
                                                                                       BadPaddingException,
                                                                                       IllegalBlockSizeException,
                                                                                       IOException,
                                                                                       InvalidAlgorithmParameterException {

        Optional<Cliente> cliente = clienteRepository.findById(compartilhamentoForm.getCliente());
        ConfiguracaoCompartilhamento configuracaoCompartilhamento = ConfiguracaoCompartilhamento.builder()
                        .cliente(cliente.get())
                        .compartilha_dados_pessoais(compartilhamentoForm.getCompartilha_dados_pessoais())
                        .compartilha_dados_compras(compartilhamentoForm.getCompartilha_dados_compras())
                        .build();
        Optional<Chaves> container = containerRepository.findByClienteId(compartilhamentoForm.getCliente());
        String encryptionKey = "";
        String characterEncoding       = "UTF-8";
        String cipherTransformation    = "AES/CBC/PKCS5PADDING";
        String aesEncryptionAlgorithem = "AES";

        if(container.isPresent()){
            encryptionKey = container.get().getChave();
        }else{
            encryptionKey = UUID.randomUUID().toString().substring(0,16);
            Chaves chaveCriada = Chaves.builder()
                    .cliente(cliente.get())
                    .chave(encryptionKey)
                    .build();
            containerRepository.save(chaveCriada);
        }

        if(compartilhamentoForm.getCompartilha_dados_pessoais() == false){
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);

            byte[] endereco = cipher.doFinal(cliente.get().getEndereco().getBytes("UTF8"));
            byte[] telefone = cipher.doFinal(cliente.get().getTelefone().getBytes("UTF8"));
            byte[] nome = cipher.doFinal(cliente.get().getNome().getBytes("UTF8"));
            byte[] sobrenome = cipher.doFinal(cliente.get().getSobrenome().getBytes("UTF8"));
            byte[] cpf = cipher.doFinal(cliente.get().getCpf().getBytes("UTF8"));

            Base64.Encoder encoder = Base64.getEncoder();

            String enderecoCriptografado = encoder.encodeToString(endereco);
            String telefoneCriptografado = encoder.encodeToString(telefone);
            String nomeCriptografado = encoder.encodeToString(nome);
            String sobrenomeCriptografado = encoder.encodeToString(sobrenome);
            String cpfCriptografado = encoder.encodeToString(cpf);

            cliente.get().setCpf(cpfCriptografado);
            cliente.get().setNome(nomeCriptografado);
            cliente.get().setSobrenome(sobrenomeCriptografado);
            cliente.get().setTelefone(telefoneCriptografado);
            cliente.get().setEndereco(enderecoCriptografado);

            clienteRepository.save(cliente.get());
            logger.info("Dados do usuário "+cliente.get().getEmail()+" ofuscados");

        }else if(compartilhamentoForm.getCompartilha_dados_pessoais() == true){
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
            Base64.Decoder decoder = Base64.getDecoder();

            byte[] cpfCriptografado = decoder.decode(cliente.get().getCpf().getBytes("UTF8"));
            byte[] nomeCriptografado = decoder.decode(cliente.get().getNome().getBytes("UTF8"));
            byte[] sobrenomeCriptografado = decoder.decode(cliente.get().getSobrenome().getBytes("UTF8"));
            byte[] telefoneCriptografado = decoder.decode(cliente.get().getTelefone().getBytes("UTF8"));
            byte[] enderecoCriptografado = decoder.decode(cliente.get().getEndereco().getBytes("UTF8"));

            String cpfDecriptado = new String(cipher.doFinal(cpfCriptografado), "UTF-8");
            String nomeDecriptado = new String(cipher.doFinal(nomeCriptografado), "UTF-8");
            String sobrenomeDecriptado = new String(cipher.doFinal(sobrenomeCriptografado), "UTF-8");
            String telefoneDecriptado = new String(cipher.doFinal(telefoneCriptografado), "UTF-8");
            String enderecoDecriptado = new String(cipher.doFinal(enderecoCriptografado), "UTF-8");

            cliente.get().setCpf(cpfDecriptado);
            cliente.get().setNome(nomeDecriptado);
            cliente.get().setSobrenome(sobrenomeDecriptado);
            cliente.get().setTelefone(telefoneDecriptado);
            cliente.get().setEndereco(enderecoDecriptado);

            clienteRepository.save(cliente.get());
            logger.info("Dados do usuário "+cliente.get().getEmail()+" desofuscados");
        }
        return configuracaoCompartilhamentoRepository.save(configuracaoCompartilhamento);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/configuracaoCompartilhamento/{id}")
    public Optional<ConfiguracaoCompartilhamento> buscaPorId(@PathVariable(value = "id") Integer id) {
        return configuracaoCompartilhamentoRepository.findById(id);
    }

    @GetMapping("/configuracao-compartilhamentos")
    public List<ConfiguracaoCompartilhamento> lista() {
        return configuracaoCompartilhamentoRepository.findAll();
    }
}
