package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja nutricionistu plana ishrana
 * 
 * Ova klasa nasledjuje klasu {@link OpstaDomenskaKlasa}
 * 
 * @author Iva Stanisic
 *
 */
public class Nutricionista extends OpstaDomenskaKlasa {

	/**
	 * ID nutricioniste kao Long
	 */
	private Long nutricionistaId;
	/**
	 * Ime nutricioniste kao String
	 */
	private String ime;
	/**
	 * Prezime nutricioniste kao String
	 */
	private String prezime;
	/**
	 * Username nutricioniste kao String
	 */
	private String username;
	/**
	 * Password nutricioniste kao String
	 */
	private String password;
	/**
	 * Ordinacija u kojoj radi nutricionista
	 */
	private Ordinacija ordinacija;

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public Nutricionista() {
	}

	/**
	 *  Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 *  
	 * @param nutricionistaId ID nutricioniste
	 * @param ime ime nutricioniste
	 * @param prezime prezime nutricioniste
	 * @param username username nutricioniste
	 * @param password password nutricioniste
	 * @param ordinacija ordinacije nutricioniste
	 */
	public Nutricionista(Long nutricionistaId, String ime, String prezime, String username, String password,
			Ordinacija ordinacija) {
		setNutricionistaId(nutricionistaId);
		setIme(ime);
		setPrezime(prezime);
		setUsername(username);
		setPassword(password);
		setOrdinacija(ordinacija);
	}
/**
 * Konstruise novu instancu klase i postavlja atribut nutricionistaId na prosledjenu vrednost
 * 
 * @param nutricionistaId ID nutricioniste
 */
	public Nutricionista(Long nutricionistaId) {
		setNutricionistaId(nutricionistaId);
	}
/**
 * Postavlja ordinaciju kojoj nutricionista pripada
 * 
 * @param ordinacija ordinacija u kojoj radi nutricionista
 */
	public void setOrdinacija(Ordinacija ordinacija) {
		if (ordinacija == null)
			throw new NullPointerException();
		this.ordinacija = ordinacija;
	}
/**
 * Postavlja ID nutricioniste
 * 
 * @param nutricionistaId ID nutricioniste
 */
	public void setNutricionistaId(Long nutricionistaId) {
		if (nutricionistaId == null)
			throw new NullPointerException("Id ne sme biti null");
		if (nutricionistaId < 0)
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		this.nutricionistaId = nutricionistaId;
	}
/**
 * Postavlja ime nutricioniste
 * 
 * @param ime nutricioniste
 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException();
		if (ime.length() < 3)
			throw new IllegalArgumentException("Ime ne sme biti manje od 2 char");
		if (ime.matches("[0-9]+"))
			throw new IllegalArgumentException("Ne smeju brojevi za ime");
		this.ime = ime;
	}
/**
 * Postavlja prezime nutricioniste
 * 
 * @param prezime nutricioniste
 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException();
		if (prezime.length() < 5)
			throw new IllegalArgumentException("Prezime ne sme biti manje od 5 char");
		if (prezime.matches("[0-9]+"))
			throw new IllegalArgumentException("Ne smeju brojevi za prezime");
		this.prezime = prezime;
	}
/**
 * Postavlja username nutricioniste
 * 
 * @param username nutricioniste
 */
	public void setUsername(String username) {
		if (username == null)
			throw new NullPointerException();
		this.username = username;
	}
/**
 * Postavlja password nutricioniste
 * 
 * @param password nutricioniste
 */
	public void setPassword(String password) {
		if (password == null)
			throw new NullPointerException();
		this.password = password;
	}
/**
 * Vraca ID nutricioniste
 * 
 * @return ID nutricioniste
 */
	public Long getNutricionistaId() {
		return nutricionistaId;
	}
/**
 * Vraca ime nutricioniste
 * 
 * @return ime nutricioniste
 */
	public String getIme() {
		return ime;
	}
/**
 * Vraca prezime nutricioniste
 * 
 * @return prezime nutricioniste
 */
	public String getPrezime() {
		return prezime;
	}
/**
 * Vraca username nutricioniste
 * 
 * @return username nutricioniste
 */
	public String getUsername() {
		return username;
	}
/**
 * Vraca password nutricioniste
 * 
 * @return password nutricioniste
 */
	public String getPassword() {
		return password;
	}
/**
 * Vraca ordinaciju u kojoj radi nutricionista
 * 
 * @return ordinacija nutricioniste
 */
	public Ordinacija getOrdinacija() {
		return ordinacija;
	}

