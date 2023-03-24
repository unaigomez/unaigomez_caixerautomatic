package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {
    @FXML
    private void cerrarsesion() throws IOException{
       App.logout();
       App.setRoot("login");

    }
}