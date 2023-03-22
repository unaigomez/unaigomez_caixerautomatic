package com.mycompany.elcaixerautomaticfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    
    private static Scene scene;
    
    static Banco banco;
    
    static Cliente c1;
    
    static Cliente c2;
    static Cliente sesion;
    
    public static Banco getBanco() {
    return banco;
    }
    public static void sesion(Cliente c) {
        System.out.println(c);
        sesion = c;
    }
    public static void logout(){
        sesion = null;
    }


    @Override
    public void start(Stage stage) throws IOException {
        
        banco = new Banco("BBVA");
        c1 = new Cliente("ugomez", "ugomez",0001);
        c1.agregarCuenta(new Cuenta("00001","corriente",1000));
        c1.agregarCuenta(new Cuenta("00002","ahorros",1500));
        c2 = new Cliente("u2", "u2",0002);
        c2.agregarCuenta(new Cuenta("00003","corriente",2000));
        c2.agregarCuenta(new Cuenta("00004","ahorros",3000));
        banco.agregarCliente(c1);
        banco.agregarCliente(c2);
        
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
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