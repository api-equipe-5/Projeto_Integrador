package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootapp.entity.Conversa;
import br.gov.sp.fatec.springbootapp.entity.Mensagem;
import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;
import br.gov.sp.fatec.springbootapp.repository.ConversaRepository;
import br.gov.sp.fatec.springbootapp.repository.MensagemRepository;

@Service("chatService")
public class ChatServiceImpl implements ChatService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    ConversaRepository conversaRepo;

    @Autowired
    MensagemRepository mensagemRepo;

    @Override
    @Transactional
    public Conversa iniciarConversa(String nomeRemetente, String nomeDestinatario, String dataHora, String conteudo) {
        Usuario remetente = usuarioRepo.findByNome(nomeRemetente);
        Usuario destinatario = usuarioRepo.findByNome(nomeDestinatario);

        Conversa conversa = new Conversa();
        conversa.setUsuarios(new HashSet<Usuario>());

        // Adicionando a conversa para o Remetente
        conversa.getUsuarios().add(remetente);
        conversaRepo.save(conversa);
        remetente.setConversas(new HashSet<Conversa>());
        remetente.getConversas().add(conversa);

        // Adicionando a conversa para o Destinatario
        conversa.getUsuarios().add(destinatario);
        conversaRepo.save(conversa);
        destinatario.setConversas(new HashSet<Conversa>());
        destinatario.getConversas().add(conversa);

        Mensagem mensagem = new Mensagem();
        mensagem.setConteudo(conteudo);
        mensagem.setDataHora(dataHora);
        mensagem.setConversa(conversa);
        mensagem.setUsuarios(new HashSet<Usuario>());
        mensagem.getUsuarios().add(remetente);
        mensagem.setDestinatario(destinatario);
        mensagemRepo.save(mensagem);

        remetente.setMensagens(new HashSet<Mensagem>());
        remetente.getMensagens().add(mensagem);
        conversa.setMensagens(new HashSet<Mensagem>());
        conversa.getMensagens().add(mensagem);
        conversaRepo.save(conversa);
        usuarioRepo.save(remetente);
        usuarioRepo.save(destinatario);

        return conversa;
    }

    @Override
    @Transactional
    public Mensagem enviarMensagem(Long chatID, String nomeRemetente, String nomeDestinatario, String dataHora,
            String conteudo) {

        Optional<Conversa> conversaOp = conversaRepo.findById(chatID);

        if (conversaOp.isPresent()) {
            Usuario remetente = usuarioRepo.findByNome(nomeRemetente);
            Usuario destinatario = usuarioRepo.findByNome(nomeDestinatario);

            Conversa conversa = conversaOp.get();

            Mensagem mensagem = new Mensagem();
            mensagem.setConteudo(conteudo);
            mensagem.setDataHora(dataHora);
            mensagem.setConversa(conversa);
            mensagem.setUsuarios(new HashSet<Usuario>());
            mensagem.getUsuarios().add(remetente);
            mensagem.setDestinatario(destinatario);
            mensagemRepo.save(mensagem);

            conversa.setMensagens(new HashSet<Mensagem>());
            conversa.getMensagens().add(mensagem);
            conversaRepo.save(conversa);
            remetente.setMensagens(new HashSet<Mensagem>());
            remetente.getMensagens().add(mensagem);
            usuarioRepo.save(remetente);

            return mensagem;
        }
       Conversa conversa =  iniciarConversa(nomeRemetente, nomeDestinatario, dataHora, conteudo);
       Mensagem mensagem = conversa.getMensagens().iterator().next();

       return mensagem;
    }

    @Override
    @Transactional
    @Modifying
    public void apagarConversa(Long chatID) {
        conversaRepo.deleteById(chatID);
    }

    @Override
    public Set<Mensagem> buscarMensagensPorIdConversa(Long conversaID) {
        Optional<Conversa> conversaOp = conversaRepo.findById(conversaID);
        Conversa conversa = conversaOp.get();

        Set<Mensagem> mensagens = conversa.getMensagens();

        return mensagens;
    }

}
