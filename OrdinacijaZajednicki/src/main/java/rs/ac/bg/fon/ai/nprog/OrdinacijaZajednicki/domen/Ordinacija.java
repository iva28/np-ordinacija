package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja ordinaciju u kojoj radi nutricionista
 * 
 * Ova klasa nasledjuje klasu {@link OpstaDomenskaKlasa}
 * 
 * @author Iva Stanisic
 *
 */
public class Ordinacija extends OpstaDomenskaKlasa {

	/**
	 * Id ordinacije kao Long
	 */
	private Long ordinacijaId;
	/**
	 * Naziv ordinacije kao String
	 */
	private String naziv;
	/**
	 * Adresa ordinacije kao String
	 */
	private String adresa;

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public Ordinacija() {
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 * 
	 * @param ordinacijaId ID ordinacije
	 * @param naziv        naziv ordinacije
	 * @param adresa       adresa ordinacije
	 */
	public Ordinacija(Long ordinacijaId, String naziv, String adresa) {
		setOrdinacijaId(ordinacijaId);
		setNaziv(naziv);
		setAdresa(adresa);
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribut ordinacijaId na
	 * prosledjenu vrednost
	 * 
	 * @param ordinacijaId ID ordinacije
	 */
	public Ordinacija(Long ordinacijaId) {
		setOrdinacijaId(ordinacijaId);
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute ordinacijaId i naziv na
	 * prosledjene vrednosti
	 * 
	 * @param ordinacijaId ID ordinacije
	 * @param naziv        naziv ordinacije
	 */
	public Ordinacija(Long ordinacijaId, String naziv) {
		setOrdinacijaId(ordinacijaId);
		setNaziv(naziv);
	}

	/**
	 * Vraca ID ordinacije
	 * 
	 * @return ID ordinacije
	 */
	public Long getOrdinacijaId() {
		return ordinacijaId;
	}

	/**
	 * Vraca naziv ordinacije
	 * 
	 * @return naziv ordinacije
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Vraca adresu ordinacije
	 * 
	 * @return adresa ordinacije
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * Postavlja ID ordinacije
	 * 
	 * @param ordinacijaId ID ordinacije
	 */
	public void setOrdinacijaId(Long ordinacijaId) {
		if (ordinacijaId == null)
			throw new NullPointerException("Id ne sme biti null");
		if (ordinacijaId < 0)
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		this.ordinacijaId = ordinacijaId;
	}

	/**
	 * Postavlja naziv ordinacije
	 * 
	 * @param naziv ordinacije
	 */
	public void setNaziv(String naziv) {
		if (naziv == null)
			throw new NullPointerException();
		if (naziv.length() < 5)
			throw new IllegalArgumentException("Naziv ne sme biti manji od 5 char");
		this.naziv = naziv;
	}

	/**
	 * Postavlja adresu ordinacije
	 * 
	 * @param adresa ordinacije
	 */
	public void setAdresa(String adresa) {
		if (adresa == null)
			throw new NullPointerException();
		this.adresa = adresa;
	}

	/**
	 * Racuna hash code na osnovu atributa ordinacijaId
	 * 
	 * @return hash code na osnovu ordinacijaId
	 */
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + Objects.hashCode(this.ordinacijaId);
		return hash;
	}

	/**
	 * Poredi dve ordinacije
	 * 
	 * @param obj druga ordinacija - sa kojom se poredi
	 * @return true ako imaju isti ordinacijaId, false u suprotnom
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
		final Ordinacija other = (Ordinacija) obj;
		return Objects.equals(this.ordinacijaId, other.ordinacijaId);
	}

	/**
	 * Vraca String vrednost sa svim atributima objekta
	 * 
	 * @return String sa svim vrednostima atrinuta domenskog objekta
	 */
	@Override
	public String toString() {
		return "Ordinacija{" + "ordinacijaId=" + ordinacijaId + ", naziv=" + naziv + ", adresa=" + adresa + '}';
	}

	@Override
	public String imeTabele() {
		return "ordinacija";
	}

	@Override
	public String vratiParametre() {
		return String.format("%s, '%s', '%s'", ordinacijaId, naziv, adresa);
	}

	@Override
	public String vratiNaziveParametara() {
		return "ordinacijaId,naziv,adresa";
	}

	@Override
	public String vratiNazivPrimarnogKljuca() {
		return "ordinacijaId";
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return ordinacijaId;
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> ordinacije = new ArrayList<>();
		try {
			while (rs.next()) {
				Long ordinacijaIdBaza = rs.getLong("ordinacijaId");
				String nazivBaza = rs.getString("naziv");
				String adresaBaza = rs.getString("adresa");
				ordinacije.add(new Ordinacija(ordinacijaIdBaza, nazivBaza, adresaBaza));
			}
		} catch (Exception ex) {
			System.err.println("Greška u konvertovanju ResultSet-a u Ordinacija klasi! " + ex.getMessage());
		}
		return ordinacije;
	}

	@Override
	public String uslovZaIzmenu() {
		return "ordinacijaId=" + ordinacijaId + ", naziv=" + naziv + ", adresa=" + adresa;
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
