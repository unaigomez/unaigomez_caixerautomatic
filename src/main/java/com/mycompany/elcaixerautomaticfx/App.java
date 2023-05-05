package com.mycompany.elcaixerautomaticfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Clase principal de la aplicación.
 * 
 * @author alumne
 */
public class App extends Application {
    
    private static Scene scene;

    static Banco banco;

    static Cliente c1;
    static Cliente c2;
    static Cliente sesion;
    static Cajero cajero;

    /**
     * Devuelve el objeto Banco.
     * 
     * @return banco, el objeto banco actual.
     */
    public static Banco getBanco() {
    return banco;
    }

    /**
     * Establece la sesión de un cliente.
     * 
     * @param c El objeto cliente que iniciará sesión.
     */
    public static void sesion(Cliente c) {
        System.out.println(c);
        sesion = c;
    }

    /**
     * Cierra la sesión del cliente actual.
     */
    public static void logout(){
        sesion = null;
    }

    /**
     * Método de inicio de la aplicación.
     * 
     * @param stage La ventana principal de la aplicación.
     * @throws IOException Si no se puede cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {

        banco = new Banco("BBVA");
        cajero = new Cajero();

        c1 = new Cliente("ugomez", "ugomez",0001);
        c1.agregarCuenta(new CuentaCorriente("01",1000));
        c1.agregarCuenta(new Cuenta("02","Ahorros",1500));
        c2 = new Cliente("u2", "u2",0002);
        c2.agregarCuenta(new CuentaCorriente("03",2000));
        c2.agregarCuenta(new Cuenta("04","Ahorros",3000));
        banco.agregarCliente(c1);
        banco.agregarCliente(c2);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));

        Parent root = fxmlLoader.load();
        PrimaryController primaryController = fxmlLoader.getController();
        primaryController.setBanco(banco);
        scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Cambia la vista de la aplicación.
     * 
     * @param fxml El archivo FXML a cargar.
     * @throws IOException Si no se puede cargar el archivo FXML.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga un archivo FXML.
     * 
     * @param fxml El archivo FXML a cargar.
     * @return El objeto Parent cargado.
     * @throws IOException Si no se puede cargar el archivo FXML.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Método principal.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
