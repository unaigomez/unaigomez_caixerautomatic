package com.mycompany.elcaixerautomaticfx;
/**
 * Clase CuentaCorriente que representa una cuenta corriente bancaria.
 * 
 * @author alumne
 */
public class CuentaCorriente extends Cuenta {
    
    /**
     * Constructor de la clase CuentaCorriente.
     * 
     * @param numeroCuenta El número de cuenta.
     * @param saldoActual El saldo actual de la cuenta corriente.
     */    
    public CuentaCorriente(String numeroCuenta, double saldoActual) {
        super(numeroCuenta, "Corriente", saldoActual);
    }
    
    /**
     * Método para transferir dinero entre cuentas corrientes.
     * 
     * @param cuentaDestino La cuenta destino a la que se realizará la transferencia.
     * @param monto El monto a transferir.
     * @throws IllegalArgumentException Si el monto es menor o igual a cero, 
     *                                  si el saldo es insuficiente para realizar la transferencia,
     *                                  o si se intenta transferir a la misma cuenta.
     */
    public void transferir(CuentaCorriente cuentaDestino, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("La transferencia debe ser mayor a cero");
        }
        if (monto > getSaldoActual()) {
            throw new IllegalArgumentException("No tienes suficiente saldo para realizar esta transferencia");
        }
        if (this.equals(cuentaDestino)) {
            throw new IllegalArgumentException("No puedes hacer transferencias a la misma cuenta");
        }
        setSaldoActual(getSaldoActual() - monto);
        cuentaDestino.setSaldoActual(cuentaDestino.getSaldoActual() + monto);
    }
}
