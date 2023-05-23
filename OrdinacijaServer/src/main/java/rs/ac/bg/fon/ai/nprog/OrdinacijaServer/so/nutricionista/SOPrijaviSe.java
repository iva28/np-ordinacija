package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 *
 * @author Iva
 */
public class SOPrijaviSe extends OpstaSO{
    
    private Nutricionista nutricionista;

    public Nutricionista vratiNutricionistu() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }
    
    
    @Override
    protected void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception {
        nutricionista  =  (Nutricionista) db.vratiJednog(obj);
    }

    @Override
    protected void validiraj(OpstaDomenskaKlasa obj) throws Exception {
        if(obj == null || !(obj instanceof Nutricionista))
            throw new Exception("Mora biti Nutricionista!\n");
    }

    
   
    
}
