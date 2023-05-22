/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.operacije.Operacije;

/**
 *
 * @author iva
 */
public class Zahtev implements Serializable{
   private Operacije operacija;
   private Object objekat;

    public Zahtev() {
    }

    public Zahtev(Operacije operation, Object object) {
        this.operacija = operation;
        this.objekat = object;
    }

    public Operacije getOperacija() {
        return operacija;
    }
    public void setOperacija(Operacije operacija) {
        this.operacija = operacija;
    }
    public Object getObjekat() {
        return objekat;
    }
    public void setObjekat(Object objekat) {
        this.objekat = objekat;
    }
}
