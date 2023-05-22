/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.transfer;

import java.io.Serializable;

/**
 *
 * @author iva
 */
public class Odgovor implements Serializable{
    private Object rezultat;
    private Exception exception;

    public Odgovor() {
    }
    public Odgovor(Object result, Exception exception) {
        this.rezultat = result;
        this.exception = exception;
    }
    public Object getRezultat() {
        return rezultat;
    }
    public Exception getException() {
        return exception;
    }
    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }
    public void setException(Exception exception) {
        this.exception = exception;
    }
}
