package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.TipJela;

/**
 *
 * @author Iva
 */
public class SOUcitajTipoveJela extends OpstaSO{
     private List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> vratiListu() {
        return lista;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        lista = db.svi(obj);
    }

    @Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
         if (obj == null || !(obj instanceof TipJela))
            throw new Exception("Mora biti TipJela!\n");
    }
    
}
