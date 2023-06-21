package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja jelo na planu ishrane pacijenta.
 * 
 * Ova klasa nasledjuje klasu {@link OpstaDomenskaKlasa}.
 * 
 * @author Iva Stanisic
 *
 */
public class Jelo extends OpstaDomenskaKlasa {

	/**
	 * ID jela kao Long
	 */
	private Long jeloId;

	/**
	 * Tip jela (vegeterijansko, sa mesom)..
	 */
	private TipJela tip;
	/**
	 * Naziv jela kao String
	 */
	private String naziv;
	/**
	 * Cena jela u dinarima
	 */
	private BigDecimal cena;
	/**
	 * Jelo u gramima
	 */
	private int kolicina;
	/**
	 * Kuvar jela
	 */
	private Kuvar kuvar;

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public Jelo() {
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 * 
	 * @param jeloId   ID jela
	 * @param tip      tip jela
	 * @param naziv    naziv jela
	 * @param cena     cena jela
	 * @param kolicina kolicina jela
	 * @param kuvar    kuvar jela
	 */
	public Jelo(Long jeloId, TipJela tip, String naziv, BigDecimal cena, int kolicina, Kuvar kuvar) {
//		this.jeloId = jeloId;
//		this.tip = tip;
//		this.naziv = naziv;
//		this.cena = cena;
//		this.kolicina = kolicina;
//		this.kuvar = kuvar;
		setJeloId(jeloId);
		setTip(tip);
		setNaziv(naziv);
		setCena(cena);
		setKolicina(kolicina);
		setKuvar(kuvar);
	}
	
	

	public Jelo(Long jeloId, String naziv) {
		setJeloId(jeloId);
		setNaziv(naziv);
	}

	/**
	 * Vraca ID jela
	 * 
	 * @return ID jela
	 */
	public Long getJeloId() {
		return jeloId;
	}

	/**
	 * Vraca tip jela.
	 * 
	 * @return tip jela
	 */
	public TipJela getTip() {
		return tip;
	}

	/**
	 * Vraca naziv jela
	 * 
	 * @return naziv jela
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Vraca cenu jela
	 * 
	 * @return cena jela
	 */
	public BigDecimal getCena() {
		return cena;
	}

	/**
	 * Vraca kolicinu jela
	 * 
	 * @return kolicina jela
	 */
	public int getKolicina() {
		return kolicina;
	}

	/**
	 * Vraca kuvara jela
	 * 
	 * @return kuvar jela
	 */
	public Kuvar getKuvar() {
		return kuvar;
	}

	/**
	 * Postavlja vrednost atributa jeloId
	 * 
	 * @param jeloId ID jela
	 */
	public void setJeloId(Long jeloId) {
		if (jeloId == null)
			throw new NullPointerException();
		if (jeloId < 0)
			throw new IllegalArgumentException("Id ne sme biti manji od 0");
		this.jeloId = jeloId;
	}

	/**
	 * Postavlja tip jela
	 * 
	 * @param tip jela
	 */
	public void setTip(TipJela tip) {
		if (tip == null)
			throw new NullPointerException();
		this.tip = tip;
	}

	/**
	 * Postavlja naziv jela
	 * 
	 * @param naziv jela
	 */
	public void setNaziv(String naziv) {
		if (naziv == null)
			throw new NullPointerException();
		if (naziv.length() < 2)
			throw new IllegalArgumentException("Naziv jela ne sme biti manji od 2 char");
		this.naziv = naziv;
	}

	/**
	 * Postavlja cenu jela, izrazenu u dinarima
	 * 
	 * @param cena jela
	 */
	public void setCena(BigDecimal cena) {
		if (cena == null)
			throw new NullPointerException("Cena ne sme biti null");
		if (cena.compareTo(BigDecimal.ZERO) <= 0)
			throw new IllegalArgumentException("Cena ne sme biti manja ili jednaka  0");
		this.cena = cena;
	}

	/**
	 * Postavlja kolicinu jela u gramima
	 * 
	 * @param kolicina jela
	 */
	public void setKolicina(int kolicina) {
		if (kolicina <= 0)
			throw new IllegalArgumentException("Kolicina ne sme biti manja ili jednaka 0");
		this.kolicina = kolicina;
	}

	/**
	 * Postavlja kuvara jela
	 * 
	 * @param kuvar jela
	 */
	public void setKuvar(Kuvar kuvar) {
		if (kuvar == null)
			throw new NullPointerException();
		this.kuvar = kuvar;
	}

	/**
	 * Vraca String vrednost sa svim atributima objekta
	 * 
	 * @return String sa svim vrednostima atrinuta domenskog objekta
	 */
	@Override
	public String toString() {
		return "Jelo{" + "jeloId=" + jeloId + ", tip=" + tip + ", naziv=" + naziv + ", cena=" + cena + ", kolicina="
				+ kolicina + ", kuvar=" + kuvar + '}';
	}

	/**
	 * Vraca hash code
	 * 
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		int hash = 5;
		return hash;
	}

	/**
	 * Poredi dva jela prema nazivu
	 * 
	 * @return true ako je unet isti objekat ili ako su nazivi jela isti, false u
	 *         ostalim slucajevima
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
		final Jelo other = (Jelo) obj;
		return Objects.equals(this.naziv, other.naziv);
	}

	@Override
	public String imeTabele() {
		return "jelo";
	}

	@Override
	public String spajanje() {
		return " j join tipjela tj on (j.tip_id = tj.tipId) join kuvar k on (j.kuvar_id = k.kuvarId) ";
	}

	@Override
	public String vratiParametre() {
		return String.format(" '%s', %s, %s, %s, %s", naziv, cena, kolicina, tip.vratiPrimarniKljuc(),
				kuvar.vratiPrimarniKljuc());
	}

	@Override
	public String vratiNaziveParametara() {
		return "(naziv, cena, kolicina, tip_id, kuvar_id) ";
	}

	@Override
	public String vratiNazivPrimarnogKljuca() {
		return "jeloId";
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return jeloId;
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Long jeloIdBaza = rs.getLong("j.jeloId");
				String nazivBaza = rs.getString("j.naziv");
				BigDecimal cenaBaza = rs.getBigDecimal("j.cena");
				int kolicinaBaza = rs.getInt("j.kolicina");
				Long tipId = rs.getLong("j.tip_id");
				Long kuvarId = rs.getLong("j.kuvar_id");

				String vrsta = rs.getString("tj.vrsta");
				String ime = rs.getString("k.ime");
				String prezime = rs.getString("k.prezime");
				Kuvar k = new Kuvar();
				k.setKuvarId(kuvarId);
				k.setIme(ime);
				k.setPrezime(prezime);
				
				lista.add(new Jelo(jeloIdBaza, new TipJela(tipId, vrsta), nazivBaza, cenaBaza, kolicinaBaza, k));
			}
		} catch (Exception e) {
			System.err.println("Greska u konvertovanju ReseultSet-a u Jelo klasi " + e.getMessage());
		}
		return lista;
	}

	@Override
	public String uslovZaIzmenu() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public String uslovZaJednog() {
		return null;
	}

	@Override
	public String vratiSlozenPrimarniKljuc() {
		return null;
	}

	@Override
	public String uslovZaVise() {
		if (tip == null && kuvar != null) {
			return " j.kuvar_id = " + kuvar.getKuvarId();
		}
		if (kuvar == null && tip != null) {
			return "j.tip_id = " + tip.getTipId();
		}
		return "j.tip_id = " + tip.getTipId() + " AND j.kuvar_id = " + kuvar.getKuvarId();
	}

	@Override
	public String uslovZaBrisanjeVise() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
