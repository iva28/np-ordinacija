package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.OpstaSO;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.TipJela;

/**
 * Predstavlja specificnu operaciju za ucitavanje svih tipova jela
 * 
 * Nasledjuje apstraktnu klasu OpstaSO i implementira apstraktne metode iz te
 * klase. Ova klasa definise logiku za validaciju i izvrsavanje operacije
 * ucitavanja tipova jela.
 *
 * @author Iva Stanisic
 */
@SuppressWarnings("comment")
public class SOUcitajTipoveJela extends OpstaSO {
	/**
	 * Predstavlja listu tipova jela (vegeterijansko, sa mesom..)
	 */
	private List<OpstaDomenskaKlasa> lista;

	/**
	 * Vraca listu svih jela
	 * 
	 * @return lista tipova jela
	 */
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
	/**
	 * Default konstruktor
	 */
	public SOUcitajTipoveJela() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
