
package com.mycompany.elcaixerautomaticfx;


public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldoActual;

    public Cuenta(String numeroCuenta, String tipoCuenta, double saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoActual = saldoActual;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }
    
    
    
    
}

//Esta clase tendría los atributos tipo (cuenta corriente o cuenta de ahorros) y saldo actual, así como métodos para realizar transacciones bancarias (retirar dinero, depositar dinero, etc.).