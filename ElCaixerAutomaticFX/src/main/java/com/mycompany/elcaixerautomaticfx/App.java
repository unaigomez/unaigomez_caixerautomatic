package com.mycompany.elcaixerautomaticfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private Banco banco;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        banco = new Banco("BBVA");
        Cliente c1 = new Cliente("Unaigomez", "ugomez");
        c1.agregarCuenta(new Cuenta("00001","corriente",1000));
        c1.agregarCuenta(new Cuenta("00002","ahorros",1500));
        Cliente c2 = new Cliente("u2", "u2");
        c2.agregarCuenta(new Cuenta("00003","corriente",2000));
        c2.agregarCuenta(new Cuenta("00004","ahorros",3000));
        banco.agregarCliente(c1);
        banco.agregarCliente(c2);
        
        
        
        scene = new Scene(loadFXML("primary"), 640, 480);
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