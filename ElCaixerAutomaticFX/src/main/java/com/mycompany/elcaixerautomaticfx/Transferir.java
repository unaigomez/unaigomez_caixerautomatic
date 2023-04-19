
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

public class Transferir {

    @FXML
    private ComboBox<Cuenta> comboBoxCuentaOrigen;

    @FXML
    private ComboBox<Cuenta> comboBoxCuentaDestino;

    @FXML
    private TextField textFieldMonto;

    @FXML
    private Button transferirButton;

    public void initialize() {
        // Obtener cuentas corrientes de la sesión
        List<Cuenta> cuentasSesion = App.sesion.getCuentas().stream()
            .filter(cuenta -> cuenta.getTipoCuenta().equals("Corriente"))
            .collect(Collectors.toList());

        // Asignar las cuentas corrientes de la sesión al primer combo box
        comboBoxCuentaOrigen.setItems(FXCollections.observableArrayList(cuentasSesion));

        // Obtener todas las cuentas corrientes de todos los clientes
        List<Cuenta> cuentasClientes = App.banco.getClientes().stream()
            .flatMap(cliente -> cliente.getCuentas().stream())
            .filter(cuenta -> cuenta.getTipoCuenta().equals("Corriente"))
            .collect(Collectors.toList());

        // Asignar todas las cuentas corrientes de todos los clientes al segundo combo box
        comboBoxCuentaDestino.setItems(FXCollections.observableArrayList(cuentasClientes));


        // Desactivar botón transferir si no hay una cuenta origen seleccionada o si no se ha ingresado un monto
        transferirButton.setDisable(true);
        comboBoxCuentaOrigen.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            transferirButton.setDisable(newVal == null || textFieldMonto.getText().isEmpty() || comboBoxCuentaDestino.getSelectionModel().getSelectedItem() == null);
        });

        // Desactivar botón transferir si no hay una cuenta destino seleccionada o si no se ha ingresado un monto
        comboBoxCuentaDestino.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            transferirButton.setDisable(newVal == null || textFieldMonto.getText().isEmpty() || comboBoxCuentaOrigen.getSelectionModel().getSelectedItem() == null);
        });

        // Desactivar botón transferir si no se ha ingresado un monto o si es un valor no numérico
        textFieldMonto.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d*\\.?\\d*")) {
                textFieldMonto.setText(oldVal);
            }
            transferirButton.setDisable(newVal.isEmpty() || comboBoxCuentaOrigen.getSelectionModel().getSelectedItem() == null || comboBoxCuentaDestino.getSelectionModel().getSelectedItem() == null);
        });
    }

    @FXML
    void transferir(ActionEvent event) {
        // Obtener la cuenta origen y destino seleccionadas
        Cuenta cuentaOrigen = comboBoxCuentaOrigen.getSelectionModel().getSelectedItem();
        Cuenta cuentaDestino = comboBoxCuentaDestino.getSelectionModel().getSelectedItem();

        
        // Obtener el monto a transferir
        double monto = Double.parseDouble(textFieldMonto.getText());
        // Realizar la transferencia
        try {
            ((CuentaCorriente) cuentaOrigen).transferir((CuentaCorriente) cuentaDestino, monto);
            Alert alert = new Alert(AlertType.INFORMATION, "La transferencia se realizó exitosamente");
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }

        // Actualizar la vista
        comboBoxCuentaOrigen.getSelectionModel().clearSelection();
        comboBoxCuentaDestino.getSelectionModel().clearSelection();
        textFieldMonto.clear();
        transferirButton.setDisable(true);
//        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Transferencia realizada con éxito.");
//        alert.showAndWait();
    }
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
