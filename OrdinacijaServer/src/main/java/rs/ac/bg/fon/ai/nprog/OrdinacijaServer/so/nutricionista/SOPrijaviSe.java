package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 * Predstavlja specificnu operaciju za prijavu nutricioniste
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * prijave nutricioniste.
 *
 * @author Iva Stanisic
 */
public class SOPrijaviSe extends OpstaSO {
	/**
	 * Nutricionista koji se prijavljuje
	 */
	private Nutricionista nutricionista;

	/**
	 * Vraca prijavljenog nutricionistu
	 * 
	 * @return nutricionista
	 */
	public Nutricionista vratiNutricionistu() {
		return nutricionista;
	}

	/**
	 * Postavlja prijavljenog nutricionistu
	 * @param nutricionista
	 */
	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		nutricionista = (Nutricionista) db.vratiJednog(obj);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof Nutricionista))
			throw new Exception("Mora biti Nutricionista!\n");
	}

}
