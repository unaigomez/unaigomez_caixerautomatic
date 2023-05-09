package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * Clase para controlar el menú de ajustes.
 * 
 * @author alumne
 */
public class Ajustes {

    /**
     * Cambia a la ventana "cantidadbilletes".
     *
     * @throws IOException si se produce un error al cambiar a la ventana "cantidadbilletes".
     */
    @FXML
    public void cantidadbilletes() throws IOException {
        App.setRoot("cantidadbilletes");
    }

    /**
     * Cambia a la ventana "cambiarusuario".
     *
     * @throws IOException si se produce un error al cambiar a la ventana "cambiarusuario".
     */
    @FXML
    public void cambiarusuario() throws IOException {
        App.setRoot("cambiarusuario");
    }

    /**
     * Cambia a la ventana "divisas".
     *
     * @throws IOException si se produce un error al cambiar a la ventana "divisas".
     */
    @FXML
    public void divisas() throws IOException {
        App.setRoot("divisas");
    }

    /**
     * Cambia a la ventana "cambiarcontrasena".
     *
     * @throws IOException si se produce un error al cambiar a la ventana "cambiarcontrasena".
     */
    @FXML
    public void cambiarcontraseña() throws IOException {
        App.setRoot("cambiarcontrasena");
    }

    /**
     * Cambia a la ventana "menu".
     *
     * @throws IOException si se produce un error al cambiar a la ventana "menu".
     */
    @FXML
    public void volver() throws IOException {
        App.setRoot("menu");
    }
}
