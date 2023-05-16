package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import java.sql.ResultSet;
import java.util.List;

/**
 * 
 * @author DELL
 *
 */
public abstract class OpstaDomenskaKlasa {

	public abstract String imeTabele();
    public abstract String vratiParametre();
    public abstract String vratiNaziveParametara();
    public abstract String vratiNazivPrimarnogKljuca();
    public abstract Long vratiPrimarniKljuc();
    public abstract List<OpstaDomenskaKlasa> konvertujUListu(ResultSet rs);
    public abstract String uslovZaIzmenu();
    public abstract String uslovZaJednog();
    public abstract String uslovZaVise();
    public abstract  String spajanje();
    public abstract  String vratiSlozenPrimarniKljuc();
    public abstract String uslovZaBrisanjeVise(); 
}
