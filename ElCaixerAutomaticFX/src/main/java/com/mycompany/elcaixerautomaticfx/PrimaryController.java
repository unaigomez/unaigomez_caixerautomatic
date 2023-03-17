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
    
    int intentos = 0;
    
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

    Cliente sesion = App.banco.buscarCliente(usuario, contrasena);
        System.out.println(sesion.toString());
    if (sesion != null) {
        System.out.println("Sesión iniciada");
//        if (sesion.getIdusuario()==0001) {
//            App.c1 = sesion;
//        } else if (sesion.getIdusuario()==0002) {
//            App.c2 = sesion;
//        }

        

        App.setRoot("secondary");
    } else {
        intentos++;
        if (intentos == 3) {
            aceptarbtn.setDisable(true); // Desactivamos el botón de aceptar
            mensajeLabel.setText("Usuario o contraseña incorrectos. Has superado el número máximo de intentos.");
        } else {
            mensajeLabel.setText("Usuario o contraseña incorrectos. Intento " + intentos + " de 3.");
        }
    }
}

    
}
