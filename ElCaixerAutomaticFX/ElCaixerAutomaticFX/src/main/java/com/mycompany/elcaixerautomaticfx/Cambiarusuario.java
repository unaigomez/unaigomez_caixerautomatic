
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Clase Cambiarusuario que permite a los usuarios cambiar su nombre de usuario.
 * 
 * @author alumne
 */
public class Cambiarusuario {
    @FXML
    TextField txt1;
    @FXML
    TextField txt2;
    @FXML
    Label mensaje;
    
    /**
     * Método para cambiar el nombre de usuario del cliente.
     * 
     */    
    @FXML
    public void cambiar() {
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
   
    /**
     * Método para volver a la pantalla anterior.
     * 
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */    
    @FXML
    public void volver() throws IOException {
        App.setRoot("ajustes");
    }
}
