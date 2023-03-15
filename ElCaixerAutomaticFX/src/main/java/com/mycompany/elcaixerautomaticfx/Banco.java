
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;


public class Banco {
    private String nombre;
    private ArrayList<Cliente> clientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<Cliente>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String usuario, String contrasena) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsuario().equals(usuario) && cliente.getContrasena().equals(contrasena)) {
                return cliente;
            }
        }
        return null;
    }
    
    
    
}

//Esta clase tendría un ArrayList de clientes y métodos para agregar y eliminar clientes, buscar clientes por nombre de usuario, etc.