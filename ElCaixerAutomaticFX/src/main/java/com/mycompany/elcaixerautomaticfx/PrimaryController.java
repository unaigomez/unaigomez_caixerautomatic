package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class PrimaryController {
    private Banco banco;
    @FXML
    TextField usuarioTextField;
    @FXML
    PasswordField contrasenaPasswordField;
    @FXML
    Button aceptarbtn;
    @FXML
    Label mensajeLabel;
    
    @FXML
    void iniciarSesion(ActionEvent event) throws IOException {
        String usuario = usuarioTextField.getText();
        String contrasena = contrasenaPasswordField.getText();

        Cliente cliente = banco.buscarCliente(usuario, contrasena);

        if (cliente != null) {
            App.setRoot("menu");
        } else {
            mensajeLabel.setText("Usuario o contraseña incorrectos");
        }
    }
    
    
        
    
    
    
    
    
    
    
    
    
//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
}
