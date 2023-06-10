package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.main;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.koordinator.*;

/**
 * Sluzi kao ulazna tacka za aplikaciju
 * 
 * @author Iva Stanisic
 */
public class Main {
	/**
	 * Metoda main je pocetna tacka aplikacije
	 * 
	 * Poziva se metoda otvoriServerFormu() klase KoordinatorS kako bi se otvorila
	 * forma servera.
	 *
	 * @param args Argumenti komandne linije koji se prosledjuju aplikaciji
	 */
	public static void main(String[] args) {
		KoordinatorS.vratiInstancu().otvoriServerFormu();
	}

	/**
	 * Default konstruktor
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}
}
