package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

/**
 *
 * @author Iva
 */
public class SONadjiPacijente extends OpstaSO{

     private List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> vratiListu() {
        return lista;
    }
    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        lista = db.nadji(obj);
    }

    @Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if (obj == null || !(obj instanceof Pacijent))
            throw new Exception("Mora biti Pacijent!\n");
    }
    
}
