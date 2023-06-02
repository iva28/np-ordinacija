package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.main;

import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.Koordinator;

/**
 * Glavna klasa koja sadrzi metodu main
 *
 * @author Iva Stanisic
 */
public class Main {
	/**
	 * Pokrece aplikaciju otvaranjem forme za prijavu preko Koordinatora
	 * 
	 * @param args Argumenti komandne linije
	 */
    public static void main(String[] args) {
       Koordinator.vratiInstancu().otvoriLoginFormu();
    }
}
