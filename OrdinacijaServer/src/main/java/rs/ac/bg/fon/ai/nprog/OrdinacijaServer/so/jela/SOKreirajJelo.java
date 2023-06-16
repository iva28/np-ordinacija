package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;


import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 * Predstavlja specificnu operaciju za kreiranje novog jela
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * kreiranja jela.
 *
 * @author Iva Stanisic
 */
public class SOKreirajJelo extends OpstaSO {
	/**
	 * Atribut koji predstavlja da li je uspesno kreirano jelo
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
		if (signal > 0) {
			uspeh = true;
		}
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Jelo)) {
			throw new Exception("Mora biti Jelo!\n");
		}
	}

	/**
	 * Default konstruktor
	 */
	public SOKreirajJelo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
