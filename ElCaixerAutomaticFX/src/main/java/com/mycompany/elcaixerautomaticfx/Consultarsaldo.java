package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class Consultarsaldo {
    
    List<Cuenta> cuentas = App.sesion.getCuentas();
    
    @FXML
    private ComboBox<Cuenta> comboBoxCuentas;
    
    @FXML
    private Label labelSaldo;
    @FXML
    private Label labelSaldoTotal;
    
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
    labelSaldoTotal.setText(String.format("Saldo total entre todas las cuentas: %.2f", saldoTotal));
    }
    
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
