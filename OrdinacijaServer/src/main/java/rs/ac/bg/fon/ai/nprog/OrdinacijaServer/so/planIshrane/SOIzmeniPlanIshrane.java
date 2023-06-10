package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 * Predstavlja specificnu operaciju za izmenu jednog plana ishrane
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije izmene
 * jednog plana ishrane.
 *
 * @author Iva Stanisic
 */
public class SOIzmeniPlanIshrane extends OpstaSO {
	/**
	 * Predstavlja uspesnost izmene plana ishrane
	 */
	private boolean uspeh = false;

	/**
	 * Vraca uspesnost izmene plana ishrane
	 * 
	 * @return true - uspeh, false inace
	 */
	public boolean isUspeh() {
		return uspeh;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		db.obrisi(new StavkaPlanaIshrane((PlanIshrane) obj));
		if (((PlanIshrane) obj).getStavke().isEmpty()) {
			uspeh = db.obrisi(obj);
		} else {
			uspeh = db.izmena(obj);
			for (StavkaPlanaIshrane s : ((PlanIshrane) obj).getStavke()) {
				s.setPlanIshrane((PlanIshrane) obj);
				db.dodaj(s);
			}
		}

	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof PlanIshrane)) {
			throw new Exception("Mora biti Plan ishrane!\n");
		}
	}

	/**
	 * Default konstruktor
	 */
	public SOIzmeniPlanIshrane() {
	}

}
