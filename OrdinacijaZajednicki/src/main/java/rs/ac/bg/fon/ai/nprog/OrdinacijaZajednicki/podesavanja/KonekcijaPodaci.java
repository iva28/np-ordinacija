package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.podesavanja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
/**
 * Predstavlja informacije za povezivanje na server i za upravljanje njima
 * 
 * Iscitava podatke iz konekcija.properties fajla, koji sadrzi podatke o portu i adresi na kojem je podignut server
 * 
 * @author Iva Stanisic
 *
 */
public class KonekcijaPodaci {
	
	/**
	 * Instanca klase KonekcijaPodaci implementirana kao singleton
	 * 
	 * Razlog ovakve implementacije je da bi svi objekti koji pozivaju ovu klasu, pozivali isti objekat
	 */
	private static KonekcijaPodaci instanca;
	/**
	 * Objekat za pristup properties fajlu
	 */
	private Properties props;

	/**
	 * Privatni konstruktor koji se poziva samo jednom, samo prvi put
	 */
	private KonekcijaPodaci() {
		try {
			props = new Properties();
			props.load(new FileInputStream("../OrdinacijaZajednicki/src/main/resources/konekcija.properties"));
		} catch (Exception ex) {
			System.err.println("Greška pri učitavanju konekcija properties fajla! " + ex.getMessage());
		}
	}

	/**
	 * Vraca instancu na objekat klase KonekcijaPodaci
	 * 
	 * Ukoliko pre toga objekat nije bio instanciran kreira novu instancu u suprotnom vraca postojecu
	 * 
	 * @return instanca klase KonekcijaPodaci
	 */
	public static KonekcijaPodaci vratiInstancu() {
		if (instanca == null) {
			instanca = new KonekcijaPodaci();
		}
		return instanca;
	}

	/**
	 * Vraca property iz properties fajla na osnovu prosledjenog kljuca
	 * 
	 * @param kljuc vrednost na osnovu koje se pretrazuje properties fajl
	 * @return String vrednost odgovarajuceg kljuca
	 */
	public String vratiProperti(String kljuc) {
		return props.getProperty(kljuc);
	}

	/**
	 * Postavlja novu adresu na kojoj server ceka klijenta
	 * 
	 * @param adresa serverskog soketa
	 * @throws Exception ako dodje do greske pri upisu adrese u fajl
	 */
	public void postaviAdresu(String adresa) throws Exception{
		try {
			props.setProperty("adresa", adresa);
			props.store(new FileOutputStream(new File("../OrdinacijaZajednicki/src/main/resources/konekcija.properties")), null);
		} catch (Exception ex) {
			System.err.println("Greška pri upisu adrese u properties fajl\n" + ex.getMessage());
		}
	}

	/**
	 * Postavlja novi port na kom server ceka klijenta
	 * 
	 * @param port serverskog soketa
	 * @throws Exception ako dodje do greske pri upisu porta u fajl
	 */
	public void postaviPort(String port) throws Exception {
		try {
			props.setProperty("port", port);
			props.store(new FileOutputStream(new File("../OrdinacijaZajednicki/src/main/resources/konekcija.properties")), null);
		} catch (Exception ex) {
			System.err.println("Greška pri upisu porta u properties fajl\n" + ex.getMessage());
		}
	}

}
