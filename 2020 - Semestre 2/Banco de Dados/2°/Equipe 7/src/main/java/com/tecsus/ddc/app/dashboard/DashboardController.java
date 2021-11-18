package com.tecsus.ddc.app.dashboard;

import com.tecsus.ddc.app.ApplicationMain;
import com.tecsus.ddc.app.Screen;
import com.tecsus.ddc.app.dialog.DialogPopup;
import com.tecsus.ddc.app.energy.EnergyController;
import com.tecsus.ddc.bill.Bill;
import com.tecsus.ddc.bill.BillController;
import com.tecsus.ddc.bill.type.BillType;
import com.tecsus.ddc.language.LanguageKeyValue;
import com.tecsus.ddc.security.SecurityContext;
import com.tecsus.ddc.user.Role;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Getter
public class DashboardController implements Initializable {

    public static boolean editable = false;
    public static Bill editableBill;

    @FXML
    private TableView<DashboardBill> billTable;
    @FXML
    private TableColumn<DashboardBill, String> number;
    @FXML
    private TableColumn<DashboardBill, String> clientCNPJ;
    @FXML
    private TableColumn<DashboardBill, String> clientName;
    @FXML
    private TableColumn<DashboardBill, String> supplier;
    @FXML
    private TableColumn<DashboardBill, String> type;
    @FXML
    private TableColumn<DashboardBill, String> instalation;
    @FXML
    private TableColumn<DashboardBill, String> hidrometer;
    @FXML
    private TableColumn<DashboardBill, String> register;
    @FXML
    private Button btnAddEnergy;
    @FXML
    private Button btnAddWater;
    @FXML
    private Button edit;
    @FXML
    private Button delete;
    @FXML
    private Button btnUserReport;
    @FXML
    private Button btnClientReport;

    private DashboardRepository dashboardRepository;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboardRepository = new DashboardRepository(ApplicationMain.connector.getConnection());

        if (SecurityContext.loggedUser != null) {
            changeVisibilityByRole(SecurityContext.loggedUser.getUser().getRoles());
        }

        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        clientCNPJ.setCellValueFactory(new PropertyValueFactory<>("clientCNPJ"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        supplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        instalation.setCellValueFactory(new PropertyValueFactory<>("instalation"));
        hidrometer.setCellValueFactory(new PropertyValueFactory<>("hidrometer"));
        register.setCellValueFactory(new PropertyValueFactory<>("register"));
        billTable.setItems(bills());
    }

    public void changeVisibilityByRole(List<Role> roles) {
        if (roles.contains(Role.ADMIN) || roles.contains(Role.KEY_USER)) return;

        for (Role role : roles) {
            if (role.equals(Role.BUSINESS_ANALYST)) {
                btnAddEnergy.setVisible(false);
                btnAddWater.setVisible(false);
                delete.setVisible(false);
                edit.setVisible(false);
            }
            if (role.equals(Role.TYPIST)) {
                btnUserReport.setVisible(false);
                btnClientReport.setVisible(false);
                delete.setVisible(false);
            }
        }
    }

    public ObservableList<DashboardBill> bills() {
        ObservableList<DashboardBill> collection = FXCollections.observableArrayList();
        collection.addAll(dashboardRepository.findAll());
        return collection;
    }

    @FXML
    protected void addEnergy(ActionEvent event) {
        try {
            Parent energy = FXMLLoader.load(getClass().getResource("/app/energy.fxml"));
            ApplicationMain.energy = new Scene(energy);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ApplicationMain.changeScene(Screen.ENERGY, SecurityContext.loggedUser);
    }

    @FXML
    protected void addWater(ActionEvent event) {
        initWater();
        ApplicationMain.changeScene(Screen.WATER, SecurityContext.loggedUser);
    }

    @FXML
    protected void logoff() {
        SecurityContext.loggedUser = null;
        ApplicationMain.changeScene(Screen.LOGIN);
    }

    @FXML
    protected void clientReport() {

    }

    @FXML
    protected void userReport() {

    }

    @FXML
    protected void edit() {
        DashboardBill dashboardBill = billTable.getSelectionModel().getSelectedItem();
        BillController billController = new BillController(ApplicationMain.connector.getConnection());

        Bill bill = billController.find(dashboardBill.getNumber());

        if (bill == null) return;

        editable = true;
        editableBill = bill;

        switch (bill.getBillType()) {
            case WATER:
                initWater();
                ApplicationMain.changeScene(Screen.WATER, bill);
                break;
            case ENERGY:
                initEnergy();
                ApplicationMain.changeScene(Screen.ENERGY, bill);
                break;
        }
    }

    private void initEnergy() {
        try {
            Parent energy = FXMLLoader.load(getClass().getResource("/app/energy.fxml"));
            ApplicationMain.energy = new Scene(energy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initWater() {
        try {
            Parent water = FXMLLoader.load(getClass().getResource("/app/water.fxml"));
            ApplicationMain.water = new Scene(water);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void delete() {
        DashboardBill bill = billTable.getSelectionModel().getSelectedItem();

        boolean confirm = DialogPopup.showConfirmDialog(
                ApplicationMain.stage,
                LanguageKeyValue.confirmation.getText(),
                LanguageKeyValue.delete_selected_bill.getText());
        if (confirm) {
            System.out.println(bill);
        }
    }
}
