package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db;


import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * Sadrzi podatke za uspostavljanje konekcije sa bazom podataka
 * 
 * @author Iva Stanisic
 */
public class KonekcijaSaBazom {
	 /**
     * Staticko privatno polje koje cuva jedinstvenu instancu klase KonekcijaSaBazom
     */
	private static KonekcijaSaBazom instanca;
	/**
     * Polje koje predstavlja trenutnu konekciju sa bazom podataka
     */
	private Connection konekcija;

	/**
	 * Privatni konstruktor koji sprecava direktno instanciranje klase
	 */
	private KonekcijaSaBazom() {

	}

	/**
	 * Vraca jedinstvenu instancu klase KonekcijaSaBazom
	 *
	 * @return Instanca klase KonekcijaSaBazom
	 */
	public static KonekcijaSaBazom getInstanca() {
		if (instanca == null) {
			instanca = new KonekcijaSaBazom();
		}
		return instanca;
	}

	/**
	 * Ootvara konekciju sa bazom podataka
	 *
	 * @return Objekat klase Connection koji predstavlja otvorenu konekciju
	 * @throws Exception ako dodje do greske prilikom izvrsavanja metode
	 */
	public Connection otvoriKonekciju() throws Exception {
		try {
			if (konekcija == null || konekcija.isClosed()) {
				try (FileReader fileReader = new FileReader("src/main/resources/konfiguracija.json")) {
					Gson gson = new Gson();
					JsonObject jsonObject = gson.fromJson(fileReader, JsonObject.class);
					String url = jsonObject.get("url").getAsString();
					String username = jsonObject.get("username").getAsString();
					String password = jsonObject.get("password").getAsString();
					konekcija = DriverManager.getConnection(url, username, password);
					konekcija.setAutoCommit(false);
					System.out.println("Otvorena konekcija..");
				} catch (IOException e) {
					System.err.println("Greška pri čitanju fajla: " + e.getMessage());
				}
			}
			return konekcija;
		} catch (Exception e) {
			System.err.println("Error in connecting to db..\n");
			throw e;
		}
	}

	/**
	 * Zatvara konekciju sa bazom podataka
	 * 
	 * @throws Exception ako dodje do greske prilikom izvrsavanja metode
	 */
	public void zatvoriKonekciju() throws Exception {
		konekcija.close();
		System.out.println("Zatvorena konekcija..");
	}

	/**
	 * Potvrdjuje transakciju nad bazom podataka (radi commit transakcije)
	 * 
	 * @throws Exception ako dodje do greske prilikom izvrsavanja metode
	 */
	public void potvrdiTransakciju() throws Exception {
		konekcija.commit();
		System.out.println("Transakcija je potvrđena :)");
	}
	/**
	 * Ponistava transakciju nad bazom podataka (radi rollback transakcije)
	 * 
	 * @throws Exception ako dodje do greske prilikom izvrsavanja metode
	 */
	public void ponistiTransakciju() throws Exception {
		konekcija.rollback();
		System.err.println("Transakcija je poništena :(");
	}
}
