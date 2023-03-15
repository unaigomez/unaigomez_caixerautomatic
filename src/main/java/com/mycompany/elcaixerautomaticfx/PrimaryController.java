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
    
    int intentosFallidos = 0;
    
    public void setBanco(Banco banco) {
    this.banco = banco;
}
/*
//    Sout para comprobar que se crean los objetos  
    @FXML
    void initialize() {
        
        System.out.println(App.c1.getUsuario());
        System.out.println(App.c1.getContrasena());
        
        for (int i = 0; i < App.banco.getClientes().size(); i++) {
            System.out.println(App.banco.getClientes().get(i));
            System.out.println(App.banco.getClientes().get(i).getUsuario());
        }
        System.out.println(App.banco);
    }
    */
    @FXML
void iniciarSesion(ActionEvent event) throws IOException {
    String usuario = usuarioTextField.getText();
    String contrasena = contrasenaPasswordField.getText();

    Cliente sesion = banco.buscarCliente(usuario, contrasena);
    //Cliente bloquear = banco.BuscarUsuario(usuario);
    System.out.println(sesion);
    //System.out.println(bloquear);
    
   
    if (sesion != null) {
        System.out.println("sessio iniciada");
        App.setRoot("secondary");
    } else {
        mensajeLabel.setText("Usuario o contraseña incorrectos");
    }
    
//    if (bloquear != null) {
//            if (intentosFallidos >= 3) {
//            mensajeLabel.setText("Has excedido el número máximo de intentos fallidos. El usuario está bloqueado.");
//            App.bloqueado.setIsbloqueado(true);
//            // Agregar código para bloquear al usuario aquí
//            } else {
//                intentosFallidos++;
//            }
//        }
}

    
    
        
    
    
    
    
    
    
    
    
    
//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
}
