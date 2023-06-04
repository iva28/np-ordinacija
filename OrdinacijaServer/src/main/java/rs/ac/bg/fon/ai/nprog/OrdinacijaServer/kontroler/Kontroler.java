package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.kontroler;

import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.kuvar.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;

/*
 *
 * @author Iva
 */
public class Kontroler {

	private static Kontroler instanca;
	private OpstaSO operacija;

	private Kontroler() {
	}

	public static Kontroler vratiInstancu() {
		if (instanca == null) {
			instanca = new Kontroler();
		}
		return instanca;
	}

	public Nutricionista prijaviSe(Nutricionista n) throws Exception {
		operacija = new SOPrijaviSe();
		operacija.izvrsiOperaciju(n);
		return ((SOPrijaviSe) operacija).vratiNutricionistu();
	}

	public List<OpstaDomenskaKlasa> ucitajListuPacijenata() throws Exception {
		operacija = new SOUcitajListuPacijenata();
		operacija.izvrsiOperaciju(new Pacijent());
		return ((SOUcitajListuPacijenata) operacija).getLista();
	}

	public boolean kreirajPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOKreirajPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOKreirajPacijenta) operacija).isUspeh();
	}

	public boolean obrisiPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOObrisiPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOObrisiPacijenta) operacija).isUspeh();
	}

	public boolean izmeniPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOIzmeniPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOIzmeniPacijenta) operacija).isUspeh();
	}

	public List<OpstaDomenskaKlasa> nadjiPacijente(Pacijent pacijent) throws Exception {
		operacija = new SONadjiPacijente();
		operacija.izvrsiOperaciju(pacijent);
		return ((SONadjiPacijente) operacija).vratiListu();
	}

	public List<OpstaDomenskaKlasa> ucitajTipoveJela() throws Exception {
		operacija = new SOUcitajTipoveJela();
		operacija.izvrsiOperaciju(new TipJela());
		return ((SOUcitajTipoveJela) operacija).vratiListu();
	}

	public List<OpstaDomenskaKlasa> ucitajKuvare() throws Exception {
		operacija = new SOUcitajKuvare();
		operacija.izvrsiOperaciju(new Kuvar());
		return ((SOUcitajKuvare) operacija).vratiListu();
	}

	public boolean kreirajJelo(Jelo jelo) throws Exception {
		operacija = new SOKreirajJelo();
		operacija.izvrsiOperaciju(jelo);
		return ((SOKreirajJelo) operacija).isUspeh();
	}

	public List<OpstaDomenskaKlasa> ucitajListuJela() throws Exception {
		operacija = new SOUcitajListuJela();
		operacija.izvrsiOperaciju(new Jelo());
		return ((SOUcitajListuJela) operacija).vratiListu();
	}

	public List<OpstaDomenskaKlasa> nadjiJela(Jelo jelo) throws Exception {
		operacija = new SONadjiJela();
		operacija.izvrsiOperaciju(jelo);
		return ((SONadjiJela) operacija).vratiListu();
	}

	public boolean kreirajPlanIshrane(PlanIshrane plan) throws Exception {
		operacija = new SOKreirajPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOKreirajPlanIshrane) operacija).isUspeh();
	}

	public List<OpstaDomenskaKlasa> ucitajListuPlanova() throws Exception {
		operacija = new SOUcitajListuPlanova();
		operacija.izvrsiOperaciju(new PlanIshrane());
		return ((SOUcitajListuPlanova) operacija).vratiListu();
	}

	public List<OpstaDomenskaKlasa> nadjiPlanove(PlanIshrane plan) throws Exception {
		operacija = new SONadjiPlanoveIshrana();
		operacija.izvrsiOperaciju(plan);
		return ((SONadjiPlanoveIshrana) operacija).vratiListu();
	}

	public boolean obrisiPlan(PlanIshrane plan) throws Exception {
		operacija = new SOObrisiPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOObrisiPlanIshrane) operacija).isUspeh();
	}

	public boolean izmeniPlanIshrane(PlanIshrane plan) throws Exception {
		operacija = new SOIzmeniPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOIzmeniPlanIshrane) operacija).isUspeh();
	}

	public List<OpstaDomenskaKlasa> ucitajListuNutricionista() throws Exception {
		operacija = new SOUcitajListuNutricionista();
		operacija.izvrsiOperaciju(new Nutricionista());
		return ((SOUcitajListuNutricionista) operacija).getLista();
	}

	public Pacijent ucitajPacijenta(Pacijent pacijent) throws Exception {
		operacija = new SOUcitajPacijenta();
		operacija.izvrsiOperaciju(pacijent);
		return ((SOUcitajPacijenta) operacija).getPacijent();
	}

	public PlanIshrane ucitajPlanIshrane(PlanIshrane plan) throws Exception {
		operacija = new SOUcitajPlanIshrane();
		operacija.izvrsiOperaciju(plan);
		return ((SOUcitajPlanIshrane) operacija).getPlanIshrane();
	}
}
