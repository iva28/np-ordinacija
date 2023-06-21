package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja pacijenta za kojeg nutricionista pravi plan ishrane
 * 
 * Ova klasa nasledjuje klasu {@link OpstaDomenskaKlasa}
 * 
 * @author Iva Stanisic
 *
 */
public class Pacijent extends OpstaDomenskaKlasa {

	/**
	 * Id pacijenta kao Long
	 */
	private Long pacijentId;
	/**
	 * Ime pacijenta kao String
	 */
	private String ime;
	/**
	 * Prezime pacijenta kao String
	 */
	private String prezime;
	/**
	 * Email pacijenta kao String
	 */
	private String email;
	/**
	 * Telefon pacijenta kao String
	 */
	private String telefon;
	/**
	 * Pol pacijenta
	 */
	private Pol pol;

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public Pacijent() {
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute (osim pacijentId) na
	 * prosledjene vrednosti
	 * 
	 * @param ime     ime pacijenta
	 * @param prezime prezime pacijenta
	 * @param email   email pacijenta
	 * @param telefon telefon pacijenta
	 * @param pol     pol pacijenta
	 */
	public Pacijent(String ime, String prezime, String email, String telefon, Pol pol) {
//		this.ime = ime;
//		this.prezime = prezime;
//		this.email = email;
//		this.telefon = telefon;
//		this.pol = pol;
		setIme(ime);
		setPrezime(prezime);
		setEmail(email);
		setTelefon(telefon);
		setPol(pol);
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 * 
	 * @param pacijentId ID pacijenta
	 * @param ime        ime pacijenta
	 * @param prezime    prezime pacijenta
	 * @param email      email pacijenta
	 * @param telefon    telefon pacijenta
	 * @param pol        pol pacijenta
	 */
	public Pacijent(Long pacijentId, String ime, String prezime, String email, String telefon, Pol pol) {
//		this.pacijentId = pacijentId;
//		this.ime = ime;
//		this.prezime = prezime;
//		this.email = email;
//		this.telefon = telefon;
//		this.pol = pol;
		setPacijentId(pacijentId);
		setIme(ime);
		setPrezime(prezime);
		setEmail(email);
		setTelefon(telefon);
		setPol(pol);
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribut pacijentId na prosledjenu
	 * vrednost
	 * 
	 * @param pacijentId ID pacijenta
	 */
	public Pacijent(Long pacijentId) {
//		this.pacijentId = pacijentId;
		setPacijentId(pacijentId);
	}

	/**
	 * Vraca ID pacijenta
	 * 
	 * @return ID pacijenta
	 */
	public Long getPacijentId() {
		return pacijentId;
	}

	/**
	 * Vraca ime pacijenta
	 * 
	 * @return ime pacijenta
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Vraca prezime pacijenta
	 * 
	 * @return prezime pacijenta
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Vraca email pacijenta
	 * 
	 * @return email pacijenta
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Vraca telefon pacijenta
	 * 
	 * @return telefon pacijenta
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * Vraca pol pacijenta
	 * 
	 * @return pol pacijenta
	 */
	public Pol getPol() {
		return pol;
	}

	/**
	 * Postavlja ID pacijenta
	 * 
	 * @param pacijentId ID pacijenta
	 */
	public void setPacijentId(Long pacijentId) {
		if (pacijentId == null)
			throw new NullPointerException("Id ne sme biti null");
		if (pacijentId < 0)
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		this.pacijentId = pacijentId;
	}

	/**
	 * Postavlja ime pacijenta
	 * 
	 * @param ime pacijenta
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException();
		if (ime.length() < 3)
			throw new IllegalArgumentException("Prekratko ime");
		this.ime = ime;
	}

	/**
	 * Postavlja prezime pacijenta
	 * 
	 * @param prezime pacijenta
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException();
		if (prezime.length() < 3)
			throw new IllegalArgumentException("Prekratko prezime");
		this.prezime = prezime;
	}

	/**
	 * Postavlja email pacijenta
	 * 
	 * @param email pacijenta
	 */
	public void setEmail(String email) {
		if (email == null)
			throw new NullPointerException();
		if (email.length() <= 5)
			throw new IllegalArgumentException("Prekratak email");
		this.email = email;
	}

	/**
	 * Postavlja telefon pacijenta
	 * 
	 * @param telefon pacijenta
	 */
	public void setTelefon(String telefon) {
		if (telefon == null)
			throw new NullPointerException();
		if (!telefon.matches("[0-9]+"))
			throw new IllegalArgumentException("Samo brojevi");
		this.telefon = telefon;
	}

	/**
	 * Postavlja pol pacijenta
	 * 
	 * @param pol pacijenta
	 */
	public void setPol(Pol pol) {
		if (pol == null)
			throw new NullPointerException();
		this.pol = pol;
	}

	/**
	 * Racuna hash code na osnovu pacijentId
	 * 
	 * @return hash code na osnovu pacijentId
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 83 * hash + Objects.hashCode(this.pacijentId);
		return hash;
	}

	/**
	 * Poredi dva pacijenta na osnovu email-a
	 * 
	 * @param obj drugi pacijent - sa kojim se poredi
	 * @return true ako imaju isti email, false u suprotnom
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
		final Pacijent other = (Pacijent) obj;
		return Objects.equals(this.email, other.email);
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

	@Override
	public String imeTabele() {
		return "pacijent";
	}

	@Override
	public String vratiParametre() {
		return String.format(" '%s', '%s', '%s', '%s', '%s'", ime, prezime, email, telefon, pol.toString());
	}

	@Override
	public String vratiNaziveParametara() {
		return "(ime, prezime, email, telefon, pol) ";
	}

	@Override
	public String vratiNazivPrimarnogKljuca() {
		return "id";
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return pacijentId;
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> pacijenti = new ArrayList<>();
		try {
			while (rs.next()) {
				Long pacijentiIdBaza = rs.getLong("id");
				String imeBaza = rs.getString("ime");
				String prezimeBaza = rs.getString("prezime");
				String emailBaza = rs.getString("email");
				String telefonBaza = rs.getString("telefon");
				Pol polBaza = Pol.valueOf(rs.getString("pol"));

				Pacijent novi = new Pacijent();
				novi.setPacijentId(pacijentiIdBaza);
				novi.setIme(imeBaza);
				novi.setPrezime(prezimeBaza);
				novi.setEmail(emailBaza);
				novi.setTelefon(telefonBaza);
				novi.setPol(polBaza);
				pacijenti.add(novi);
			}
		} catch (Exception ex) {
			System.err.println("Greška u ResultSet-u u Pacijent klasi! " + ex.getMessage());
		}
		System.out.println(pacijenti);
		return pacijenti;
	}

	@Override
	public String uslovZaIzmenu() {
		return "ime = '" + ime + "' ,prezime = '" + prezime + "' , email = '" + email + "', telefon = '" + telefon
				+ "' ,pol = '" + pol + "'";
	}

	@Override
	public String uslovZaJednog() {
		return " email ='" + email + "'";
	}

	@Override
	public String spajanje() {
		return "";
	}

	@Override
	public String vratiSlozenPrimarniKljuc() {
		return null;
	}

	@Override
	public String uslovZaVise() {
		return " ime= '" + ime + "'";
	}

	@Override
	public String uslovZaBrisanjeVise() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
