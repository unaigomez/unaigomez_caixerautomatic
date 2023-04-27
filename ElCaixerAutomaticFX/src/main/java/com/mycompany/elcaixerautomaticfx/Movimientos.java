
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class Movimientos {
    
    @FXML
    private TextArea movimientosTextArea;

    @FXML
    void initialize() {
        List<Movimiento> movimientos = App.sesion.getMovimientos();
        StringBuilder sb = new StringBuilder();
        for (Movimiento movimiento : movimientos) {
            sb.append(movimiento.toString()).append("\n");
        }
        movimientosTextArea.setText(sb.toString());
    }


    
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
