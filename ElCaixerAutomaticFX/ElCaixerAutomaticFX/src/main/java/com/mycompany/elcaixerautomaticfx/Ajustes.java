
package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;


public class Ajustes {
    @FXML
    private void cantidadbilletes() throws IOException{
        App.setRoot("cantidadbilletes");
    }
    @FXML
    private void cambiarusuario() throws IOException{
        App.setRoot("cambiarusuario");
    }
    @FXML
    private void divisas() throws IOException{
        App.setRoot("divisas");
    }
    
    @FXML
    private void cambiarcontraseña() throws IOException{
       App.setRoot("cambiarcontrasena");
    }
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
    
}
