package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db;

/**
 *
 * @author Iva
 */
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

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
                Properties properties = new Properties();
                properties.load(new FileInputStream("konfiguracija/konfiguracija.properties"));
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");
                konekcija = DriverManager.getConnection(url, username, password);
                konekcija.setAutoCommit(false);
                System.out.println("Otvorena konekcija..");
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
