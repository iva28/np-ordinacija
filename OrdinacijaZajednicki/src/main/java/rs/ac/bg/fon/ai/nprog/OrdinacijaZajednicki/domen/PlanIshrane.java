package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja plan ishrane kojeg nutricionista pravi za pacijenta
 * 
 * Ova klasa nasledjuje klasu {@link OpstaDomenskaKlasa}
 * 
 * @author Iva Stanisic
 *
 */
public class PlanIshrane extends OpstaDomenskaKlasa {
	/**
	 * Id plana ishrane kao Long
	 */
	private Long planIshraneId;
	/**
	 * Datum pocetka plana
	 */
	private Date datum;
	/**
	 * Cena plana u dinarima
	 */
	private BigDecimal cena;
	/**
	 * Broj dana trajanja plana
	 */
	private int brojDana;
	/**
	 * Pacijent za kojeg je plan napravljen
	 */
	private Pacijent pacijent;
	/**
	 * Nutricionista koji je napravio plan
	 */
	private Nutricionista nutricionista;
	/**
	 * Lista stavki koje se nalaze na planu ishrane
	 */
	private List<StavkaPlanaIshrane> stavke;

	/**
	 * Vraca stavke koje se nalaze na planu
	 * 
	 * @return lista stavki plana
	 */
	public List<StavkaPlanaIshrane> getStavke() {
		return stavke;
	}

