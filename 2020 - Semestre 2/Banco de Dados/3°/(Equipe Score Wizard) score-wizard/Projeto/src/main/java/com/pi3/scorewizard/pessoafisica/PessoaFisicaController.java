package com.pi3.scorewizard.pessoafisica;

import java.util.ArrayList;
import java.util.Date;

import com.pi3.scorewizard.experiencia.ExperienciaVerificacao;
import com.pi3.scorewizard.experiencia.ExperienciaVerificacaoController;
import com.pi3.scorewizard.experiencia.ExperienciaVerificacaoRepository;
import com.pi3.scorewizard.movimento.MovimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/pessoafisica")
public class PessoaFisicaController {

	@Autowired
    private PessoaFisicaRepository pessoafisicarepository;
    
    @Autowired
	private MovimentoRepository movimentorepository;
    
	@Autowired
	ExperienciaVerificacaoController ec = new ExperienciaVerificacaoController();
	
	@Autowired
	private ExperienciaVerificacaoRepository experienciaVerificacao;
	
	@PostMapping(path="/addpessoaf")
    public @ResponseBody String addpessoaf (@RequestParam String docCli,
    										@RequestParam String nome,
                                            @RequestParam String sexo,
                                            @RequestParam int date,
                                            @RequestParam String cidade,
                                            @RequestParam String estado, 
                                            @RequestParam String senha) {

      PessoaFisica pesf = new PessoaFisica(docCli, nome, sexo, date, cidade, estado, senha, 100); 
      pessoafisicarepository.save(pesf);
      
      ec.addExp(pesf.getDocumento(), "Pagamento", 0, 0, new Date());
      
      return "Saved";
    }
	
    @GetMapping(path="/getAllPessoaFisica")
    public @ResponseBody ArrayList<PessoaFisica> getAllPessoaFisica() {
        return pessoafisicarepository.findAll();
    }

    @GetMapping(path="/getPessoaFisica")
    public @ResponseBody PessoaFisica getPessoaFisica(@RequestParam String documento) {
         return pessoafisicarepository.findByDocumento(documento);
    }
    
    @PutMapping(path="/changePassword")
    public @ResponseBody String changePassword(@RequestParam String docCli,
                                                @RequestParam String senhaAtual, 
                                                @RequestParam String senhaNova) {

      if(pessoafisicarepository.findById(docCli).isPresent()) {
        PessoaFisica pesf = pessoafisicarepository.findById(docCli).get();
        if(pesf.getSenha().equals(senhaAtual)){
            pessoafisicarepository.save(pesf);
            return "Senha alterada com sucesso.";
        }
        return "A senha atual está incorreta.";
      }
      return "Documento não registrado.";
    }
    
    @GetMapping(path="/getPessoaFisicaMetas")
    public @ResponseBody Double getPessoaFisicaMetaMovimento(@RequestParam String documento) {
        PessoaFisica pessoa = pessoafisicarepository.findByDocumento(documento);
        Double atraso;

        atraso = Double.valueOf((movimentorepository.findByPessoaFisicaDocumento(pessoa.getDocumento()).size() * 100) / 100);

        return atraso;
    }
    
    @GetMapping(path="/getPessoaFisicaScore")
    public @ResponseBody int getPessoaFisicaScore(@RequestParam String documento) {
        PessoaFisica pessoa = pessoafisicarepository.findByDocumento(documento);
        Double operacao, parcela, atraso, inadimplencia, score;

        operacao = 100.00 / pessoa.getOperacoesCount();
        parcela = 100.00 / pessoa.getMovimentosCount();
        atraso = Double.valueOf((movimentorepository.findByPessoaFisicaDocumento(pessoa.getDocumento()).size() * 100) / 100);
        inadimplencia = (parcela * (atraso * 2))/100;
        score = 1000-(inadimplencia*100);
        
        System.out.println("Operacao " + pessoa.getOperacoesCount());
        System.out.println("Movimentos " + pessoa.getMovimentosCount());
        System.out.println("operacao: " + operacao.toString());
        System.out.println("parcela: " + parcela.toString());
        System.out.println("atraso: " + atraso.toString());
        System.out.println("inadimplencia: " + inadimplencia.toString());

        return score.intValue();
    }

    @GetMapping(path="/getPessoaFisicaNewScore")
    public @ResponseBody int getPessoaFisicaNewScore(@RequestParam String documento, @RequestParam ArrayList<Integer> movimentosId) {
        PessoaFisica pessoa = pessoafisicarepository.findByDocumento(documento);
        Double operacao, parcela, atraso, inadimplencia, score;

        operacao = 100.00 / pessoa.getOperacoesCount();
        parcela = 100.00 / pessoa.getMovimentosCount();
        atraso = Double.valueOf(((movimentorepository.findByPessoaFisicaDocumento(pessoa.getDocumento()).size() - movimentosId.size()) * 100) / 100);
        inadimplencia = (parcela * (atraso * 10))/10;
        score = 1000-(inadimplencia*100);
        
        return score.intValue();
    }
    
    @GetMapping(path="/getXP")
    public @ResponseBody int getCalcularXP(@RequestParam String documento) {
    	PessoaFisica pessoa = pessoafisicarepository.findByDocumento(documento);
        ExperienciaVerificacao experiencia = experienciaVerificacao.findByDocumentoCliente(documento);
        int operacao, movimentos;
        
        operacao = pessoa.getOperacoesCount();
        movimentos = pessoa.getMovimentosCount();
        System.out.println(operacao);
        System.out.println(movimentos);
        
        int oldoperacao = experiencia.getQtd_parcelas_operacoes();
        int oldmovimentos = experiencia.getQtd_parcelas_movimentos();
        
        int XPAdiquirido = 0;
        int XPMovimento = 0;
        int XPOperacao = 0;
        
        if(operacao < oldoperacao){
        	int operacoesToXP = oldoperacao - operacao;
			XPOperacao = operacoesToXP*10;
			System.out.println(XPOperacao);
        }
        
        if(movimentos < oldmovimentos){
			int movimentosToXP = oldmovimentos - movimentos;
			XPMovimento = movimentosToXP*20;
			System.out.println(XPMovimento);
        }
        
        XPAdiquirido = XPOperacao + XPMovimento;
        System.out.println(XPAdiquirido);
        
        ExperienciaVerificacao newexperiencia = new ExperienciaVerificacao(documento,"Pagamento",operacao,movimentos,new Date());
        PessoaFisica pesf = new PessoaFisica(documento, pessoa.getNome(), pessoa.getSexo(), pessoa.getAnoNascimento(), pessoa.getCidade(), pessoa.getEstado(), pessoa.getSenha(), (XPAdiquirido + pessoa.getXP()));

        pessoafisicarepository.save(pesf);
        experienciaVerificacao.save(newexperiencia);
        
        PessoaFisica pessoacont = pessoafisicarepository.findByDocumento(documento);
		int nivelUser = pessoacont.getXP()/100;
		System.out.println(nivelUser);

        return nivelUser;
    }
}
