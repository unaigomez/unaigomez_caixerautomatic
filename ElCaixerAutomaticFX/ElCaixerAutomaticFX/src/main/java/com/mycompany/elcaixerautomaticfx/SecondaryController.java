package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Clase para controlar el menú principal del banco
 * 
 * @author alumne
 */
public class SecondaryController {
    
    @FXML
    Label bienvenidolbl;
    /**
     * Método para inicializar la pantalla con un mensaje de bienvenida al usuario.
     * 
     */
    @FXML
    public void initialize() {
        bienvenidolbl.setText("Bienvenido "+App.sesion.getUsuario());
    }
    /**
     * Método para cerrar sesión
     * 
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @FXML
    public void cerrarsesion() throws IOException{
       App.logout();
       App.setRoot("login");

    }
    /**
     * Método para ir al apartado consultarsaldo
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @FXML
    public void consultarsaldo() throws IOException{
       App.setRoot("consultarsaldo");
    }
    /**
     * Método para ir al apartado ingresar
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @FXML
    public void ingresar() throws IOException{
       App.setRoot("ingresar");
    }
    /**
     * Método para ir al apartado transferir
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @FXML
    public void transferir() throws IOException{
       App.setRoot("transferencias");
    }
    /**
     * Método para ir al apartado retirar
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @FXML
    public void retirar() throws IOException{
       App.setRoot("retirar");
    }
    /**
     * Método para ir al apartado movimientos
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @FXML
    public void movimientos() throws IOException{
        App.setRoot("movimientos");
    }
    /**
     * Método para ir al apartado ajustes
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @FXML
    public void ajustes() throws IOException{
        App.setRoot("ajustes");
    }
}