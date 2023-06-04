package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.operacije.Operacije;

/**
 * Predstavlja zahtev koji pokrece komunikaciju izmedju klijent i server strane
 *
 * @author Iva Stanisic
 */
public class Zahtev implements Serializable {
	/**
	 * Predstavlja zahtevanu operaciju
	 */
	private Operacije operacija;
	/**
	 * Objekat koji se salje kroz mrezu
	 */
	private Object objekat;

	/**
	 * Podrazumevani konstruktor
	 */
	public Zahtev() {
	}

	/**
	 * Parametrizovani konstruktor
	 * 
	 * @param operation operacija koja se zahteva
	 * @param object    objekat koji se salje
	 */
	public Zahtev(Operacije operation, Object object) {
		this.operacija = operation;
		this.objekat = object;
	}

	/**
	 * Vraca operaciju koja se zahteva
	 * 
	 * @return operacija koja se trazi
	 */
	public Operacije getOperacija() {
		return operacija;
	}

	/**
	 * Postavlja operaciju koja se zahteva
	 * 
	 * @param operacija koja se trazi
	 */
	public void setOperacija(Operacije operacija) {
		this.operacija = operacija;
	}

	/**
	 * Vraca objekat koji se salje uz zahtev
	 * 
	 * @return objekat koji se salje
	 */
	public Object getObjekat() {
		return objekat;
	}
	/**
	 * Postavlja objekat koji se salje uz zahtev
	 * 
	 * @param objekat koji se salje
	 */
	public void setObjekat(Object objekat) {
		this.objekat = objekat;
	}
}
