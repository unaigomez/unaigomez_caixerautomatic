
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;


public class Cliente {
    private String usuario;
    private String contrasena;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cuentas = new ArrayList<Cuenta>();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
    
    
    
    
    
    
    
    
}

//Esta clase tendría los atributos nombre de usuario y contraseña, así como un ArrayList de cuentas bancarias. También tendría métodos para agregar y eliminar cuentas bancarias, buscar cuentas bancarias por número de cuenta, etc.