
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;

/**
 * Clase que representa el banco.
 * 
 * @author alumne
 */
public class Banco {
    private String nombre;
    private ArrayList<Cliente> clientes;
    
    /**
     * Contructor del objeto banco
     * 
     * @param nombre Nombre del banco
     */
    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<Cliente>();
    }
    
    /**
     * La representación en string del banco
     * 
     * @return String banco
     */
    @Override
    public String toString() {
        return "Banco{" + "nombre=" + nombre + ", clientes=" + clientes.toString() + '}';
    }
    
    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    
    /**
     * Método para agregar un cliente al arraylist de clientes del banco.
     * @param cliente Cliente añadido al arraylist
     */
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    /**
     * Método para el inicio de sesión. Busca un cliente en el arraylist del banco
     * @param usuario Usuario introducido por el cliente
     * @param contrasena Contraseña introducida por el cliente
     * @return Si se encuentra el usuario en el arraylist con los parametros correctos devuelve el cliente c, sino devuelve null.
     */
    public Cliente buscarCliente(String usuario, String contrasena) {
        
        for (int i = 0; i < App.banco.clientes.size(); i++) {
            Cliente c = App.banco.clientes.get(i);
            if (App.banco.getClientes().get(i).getUsuario().equals(usuario) && App.banco.getClientes().get(i).getContrasena().equals(contrasena)) {
                System.out.println("Usuario encontrado");
                return c;
            }
        }
        return null;
    }
}


