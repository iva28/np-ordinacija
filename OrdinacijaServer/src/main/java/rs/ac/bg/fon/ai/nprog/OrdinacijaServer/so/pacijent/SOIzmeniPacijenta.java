package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 * Predstavlja specificnu operaciju za izmenu jednog pacijenta
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije izmene
 * jednog pacijenta.
 *
 * @author Iva Stanisic
 */
public class SOIzmeniPacijenta extends OpstaSO {
	/**
	 * Predstavlja uspesnost izmene pacijenta
	 */
	private boolean uspeh = false;

	/**
	 * Vraca uspesnost izmene pacijenta
	 * 
	 * @return true - uspeh, false inace
	 */
	public boolean isUspeh() {
		return uspeh;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		uspeh = db.izmena(obj);
		if (uspeh == false)
			throw new Exception("Ne moze da se izmeni pacijent");
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Pacijent))
			throw new Exception("Mora biti Pacijent!\n");
	}

	/**
	 * Default konstruktor
	 */
	public SOIzmeniPacijenta() {
		super();
		// TODO Auto-generated constructor stub
	}

}
