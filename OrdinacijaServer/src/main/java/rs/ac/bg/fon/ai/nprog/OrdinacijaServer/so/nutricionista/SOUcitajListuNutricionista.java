package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 * Predstavlja specificnu operaciju za ucitavanje svih nutricionista
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * ucitavanja svih nutricionista.
 *
 * @author Iva Stanisic
 */
public class SOUcitajListuNutricionista extends OpstaSO {
	/**
	 * Predstavlja listu nutricionista
	 */
	private List<OpstaDomenskaKlasa> lista;

	/**
	 * Vraca listu svih nutricionista
	 * 
	 * @return lista nutricionista
	 */
	public List<OpstaDomenskaKlasa> getLista() {
		return lista;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		lista = db.svi(obj);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Nutricionista)) {
			throw new Exception("Mora biti Nutricionista!\n");
		}
	}

	/**
	 * Default konstruktor
	 */
	public SOUcitajListuNutricionista() {
		super();
		// TODO Auto-generated constructor stub
	}

}
