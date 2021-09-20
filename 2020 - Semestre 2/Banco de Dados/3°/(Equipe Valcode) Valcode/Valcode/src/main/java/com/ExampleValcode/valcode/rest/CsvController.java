package com.ExampleValcode.valcode.rest;

import com.ExampleValcode.valcode.helper.CsvOperacoesHelper;
import com.ExampleValcode.valcode.message.ResponseMessage;
import com.ExampleValcode.valcode.service.*;
import com.ExampleValcode.valcode.util.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/csv")
public class CsvController {
    private final CsvFonteService fileService;


    private final CsvUtils utils;
    private final CsvModalidadeService modalidadeService;
    private final CsvMovimentosService movimentosService;
    private final CsvPessoaFisicaService pessoaFisicaService;
    private final CsvPagamentoService csvPagamentoService;
    private final CsvOperacoesService csvOperacoesService;

    @Autowired
    public CsvController(
            CsvFonteService fileService,
            CsvModalidadeService modalidadeService,
            CsvMovimentosService movimentosService,
            CsvPessoaFisicaService pessoaFisicaService,
            CsvUtils utils,
            CsvPagamentoService csvPagamentoService,
            CsvOperacoesService csvOperacoesService){
        this.modalidadeService = modalidadeService;
        this.fileService = fileService;
        this.utils = utils;
        this.movimentosService = movimentosService;
        this.pessoaFisicaService = pessoaFisicaService;
        this.csvPagamentoService = csvPagamentoService;
        this.csvOperacoesService = csvOperacoesService;
    }

    @PostMapping("/upload/{proccess}")
    public ResponseEntity<ResponseMessage> uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable String proccess
    ){
        String message = "";
        if (CsvUtils.hasCSVFormat(file)){
            try{
                switch (proccess){
                    case "fonte":
                        fileService.save(file);
                        break;
                    case "modalidade":
                        modalidadeService.save(file);
                        break;
                    case "movimentos":
                        movimentosService.save(file);
                        break;
                    case "pf":
                        pessoaFisicaService.save(file);
                        break;
                    case "pagamento":
                        csvPagamentoService.save(file);
                        break;
                    case "operacoes":
                        csvOperacoesService.save(file);
                        break;

                }

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e){
                message = "Could not upload the file: " + file.getOriginalFilename() + "! " + e.toString();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }


}
