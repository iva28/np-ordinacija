package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja kuvara jela
 * 
 * Ova klasa nasledjuje klasu {@link OpstaDomenskaKlasa}
 * 
 * @author Iva Stanisic
 *
 */
public class Kuvar extends OpstaDomenskaKlasa {

	/**
	 * ID kuvara kao Long
	 */
	private Long kuvarId;
	/**
	 * Ime kuvara kao String
	 */
	private String ime;
	/**
	 * Prezime kuvara kao String
	 */
	private String prezime;
	/**
	 * Adresa kuvara kao String
	 */
	private String adresa;
	/**
	 * Telefon kuvara kao String
	 */
	private String telefon;

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public Kuvar() {
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 * 
	 * @param kuvarId ID kuvara
	 * @param ime     ime kuvara
	 * @param prezime prezime kuvara
	 * @param adresa  adresa kuvara
	 * @param telefon telefon kuvara
	 */
	public Kuvar(Long kuvarId, String ime, String prezime, String adresa, String telefon) {
		this.kuvarId = kuvarId;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.telefon = telefon;
//		setKuvarId(kuvarId);
//		setIme(ime);
//		setPrezime(prezime);
//		setAdresa(adresa);
//		setTelefon(telefon);
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute kuvarId, ime i prezime na
	 * prosledjene vrednosti
	 * 
	 * @param kuvarId ID kuvara
	 * @param ime     ime kuvara
	 * @param prezime prezime kuvara
	 */
	public Kuvar(Long kuvarId, String ime, String prezime) {
		this.kuvarId = kuvarId;
		this.ime = ime;
		this.prezime = prezime;
//		setKuvarId(kuvarId);
//		setIme(ime);
//		setPrezime(prezime);
	}

	/**
	 * Vraca ID kuvara
	 * 
	 * @return ID kuvara kao Long
	 */
	public Long getKuvarId() {
		return kuvarId;
	}

	/**
	 * Vraca ime kuvara
	 * 
	 * @return ime kuvara
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Vraca prezime kuvara
	 * 
	 * @return prezime kuvara
	 */
	public String getPrezime() {
		return prezime;
	}
/**
 * Vraca adresu kuvara
 * 
 * @return adresa kuvara
 */
	public String getAdresa() {
		return adresa;
	}
/**
 * Vraca telefon kuvara
 * 
 * @return telefon kuvara
 */
	public String getTelefon() {
		return telefon;
	}
/**
 * Postavlja vrednost atributa kuvarId
 * 
 * @param kuvarId ID kuvara
 */
	public void setKuvarId(Long kuvarId) {
		if (kuvarId == null)
			throw new NullPointerException();
		if (kuvarId <= 0)
			throw new IllegalArgumentException();
		this.kuvarId = kuvarId;
	}
/**
 * Postavlja ime kuvara
 * 
 * @param ime kuvara
 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException();
		if (ime.length() < 2)
			throw new IllegalArgumentException("Ime ne sme biti manje od 2 char");
		this.ime = ime;
	}
/**
 * Postavlja prezime kuvara
 * 
 * @param prezime kuvara
 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException();
		if (prezime.length() < 5)
			throw new IllegalArgumentException("Prezime ne sme biti manje od 5 char");
		this.prezime = prezime;
	}
/**
 * Postavlja adresu kuvara
 * 
 * @param adresa kuvara
 */
	public void setAdresa(String adresa) {
		if (adresa == null)
			throw new NullPointerException();
		this.adresa = adresa;
	}
/**
 * Postavlja telefon kuvara
 * 
 * @param telefon kuvara
 */
	public void setTelefon(String telefon) {
		if (telefon == null)
			throw new NullPointerException();
		if (telefon.length() < 7)
			throw new IllegalArgumentException();
		this.telefon = telefon;
	}

	/**
	 * Vraca hash code izracunat na osnovu ID-a kuvara
	 * 
	 * @return hash code na osnovu kuvarId
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.kuvarId);
		return hash;
	}

	/**
	 * Poredi dva kuvara na osnovu ID-a
	 * 
	 * @return true ako dva kuvara imaju isti ID, false u suprotnom
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
		final Kuvar other = (Kuvar) obj;
		return Objects.equals(this.kuvarId, other.kuvarId);
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
		return "kuvar";
	}

	@Override
	public String vratiParametre() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String vratiNaziveParametara() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String vratiNazivPrimarnogKljuca() {
		return "kuvarId";
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return kuvarId;
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> kuvari = new ArrayList<>();
		try {
			while (rs.next()) {
				Long kuvarId = rs.getLong("kuvarId");
				String ime = rs.getString("ime");
				String prezime = rs.getString("prezime");
				String adresa = rs.getString("adresa");
				String telefon = rs.getString("telefon");

				kuvari.add(new Kuvar(kuvarId, ime, prezime, adresa, telefon));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in converting list in Kuvari!\n");
		}
		return kuvari;
	}

	@Override
	public String uslovZaIzmenu() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String uslovZaJednog() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String uslovZaBrisanjeVise() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
