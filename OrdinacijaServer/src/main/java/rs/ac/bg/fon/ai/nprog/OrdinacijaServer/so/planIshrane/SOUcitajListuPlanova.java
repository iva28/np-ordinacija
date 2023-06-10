package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 * Predstavlja specificnu operaciju za ucitavanje svih planova ishrana
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * ucitavanja svih planova ishrana.
 *
 * @author Iva Stanisic
 */
public class SOUcitajListuPlanova extends OpstaSO {
	/**
	 * Predstavlja listu planova ishrana
	 */
	private List<OpstaDomenskaKlasa> lista;

	/**
	 * Vraca listu svih planova ishrana
	 * 
	 * @return lista planova ishrana
	 */
	public List<OpstaDomenskaKlasa> vratiListu() {
		return lista;
	}

	@Override
	protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		lista = db.svi(obj);
		for (OpstaDomenskaKlasa o : lista) {
			PlanIshrane plan = (PlanIshrane) o;
			List<OpstaDomenskaKlasa> stavkeG = db.nadji(new StavkaPlanaIshrane(plan));
			List<StavkaPlanaIshrane> stavke = new ArrayList<>();
			for (OpstaDomenskaKlasa s : stavkeG) {
				StavkaPlanaIshrane stavka = (StavkaPlanaIshrane) s;
				stavke.add(stavka);
			}
			plan.setStavke(stavke);
		}
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
	public SOUcitajListuPlanova() {
		super();
	}

}
