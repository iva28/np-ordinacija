package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja stavku plana ishrane
 * 
 * Stavka plana ishrane se sastoji od rednog broja (rb), cene, količine, jela i
 * plana ishrane
 * 
 * Ova klasa nasledjuje klasu {@link OpstaDomenskaKlasa}
 * 
 * @author Iva Stanisic
 *
 */
public class StavkaPlanaIshrane extends OpstaDomenskaKlasa {

	/**
	 * Redni broj stavke
	 */
	private Long rb;
	/**
	 * Cena stavke u dinarima
	 */
	private BigDecimal cena;
	/**
	 * Kolicina stavke kao int
	 */
	private int kolicina;
	/**
	 * Jelo koje se nalazi na stavki plana
	 */
	private Jelo jelo;
	/**
	 * Plan ishrane na kojem se nalazi stavka
	 */
	private PlanIshrane planIshrane;

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public StavkaPlanaIshrane() {
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 * 
	 * @param rb       redni broj stavke
	 * @param cena     cena stavke
	 * @param kolicina kolicina stavke
	 * @param jelo     jelo na koje se stavka odnosi
	 */
	public StavkaPlanaIshrane(Long rb, BigDecimal cena, int kolicina, Jelo jelo) {
		this.rb = rb;
		this.cena = cena;
		this.kolicina = kolicina;
		this.jelo = jelo;
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribut planIshrane na prosledjenu
	 * vrednost
	 * 
	 * @param planIshrane plan ishrane na kome se stavka nalazi
	 */
	public StavkaPlanaIshrane(PlanIshrane planIshrane) {
		this.planIshrane = planIshrane;
	}

	/**
	 * Vraca redni broj stavke
	 * 
	 * @return redni broj stavke
	 */
	public Long getRb() {
		return rb;
	}

	/**
	 * Vraca cenu stavke u dinarima
	 * 
	 * @return cena stavke
	 */
	public BigDecimal getCena() {
		return cena;
	}

	/**
	 * Vraca kolicinu stavke
	 * 
	 * @return kolicina stavke
	 */
	public int getKolicina() {
		return kolicina;
	}

	/**
	 * Vraca jelo na koje se stavka odnosi
	 * 
	 * @return jelo koje se nalazi na stavci
	 */
	public Jelo getJelo() {
		return jelo;
	}

	/**
	 * Vraca plan ishrane na kojem se stavka nalazi
	 * 
	 * @return plan ishrane stavke
	 */
	public PlanIshrane getPlanIshrane() {
		return planIshrane;
	}

	/**
	 * Postavlja redni broj stavke
	 * 
	 * @param rb redni broj stavke
	 */
	public void setRb(Long rb) {
		if (rb == null) 
			throw new NullPointerException("Id ne sme biti null");
		if (rb < 0)
			throw new IllegalArgumentException("Id ne sme biti manji od nule");
		this.rb = rb;
	}

	/**
	 * Postavlja cenu stavke
	 * 
	 * @param cena stavke u dinarima
	 */
	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	/**
	 * Postavlja kolicinu stavke
	 * 
	 * @param kolicina stavke
	 */
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	/**
	 * Postavlja jelo stavke
	 * 
	 * @param jelo stavke
	 */
	public void setJelo(Jelo jelo) {
		this.jelo = jelo;
	}

	/**
	 * Postavlja plan ishrane za stavku
	 * 
	 * @param planIshrane plan ishrane stavke
	 */
	public void setPlanIshrane(PlanIshrane planIshrane) {
		this.planIshrane = planIshrane;
	}

	/**
	 * Vraca String vrednost sa svim atributima objekta
	 * 
	 * @return String sa svim vrednostima atrinuta domenskog objekta
	 */
	@Override
	public String toString() {
		return "StavkaPlanaIshrane{" + "rb=" + rb + ", cena=" + cena + ", kolicina=" + kolicina + ", jelo=" + jelo
				+ ", planIshrane=" + planIshrane + '}';
	}

	@Override
	public String imeTabele() {
		return "stavkaplanaishrane";
	}

	@Override
	public String vratiParametre() {
		return String.format(" %s, %s, %s, %s", cena, kolicina, planIshrane.vratiPrimarniKljuc(),
				jelo.vratiPrimarniKljuc());
	}

	@Override
	public String vratiNaziveParametara() {
		return "(cena, kolicina, planishraneId, jelo_id) ";
	}

	@Override
	public String vratiNazivPrimarnogKljuca() {
		return null;
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return null;
	}

	/**
	 * racuna hash code na osnovu rednog broja stavke
	 * 
	 * @return hash code na osnovu rb stavke
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.rb);
		return hash;
	}

	/**
	 * Poredi dve stavke na osnovu jela
	 * 
	 * @param obj druga stavka - sa kojom se poredi
	 * @return true ako su jela ista na obe stavke, false u suprotnom
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
		final StavkaPlanaIshrane other = (StavkaPlanaIshrane) obj;
		return Objects.equals(this.jelo, other.jelo);
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Long rbBaza = rs.getLong("s.rb");
				BigDecimal cenaBaza = rs.getBigDecimal("s.cena");
				int kolicinaBaza = rs.getInt("s.kolicina");
				Long planIshraneId = rs.getLong("s.planishraneId");

				Long jeloId = rs.getLong("s.jelo_id");

				String nazivJela = rs.getString("j.naziv");
				BigDecimal cenaJelaBaza = rs.getBigDecimal("j.cena");
				int gramaza = rs.getInt("j.kolicina");

				Long tipId = rs.getLong("j.tip_id");
				Long kuvarId = rs.getLong("j.kuvar_id");

				String vrstaJela = rs.getString("tj.vrsta");

				String imeKuvara = rs.getString("k.ime");
				String prezimeKuvara = rs.getString("k.prezime");

				StavkaPlanaIshrane nova = new StavkaPlanaIshrane();
				nova.setRb(rbBaza);

				nova.setPlanIshrane(new PlanIshrane(planIshraneId));
				nova.setPlanIshrane(planIshrane);
				nova.setJelo(new Jelo(jeloId, new TipJela(tipId, vrstaJela), nazivJela, cenaJelaBaza, gramaza,
						new Kuvar(kuvarId, imeKuvara, prezimeKuvara)));
				nova.setKolicina(kolicinaBaza);
				nova.setCena(cenaBaza);
				lista.add(nova);
			}
		} catch (Exception e) {
			System.err.println("Greska u konvertovanju liste u Stavka plana ishrane klasi! " + e.getMessage());
		}
		return lista;
	}

	@Override
	public String uslovZaIzmenu() {
		return " cena = " + cena + " ,kolicina = " + kolicina + " ,planishraneId = " + planIshrane.vratiPrimarniKljuc()
				+ " , jelo_id = " + jelo.vratiPrimarniKljuc();
	}

	@Override
	public String uslovZaJednog() {
		return null;
	}

	@Override
	public String spajanje() {
		return " s join planishrane p on (s.planishraneId = p.planishraneId) "
				+ "join jelo j on (s.jelo_id = j.jeloId) " + "join tipjela tj on (j.tip_id = tj.tipId)"
				+ " join kuvar k on (j.kuvar_id = k.kuvarId) ";
	}

	@Override
	public String vratiSlozenPrimarniKljuc() {
		return "planishraneId = " + planIshrane.vratiPrimarniKljuc() + " AND rb = " + getRb();
	}

	@Override
	public String uslovZaVise() {
		return "s.planishraneId = " + planIshrane.vratiPrimarniKljuc();
	}

	@Override
	public String uslovZaBrisanjeVise() {
		return " planishraneId = " + planIshrane.vratiPrimarniKljuc();
	}

}
