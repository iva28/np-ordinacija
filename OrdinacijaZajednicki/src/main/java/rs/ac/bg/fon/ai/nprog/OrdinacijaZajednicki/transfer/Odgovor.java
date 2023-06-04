package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.transfer;

import java.io.Serializable;

/**
 * Predstavlja odgovor u komunikaciji izmedju klijent i server strane
 *
 * @author Iva Stanisic
 */
public class Odgovor implements Serializable {
	/**
	 * Predstavlja odgovor
	 */
	private Object rezultat;
	/**
	 * Predstavlja gresku koja je nastala
	 */
	private Exception exception;

	/**
	 * Prazan konstruktor
	 */
	public Odgovor() {
	}

	/**
	 * Parametrizovan konstruktor
	 * 
	 * @param result    odgovor koji je poslat
	 * @param exception greska koja je nastala
	 */
	public Odgovor(Object result, Exception exception) {
		this.rezultat = result;
		this.exception = exception;
	}

	/**
	 * Vraca rezultat odgovora
	 * 
	 * @return rezultat rezultat odgovora
	 */
	public Object getRezultat() {
		return rezultat;
	}

	/**
	 * Vraca gresku odgovora
	 * 
	 * @return greska greska odgovora
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Postavlja rezultat odgovora
	 * 
	 * @param rezultat rezultat odgovora
	 */
	public void setRezultat(Object rezultat) {
		this.rezultat = rezultat;
	}

	/**
	 * Postavlja gresku odgovora
	 * 
	 * @param exception greska
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}
}
