package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 * Predstavlja specificnu operaciju za pretragu jela
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * nalazenja jela.
 *
 * @author Iva Stanisic
 */
public class SONadjiJela extends OpstaSO {

	/**
	 * Predstavlja listu nadjenih jela
	 */
	private List<OpstaDomenskaKlasa> lista;

	/**
	 * Vraca listu nadjenih jela
	 * 
	 * @return lista jela
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
		if (obj == null || !(obj instanceof Jelo))
			throw new Exception("Mora biti Jelo!\n");
	}

	/**
	 * Default konstruktor
	 */
	public SONadjiJela() {
		super();
		// TODO Auto-generated constructor stub
	}

}