	@Override
	public String imeTabele() {
		return "nutricionista";
	}

	@Override
	public String vratiParametre() {
		return String.format("%s, '%s', '%s', '%s', '%s', %s", nutricionistaId, ime, prezime, username, password,
				ordinacija.vratiPrimarniKljuc());
	}

	@Override
	public String vratiNaziveParametara() {
		return "nutricionistaId,ime,prezime,username,password,ordinacijaId";
	}

	@Override
	public String vratiNazivPrimarnogKljuca() {
		return "nutricionistaId";
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return nutricionistaId;
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> nutricionisti = new ArrayList<>();
		try {
			while (rs.next()) {
				Long idBaza = rs.getLong("n.nutricionistaId");
				String imeBaza = rs.getString("n.ime");
				String prezimeBaza = rs.getString("n.prezime");
				String usernameBaza = rs.getString("n.username");
				String passwordBaza = rs.getString("n.password");
				Long ordinacijaId = rs.getLong("n.ordinacijaId");
				String imeOrdinacije = rs.getString("o.naziv");
				Ordinacija o = new Ordinacija();
				o.setOrdinacijaId(ordinacijaId);
				o.setNaziv(imeOrdinacije);
				Nutricionista n = new Nutricionista(idBaza, imeBaza, prezimeBaza, usernameBaza, passwordBaza, o);
				System.out.println(n);
				nutricionisti.add(n);
			}
		} catch (Exception ex) {
			System.err.println("Greska u konvertovanju ResultSet-a u Nutricionista klasi! " + ex.getMessage());
		}
		return nutricionisti;
	}

	@Override
	public String uslovZaIzmenu() {
		return "nutricionistaId=" + nutricionistaId + ", ime=" + ime + ", prezime=" + prezime + ", username=" + username
				+ ", password=" + password + ", ordinacijaId=" + ordinacija.vratiPrimarniKljuc();
	}

	@Override
	public String uslovZaJednog() {
		return " n.username= '" + getUsername() + "' AND n.password= '" + getPassword() + "'";
	}
	/**
	 * Vraca String vrednost sa svim atributima objekta
	 * 
	 * @return String sa svim vrednostima atrinuta domenskog objekta
	 */
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
/**
 * Poredi dvoje nutricionista
 * 
 * Dvoje nutricionista su isti ako imaju isto ime i prezime
 * 
 * @param obj drugi nutricionista - sa kojim se poredi
 * @return true ako imaju isto ime i prezime, false u suprotnom
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Nutricionista other = (Nutricionista) obj;
		if (!Objects.equals(this.ime, other.ime)) {
			return false;
		}
		return Objects.equals(this.prezime, other.prezime);
	}

	/**
	 * Racuna hash code na osnovu imena i prezimena nutricioniste
	 * 
	 * @return hash code na osnovu imena i prezimena
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 59 * hash + Objects.hashCode(this.ime);
		hash = 59 * hash + Objects.hashCode(this.prezime);
		return hash;
	}

	@Override
	public String spajanje() {
		return " n join ordinacija o on (n.ordinacijaId = o.ordinacijaId)";
	}

	@Override
	public String vratiSlozenPrimarniKljuc() {
		return null;
	}

	@Override
	public String uslovZaVise() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String uslovZaBrisanjeVise() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
