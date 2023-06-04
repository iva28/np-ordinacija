package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 *
 * @author Iva
 */
public class SOUcitajPacijenta extends OpstaSO{
    private Pacijent pacijent;

    public Pacijent getPacijent() {
        return pacijent;
    }
    
    

    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        pacijent = (Pacijent) db.vratiJednog(obj);
    }

    @Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if (obj == null || !(obj instanceof Pacijent))
            throw new Exception("Mora biti Pacijent!\n");
    }
    
}
