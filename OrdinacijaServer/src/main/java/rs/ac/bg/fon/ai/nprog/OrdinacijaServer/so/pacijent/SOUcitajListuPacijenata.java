package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 * Predstavlja specificnu operaciju za ucitavanje svih pacijenata
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * ucitavanja svih pacijenata.
 *
 * @author Iva Stanisic
 */
public class SOUcitajListuPacijenata extends OpstaSO {
	/**
	 * Predstavlja listu pacijenata
	 */
	private List<OpstaDomenskaKlasa> lista;

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		lista = db.svi(obj);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Pacijent)) {
			throw new Exception("Mora biti Pacijent!\n");
		}
	}

	/**
	 * Vraca listu svih pacijenata
	 * 
	 * @return lista pacijenata
	 */
	public List<OpstaDomenskaKlasa> getLista() {
		return lista;
	}

}
