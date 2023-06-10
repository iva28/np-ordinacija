package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 * Predstavlja specificnu operaciju za kreiranje novog plana ishrane
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * kreiranja plana ishrane.
 *
 * @author Iva Stanisic
 */
public class SOKreirajPlanIshrane extends OpstaSO {
	/**
	 * Atribut koji predstavlja da li je uspesno kreiran plan ishrane
	 */
	private boolean uspeh = true;

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
		Long id = db.dodaj(obj);
		if (id == -1) {
			uspeh = false;
			System.err.println("Ne može da se kreira plan");
			return;
		}
		for (StavkaPlanaIshrane s : ((PlanIshrane) obj).getStavke()) {
			s.setPlanIshrane(new PlanIshrane(id));
			db.dodaj(s);
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
	public SOKreirajPlanIshrane() {

	}

}
