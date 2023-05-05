
package com.mycompany.elcaixerautomaticfx;

import javafx.scene.control.Alert;
/**
 * Clase Cajero que representa un cajero automático con diferentes denominaciones de billetes.
 * 
 * @author alumne
 */

public class Cajero {
    private int billete500;
    private int billete200;
    private int billete100;
    private int billete50;
    private int billete20;
    private int billete10;
    private int billete5;
    private boolean operacion;
    
    /**
     * Constructor del objeto Cajero con valores predeterminados para cada denominación de billetes.
     */
    public Cajero() {
        this.billete500 = 100;
        this.billete200 = 100;
        this.billete100 = 100;
        this.billete50 = 100;
        this.billete20 = 100;
        this.billete10 = 100;
        this.billete5 = 8;
        this.operacion = true;
    }

    public int getBillete500() {
        return billete500;
    }

    public void setBillete500(int billete500) {
        this.billete500 = billete500;
    }

    public int getBillete200() {
        return billete200;
    }

    public void setBillete200(int billete200) {
        this.billete200 = billete200;
    }

    public int getBillete100() {
        return billete100;
    }

    public void setBillete100(int billete100) {
        this.billete100 = billete100;
    }

    public int getBillete50() {
        return billete50;
    }

    public void setBillete50(int billete50) {
        this.billete50 = billete50;
    }

    public int getBillete20() {
        return billete20;
    }

    public void setBillete20(int billete20) {
        this.billete20 = billete20;
    }

    public int getBillete10() {
        return billete10;
    }

    public void setBillete10(int billete10) {
        this.billete10 = billete10;
    }

    public int getBillete5() {
        return billete5;
    }

    public void setBillete5(int billete5) {
        this.billete5 = billete5;
    }

    public boolean isOperacion() {
        return operacion;
    }

    public void setOperacion(boolean operacion) {
        this.operacion = operacion;
    }
    
    /**
     * Ingresa billetes en el cajero.
     * 
     * @param denominacion La denominación del billete a ingresar.
     * @param cantidad La cantidad de billetes a ingresar.
     */
    public void ingresarBilletes(int denominacion, int cantidad) {
        switch (denominacion) {
            case 500:
                billete500 += cantidad;
                break;
            case 200:
                billete200 += cantidad;
                break;
            case 100:
                billete100 += cantidad;
                break;
            case 50:
                billete50 += cantidad;
                break;
            case 20:
                billete20 += cantidad;
                break;
            case 10:
                billete10 += cantidad;
                break;
            case 5:
                billete5 += cantidad;
                break;
            default:
                break;
        }
    }
    
    /**
     * Retira billetes del cajero.
     * 
     * @param denominacion La denominación del billete a retirar.
     * @param cantidad La cantidad de billetes a retirar.
     */
    public void retirarBilletes(int denominacion, int cantidad) {
        operacion=true;
        switch (denominacion) {
            case 500:
                if (App.cajero.billete500-cantidad>=0) {
                    billete500 -= cantidad;
                    break;
                } else {
                    operacion = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("No hay suficientes billetes de 500€ para tu operación.");
                    alert.showAndWait();
                    return;

                }
                
            case 200:
                if (App.cajero.billete200-cantidad>=0) {
                    billete200 -= cantidad;
                    break;
                } else {
                    operacion = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("No hay suficientes billetes de 200€ para tu operación.");
                    alert.showAndWait();
                    return;
                }
            case 100:
                if (App.cajero.billete100-cantidad>=0) {
                    billete100 -= cantidad;
                    break;
                } else {
                    operacion = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("No hay suficientes billetes de 100€ para tu operación.");
                    alert.showAndWait();
                    return;
                }
            case 50:
                if (App.cajero.billete50-cantidad>=0) {
                    billete50 -= cantidad;
                    break;
                } else {
                    operacion = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("No hay suficientes billetes de 50€ para tu operación.");
                    alert.showAndWait();
                    return;
                }
            case 20:
                if (App.cajero.billete20-cantidad>=0) {
                    billete20 -= cantidad;
                    break;
                } else {
                    operacion = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("No hay suficientes billetes de 20€ para tu operación.");
                    alert.showAndWait();
                    return;
                }
            case 10:
                if (App.cajero.billete10-cantidad>=0) {
                    billete10 -= cantidad;
                    break;
                } else {
                    operacion = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("No hay suficientes billetes de 10€ para tu operación.");
                    alert.showAndWait();
                    return;
                }
            case 5:
                if (App.cajero.billete5-cantidad>=0) {
                    billete5 -= cantidad;
                    break;
                } else {
                    operacion = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("No hay suficientes billetes de 5€ para tu operación.");
                    alert.showAndWait();
                    return;
                }
            default:
                break;
        }
    }
    
    /**
     * Devuelve una representación en cadena del objeto Cajero.
     * 
     * @return Una cadena que representa al objeto Cajero.
     */
    @Override
    public String toString() {
        return "Cajero{" + "500€=" + billete500 + ", 200€=" + billete200 + ", 100€=" + billete100 + ", 50€=" + billete50 + ", 20€=" + billete20 + ", 10€=" + billete10 + ", 5€=" + billete5 + '}';
    }
    



    
    
}

