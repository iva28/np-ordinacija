package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 *
 * @author Iva
 */
public class SOKreirajPacijenta extends OpstaSO {

    private boolean uspeh;

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
          Long signal = db.dodaj(obj);
          if (signal >  0)
              uspeh = true;
    }


@Override
protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if (obj == null || !(obj instanceof Pacijent)) {
            throw new Exception("Mora biti Pacijent!\n");
        }
    }

}
