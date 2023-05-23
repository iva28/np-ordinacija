package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db;

/**
 *
 * @author Iva
 */
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class KonekcijaSaBazom {

	private static KonekcijaSaBazom instanca;
	private Connection konekcija;

	private KonekcijaSaBazom() {

	}

	public static KonekcijaSaBazom getInstanca() {
		if (instanca == null) {
			instanca = new KonekcijaSaBazom();
		}
		return instanca;
	}

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

	public void zatvoriKonekciju() throws Exception {
		konekcija.close();
		System.out.println("Zatvorena konekcija..");
	}

	public void potvrdiTransakciju() throws Exception {
		konekcija.commit();
		System.out.println("Transakcija je potvrđena :)");
	}

	public void ponistiTransakciju() throws Exception {
		konekcija.rollback();
		System.err.println("Transakcija je poništena :(");
	}
}
