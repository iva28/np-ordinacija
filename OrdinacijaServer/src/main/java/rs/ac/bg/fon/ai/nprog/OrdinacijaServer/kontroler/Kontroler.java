package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.kontroler;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.kuvar.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;

/**
 * Predstavlja kontrolera koji upravlja sistemskim operacijama
 *
 * Implementira singleton obrazac
 * 
 * @author Iva Stanisic
 */
public class Kontroler {
	/**
	 * Privatno staticko polje koje cuva jedinstvenu instancu klase Kontroler
	 */
	private static Kontroler instanca;
	/**
	 * Polje koje cuva referencu na objekat OpstaSO koji se koristi za izvrsavanje
	 * operacija
	 */
	private OpstaSO operacija;

	/**
	 * Privatni konstruktor klase Kontroler koji onemogucava direktno instanciranje
	 * objekata klase
	 */
	private Kontroler() {
	}

	/**
	 * Vraca instancu klase Kontroler
	 * 
	 * Ako instanca ne postoji, kreira je i vraca
	 *
	 * @return Instanca klase Kontroler
	 */
	public static Kontroler vratiInstancu() {
		if (instanca == null) {
			instanca = new Kontroler();
		}
		return instanca;
	}

	/**
	 * Prijavljuje nutricionistu na sistem
	 *
	 * @param n Nutricionista koji se prijavljuje
	 * @return Prijavljeni nutricionista
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public Nutricionista prijaviSe(Nutricionista n) throws Exception {
		operacija = new SOPrijaviSe();
		operacija.izvrsiOperaciju(n);
		return ((SOPrijaviSe) operacija).vratiNutricionistu();
	}

	/**
	 * Ucitava listu pacijenata
	 * 
	 * @return Lista pacijenata
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> ucitajListuPacijenata() throws Exception {
		operacija = new SOUcitajListuPacijenata();
		operacija.izvrsiOperaciju(new Pacijent());
		return ((SOUcitajListuPacijenata) operacija).getLista();
	}

	/**
	 * Kreira pacijenta
	 * 
	 * @param pacijent Pacijent koji se kreira
	 * @return Vrednost boolean koja oznacava uspeh kreiranja pacijenta
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public boolean kreirajPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOKreirajPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOKreirajPacijenta) operacija).isUspeh();
	}

	/**
	 * Brise pacijenta
	 * 
	 * @param pacijent Pacijent koji se brise
	 * @return Vrednost boolean koja oznacava uspeh brisanja pacijenta
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public boolean obrisiPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOObrisiPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOObrisiPacijenta) operacija).isUspeh();
	}

	/**
	 * Menja pacijenta
	 *
	 * @param pacijent Pacijent koji se menja
	 * @return Vrednost boolean koja oznacava uspeh izmene pacijenta
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public boolean izmeniPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOIzmeniPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOIzmeniPacijenta) operacija).isUspeh();
	}

	/**
	 * Pretrazuje pacijente
	 * 
	 * @param pacijent Pacijent na osnovu kojeg se vrsi pretraga
	 * @return lista nadjenih pacijenata koji odgovaraju kriterijumu pretrage
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> nadjiPacijente(Pacijent pacijent) throws Exception {
		operacija = new SONadjiPacijente();
		operacija.izvrsiOperaciju(pacijent);
		return ((SONadjiPacijente) operacija).vratiListu();
	}

	/**
	 * Ucitava listu tipova jela
	 * 
	 * @return Lista tipova jela
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> ucitajTipoveJela() throws Exception {
		operacija = new SOUcitajTipoveJela();
		operacija.izvrsiOperaciju(new TipJela());
		return ((SOUcitajTipoveJela) operacija).vratiListu();
	}

	/**
	 * Ucitava listu kuvara
	 * 
	 * @return Lista kuvara
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> ucitajKuvare() throws Exception {
		operacija = new SOUcitajKuvare();
		operacija.izvrsiOperaciju(new Kuvar());
		return ((SOUcitajKuvare) operacija).vratiListu();
	}

	/**
	 * Kreira jelo
	 * 
	 * @param jelo Jelo koje se kreira
	 * @return Vrednost boolean koja oznacava uspeh kreiranja jela
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public boolean kreirajJelo(Jelo jelo) throws Exception {
		operacija = new SOKreirajJelo();
		operacija.izvrsiOperaciju(jelo);
		return ((SOKreirajJelo) operacija).isUspeh();
	}

	/**
	 * Ucitava listu jela
	 * 
	 * @return Lista jela
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> ucitajListuJela() throws Exception {
		operacija = new SOUcitajListuJela();
		operacija.izvrsiOperaciju(new Jelo());
		return ((SOUcitajListuJela) operacija).vratiListu();
	}

	/**
	 * Pretrazuje jela
	 * 
	 * @param jelo Jelo na osnovu kojeg se pretrazuje
	 * @return Lista jela koje odgovaraju kriterijumu pretrage
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> nadjiJela(Jelo jelo) throws Exception {
		operacija = new SONadjiJela();
		operacija.izvrsiOperaciju(jelo);
		return ((SONadjiJela) operacija).vratiListu();
	}

	/**
	 * Kreira plan ishrane
	 *
	 * @param plan Plan ishrane koji se kreira
	 * @return Vrednost boolean koja oznacava uspeh kreiranja plana ishrane
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public boolean kreirajPlanIshrane(PlanIshrane plan) throws Exception {
		operacija = new SOKreirajPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOKreirajPlanIshrane) operacija).isUspeh();
	}

	/**
	 * Ucitava listu planova ishrane
	 * 
	 * @return Lista planova ishrane
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> ucitajListuPlanova() throws Exception {
		operacija = new SOUcitajListuPlanova();
		operacija.izvrsiOperaciju(new PlanIshrane());
		return ((SOUcitajListuPlanova) operacija).vratiListu();
	}

	/**
	 * Pretrazuje planove ishrana
	 * 
	 * @param plan Plan ishrane na osnovu kojeg se vrsi pretraga
	 * @return Lista planova ishrana koji odgovaraju kriterijumu pretrage
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> nadjiPlanove(PlanIshrane plan) throws Exception {
		operacija = new SONadjiPlanoveIshrana();
		operacija.izvrsiOperaciju(plan);
		return ((SONadjiPlanoveIshrana) operacija).vratiListu();
	}

	/**
	 * Brise plan ishrane
	 * 
	 * @param plan Plan ishrane koji se brise
	 * @return Vrednost boolean koja oznacava uspeh brisanja plana ishrane
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public boolean obrisiPlan(PlanIshrane plan) throws Exception {
		operacija = new SOObrisiPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOObrisiPlanIshrane) operacija).isUspeh();
	}

	/**
	 * Menja plan ishrane
	 * 
	 * @param plan Plan ishrane koji se menja
	 * @return Vrednost boolean koja oznacava uspeh izmene plana ishrane
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public boolean izmeniPlanIshrane(PlanIshrane plan) throws Exception {
		operacija = new SOIzmeniPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOIzmeniPlanIshrane) operacija).isUspeh();
	}

	/**
	 * Ucitava listu nutricionista
	 *
	 * @return Lista nutricionista
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public List<OpstaDomenskaKlasa> ucitajListuNutricionista() throws Exception {
		operacija = new SOUcitajListuNutricionista();
		operacija.izvrsiOperaciju(new Nutricionista());
		return ((SOUcitajListuNutricionista) operacija).getLista();
	}

	/**
	 * Ucitava pacijenta
	 * 
	 * @param pacijent Pacijent ciji se podaci ucitavaju
	 * @return Objekat klase Pacijent
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public Pacijent ucitajPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOUcitajPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOUcitajPacijenta) operacija).getPacijent();
	}
	/**
	 * Ucitava plan ishrane
	 * 
	 * @param plan Plan ishrane ciji se podaci ucitavaju
	 * @return Objekat klase PlanIshrane koji predstavlja ucitane podatke
	 * @throws Exception ako se dogodi greska prilikom izvrsavanja operacije
	 */
	public PlanIshrane ucitajPlanIshrane(PlanIshrane plan) throws Exception {
		operacija = new SOUcitajPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOUcitajPlanIshrane) operacija).getPlanIshrane();
	}
}
