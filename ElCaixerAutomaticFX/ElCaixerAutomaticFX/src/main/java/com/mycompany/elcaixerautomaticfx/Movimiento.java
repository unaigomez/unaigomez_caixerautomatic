
package com.mycompany.elcaixerautomaticfx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa el objeto Movimiento
 * 
 * @author alumne
 */
public class Movimiento {
    private LocalDateTime fecha;
    private String tipo;
    private double importe;
    private String cuenta;
    
    /**
     * Constructor del objeto Movimiento
     * @param tipo Tipo de movimiento.
     * @param importe Importe del movimiento.
     * @param cuenta Cuenta a la que pertenece el movimiento.
     */
    public Movimiento(String tipo, double importe, String cuenta) {
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.importe = importe;
        this.cuenta = cuenta;
    }

    /**
     * toString del objeto Movimiento.
     * 
     * @return toString Movimiento.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fecha.format(formatter);
        return "Movimiento ==> {" + "Fecha = " + fechaFormateada + "  |  Tipo = " + tipo + " |  Importe = " + importe + "€  |  Cuenta = "+ cuenta+ '}';
    }

    
    //Getters y setters
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    

    
    
    
}
