
package com.mycompany.elcaixerautomaticfx;

import java.util.ArrayList;


public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldoActual;
    private ArrayList<Movimiento> movimientos;

    public Cuenta(String numeroCuenta, String tipoCuenta, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoActual = saldoActual;
        this.movimientos = new ArrayList<Movimiento>();
    }

    @Override
    public String toString() {
        return "{" + "Cuenta = " + numeroCuenta + " - " + tipoCuenta + "Movimientos = " + movimientos.toString() + '}';
    }
    

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

    public void agregarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }
    
    
    
    
}

//Esta clase tendría los atributos tipo (cuenta corriente o cuenta de ahorros) y saldo actual, así como métodos para realizar transacciones bancarias (retirar dinero, depositar dinero, etc.).