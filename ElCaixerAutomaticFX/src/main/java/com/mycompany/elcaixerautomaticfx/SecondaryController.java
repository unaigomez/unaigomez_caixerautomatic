package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SecondaryController {
    
    @FXML
    Label bienvenidolbl;
    
    @FXML
    void initialize() {
        bienvenidolbl.setText("Bienvenido "+App.sesion.getUsuario());
    }
    @FXML
    private void cerrarsesion() throws IOException{
       App.logout();
       App.setRoot("login");

    }
    
    @FXML
    private void cambiarcontraseña() throws IOException{
       App.setRoot("cambiarcontrasena");
    }
    @FXML
    private void consultarsaldo() throws IOException{
       App.setRoot("consultarsaldo");
    }
    
    @FXML
    void probar(){
        System.out.println(App.c1.toString());
        System.out.println(App.c2.toString());
        System.out.println(App.sesion.toString());
        
    }
}