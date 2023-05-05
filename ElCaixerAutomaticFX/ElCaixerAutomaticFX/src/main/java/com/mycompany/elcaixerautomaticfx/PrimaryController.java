package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Clase para controlar el inicio de sesión.
 * 
 * @author alumne
 */
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
    
    /**
     * Método para establecer el banco.
     * 
     * @param banco El banco a establecer.
     */    
    public void setBanco(Banco banco) {
    this.banco = banco;
}
     /**
     * Método para iniciar sesión.
     * 
     * @param event Evento de acción del botón "aceptar".
     * @throws IOException Si ocurre un error al cargar la vista del menú.
     */
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
}
