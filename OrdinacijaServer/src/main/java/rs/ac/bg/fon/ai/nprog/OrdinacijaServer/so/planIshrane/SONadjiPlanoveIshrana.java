package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 * Predstavlja specificnu operaciju za pretragu planova ishrana
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * nalazenja planova ishrana.
 *
 * @author Iva Stanisic
 */
public class SONadjiPlanoveIshrana extends OpstaSO {
	/**
	 * Predstavlja listu nadjenih planova ishrana
	 */
    private List<OpstaDomenskaKlasa> lista;
    /**
	 * Vraca listu nadjenih planova ishrana
	 * 
	 * @return lista planova ishrana
	 */
    public List<OpstaDomenskaKlasa> vratiListu() {
        return lista;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
       lista = db.nadji(obj);
        for (OpstaDomenskaKlasa o : lista) {
            PlanIshrane plan = (PlanIshrane) o;
            List<OpstaDomenskaKlasa> stavkeG = db.nadji(new StavkaPlanaIshrane(plan));
            List<StavkaPlanaIshrane> stavke = new ArrayList<>();
            for (OpstaDomenskaKlasa s : stavkeG) {
                stavke.add((StavkaPlanaIshrane)s);
            }
            plan.setStavke(stavke);
        }
    }

    /**
     * Default konstruktor
     */
    public SONadjiPlanoveIshrana() {
		super();
	}

	@Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if (obj == null || !(obj instanceof PlanIshrane)) {
            throw new Exception("Mora biti Plan Ishrane!\n");
        }
    }

}
