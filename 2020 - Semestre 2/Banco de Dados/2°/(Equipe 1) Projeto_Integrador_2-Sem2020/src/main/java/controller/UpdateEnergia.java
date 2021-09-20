package controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import javafx.scene.control.ComboBox;
import java.util.Optional;
import java.util.ResourceBundle;
import util.TextFieldFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import classes.Conta;
import classes.Energia;
import dao.ContaDAO;
import dao.EnergiaDAO;

public class UpdateEnergia implements Initializable {
    
    @FXML
    private TextField txtNumInstalacao;
    @FXML
    private TextField txtMesReferenciaEnergia;
    @FXML
    private TextField txtContaKwH;
    @FXML
    private TextField txtDataVencimento;
    @FXML
    private TextField txtValorTotalAPagar;
    @FXML
    private TextField txtDataLeituraAnterior;
    @FXML
    private TextField txtDataLeituraAtual;
    @FXML
    private ComboBox comboBandeirasTarifarias;
    @FXML
    private TextField txtConstMulti;
    @FXML
    private TextField txtNRdoMedidor;
    @FXML
    private TextField txtLeituraAnterior;
    @FXML
    private TextField txtLeituraAtual;
    @FXML
    private TextField txtCodigoFiscal;
    @FXML
    private TextField txtGrupoSubgrupo;
    @FXML
    private TextField txtClasseSubclasse;
    @FXML
    private TextField txtRoteiroLeitura;
    @FXML
    private TextField txtMTarifaria;
    @FXML
    private TextField txtTensaoNominal;
    @FXML
    private TextField txtFornecimento;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtNCadastros;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnRetornarEnergia;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnDeletar;

