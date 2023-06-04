package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
/**
 *
 * @author Iva
 */
public class SOUcitajListuNutricionista extends OpstaSO {

    private List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> getLista() {
        return lista;
    }
    
    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        lista = db.svi(obj);
    }

    @Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if (obj == null || !(obj instanceof Nutricionista)) {
            throw new Exception("Mora biti Nutricionista!\n");
        }
    }

}
