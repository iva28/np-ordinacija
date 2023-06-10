package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 * Predstavlja specificnu operaciju za brisanje jednog plana ishrane
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * brisanja jednog plana ishrane.
 *
 * @author Iva Stanisic
 */
public class SOObrisiPlanIshrane extends OpstaSO {
	/**
	 * Predstavlja uspesnost brisanja plana ishrane
	 */
	private boolean uspeh = false;

	/**
	 * Vraca uspesnost brisanja plana ishrane
	 * 
	 * @return true - uspeh, false inace
	 */
	public boolean isUspeh() {
		return uspeh;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		db.obrisi(new StavkaPlanaIshrane((PlanIshrane) obj));
		uspeh = db.obrisi(obj);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof PlanIshrane)) {
			throw new Exception("Mora biti Plan Ishrane!\n");
		}
	}

	/**
	 * Default konstruktor
	 */
	public SOObrisiPlanIshrane() {
		super();
	}

}
