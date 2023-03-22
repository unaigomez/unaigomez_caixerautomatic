
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;


public class Banco {
    private String nombre;
    private ArrayList<Cliente> clientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<Cliente>();
    }

    @Override
    public String toString() {
        return "Banco{" + "nombre=" + nombre + ", clientes=" + clientes.toString() + '}';
    }
    

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

    

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String usuario, String contrasena) {
        
        for (int i = 0; i < App.banco.clientes.size(); i++) {
            Cliente c = App.banco.clientes.get(i);
            if (App.banco.getClientes().get(i).getUsuario().equals(usuario) && App.banco.getClientes().get(i).getContrasena().equals(contrasena)) {
                // Usuario encontrado, hacer algo aquí
                System.out.println("Usuario encontrado");
                return c;
            }
        }
        return null;
    }
<<<<<<< HEAD
}
=======
    
    public Cliente BuscarUsuario(String usuario) {
        for (int i = 0; i < App.banco.clientes.size(); i++) {
            Cliente c = App.banco.clientes.get(i);
            if (App.banco.getClientes().get(i).getUsuario().equals(usuario)) {
                return c;
            }
        }
        return null;
    }
    
    
    
}

//Esta clase tendría un ArrayList de clientes y métodos para agregar y eliminar clientes, buscar clientes por nombre de usuario, etc.
>>>>>>> 8452c3504976009be6ca9bcdb1006aefef35c2c2
