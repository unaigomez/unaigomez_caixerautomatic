
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Cambiarusuario {
    @FXML
    TextField txt1;
    @FXML
    TextField txt2;
    @FXML
    Label mensaje;
    
    @FXML
    void cambiar() {
        String a1 = txt1.getText();
        String a2 = txt2.getText();
        
        if (a1.equals("") || a2.equals("")) {
            mensaje.setText("Rellena todos los campos.");
        } else if (!a1.equals(a2)) {
            mensaje.setText("Error. Los usuarios no coinciden.");
        } else {
            App.sesion.setUsuario(a1);
            System.out.println(App.sesion.toString());
            mensaje.setText("Usuario cambiado correctamente");
        }
    }
    
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
