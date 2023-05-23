package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.podesavanja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class KonekcijaPodaci {
	private static KonekcijaPodaci instanca;
	private Properties props;

	private KonekcijaPodaci() {
		try {
			props = new Properties();
			props.load(new FileInputStream("../OrdinacijaZajednicki/src/main/resources/konekcija.properties"));
		} catch (Exception ex) {
			System.err.println("Greška pri učitavanju konekcija properties fajla! " + ex.getMessage());
		}
	}

	public static KonekcijaPodaci vratiInstancu() {
		if (instanca == null) {
			instanca = new KonekcijaPodaci();
		}
		return instanca;
	}

	public String vratiProperti(String kljuc) {
		return props.getProperty(kljuc);
	}

	public void postaviAdresu(String adresa) {
		try {
			props.setProperty("adresa", adresa);
			props.store(new FileOutputStream(new File("../OrdinacijaZajednicki/src/main/resources/konekcija.properties")), null);
		} catch (Exception ex) {
			System.err.println("Greška pri upisu adrese u properties fajl\n" + ex.getMessage());
		}
	}

	public void postaviPort(String port) {
		try {
			props.setProperty("port", port);
			props.store(new FileOutputStream(new File("../OrdinacijaZajednicki/src/main/resources/konekcija.properties")), null);
		} catch (Exception ex) {
			System.err.println("Greška pri upisu porta u properties fajl\n" + ex.getMessage());
		}
	}

}
