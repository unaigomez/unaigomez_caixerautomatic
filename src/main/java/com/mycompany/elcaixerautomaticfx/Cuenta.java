
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cuenta que representa una cuenta bancaria.
 * 
 * @author alumne
 */
public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldoActual;
    private ArrayList<Movimiento> movimientos;
    
    /**
     * Constructor de la clase Cuenta.
     * 
     * @param numeroCuenta El número de cuenta.
     * @param tipoCuenta El tipo de cuenta.
     * @param saldoActual El saldo actual de la cuenta.
     */
    public Cuenta(String numeroCuenta, String tipoCuenta, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoActual = saldoActual;
        this.movimientos = new ArrayList<Movimiento>();
    }

    /**
     * El toString del objeto cuenta.
     * 
     * @return toString cuenta.
     */
    @Override
    public String toString() {
        return "{" + "Cuenta = " + numeroCuenta + " - " + tipoCuenta+ '}';
    }
    
    //Getters y setters.
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    

    /**
     * Método para añadir un movimiento a la lista de movimientos de la cuenta.
     * 
     * @param movimiento Movimiento a añadir
     */
    public void agregarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }
    
    /**
     * Método para devolver la lista de movimientos de una cuenta.
     * 
     * @return La lista de movimientos de la cuenta.
     */
    public List<Movimiento> getListaMovimientos() {
        List<Movimiento> movimientos = new ArrayList<>();
        for (Movimiento movimiento : this.movimientos) {
            movimientos.add(movimiento);
        }
        return movimientos;
    }
    
    
    
    
}

