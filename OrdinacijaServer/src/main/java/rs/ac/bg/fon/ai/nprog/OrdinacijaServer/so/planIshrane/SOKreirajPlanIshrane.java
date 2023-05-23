package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 *
 * @author Iva
 */
public class SOKreirajPlanIshrane extends OpstaSO {

    private boolean uspeh = true;

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        Long id = db.dodaj(obj);
        if(id == -1) {
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

}
