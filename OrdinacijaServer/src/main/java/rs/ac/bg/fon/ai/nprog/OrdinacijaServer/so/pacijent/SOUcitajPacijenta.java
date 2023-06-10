package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 * Predstavlja specificnu operaciju za ucitavanje jednog pacijenta
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * ucitavanja jednog pacijenta.
 *
 * @author Iva Stanisic
 */
public class SOUcitajPacijenta extends OpstaSO {
	/**
	 * Pacijent koji se ucitava
	 */
	private Pacijent pacijent;

	/**
	 * Ucitani pacijent
	 * 
	 * @return pacijent koji je ucitan
	 */
	public Pacijent getPacijent() {
		return pacijent;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		pacijent = (Pacijent) db.vratiJednog(obj);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Pacijent))
			throw new Exception("Mora biti Pacijent!\n");
	}

	/**
	 * Default konstruktor
	 */
	public SOUcitajPacijenta() {
		super();
		// TODO Auto-generated constructor stub
	}

}
