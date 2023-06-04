package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 *
 * @author Iva
 */
public class SOKreirajJelo extends OpstaSO {

    private boolean uspeh;

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

}
