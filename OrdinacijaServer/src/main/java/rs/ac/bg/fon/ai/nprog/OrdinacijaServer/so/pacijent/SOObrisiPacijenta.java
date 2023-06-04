package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
/**
 *
 * @author Iva
 */
public class SOObrisiPacijenta extends OpstaSO{
     private boolean uspeh = false;

    public boolean isUspeh() {
        return uspeh;
    }
    
    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        uspeh = db.obrisi(obj);
    }

    @Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if(obj == null || !(obj instanceof Pacijent))
            throw new Exception("Mora biti Pacijent!\n");
    }

    
}
