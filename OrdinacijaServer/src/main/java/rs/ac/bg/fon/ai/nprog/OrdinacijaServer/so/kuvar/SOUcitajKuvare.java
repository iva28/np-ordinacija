package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.kuvar;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 * Predstavlja specificnu operaciju za ucitavanje svih kuvara
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * ucitavanja svih kuvara.
 *
 * @author Iva Stanisic
 */
public class SOUcitajKuvare extends OpstaSO {
	/**
	 * Predstavlja listu kuvara
	 */
	private List<OpstaDomenskaKlasa> lista;

	/**
	 * Vraca listu svih kuvara
	 * 
	 * @return lista kuvara
	 */
	public List<OpstaDomenskaKlasa> vratiListu() {
		return lista;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		lista = db.svi(obj);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (!(obj instanceof Kuvar))
			throw new Exception("Mora biti Kuvar!\n");
	}

	/**
	 * Default konstruktor
	 */
	public SOUcitajKuvare() {
		super();
		// TODO Auto-generated constructor stub
	}

}
