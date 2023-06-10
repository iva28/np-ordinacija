package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.KonekcijaSaBazom;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

/**
 * Predstavlja osnovnu implementaciju operacija nad domenskim klasama
 * 
 * Definiše okvir za izvrsavanje operacija sa bazom podataka.
 * 
 * @author Iva Stanisic
 */
public abstract class OpstaSO {
	/**
	 * Objekat klase DBBroker koji se koristi za pristup bazi podataka
	 * 
	 * Ovaj objekat omogucava izvrsavanje SQL upita i manipulaciju nad podacima
	 */
	protected DBBroker db = new DBBroker();

	/**
	 * Izvrsava operaciju nad objektom domenske klase
	 * 
	 * Validira objekat, otvara konekciju sa bazom podataka, izvrsava specificnu
	 * operaciju, potvrdjuje transakciju, ili ponistava transakciju u slucaju
	 * greske. Na kraju zatvara konekciju sa bazom podataka.
	 *
	 * @param obj Objekat domenske klase nad kojim se vrsi operacija
	 * @throws Exception U slucaju da dodje do greske prilikom izvrsavanja operacije
	 */
	public final void izvrsiOperaciju(OpstaDomenskaKlasa obj) throws Exception {
		try {
			validiraj(obj);
			KonekcijaSaBazom.getInstanca().otvoriKonekciju();
			izvrsiSpecificnuOperaciju(obj);
			KonekcijaSaBazom.getInstanca().potvrdiTransakciju();
		} catch (Exception e) {
			KonekcijaSaBazom.getInstanca().ponistiTransakciju();
		} finally {
			KonekcijaSaBazom.getInstanca().zatvoriKonekciju();
		}
	}

	/**
	 * Apstraktna metoda koja predstavlja specificnu operaciju koja se izvrsava nad
	 * objektom domenske klase
	 *
	 * @param obj Objekat domenske klase nad kojim se vrsi operacija
	 * @throws Exception U slucaju da dodje do greske prilikom izvrsavanja operacije
	 */
	protected abstract void izvrsiSpecificnuOperaciju(OpstaDomenskaKlasa obj) throws Exception;

	/**
	 * Apstraktna metoda koja vrsi validaciju objekta domenske klase pre izvrsavanja
	 * operacije
	 *
	 * @param obj Objekat domenske klase koji se validira
	 * @throws Exception U slucaju da dodje do greske prilikom izvrsavanja operacije
	 */
	protected abstract void validiraj(OpstaDomenskaKlasa obj) throws Exception;

	/**
	 * Default konstruktor
	 */
	public OpstaSO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
