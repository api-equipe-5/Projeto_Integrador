package br.gov.sp.fatec.springbootapp.service;

import br.gov.sp.fatec.springbootapp.entity.Atividade;

public interface AtividadeService {

    public Atividade criarAtividade(String nomeDestinatario, String nomeRemetente, String titulo, String conteudo,
            String dataDisparo, String dataAgendada, Integer status);

    // public LinkedList<Notificacao> criarNotificacaoDupla(String
    // nomeDestinatario1, String nomeDestinatario2, String nomeRemetente, String
    // titulo, String conteudo);
    public void deletarAtividade(Long notID);

    public Atividade atualizarStatusAtividade(Long notID, Integer status);

    public Atividade concluirAtividade(Long notID, Integer status, String dataConclusao);
}