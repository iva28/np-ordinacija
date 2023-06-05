package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 * Predstavlja specificnu operaciju za pretragu pacijenata
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * nalazenja pacijenata.
 *
 * @author Iva Stanisic
 */
public class SONadjiPacijente extends OpstaSO {

	/**
	 * Predstavlja listu nadjenih pacijenata
	 */
	private List<OpstaDomenskaKlasa> lista;

	/**
	 * Vraca listu nadjenih pacijenata
	 * 
	 * @return lista pacijenata
	 */
	public List<OpstaDomenskaKlasa> vratiListu() {
		return lista;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		lista = db.nadji(obj);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Pacijent))
			throw new Exception("Mora biti Pacijent!\n");
	}

}
