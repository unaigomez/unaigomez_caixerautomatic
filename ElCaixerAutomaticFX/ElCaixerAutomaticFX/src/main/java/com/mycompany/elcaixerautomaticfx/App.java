package com.mycompany.elcaixerautomaticfx;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase principal de la aplicación.
 * 
 * @author alumne
 */
public class App extends Application {
    
    private static Scene scene;

    static Banco banco;

    static Cliente sesion;

    /**
     * Método para establecer la sesión iniciada
     * 
     * @param cliente cliente iniciado
     */
    public static void setSesion(Cliente cliente) {
        sesion = cliente;
    }

    static Cajero cajero;
    static ArrayList<Cuenta> cuentas = new ArrayList<>();

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
    public void start(Stage stage) throws IOException, URISyntaxException {

        banco = new Banco("BBVA");
        cajero = new Cajero();

        File archivoUsuarios = new File(getClass().getResource("/com/mycompany/elcaixerautomaticfx/usuarios.txt").toURI());
        cargarUsuarios(archivoUsuarios);

        File archivoCuentas = new File(getClass().getResource("/com/mycompany/elcaixerautomaticfx/cuentas.txt").toURI());
        cuentas = cargarCuentas(archivoCuentas);

        asociarCuentasAClientes();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));

        Parent root = fxmlLoader.load();
        PrimaryController primaryController = fxmlLoader.getController();
        primaryController.setBanco(banco);
        scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cargar los usuarios desde un archivo .txt
     * 
     * @param archivo El archivo de usuarios
     * @throws FileNotFoundException 
     */
    public void cargarUsuarios(File archivo) throws FileNotFoundException {
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");
            String usuario = datos[0];
            String contrasena = datos[1];
            int numeroCuenta = Integer.parseInt(datos[2]);
            Cliente cliente = new Cliente(usuario, contrasena, numeroCuenta);
            banco.agregarCliente(cliente);
        }
        scanner.close();
    }
    
    /**
     * Método para cargar las cuentas desde un archivo .txt
     * 
     * @param archivo Archivo .txt de las cuentas
     * @return Arraylist de las cuentas del archivo cuentas.txt
     * @throws FileNotFoundException 
     */
    public ArrayList<Cuenta> cargarCuentas(File archivo) throws FileNotFoundException {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");
            String tipoCuenta = datos[0];
            String numeroCuenta = datos[1];
            double saldoActual = Double.parseDouble(datos[2]);
            int idusuario = Integer.parseInt(datos[3]);
            Cuenta cuenta = null;
            if (tipoCuenta.equals("Corriente")) {
                cuenta = new CuentaCorriente(numeroCuenta, saldoActual, idusuario); 
            } else if (tipoCuenta.equals("Ahorro")) {
                cuenta = new Cuenta(numeroCuenta, "Ahorros", saldoActual, idusuario);
            }
            cuentas.add(cuenta);
        }
        scanner.close();
        return cuentas;
    }

    /**
     * Método para asociar las cuentas a los clientes.
     * 
     */
    public void asociarCuentasAClientes() {
        for (Cliente cliente : banco.getClientes()) {
            for (Cuenta cuenta : cuentas) {
                // Cambiar la condición para comparar el idusuario de Cliente con el idusuario de Cuenta
                if (cuenta.getIdusuario() == cliente.getIdusuario()) {
                    cliente.agregarCuenta(cuenta);
                }
            }
        }
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
