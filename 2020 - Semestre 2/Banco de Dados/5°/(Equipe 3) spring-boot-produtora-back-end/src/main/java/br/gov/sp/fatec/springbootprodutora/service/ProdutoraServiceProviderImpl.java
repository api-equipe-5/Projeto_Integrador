package br.gov.sp.fatec.springbootprodutora.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.entity.Filme;
import br.gov.sp.fatec.springbootprodutora.entity.Novela;
import br.gov.sp.fatec.springbootprodutora.entity.Pessoa;
import br.gov.sp.fatec.springbootprodutora.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootprodutora.repository.AtorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DiretorRepository;
import br.gov.sp.fatec.springbootprodutora.repository.DubleRepository;
import br.gov.sp.fatec.springbootprodutora.repository.FilmeRepository;
import br.gov.sp.fatec.springbootprodutora.repository.NovelaRepository;

@Service("ProdutoraServiceProvider") 
public class ProdutoraServiceProviderImpl implements ProdutoraServiceProvider {

    @Autowired
    private FilmeRepository filmeRepo;

    @Autowired
    private NovelaRepository novelaRepo;

    @Autowired
    private DiretorRepository diretorRepo;

    @Autowired
    private AtorRepository atorRepo;

    @Autowired
    private DubleRepository dubleRepo;

    //Filme ----------------------------------------------------------------------------------------------------

    @Override
    public List<Filme> buscarTodosFilmes(){
        return filmeRepo.findAll();
    }

    @Override
    public Filme buscarFilmePorId(Long id)
    {
        Optional<Filme> filmeOp= filmeRepo.findById(id);
        if(filmeOp.isPresent())
        {
            return filmeOp.get();
        }
         throw new RegistroNaoEncontradoException("filme nao encontrado!");
    }

    @Override
    public Filme buscarFilmePorNome(String nome)
    {
        Filme filme = filmeRepo.findByNome(nome);
        if(filme!=null)
        {
            return filme;
        }
        throw new RegistroNaoEncontradoException("filme nao encontrado!");
    }

    @Transactional
    public Filme criaFilme(String nome, Long ano, Float duracao, String descricao, String nomeDiretor, String atorNome, String dubleNome) {
            
            Diretor diretor = diretorRepo.findByNome(nomeDiretor);
            Ator ator = atorRepo.findByNome(atorNome);
            Duble duble = dubleRepo.findByNome(dubleNome);

            Filme filme = new Filme();
            filme.setNome(nome);
            filme.setAno(ano);
            filme.setDuracao(duracao);
            filme.setDescricao(descricao);
            filme.setDiretor(diretor);
            filme.setPessoas(new HashSet<Pessoa>());
            filme.getPessoas().add(ator);
            filme.getPessoas().add(duble);
            
            filmeRepo.save(filme);

            return filme;
    }

    //Novela ----------------------------------------------------------------------------------------------------

    @Override
    public List<Novela> buscarTodasNovelas(){
        return novelaRepo.findAll();
    }

    @Override
    public Novela buscarNovelaPorId(Long id)
    {
        Optional<Novela> novelaOp= novelaRepo.findById(id);
        if(novelaOp.isPresent())
        {
            return novelaOp.get();
        }
         throw new RegistroNaoEncontradoException("novela nao encontrada!");
    }

    @Override
    public Novela buscarNovelaPorNome(String nome)
    {
        Novela novela = novelaRepo.findByNome(nome);
        if(novela!=null)
        {
            return novela;
        }
        throw new RegistroNaoEncontradoException("novela nao encontrada!");
    }

