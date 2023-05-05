
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Clase transferir que permite a los usuarios transferir dinero entre cuentas corrientes
 * 
 * @author alumne
 */
public class Transferir {

    @FXML
    private ComboBox<Cuenta> comboBoxCuentaOrigen;

    @FXML
    private ComboBox<Cuenta> comboBoxCuentaDestino;

    @FXML
    private TextField textFieldDinero;

    @FXML
    private Button transferirButton;

    /**
     * Método para inicializar la pantalla con los combobox de las cuentas
     */
    public void initialize() {

        List<Cuenta> cuentasSesion = App.sesion.getCuentas().stream()
            .filter(cuenta -> cuenta.getTipoCuenta().equals("Corriente"))
            .collect(Collectors.toList());


        comboBoxCuentaOrigen.setItems(FXCollections.observableArrayList(cuentasSesion));


        List<Cuenta> cuentasClientes = App.banco.getClientes().stream()
            .flatMap(cliente -> cliente.getCuentas().stream())
            .filter(cuenta -> cuenta.getTipoCuenta().equals("Corriente"))
            .collect(Collectors.toList());


        comboBoxCuentaDestino.setItems(FXCollections.observableArrayList(cuentasClientes));



        transferirButton.setDisable(true);
        comboBoxCuentaOrigen.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            transferirButton.setDisable(newVal == null || textFieldDinero.getText().isEmpty() || comboBoxCuentaDestino.getSelectionModel().getSelectedItem() == null);
        });


        comboBoxCuentaDestino.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            transferirButton.setDisable(newVal == null || textFieldDinero.getText().isEmpty() || comboBoxCuentaOrigen.getSelectionModel().getSelectedItem() == null);
        });


        textFieldDinero.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d*\\.?\\d*")) {
                textFieldDinero.setText(oldVal);
            }
            transferirButton.setDisable(newVal.isEmpty() || comboBoxCuentaOrigen.getSelectionModel().getSelectedItem() == null || comboBoxCuentaDestino.getSelectionModel().getSelectedItem() == null);
        });
    }

    /**
     * Método para realizar la transferencia
     * 
     * @param event 
     */
    @FXML
    void transferir(ActionEvent event) {

        Cuenta cuentaOrigen = comboBoxCuentaOrigen.getSelectionModel().getSelectedItem();
        Cuenta cuentaDestino = comboBoxCuentaDestino.getSelectionModel().getSelectedItem();

        

        double dinero = Double.parseDouble(textFieldDinero.getText());

        try {
            ((CuentaCorriente) cuentaOrigen).transferir((CuentaCorriente) cuentaDestino, dinero);
            cuentaOrigen.agregarMovimiento(new Movimiento("Transferencia",-dinero,cuentaOrigen.getNumeroCuenta()));
            cuentaDestino.agregarMovimiento(new Movimiento("Transferencia",dinero,cuentaDestino.getNumeroCuenta()));
            Alert alert = new Alert(AlertType.INFORMATION, "La transferencia se realizó exitosamente");
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }


        comboBoxCuentaOrigen.getSelectionModel().clearSelection();
        comboBoxCuentaDestino.getSelectionModel().clearSelection();
        textFieldDinero.clear();
        transferirButton.setDisable(true);

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
