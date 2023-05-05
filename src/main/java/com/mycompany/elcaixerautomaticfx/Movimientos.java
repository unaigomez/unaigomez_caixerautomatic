
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Clase movimientos que permite a los usuarios consultar los movimientos de todas sus cuentas.
 * 
 * @author alumne
 */
public class Movimientos {
    
    @FXML
    private TextArea movimientosTextArea;

    /**
     * Método para inicializar la pantalla con el textArea lleno de los movimientos del usuario.
     */
    @FXML
    void initialize() {
        List<Movimiento> movimientos = App.sesion.getMovimientos();
        StringBuilder sb = new StringBuilder();
        for (Movimiento movimiento : movimientos) {
            sb.append(movimiento.toString()).append("\n");
        }
        movimientosTextArea.setText(sb.toString());
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
