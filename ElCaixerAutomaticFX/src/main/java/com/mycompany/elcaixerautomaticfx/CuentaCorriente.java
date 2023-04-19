package com.mycompany.elcaixerautomaticfx;

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(String numeroCuenta, double saldoActual) {
        super(numeroCuenta, "Corriente", saldoActual);
    }

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
