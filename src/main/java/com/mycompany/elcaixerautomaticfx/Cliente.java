
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;


public class Cliente {
    private String usuario;
    private String contrasena;
    private ArrayList<Cuenta> cuentas;
    private boolean isbloqueado;

    public Cliente(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cuentas = new ArrayList<Cuenta>();
        this.isbloqueado = false;
    }

    @Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", cuentas=" + cuentas + ", isbloqueado=" + isbloqueado + '}';
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

    public boolean isIsbloqueado() {
        return isbloqueado;
    }

    public void setIsbloqueado(boolean isbloqueado) {
        this.isbloqueado = isbloqueado;
    }
    

    

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
    
    
    
    
    
    
    
    
}

//Esta clase tendría los atributos nombre de usuario y contraseña, así como un ArrayList de cuentas bancarias. También tendría métodos para agregar y eliminar cuentas bancarias, buscar cuentas bancarias por número de cuenta, etc.