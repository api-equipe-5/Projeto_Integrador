package br.gov.sp.fatec.springbootapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootapp.entity.Atividade;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;
import br.gov.sp.fatec.springbootapp.repository.AtividadeRepository;

@Service("AtividadeService")
public class AtividadeServiceImpl implements AtividadeService {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AtividadeRepository atvRepo;

    SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");

    @Transactional
    public Atividade criarAtividade(String nomeDestinatario, String nomeRemetente, String titulo, String conteudo,
            String dataDisparo, String dataAgendada, Integer status) {

        Usuario usuarioDestinatario = usuarioRepo.buscaUsuarioPorNome(nomeDestinatario);
        Usuario usuarioRemetente = usuarioRepo.buscaUsuarioPorNome(nomeRemetente);
        
        Atividade atividade = new Atividade();
        atividade.setTitulo(titulo);
        atividade.setConteudo(conteudo);
        atividade.setAtvRemetente(usuarioRemetente);
        atividade.setAtvDestinatario(usuarioDestinatario);

        try {
            atividade.setDataDisparo(this.formatoData.parse(dataDisparo));
            atividade.setDataLimite(this.formatoData.parse(dataAgendada));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        atividade.setStatus(status);
        atvRepo.save(atividade);
        return atividade;
    }

    @Override
    @Transactional
    public void deletarAtividade(Long notID) {
        atvRepo.deleteById(notID);
    }

    @Override
    @Transactional
    public Atividade atualizarStatusAtividade(Long notID, Integer status) {

        Optional<Atividade> notOp = atvRepo.findById(notID);

        if(notOp.isPresent()){
            Atividade atividade = notOp.get();

            atividade.setStatus(status);
            atvRepo.save(atividade);
            return atividade;
        
        }
        throw new RegistroNaoEncontradoException("Atividade não encontrada");
    }

    @Override
    public Atividade concluirAtividade(Long notID, Integer status, String dataConclusao) {
        Optional<Atividade> notOp = atvRepo.findById(notID);

        if(notOp.isPresent()){
            Atividade atividade = notOp.get();

            atividade.setStatus(status);
            try {
                atividade.setDataConclusao(this.formatoData.parse(dataConclusao));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            atvRepo.save(atividade);
            return atividade;
        
        }
        throw new RegistroNaoEncontradoException("Atividade não encontrada");
    }
    
}