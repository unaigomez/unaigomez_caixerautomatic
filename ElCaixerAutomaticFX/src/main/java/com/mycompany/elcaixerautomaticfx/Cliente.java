
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;


public class Cliente {
    private String usuario;
    private String contrasena;
    private ArrayList<Cuenta> cuentas;
    private int idusuario;

    public Cliente(String usuario, String contrasena, int idusuario) {
        
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cuentas = new ArrayList<Cuenta>();
        this.idusuario = idusuario;
    }

    @Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", cuentas=" + cuentas + ", idusuario=" + idusuario + '}';
    }

    

    
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    

    

    
    

    

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
    
    
    
    
    
    
    
    
}

//Esta clase tendría los atributos nombre de usuario y contraseña, así como un ArrayList de cuentas bancarias. También tendría métodos para agregar y eliminar cuentas bancarias, buscar cuentas bancarias por número de cuenta, etc.