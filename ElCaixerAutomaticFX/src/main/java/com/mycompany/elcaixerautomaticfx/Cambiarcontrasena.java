
package com.mycompany.elcaixerautomaticfx;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class Cambiarcontrasena {
    
    @FXML
    PasswordField antiguapswd;
    @FXML
    PasswordField nueva1pswd;
    @FXML
    PasswordField nueva2pswd;
    @FXML
    Label mensaje;
    
    
    @FXML
    void cambiar() {
        String antigua = antiguapswd.getText();
        String nueva1 = nueva1pswd.getText();
        String nueva2 = nueva2pswd.getText();
        
        if (antigua.equals("") || nueva1.equals("") || nueva2.equals("")) {
            mensaje.setText("Rellena todos los campos.");
        } else if (!antigua.equals(App.sesion.getContrasena())) {
            mensaje.setText("Error. La contraseña antigua es incorrecta");
        } else if (!nueva1.equals(nueva2)) {
            mensaje.setText("Error. Las contraseñas nuevas no coinciden.");
        } else {
            App.sesion.setContrasena(nueva1);
            System.out.println(App.sesion.toString());
            mensaje.setText("Contraseña cambiada correctamente");
        }
    }
    
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
