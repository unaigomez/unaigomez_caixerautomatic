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
 * Clase Ingresar que permite a los usuarios ingresar dinero a sus cuentas.
 * 
 * @author alumne
 */
public class Ingresar {
    @FXML
    TextField dinerotxt;
    @FXML
    private ComboBox<Cuenta> comboBoxCuentas;
    @FXML
    Label labelSaldo;
    @FXML
    Button ingresarbtn;
    
    double totalIngreso = 0;
    int cnt500 = 0;
    int cnt200 = 0;
    int cnt100 = 0;
    int cnt50 = 0;
    int cnt20 = 0;
    int cnt10 = 0;
    int cnt5 = 0;
    
    /**
     * Método para ingresar dinero en la cuenta elegida.
     * 
     */
    @FXML 
    public void ingresar(){
        double dinero = totalIngreso;
        Cuenta cuentaSeleccionada = comboBoxCuentas.getSelectionModel().getSelectedItem();
        if (cuentaSeleccionada != null) {
            double saldoActual = cuentaSeleccionada.getSaldoActual();
            double saldoNuevo = saldoActual + dinero;
            cuentaSeleccionada.setSaldoActual(saldoNuevo);
            System.out.println(cuentaSeleccionada.getSaldoActual());
            labelSaldo.setText("Saldo: " + saldoNuevo);
            
            App.cajero.ingresarBilletes(500, cnt500);
            App.cajero.ingresarBilletes(200, cnt200);
            App.cajero.ingresarBilletes(100, cnt100);
            App.cajero.ingresarBilletes(50, cnt50);
            App.cajero.ingresarBilletes(20, cnt20);
            App.cajero.ingresarBilletes(10, cnt10);
            App.cajero.ingresarBilletes(5, cnt5);
            cnt500 = 0;
            cnt200 = 0;
            cnt100 = 0;
            cnt50 = 0;
            cnt20 = 0;
            cnt10 = 0;
            cnt5 = 0;
            
        }
        dinerotxt.clear();
        cuentaSeleccionada.agregarMovimiento(new Movimiento("Ingreso",totalIngreso,cuentaSeleccionada.getNumeroCuenta()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "El ingreso se realizó exitosamente");
        totalIngreso=0;
        alert.showAndWait();
    }
    /**
     * Método para sumar 500 euros al totalIngreso.
     */
    @FXML
    public void s500 () {
        totalIngreso += 500;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt500++;
        
    }
    /**
     * Método para sumar 200 euros al totalIngreso.
     */
    @FXML
    public void s200 () {
        totalIngreso += 200;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt200++;
    }
    /**
     * Método para sumar 100 euros al totalIngreso.
     */
    @FXML
    public void s100 () {
        totalIngreso += 100;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt100++;
    }
    /**
     * Método para sumar 50 euros al totalIngreso.
     */
    @FXML
    public void s50 () {
        totalIngreso += 50;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt50++;
    }
    /**
     * Método para sumar 20 euros al totalIngreso.
     */
    @FXML
    public void s20 () {
        totalIngreso += 20;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt20++;
    }
    /**
     * Método para sumar 10 euros al totalIngreso.
     */
    @FXML
    public void s10 () {
        totalIngreso += 10;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt10++;
    }
    /**
     * Método para sumar 5 euros al totalIngreso.
     */
    @FXML
    public void s5 () {
        totalIngreso += 5;
        dinerotxt.setText(Double.toString(totalIngreso));
        cnt5++;
    }
    /**
     * Método para inicializar la pantalla con el combobox.
     */
    @FXML
    public void initialize() {
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
    
    /**
     * Método para volver a la pantalla anterior.
     * 
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */     
    @FXML
    public void volver() throws IOException {
        App.setRoot("menu");
    }
}
