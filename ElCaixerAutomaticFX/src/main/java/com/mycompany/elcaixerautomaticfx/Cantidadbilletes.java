

package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


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
    
    @FXML
    void initialize() {
        b500.setText("Billetes de 500: "+ App.cajero.getBillete500());
        b200.setText("Billetes de 200: "+ App.cajero.getBillete200());
        b100.setText("Billetes de 100: "+ App.cajero.getBillete100());
        b50.setText("Billetes de 50: "+ App.cajero.getBillete50());
        b20.setText("Billetes de 20: "+ App.cajero.getBillete20());
        b10.setText("Billetes de 10: "+ App.cajero.getBillete10());
        b5.setText("Billetes de 5: "+ App.cajero.getBillete5());
    }
    
    @FXML
    void volver() throws IOException {
        App.setRoot("menu");
    }
}
