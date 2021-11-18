package com.tecsus.ddc.app.energy;

import com.tecsus.ddc.app.ApplicationMain;
import com.tecsus.ddc.app.Screen;
import com.tecsus.ddc.app.TextFieldFormatter;
import com.tecsus.ddc.app.dashboard.DashboardBill;
import com.tecsus.ddc.app.dashboard.DashboardController;
import com.tecsus.ddc.bill.Bill;
import com.tecsus.ddc.bill.BillController;
import com.tecsus.ddc.bill.type.BillType;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.instalation.InstalationController;
import com.tecsus.ddc.meter.Meter;
import com.tecsus.ddc.register.Register;
import com.tecsus.ddc.register.RegisterController;
import com.tecsus.ddc.register.RegisterRepository;
import com.tecsus.ddc.security.SecurityContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class EnergyController implements Initializable {

    @FXML
    private TextField txtLeituraAtual, txtLeituraAnterior, txtProximaLeitura, txtMesRef;
    @FXML
    private TextField txtInstalacao, txtNumConta, txtMedidor, txtValor, txtValorAtual, txtValorAnterior, txtVencimento;
    @FXML
    private TextField txtConsumo, txtPeriodoConsumo;
    @FXML
    private Label lblCliente, lblFornecedor, lblEndereco;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (DashboardController.editable) {
            if (DashboardController.editableBill != null) {
                constructFrom(DashboardController.editableBill);
            }
        }
    }

    public void freeTxt() {
        txtLeituraAnterior.setText("");
        txtLeituraAtual.setText("");
        txtProximaLeitura.setText("");
        txtMesRef.setText("");
        txtInstalacao.setText("");
        txtNumConta.setText("");
        txtMedidor.setText("");
        txtValor.setText("");
        txtValorAtual.setText("");
        txtValorAnterior.setText("");
        txtConsumo.setText("");
        txtPeriodoConsumo.setText("");
        lblCliente.setText("");
        lblFornecedor.setText("");
        lblEndereco.setText("");
    }

    @FXML
    protected void back() {
        DashboardController.editable = false;
        freeTxt();
        ApplicationMain.changeScene(Screen.DASHBOARD);
    }

    @FXML
    protected void save() {
        String billNum = txtNumConta.getText();
        String instalation = txtInstalacao.getText();
        String meterNumber = txtMedidor.getText();
        String month = txtMesRef.getText();
        String value = txtValor.getText();
        String actualRead = txtLeituraAtual.getText();
        String actualReadValue = txtValorAtual.getText();
        String previousRead = txtLeituraAnterior.getText();
        String previousReadValue = txtValorAnterior.getText();
        String nextRead = txtProximaLeitura.getText();
        String dueDate = txtVencimento.getText();
        String consum = txtConsumo.getText();
        String consumPeriod = txtPeriodoConsumo.getText();

        SimpleDateFormat refMonthFormatter = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        BillController controller = new BillController(ApplicationMain.connector.getConnection());

        RegisterController registerController = new RegisterController(new RegisterRepository(ApplicationMain.connector.getConnection()));

        try {
            final Bill bill = Bill.builder()
                    .billType(BillType.ENERGY)
                    .instalation(Instalation.builder().instalationNumber(instalation).build())
                    .billNum(billNum)
                    .meter(Meter.builder().meterNumber(meterNumber).build())
                    .refMonth(refMonthFormatter.parse(month))
                    .value(new BigDecimal(value))
                    .actualRead(formatter.parse(actualRead))
                    .actualReadValue(new BigDecimal(actualReadValue))
                    .previousRead(formatter.parse(previousRead))
                    .previousReadValue(new BigDecimal(previousReadValue))
                    .nextRead(formatter.parse(nextRead))
                    .dueDate(formatter.parse(dueDate))
                    .consum(Integer.parseInt(consum))
                    .consumPeriod(Integer.parseInt(consumPeriod))
                    .build();
            controller.save(bill);

            Register register = Register.builder()
                    .user(SecurityContext.loggedUser.getUser())
                    .instalation(bill.getInstalation())
                    .bill(bill)
                    .build();

            registerController.save(register);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        freeTxt();
    }

    public void constructFrom(Bill bill) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat refMonthFormat = new SimpleDateFormat("MM/yyyy");

        txtLeituraAnterior.setText(dateFormat.format(bill.getPreviousRead()));
        txtLeituraAtual.setText(dateFormat.format(bill.getActualRead()));
        txtProximaLeitura.setText(dateFormat.format(bill.getNextRead()));
        txtMesRef.setText(refMonthFormat.format(bill.getRefMonth()));
        txtInstalacao.setText(bill.getInstalation().getInstalationNumber());
        txtNumConta.setText(bill.getBillNum());
        txtMedidor.setText(bill.getMeter().getMeterNumber());
        txtValor.setText(bill.getValue().toString());
        txtValorAtual.setText(bill.getActualReadValue().toString());
        txtValorAnterior.setText(bill.getPreviousReadValue().toString());
        txtConsumo.setText(bill.getConsum().toString());
        txtPeriodoConsumo.setText(bill.getConsumPeriod().toString());

        searchInstalation(bill.getInstalation().getInstalationNumber());
        DashboardController.editable = false;
    }

    @FXML
    protected void searchInstalation() {
        String instalation = txtInstalacao.getText();
        this.searchInstalation(instalation);
    }

    protected void searchInstalation(String instalation) {
        InstalationController controller = new InstalationController(ApplicationMain.connector.getConnection());
        Instalation response = controller.find(instalation);

        lblCliente.setText(String.format("%s, %s", response.getClient().getName(), response.getClient().getIdentification().getDocument()));
        lblFornecedor.setText(String.format("%s, %s", response.getSupplier().getName(), response.getSupplier().getCnpj().getDocument()));
        lblEndereco.setText(response.getAddress().toString());
    }


    @FXML
    public void mascData(KeyEvent keyEvent) {
        TextFieldFormatter dataMasc = new TextFieldFormatter();
        dataMasc.setMask("##/##/####");
        dataMasc.setCaracteresValidos("0123456789");
        dataMasc.setTf(txtLeituraAtual);
        dataMasc.formatter();
        dataMasc.setTf(txtLeituraAnterior);
        dataMasc.formatter();
        dataMasc.setTf(txtProximaLeitura);
        dataMasc.formatter();
        dataMasc.setTf(txtVencimento);
        dataMasc.formatter();
    }
    @FXML
    public void mascRef(KeyEvent keyEvent) {
        TextFieldFormatter refMasc = new TextFieldFormatter();
        refMasc.setMask("##/####");
        refMasc.setCaracteresValidos("0123456789");
        refMasc.setTf(txtMesRef);
        refMasc.formatter();
    }
}
