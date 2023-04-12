package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;

public class Ingresar {
    @FXML
    TextField dinerotxt;
    @FXML
    private ComboBox<Cuenta> comboBoxCuentas;
    @FXML
    Label labelSaldo;
    @FXML
    Button ingresarbtn;
    
    
    @FXML 
    void ingresar(){
        double dinero = Double.parseDouble(dinerotxt.getText());
        Cuenta cuentaSeleccionada = comboBoxCuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null) {
            double saldoActual = cuentaSeleccionada.getSaldoActual();
            double saldoNuevo = saldoActual + dinero;
            cuentaSeleccionada.setSaldoActual(saldoNuevo);
            System.out.println(cuentaSeleccionada.getSaldoActual());
            labelSaldo.setText("Saldo: " + saldoNuevo);
        }
        dinerotxt.clear();
    }
    @FXML
    void s0 () {
        String s = dinerotxt.getText();
        String newText = s + "0";
        dinerotxt.setText(newText);
    }
    @FXML
    void s1 () {
        String s = dinerotxt.getText();
        String newText = s + "1";
        dinerotxt.setText(newText);
    }
    @FXML
    void s2 () {
        String s = dinerotxt.getText();
        String newText = s + "2";
        dinerotxt.setText(newText);
    }
    @FXML
    void s3 () {
        String s = dinerotxt.getText();
        String newText = s + "3";
        dinerotxt.setText(newText);
    }
    @FXML
    void s4 () {
        String s = dinerotxt.getText();
        String newText = s + "4";
        dinerotxt.setText(newText);
    }
    @FXML
    void s5 () {
        String s = dinerotxt.getText();
        String newText = s + "5";
        dinerotxt.setText(newText);
    }
    @FXML
    void s6 () {
        String s = dinerotxt.getText();
        String newText = s + "6";
        dinerotxt.setText(newText);
    }
    @FXML
    void s7 () {
        String s = dinerotxt.getText();
        String newText = s + "7";
        dinerotxt.setText(newText);
    }
    @FXML
    void s8 () {
        String s = dinerotxt.getText();
        String newText = s + "8";
        dinerotxt.setText(newText);
    }
    @FXML
    void s9 () {
        String s = dinerotxt.getText();
        String newText = s + "9";
        dinerotxt.setText(newText);
    }
    @FXML
    void punto () {
        String s = dinerotxt.getText();
        if (!s.contains(".")) {
            String newText = s + ".";
            dinerotxt.setText(newText);
        }
        
    }
    @FXML
    void borrarDigito() {
        String textoActual = dinerotxt.getText();
        if (!textoActual.isEmpty()) {
            String s = textoActual.substring(0, textoActual.length() - 1);
            dinerotxt.setText(s);
        }
    }
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
    ingresarbtn.setDisable(true);
    comboBoxCuentas.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
        ingresarbtn.setDisable(newVal == null || dinerotxt.getText().isEmpty());
    });

    dinerotxt.textProperty().addListener((obs, oldVal, newVal) -> {
        ingresarbtn.setDisable(comboBoxCuentas.getSelectionModel().isEmpty() || newVal.isEmpty());
    });

    }
    
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
