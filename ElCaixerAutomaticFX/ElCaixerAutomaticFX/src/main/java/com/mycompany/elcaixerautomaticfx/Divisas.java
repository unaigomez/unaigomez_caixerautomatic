
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class Divisas {
    
    private final double USD_RATE = 1.21; 
    private final double GBP_RATE = 0.87; 
    private final double MXN_RATE = 25.77; 
    private final double ARS_RATE = 112.27; 

    @FXML
    private RadioButton usdRadioButton;

    @FXML
    private RadioButton gbpRadioButton;

    @FXML
    private RadioButton mxnRadioButton;

    @FXML
    private RadioButton arsRadioButton;

    @FXML
    private ToggleGroup a1;

    @FXML
    private TextField eurosTextField;

    @FXML
    private Label outputLabel;

    @FXML
    private void initialize() {
        // Configurar el evento para los botones de conversión
        a1.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            double euros = Double.parseDouble(eurosTextField.getText());
            double rate = 0.0;
            String currency = "";

            // Determinar el tipo de cambio y la moneda seleccionada
            if (usdRadioButton.isSelected()) {
                rate = USD_RATE;
                currency = "USD";
            } else if (gbpRadioButton.isSelected()) {
                rate = GBP_RATE;
                currency = "GBP";
            } else if (mxnRadioButton.isSelected()) {
                rate = MXN_RATE;
                currency = "MXN";
            } else if (arsRadioButton.isSelected()) {
                rate = ARS_RATE;
                currency = "ARS";
            }

            // Calcular el monto convertido y mostrarlo en la etiqueta
            double convertedAmount = euros * rate;
            outputLabel.setText(String.format("%.2f euros son %.2f %s", euros, convertedAmount, currency));
        });
    }

    
    
    
    @FXML
    void volver() throws IOException {
        App.setRoot("ajustes");
    }
}
