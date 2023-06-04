package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 *
 * @author Iva
 */
public class SONadjiPlanoveIshrana extends OpstaSO {

    private List<OpstaDomenskaKlasa> lista;

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

    @Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if (obj == null || !(obj instanceof PlanIshrane)) {
            throw new Exception("Mora biti Plan Ishrane!\n");
        }
    }

}
