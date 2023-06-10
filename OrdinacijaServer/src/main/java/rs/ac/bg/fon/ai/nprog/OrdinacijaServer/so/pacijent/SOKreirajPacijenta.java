package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 * Predstavlja specificnu operaciju za kreiranje novog pacijenta
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * kreiranja pacijenta.
 *
 * @author Iva Stanisic
 */
public class SOKreirajPacijenta extends OpstaSO {
	/**
	 * Atribut koji predstavlja da li je uspesno kreiran pacijent
	 */
	private boolean uspeh;

	/**
	 * Vraca uspeh izvrsenja operacije kreiranja
	 * 
	 * @return true-uspeh, false inace
	 */
	public boolean isUspeh() {
		return uspeh;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		Long signal = db.dodaj(obj);
		if (signal > 0)
			uspeh = true;
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Pacijent)) {
			throw new Exception("Mora biti Pacijent!\n");
		}
	}

	/**
	 * Default konstruktor
	 */
	public SOKreirajPacijenta() {
		super();
		// TODO Auto-generated constructor stub
	}

}
