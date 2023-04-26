
package com.mycompany.elcaixerautomaticfx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Movimiento {
    private LocalDateTime fecha;
    private String tipo;
    private double importe;

    public Movimiento(String tipo, double importe) {
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.importe = importe;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fecha.format(formatter);
        return "Movimiento{" + "fecha=" + fechaFormateada + ", tipo=" + tipo + ", importe=" + importe + '}';
    }

    

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

    
    
    
}