	/**
	 * Postavlja listu stavki na plan ishrane
	 * 
	 * @param stavke lista stavki na planu ishrane
	 */
	public void setStavke(List<StavkaPlanaIshrane> stavke) {
		this.stavke = stavke;
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public PlanIshrane() {
		stavke = new ArrayList<>();
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 * 
	 * @param planIshraneId ID plana
	 * @param datum         datum pocetka plana
	 * @param cena          cena plana
	 * @param brojDana      broj dana trajanja plana
	 * @param pacijent      pacijent koji je korisnik plana
	 * @param nutricionista nutricionista koji pravi plan
	 * @param stavke        stavke na planu
	 */
	public PlanIshrane(Long planIshraneId, Date datum, BigDecimal cena, int brojDana, Pacijent pacijent,
			Nutricionista nutricionista, List<StavkaPlanaIshrane> stavke) {
		this.planIshraneId = planIshraneId;
		this.datum = datum;
		this.cena = cena;
		this.brojDana = brojDana;
		this.pacijent = pacijent;
		this.nutricionista = nutricionista;
		this.stavke = stavke;
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute (osim stavki plana) na
	 * prosledjene vrednosti
	 * 
	 * @param planIshraneId ID plana
	 * @param datum         datum pocetka plana
	 * @param cena          cena plana
	 * @param brojDana      broj dana trajanja plana
	 * @param pacijent      pacijent koji je korisnik plana
	 * @param nutricionista nutricionista koji pravi plan
	 */
	public PlanIshrane(Long planIshraneId, Date datum, BigDecimal cena, int brojDana, Pacijent pacijent,
			Nutricionista nutricionista) {
		this.planIshraneId = planIshraneId;
		this.datum = datum;
		this.cena = cena;
		this.brojDana = brojDana;
		this.pacijent = pacijent;
		this.nutricionista = nutricionista;
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribut planIshraneId na
	 * prosledjenu vrednost
	 * 
	 * @param planIshraneId ID plana
	 */
	public PlanIshrane(Long planIshraneId) {
		this.planIshraneId = planIshraneId;
	}

	/**
	 * Vraca ID plana
	 * 
	 * @return ID plana
	 */
	public Long getPlanIshraneId() {
		return planIshraneId;
	}

	/**
	 * Vraca datum plana
	 * 
	 * @return datum plana
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * Vraca cenu plana
	 * 
	 * @return cena plana
	 */
	public BigDecimal getCena() {
		return cena;
	}

	/**
	 * Vraca trajanje plana u danima
	 * 
	 * @return broj dana koliko traje plan
	 */
	public int getBrojDana() {
		return brojDana;
	}

	/**
	 * Vraca pacijenta koji koristi plan
	 * 
	 * @return pacijent koji koristi plan
	 */
	public Pacijent getPacijent() {
		return pacijent;
	}

	/**
	 * Vraca nutricionistu koji je napravio plan
	 * 
	 * @return nutricionista koji je napravio plan
	 */
	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	/**
	 * Postavlja ID plana ishrane
	 * 
	 * @param planIshraneId ID plana
	 */
	public void setPlanIshraneId(Long planIshraneId) {
		this.planIshraneId = planIshraneId;
	}

	/**
	 * Postavlja datum plana
	 * 
	 * @param datum plana
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}

	/**
	 * Postavlja cenu plana
	 * 
	 * @param cena plana
	 */
	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	/**
	 * Postavlja broj dana trajanja plana
	 * 
	 * @param brojDana trajanja plana
	 */
	public void setBrojDana(int brojDana) {
		this.brojDana = brojDana;
	}

	/**
	 * Postavlja korisnika tj. pacijenta plana
	 * 
	 * @param pacijent plana ishrane
	 */
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	/**
	 * Postavlja nutricionistu plana ishrane
	 * 
	 * @param nutricionista plana
	 */
	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	/**
	 * Dodaje novu stavku na plan ishrane
	 * 
	 * @param stavka nova stavka koja se dodaje na plan ishrane
	 */
	public void dodajStavku(StavkaPlanaIshrane stavka) {
		stavke.add(stavka);
	}

	/**
	 * Vraca String vrednost sa svim atributima objekta
	 * 
	 * @return String sa svim vrednostima atrinuta domenskog objekta
	 */

	@Override
	public String toString() {
		return "PlanIshrane{" + "planIshraneId=" + planIshraneId + ", datum=" + datum + ", cena=" + cena + ", pacijent="
				+ pacijent + ", nutricionista=" + nutricionista + '}';
	}

	/**
	 * Racuna hash code na osnovu ID plana ishrane
	 * @return hash code na osnovu planIshraneId
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(this.planIshraneId);
		return hash;
	}
/**
 * Poredi dva plana na osnovu datuma, pacijenta i nutricioniste
 * 
 * @param obj drugi plan ishrane - sa kojim se poredi
 * @return true ako planovi imaju isti datum, pacijenta i nutricionistu. False u suprotnom.
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
		final PlanIshrane other = (PlanIshrane) obj;
		if (this.brojDana != other.brojDana) {
			return false;
		}
		if (!Objects.equals(this.datum, other.datum)) {
			return false;
		}
		if (!Objects.equals(this.pacijent, other.pacijent)) {
			return false;
		}
		return Objects.equals(this.nutricionista, other.nutricionista);
	}

	@Override
	public String imeTabele() {
		return "planishrane";
	}

	@Override
	public String vratiParametre() {
		return String.format("'%s', %s, %s, %s, %s", new java.sql.Date(datum.getTime()), cena,
				pacijent.vratiPrimarniKljuc(), nutricionista.vratiPrimarniKljuc(), brojDana);
	}

	@Override
	public String vratiNaziveParametara() {
		return " (datum,cena,pacijentId,nutricionistaId,brojDana)";
	}

	@Override
	public String vratiNazivPrimarnogKljuca() {
		return "planishraneId";
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return planIshraneId;
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> planovi = new ArrayList<>();
		try {
			while (rs.next()) {
				Long planIshraneIdBaza = rs.getLong("pi.planishraneId");
				Date datumBaza = rs.getDate("pi.datum");
				BigDecimal cenaBaza = rs.getBigDecimal("pi.cena");
				Long pacijentId = rs.getLong("pi.pacijentId");
				Long nutricionistaId = rs.getLong("pi.nutricionistaId");
				int brojDanaBaza = rs.getInt("pi.brojDana");
				String imeP = rs.getString("p.ime");
				String prezimeP = rs.getString("p.prezime");
				String emailP = rs.getString("p.email");

				String imeN = rs.getString("n.ime");
				String prezimeN = rs.getString("n.prezime");

				PlanIshrane pi = new PlanIshrane(planIshraneIdBaza, datumBaza, cenaBaza, brojDanaBaza,
						new Pacijent(pacijentId, imeP, prezimeP, emailP, "", null),
						new Nutricionista(nutricionistaId, imeN, prezimeN, "", "", null));
				planovi.add(pi);
			}
		} catch (Exception ex) {
			System.err.println("Greška u konvertovanju ResultSet-a u Plan Ishrane klasi! " + ex.getMessage());
		}
		return planovi;
	}

	@Override
	public String uslovZaIzmenu() {
		return " datum = '" + new java.sql.Date(datum.getTime()) + "', cena = " + cena + " ,pacijentId = "
				+ pacijent.vratiPrimarniKljuc() + " ,nutricionistaId = " + nutricionista.vratiPrimarniKljuc()
				+ " ,brojDana = " + brojDana;
	}

	@Override
	public String uslovZaJednog() {
		return " pi.planishraneId =" + planIshraneId;
	}

	@Override
	public String spajanje() {
		return " pi join pacijent p on (pi.pacijentId = p.id) "
				+ "join nutricionista n on (pi.nutricionistaId = n.nutricionistaId)";
	}

	@Override
	public String vratiSlozenPrimarniKljuc() {
		return null;
	}

	@Override
	public String uslovZaVise() {
		if (pacijent == null && nutricionista != null) {
			return " n.ime = '" + nutricionista.getIme() + "' AND n.prezime = '" + nutricionista.getPrezime() + "'";
		} else if (pacijent != null && nutricionista == null) {
			return " p.ime ='" + pacijent.getIme() + "' AND p.prezime ='" + pacijent.getPrezime() + "'";
		} else {
			return "p.ime ='" + pacijent.getIme() + "' AND p.prezime ='" + pacijent.getPrezime() + "' AND n.ime = '"
					+ nutricionista.getIme() + "' AND n.prezime ='" + nutricionista.getPrezime() + "'";
		}
	}

	@Override
	public String uslovZaBrisanjeVise() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