    //Diretor---------------------------------------------------------------------------------------------
    @PreAuthorize("hasAnyRole('ADMIN, DIRETOR')")
    public Diretor criaDiretor(String nome, Long cpf) {
        Diretor diretor = new Diretor();
        diretor.setNome(nome);
        diretor.setCpf(cpf);
        diretorRepo.save(diretor);

        return diretor;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    @Override
    public List<Diretor> buscarTodosDiretores(){
        return diretorRepo.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    @Override
    public Diretor buscarDiretorPorId(Long id)
    {
        Optional<Diretor> diretorOp= diretorRepo.findById(id);
        if(diretorOp.isPresent())
        {
            return diretorOp.get();
        }
         throw new RegistroNaoEncontradoException("diretor nao encontrado!");
    }
    
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Diretor buscarDiretorPorNome(String nome)
    {
        Diretor diretor = diretorRepo.findByNome(nome);
        if(diretor!=null)
        {
            return diretor;
        }
        throw new RegistroNaoEncontradoException("diretor nao encontrado!");
    }

    
    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Diretor> buscarDiretorPorLetra(String nome){
         List<Diretor> diretor = diretorRepo.findByNomeContainsIgnoreCase(nome);
        if(diretor!=null)
        {
            return diretor;
        }
        throw new RegistroNaoEncontradoException("diretor nao encontrado!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteDiretor(Long id){
        diretorRepo.deleteById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    public Diretor updateDiretor(Long id, String nome, Long cpf){
        Optional<Diretor> oldDiretor = diretorRepo.findById(id);

        if(oldDiretor.isPresent()){
            Diretor diretor = oldDiretor.get();
            diretor.setNome(nome);
            diretor.setCpf(cpf);
            diretorRepo.save(diretor);

            return diretor;
        }
        throw new RegistroNaoEncontradoException("diretor nao encontrado!");
    }

    //Ator ---------------------------------------------------------------------------------------------------
    public Ator criaAtor(String nome, Long cpf, String fama){
        Ator ator = new Ator();
        ator.setNome(nome);
        ator.setCpf(cpf);
        ator.setFama(fama);
        atorRepo.save(ator);

        return ator;
    }

    @Override
    public List<Ator> buscarTodosAtores(){
        return atorRepo.findAll();
    }

    @Override
    public Ator buscarAtorPorId(Long id)
    {
        Optional<Ator> atorOp= atorRepo.findById(id);
        if(atorOp.isPresent())
        {
            return atorOp.get();
        }
         throw new RegistroNaoEncontradoException("ator nao encontrado!");
    }

    @Override
    public Ator buscarAtorPorNome(String nome)
    {
        Ator ator = atorRepo.findByNome(nome);
        if(ator!=null)
        {
            return ator;
        }
        throw new RegistroNaoEncontradoException("ator nao encontrado!");
    }

    
    @Override
    public List<Ator> buscarAtorPorLetra(String nome){
         List<Ator> ator = atorRepo.findByNomeContainsIgnoreCase(nome);
        if(ator!=null)
        {
            return ator;
        }
        throw new RegistroNaoEncontradoException("ator nao encontrado!");
    }

    public void deleteAtor(Long id){
        atorRepo.deleteById(id);
    }

    public Ator updateAtor(Long id, String nome, Long cpf, String fama){
        Optional<Ator> oldAtor = atorRepo.findById(id);

        if(oldAtor.isPresent()){
            Ator ator = oldAtor.get();
            ator.setNome(nome);
            ator.setCpf(cpf);
            ator.setFama(fama);
            atorRepo.save(ator);

            return ator;
        }
        throw new RegistroNaoEncontradoException("ator nao encontrado!");
    }

    //Duble----------------------------------------------------------------------------------
    public Duble criaDuble(String nome, Long cpf, String especialidade){
        Duble duble = new Duble();
        duble.setNome(nome);
        duble.setCpf(cpf);
        duble.setEspecialidade(especialidade);
        dubleRepo.save(duble);

        return duble;
    }

    @Override
    public List<Duble> buscarTodosDubles(){
        return dubleRepo.findAll();
    }

    @Override
    public Duble buscarDublePorId(Long id)
    {
        Optional<Duble> dubleOp= dubleRepo.findById(id);
        if(dubleOp.isPresent())
        {
            return dubleOp.get();
        }
         throw new RegistroNaoEncontradoException("duble nao encontrado!");
    }

    @Override
    public Duble buscarDublePorNome(String nome)
    {
        Duble duble = dubleRepo.findByNome(nome);
        if(duble!=null)
        {
            return duble;
        }
        throw new RegistroNaoEncontradoException("duble nao encontrado!");
    }

    
    @Override
    public List<Duble> buscarDublePorLetra(String nome){
         List<Duble> duble = dubleRepo.findByNomeContainsIgnoreCase(nome);
        if(duble!=null)
        {
            return duble;
        }
        throw new RegistroNaoEncontradoException("duble nao encontrado!");
    }

    public void deleteDuble(Long id){
        dubleRepo.deleteById(id);
    }

    public Duble updateDuble(Long id, String nome, Long cpf, String especialidade){
        Optional<Duble> oldDuble = dubleRepo.findById(id);

        if(oldDuble.isPresent()){
            Duble duble = oldDuble.get();
            duble.setNome(nome);
            duble.setCpf(cpf);
            duble.setEspecialidade(especialidade);
            dubleRepo.save(duble);

            return duble;
        }
        throw new RegistroNaoEncontradoException("duble nao encontrado!");
    }

}