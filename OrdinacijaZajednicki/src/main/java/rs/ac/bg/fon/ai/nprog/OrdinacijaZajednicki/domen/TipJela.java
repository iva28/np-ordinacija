package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja moguce tipove jela
 * 
 * Mogu biti veganska, vegeterijanska, sa mesom i bez glutena
 * 
 * @author Iva Stanisic
 *
 */
public class TipJela extends OpstaDomenskaKlasa {
	/**
	 * Id tipa kao Long
	 */
	private Long tipId;
	/**
	 * Naziv vrste jela kao String
	 */
	private String vrsta;

	/**
	 * Konstruise novu instancu klase i postavlja atribute na prosledjene vrednosti
	 * 
	 * @param tipId ID tipa jela
	 * @param vrsta vrsta tipa jela
	 */
	public TipJela(Long tipId, String vrsta) {
		this.tipId = tipId;
		this.vrsta = vrsta;
	}

	/**
	 * Konstruise novu instancu klase i postavlja atribute na default vrednosti
	 */
	public TipJela() {
	}

	/**
	 * Vraca ID tipa jela
	 * 
	 * @return ID tipa jela
	 */
	public Long getTipId() {
		return tipId;
	}

	/**
	 * Vraca vrstu tj. tip jela
	 * 
	 * @return vrsta jela
	 */
	public String getVrsta() {
		return vrsta;
	}

	/**
	 * Postavlja ID tipa jela
	 * 
	 * @param tipId tip jela ID
	 */
	public void setTipId(Long tipId) {
		if (tipId == null)
			throw new NullPointerException("Ne moze id biti null");
		if (tipId < 0)
			throw new IllegalArgumentException("ID Ne sme biti manji od 0");
		this.tipId = tipId;
	}

	/**
	 * Postavlja vrstu tj. tip jela
	 * 
	 * @param vrsta jela
	 */
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	/**
	 * Vraca String vrednost sa svim atributima objekta
	 * 
	 * @return String sa svim vrednostima atrinuta domenskog objekta
	 */
	@Override
	public String toString() {
		return vrsta;
	}
/**
 * Racuna hash code na osnovu tipId
 * 
 * @return hash code na osnovu tipId
 */
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + Objects.hashCode(this.tipId);
		return hash;
	}
/**
 * Poredi dva tipa jela
 * 
 * @param obj drugi tip jela - sa kojim se poredi
 * @return true ako imaju isti tipId, false u suprotnom
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
		final TipJela other = (TipJela) obj;
		return Objects.equals(this.tipId, other.tipId);
	}

	@Override
	public String imeTabele() {
		return "tipjela";
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
		return "tipId";
	}

	@Override
	public Long vratiPrimarniKljuc() {
		return tipId;
	}

	@Override
	public List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs) {
		List<OpstaDomenskaKlasa> jela = new ArrayList<>();
		try {
			while (rs.next()) {
				Long tipIdBaza = rs.getLong("tipId");
				String vrstaBaza = rs.getString("vrsta");
				jela.add(new TipJela(tipIdBaza, vrstaBaza));
			}
		} catch (SQLException ex) {
			System.err.println("Greška u konvertovanju u ResultSet-u u Tip Jelo klasi! " + ex.getMessage());
		}
		return jela;
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
