package com.mycompany.elcaixerautomaticfx;

import java.io.IOException;
import javafx.fxml.FXML;

<<<<<<< HEAD

public class SecondaryController {
    
    
    
    
    
    @FXML
    private void cerrarsesion() throws IOException{
       App.logout();
       App.setRoot("login");
=======
public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
    }
}