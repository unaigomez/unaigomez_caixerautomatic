

package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Clase Cantidadbilletes que muestra la cantidad de billetes en el cajero.
 * 
 * @author alumne
 */
public class Cantidadbilletes {
    @FXML
    Label b500;
    @FXML
    Label b200;
    @FXML
    Label b100;
    @FXML
    Label b50;
    @FXML
    Label b20;
    @FXML
    Label b10;
    @FXML
    Label b5;
    
    /**
     * Método para inicializar la pantalla con la cantidad de billetes.
     * 
     */    
    @FXML
    void initialize() {
        b500.setText(Integer.toString(App.cajero.getBillete500()));
        b200.setText(Integer.toString(App.cajero.getBillete200()));
        b100.setText(Integer.toString(App.cajero.getBillete100()));
        b50.setText(Integer.toString(App.cajero.getBillete50()));
        b20.setText(Integer.toString(App.cajero.getBillete20()));
        b10.setText(Integer.toString(App.cajero.getBillete10()));
        b5.setText(Integer.toString(App.cajero.getBillete5()));
    }
    
    /**
     * Método para volver a la pantalla anterior.
     * 
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */    
    @FXML
    void volver() throws IOException {
        App.setRoot("ajustes");
    }
}
