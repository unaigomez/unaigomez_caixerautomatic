
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cliente que representa a un cliente del cajero automático.
 * 
 * @author alumne
 */
public class Cliente {
    private String usuario;
    private String contrasena;
    private ArrayList<Cuenta> cuentas;
    private int idusuario;
    
    /**
     * Constructor de la clase Cliente.
     * 
     * @param usuario El nombre de usuario del cliente.
     * @param contrasena La contraseña del cliente.
     * @param idusuario El ID del usuario del cliente.
     */
    public Cliente(String usuario, String contrasena, int idusuario) {
        
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cuentas = new ArrayList<Cuenta>();
        this.idusuario = idusuario;
    }
    
    /**
     * Devuelve una representación en string del objeto Cliente
     * 
     * @return String representación del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", cuentas=" + cuentas.toString() + ", idusuario=" + idusuario + '}';
    }

    //Getters y setters
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
    
    
    /**
     * Método para agregar una cuenta al alrraylist cuentas del cliente.
     * 
     * @param cuenta Cuenta añadida al cliente.
     */
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
    
    /**
     * Método para devolver la lista de movimientos de un cliente
     * 
     * @return Lista de movimientos del cliente
     */
    public List<Movimiento> getMovimientos() {
        List<Movimiento> movimientos = new ArrayList<>();
        for (Cuenta cuenta : this.cuentas) {
            movimientos.addAll(cuenta.getMovimientos());
        }
        return movimientos;
    }
    
}

