package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 * Predstavlja specificnu operaciju za ucitavanje jednog plana ishrane
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * ucitavanja jednog plana ishrane.
 *
 * @author Iva Stanisic
 */
public class SOUcitajPlanIshrane extends OpstaSO {
	/**
	 * Plan ishrane koji se ucitava
	 */
	private PlanIshrane planIshrane;

	/**
	 * Ucitani plan ishrane
	 * 
	 * @return plan ishrane koji je ucitan
	 */
	public PlanIshrane getPlanIshrane() {
		return planIshrane;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		planIshrane = (PlanIshrane) db.vratiJednog(obj);
		List<OpstaDomenskaKlasa> stavke_baza = db.nadji(new StavkaPlanaIshrane(planIshrane));
		List<StavkaPlanaIshrane> stavke = new ArrayList<>();
		for (OpstaDomenskaKlasa s : stavke_baza) {
			StavkaPlanaIshrane stavka = (StavkaPlanaIshrane) s;
			stavke.add(stavka);
		}
		planIshrane.setStavke(stavke);
	}

	@Override
	protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
		if (obj == null || !(obj instanceof PlanIshrane))
			throw new Exception("Mora biti Plan Ishrane!\n");
	}

	/**
	 * Default konstruktor
	 */
	public SOUcitajPlanIshrane() {
		super();
	}

}
