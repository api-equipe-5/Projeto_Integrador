package br.gov.sp.fatec.springbootapp.service;

import java.util.Set;

import br.gov.sp.fatec.springbootapp.entity.Conversa;
import br.gov.sp.fatec.springbootapp.entity.Mensagem;

public interface ChatService {
    
    public Conversa iniciarConversa(String nomeRemetente, String nomeDestinatario, String dataHora,String conteudo);

    public Mensagem enviarMensagem(Long chatID, String nomeRemetente, String nomeDestinatario, String dataHora,String conteudo);

    public void apagarConversa(Long chatID);

    public Set<Mensagem> buscarMensagensPorIdConversa(Long conversaID);
}
