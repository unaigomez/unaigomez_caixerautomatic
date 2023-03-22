package com.mycompany.elcaixerautomaticfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

<<<<<<< HEAD

=======
/**
 * JavaFX App
 */
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
public class App extends Application {
    
    private static Scene scene;
    
    static Banco banco;
    
    static Cliente c1;
    
    static Cliente c2;
    static Cliente sesion;
<<<<<<< HEAD
=======
    static Cliente bloqueado;
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
    
    public static Banco getBanco() {
    return banco;
    }
<<<<<<< HEAD
    public static void sesion(Cliente c) {
        System.out.println(c);
        sesion = c;
    }
    public static void logout(){
        sesion = null;
    }
=======
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2


    @Override
    public void start(Stage stage) throws IOException {
        
        banco = new Banco("BBVA");
<<<<<<< HEAD
        c1 = new Cliente("ugomez", "ugomez",0001);
        c1.agregarCuenta(new Cuenta("00001","corriente",1000));
        c1.agregarCuenta(new Cuenta("00002","ahorros",1500));
        c2 = new Cliente("u2", "u2",0002);
=======
        c1 = new Cliente("Unaigomez", "ugomez");
        c1.agregarCuenta(new Cuenta("00001","corriente",1000));
        c1.agregarCuenta(new Cuenta("00002","ahorros",1500));
        c2 = new Cliente("u2", "u2");
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
        c2.agregarCuenta(new Cuenta("00003","corriente",2000));
        c2.agregarCuenta(new Cuenta("00004","ahorros",3000));
        banco.agregarCliente(c1);
        banco.agregarCliente(c2);
        
        
        
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
=======
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
        Parent root = fxmlLoader.load();
        PrimaryController primaryController = fxmlLoader.getController();
        primaryController.setBanco(banco);
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}