package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
=======
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
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
    
<<<<<<< HEAD
    int intentos = 0;
=======
    int intentosFallidos = 0;
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
    
    public void setBanco(Banco banco) {
    this.banco = banco;
}
<<<<<<< HEAD
    @FXML
    void iniciarSesion(ActionEvent event) throws IOException {
        String usuario = usuarioTextField.getText();
        String contrasena = contrasenaPasswordField.getText();
        
        if (usuario.equals("") || contrasena.equals("")) {
            mensajeLabel.setText("Rellena todos los campos.");
        } else {
            Cliente sesion = App.banco.buscarCliente(usuario, contrasena);
            if (sesion != null) {
                App.sesion= sesion;
                System.out.println("Sesión iniciada");
                if (sesion.getIdusuario()==0001) {
                    App.sesion(App.c1);
                } else if (sesion.getIdusuario()==0002) {
                    App.sesion(App.c2);
                }
                App.setRoot("menu");
            } else {
                intentos++;
                if (intentos == 3) {
                    aceptarbtn.setDisable(true); 
                    mensajeLabel.setText("Usuario o contraseña incorrectos. Has superado el número máximo de intentos.");
                } else {
                    mensajeLabel.setText("Usuario o contraseña incorrectos. Intento " + intentos + " de 3.");
                }
            }
        }
        
    }
    
    

    
=======
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
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
}