    @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
            // TODO Auto-generated method stub
            comboBandeirasTarifarias.getItems().add("Verde");
            comboBandeirasTarifarias.getItems().add("Amarelo");
            comboBandeirasTarifarias.getItems().add("Vermelho");
        }

    public void changeScreenRetornarRelatorio(ActionEvent event) {
        Main.changeScreen("main");

        txtNumInstalacao.setText("");
        txtMesReferenciaEnergia.setText("");
        txtContaKwH.setText("");
        txtValorTotalAPagar.setText("");
        txtDataLeituraAnterior.setText("");
        txtDataLeituraAtual.setText("");
        comboBandeirasTarifarias.setValue("");
        txtConstMulti.setText("");
        txtNRdoMedidor.setText("");
        txtLeituraAnterior.setText("");
        txtLeituraAtual.setText("");
        txtCodigoFiscal.setText("");
        txtGrupoSubgrupo.setText("");
        txtClasseSubclasse.setText("");
        txtRoteiroLeitura.setText("");
        txtMTarifaria.setText("");
        txtTensaoNominal.setText("");
        txtFornecimento.setText("");
        txtUsuario.setText("");
        txtNCadastros.setText("");
        txtDataVencimento.setText("");
    }
    public void buscarNumeroInstalacao(ActionEvent event) {
         if (EnergiaDAO.validacaoConta(BigInteger.valueOf(Long.parseLong(txtNumInstalacao.getText())), txtMesReferenciaEnergia.getText())){

            EnergiaDAO.buscar(BigInteger.valueOf(Long.parseLong(txtNumInstalacao.getText())), txtMesReferenciaEnergia.getText(),txtContaKwH,txtValorTotalAPagar,txtDataLeituraAnterior,txtDataLeituraAtual,comboBandeirasTarifarias,txtConstMulti,txtNRdoMedidor,txtLeituraAnterior,txtLeituraAtual,txtCodigoFiscal,txtGrupoSubgrupo,txtClasseSubclasse,txtRoteiroLeitura,txtMTarifaria,txtTensaoNominal,txtFornecimento);     
            ContaDAO.buscarconta(BigInteger.valueOf(Long.parseLong(txtNumInstalacao.getText())), txtMesReferenciaEnergia.getText(),txtDataVencimento);  
            ContaDAO.buscarUsuario(txtUsuario);
            ContaDAO.buscarContador(txtNCadastros);
        } else {
            Alert cadastro = new Alert(Alert.AlertType.INFORMATION);
            cadastro.setTitle("Numero de instalação e/ou mês de referência não encontrado");
            cadastro.setHeaderText("Digite um numero de instalação e/ou mês de referência válido!");
            cadastro.showAndWait();

            txtNumInstalacao.setText("");
            txtMesReferenciaEnergia.setText("");

        }
    }

    public void editarCampos(ActionEvent event) {
            Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA ATUALIZAR O CADASTRO?");

            Optional<ButtonType> result = confirmacao.showAndWait();
            if (result.get() == ButtonType.OK){
                Energia n = new Energia();
                EnergiaDAO daoene = new EnergiaDAO();

                n.setEne_consumo_conta_mes(BigInteger.valueOf(Long.parseLong(txtContaKwH.getText())));
                n.setEne_codigo_fiscal(BigInteger.valueOf(Long.parseLong(txtCodigoFiscal.getText())));
                n.setEne_grupo_subgrupo(txtGrupoSubgrupo.getText());
                n.setEne_tipo_fornecimento(txtFornecimento.getText());
                n.setEne_classe_subclasse(txtClasseSubclasse.getText());
                n.setEne_roteiro_leitura(txtRoteiroLeitura.getText());
                n.setEne_modalidade_tarifaria(txtMTarifaria.getText());
                n.setEne_tensao_nominal(txtTensaoNominal.getText());
                n.setEne_numero_medidor(BigInteger.valueOf(Long.parseLong(txtNRdoMedidor.getText())));
                n.setEne_const_multi(BigDecimal.valueOf(Double.parseDouble(txtConstMulti.getText())));
                n.setEne_leitura_anterior_cod(BigInteger.valueOf(Long.parseLong(txtLeituraAnterior.getText())));
                n.setEne_leitura_atual_cod(BigInteger.valueOf(Long.parseLong(txtLeituraAtual.getText())));
                n.setEne_data_leitura_anterior(txtDataLeituraAnterior.getText());
                n.setEne_data_leitura_atual(txtDataLeituraAtual.getText());
                n.setEne_tipo_bandeira(String.valueOf(comboBandeirasTarifarias.getValue()));
                n.setEne_valor_total(BigDecimal.valueOf(Double.parseDouble(txtValorTotalAPagar.getText())));
                n.setInt_numero_instalacao(BigInteger.valueOf(Long.parseLong(txtNumInstalacao.getText())));
                n.setCta_mes_referencia(txtMesReferenciaEnergia.getText());

                daoene.update(n);
                Conta c = new Conta();
                ContaDAO daoconta = new ContaDAO();
                c.setCta_mes_referencia(txtMesReferenciaEnergia.getText());
                c.setInt_numero_instalacao(BigInteger.valueOf(Long.parseLong(txtNumInstalacao.getText())));
                c.setCta_vencimento(txtDataVencimento.getText());
                
                daoconta.updateconta(c);
                
                Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados atualizado com sucesso");
                cadastrado.setHeaderText("Os dados foram atualizados com sucesso");
                cadastrado.showAndWait();

                txtNumInstalacao.setText("");
                txtDataVencimento.setText("");
                txtMesReferenciaEnergia.setText("");
                txtContaKwH.setText("");
                txtValorTotalAPagar.setText("");
                txtDataLeituraAnterior.setText("");
                txtDataLeituraAtual.setText("");
                comboBandeirasTarifarias.setValue("");
                txtConstMulti.setText("");
                txtNRdoMedidor.setText("");
                txtLeituraAnterior.setText("");
                txtLeituraAtual.setText("");
                txtCodigoFiscal.setText("");
                txtGrupoSubgrupo.setText("");
                txtClasseSubclasse.setText("");
                txtRoteiroLeitura.setText("");
                txtMTarifaria.setText("");
                txtTensaoNominal.setText("");
                txtFornecimento.setText("");
                txtUsuario.setText("");
                txtNCadastros.setText("");
         }else{

         }
    }   

    public void deletarConta(ActionEvent event) {
        Alert confirmacao = new Alert(AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação de Informações");
            confirmacao.setHeaderText(null);
            confirmacao.setContentText("DESEJA DELETAR ESSA CONTA DE ENERGIA?");

        Optional<ButtonType> result = confirmacao.showAndWait();
         if (result.get() == ButtonType.OK){
            Energia n = new Energia();
            EnergiaDAO daoene = new EnergiaDAO();

            n.setInt_numero_instalacao(BigInteger.valueOf(Long.parseLong(txtNumInstalacao.getText())));
            n.setCta_mes_referencia(txtMesReferenciaEnergia.getText());
            
            daoene.delete(n);

            ContaDAO daoconta = new ContaDAO();
            daoconta.delete();

            Alert cadastrado = new Alert(Alert.AlertType.INFORMATION);
                cadastrado.setTitle("Dados deletados com sucesso");
                cadastrado.setHeaderText("Os dados foram deletados com sucesso");
                cadastrado.showAndWait();

                txtNumInstalacao.setText("");
                txtDataVencimento.setText("");
                txtMesReferenciaEnergia.setText("");
                txtContaKwH.setText("");
                txtValorTotalAPagar.setText("");
                txtDataLeituraAnterior.setText("");
                txtDataLeituraAtual.setText("");
                comboBandeirasTarifarias.setValue("");
                txtConstMulti.setText("");
                txtNRdoMedidor.setText("");
                txtLeituraAnterior.setText("");
                txtLeituraAtual.setText("");
                txtCodigoFiscal.setText("");
                txtGrupoSubgrupo.setText("");
                txtClasseSubclasse.setText("");
                txtRoteiroLeitura.setText("");
                txtMTarifaria.setText("");
                txtTensaoNominal.setText("");
                txtFornecimento.setText("");
                txtUsuario.setText("");
                txtNCadastros.setText("");
        }else{

        }

        }
   
    
    @FXML
    private void mascaraVencimento(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataVencimento);
        tff.formatter();
    }
    @FXML
    private void mascaraDataAnt(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataLeituraAnterior);
        tff.formatter();
    }
    @FXML
    private void mascaraDataAtual(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtDataLeituraAtual);
        tff.formatter();
    }
    @FXML
    private void mascaraMesReferencia(){
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("##/####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtMesReferenciaEnergia);
        tff.formatter();
    }
}