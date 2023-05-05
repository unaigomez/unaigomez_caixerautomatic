
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;

/**
 * Clase retirar que permite al usuario retirar dinero de sus cuentas.
 * 
 * @author alumne
 */
public class Retirar {
    @FXML
    TextField dinerotxt;
    @FXML
    private ComboBox<Cuenta> comboBoxCuentas;
    @FXML
    Label labelSaldo;
    @FXML
    Button retirarbtn;
    
    double totalRetiro = 0;
    int cnt500 = 0;
    int cnt200 = 0;
    int cnt100 = 0;
    int cnt50 = 0;
    int cnt20 = 0;
    int cnt10 = 0;
    int cnt5 = 0;
    
    /**
     * Método para retirar dinero de la cuenta
     * 
     */
    @FXML 
    void retirar(){
        double dinero = totalRetiro;
        Cuenta cuentaSeleccionada = comboBoxCuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null) {
            
            App.cajero.retirarBilletes(500, cnt500);
            App.cajero.retirarBilletes(200, cnt200);
            App.cajero.retirarBilletes(100, cnt100);
            App.cajero.retirarBilletes(50, cnt50);
            App.cajero.retirarBilletes(20, cnt20);
            App.cajero.retirarBilletes(10, cnt10);
            App.cajero.retirarBilletes(5, cnt5);
            cnt500 = 0;
            cnt200 = 0;
            cnt100 = 0;
            cnt50 = 0;
            cnt20 = 0;
            cnt10 = 0;
            cnt5 = 0;
            if (cuentaSeleccionada.getSaldoActual()-dinero<0) {
                dinerotxt.clear();
                totalRetiro = 0;
                Alert alert = new Alert(Alert.AlertType.ERROR, "No tienes suficiente dinero para realizar la operación");
                alert.showAndWait();
                return;
            }
            if (!App.cajero.isOperacion()) {
                dinerotxt.clear();
                totalRetiro = 0;
                return;
            }
            double saldoActual = cuentaSeleccionada.getSaldoActual();
            double saldoNuevo = saldoActual - dinero;
            cuentaSeleccionada.setSaldoActual(saldoNuevo);
            System.out.println(cuentaSeleccionada.getSaldoActual());
            labelSaldo.setText("Saldo: " + saldoNuevo);
            cuentaSeleccionada.agregarMovimiento(new Movimiento("Retiro",-totalRetiro,cuentaSeleccionada.getNumeroCuenta()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "El retiro se realizó exitosamente");
            alert.showAndWait();
            totalRetiro = 0;
        }
        dinerotxt.clear();
        
    }
    
    /**
     * Método para añadir 500 euros a totalRetiro.
     */
    @FXML
    void s500 () {
        totalRetiro += 500;
        dinerotxt.setText(Double.toString(totalRetiro));
        cnt500++;
    }
    /**
     * Método para añadir 200 euros a totalRetiro.
     */
    @FXML
    void s200 () {
        totalRetiro += 200;
        dinerotxt.setText(Double.toString(totalRetiro));
        cnt200++;
    }
    /**
     * Método para añadir 100 euros a totalRetiro.
     */
    @FXML
    void s100 () {
        totalRetiro += 100;
        dinerotxt.setText(Double.toString(totalRetiro));
        cnt100++;
    }
    /**
     * Método para añadir 50 euros a totalRetiro.
     */
    @FXML
    void s50 () {
        totalRetiro += 50;
        dinerotxt.setText(Double.toString(totalRetiro));
        cnt50++;
    }
    /**
     * Método para añadir 20 euros a totalRetiro.
     */
    @FXML
    void s20 () {
        totalRetiro += 20;
        dinerotxt.setText(Double.toString(totalRetiro));
        cnt20++;
    }
    /**
     * Método para añadir 10 euros a totalRetiro.
     */
    @FXML
    void s10 () {
        totalRetiro += 10;
        dinerotxt.setText(Double.toString(totalRetiro));
        cnt10++;
    }
    /**
     * Método para añadir 5 euros a totalRetiro.
     */
    @FXML
    void s5 () {
        totalRetiro += 5;
        dinerotxt.setText(Double.toString(totalRetiro));
        cnt5++;
    }
    /**
     * Método para inicializar la pantalla con los combobox.
     */
    @FXML
    void initialize() {
        List<Cuenta> cuentas = App.sesion.getCuentas();
        comboBoxCuentas.getItems().addAll(cuentas);
        comboBoxCuentas.setCellFactory(param -> new ListCell<Cuenta>() {
            @Override
            protected void updateItem(Cuenta cuenta, boolean empty) {
                super.updateItem(cuenta, empty);
                if (empty || cuenta == null) {
                    setText(null);
                } else {
                    setText(String.format("Cuenta %s - %s", cuenta.getNumeroCuenta(), cuenta.getTipoCuenta()));
                }
            }
        });
        comboBoxCuentas.setOnAction(event -> {
            Cuenta cuentaSeleccionada = comboBoxCuentas.getSelectionModel().getSelectedItem();
            if (cuentaSeleccionada != null) {
                double saldo = cuentaSeleccionada.getSaldoActual();
                labelSaldo.setText("Saldo: " + saldo);
            }
        });
        double saldoTotal = 0;
    for (Cuenta cuenta : cuentas) {
        saldoTotal += cuenta.getSaldoActual();
    }
    retirarbtn.setDisable(true);
    comboBoxCuentas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
        retirarbtn.setDisable(newVal == null || dinerotxt.getText().isEmpty());
    });

    dinerotxt.textProperty().addListener((obs, oldVal, newVal) -> {
        retirarbtn.setDisable(comboBoxCuentas.getSelectionModel().isEmpty() || newVal.isEmpty());
    });

    }
    
    /**
     * Método para volver a la pantalla anterior.
     * 
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */ 
    
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
