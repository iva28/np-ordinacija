package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela.SOUcitajListuJela;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista.SOUcitajListuNutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent.SOUcitajListuPacijenata;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

class SOIzmeniPlanIshraneTest {

	SOIzmeniPlanIshrane izmeniPlan;
	SOUcitajPlanIshrane ucitajPlan;
	SOUcitajListuPlanova sviPlanovi;
	SOKreirajPlanIshrane kreirajNovi;
	SOObrisiPlanIshrane obrisiPlan;
	SOUcitajListuPacijenata ucitajPacijente;
	SOUcitajListuNutricionista ucitajNutricioniste;
	SOUcitajListuJela ucitajJela;

	@BeforeEach
	void setUp() throws Exception {
		izmeniPlan = new SOIzmeniPlanIshrane();
		ucitajPlan = new SOUcitajPlanIshrane();
		sviPlanovi = new SOUcitajListuPlanova();
		kreirajNovi = new SOKreirajPlanIshrane();
		obrisiPlan = new SOObrisiPlanIshrane();
		ucitajPacijente = new SOUcitajListuPacijenata();
		ucitajNutricioniste = new SOUcitajListuNutricionista();
		ucitajJela = new SOUcitajListuJela();
	}

	@AfterEach
	void tearDown() throws Exception {
		izmeniPlan = null;
		ucitajPlan = null;
		sviPlanovi = null;
		obrisiPlan = null;
		kreirajNovi = null;
		ucitajPacijente = null;
		ucitajNutricioniste = null;
		ucitajJela = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuIzmeniPlanIshrane() throws Exception {
		ucitajPacijente.izvrsiOperaciju(new Pacijent());
		assertNotNull(ucitajPacijente.getLista());
		assertTrue(ucitajPacijente.getLista().size() > 0);
		ucitajNutricioniste.izvrsiOperaciju(new Nutricionista());
		assertNotNull(ucitajNutricioniste.getLista());
		assertTrue(ucitajNutricioniste.getLista().size() > 0);
		ucitajJela.izvrsiOperaciju(new Jelo());
		assertNotNull(ucitajJela.vratiListu());
		assertTrue(ucitajJela.vratiListu().size() > 1);
		PlanIshrane plan = new PlanIshrane();
		plan.setBrojDana(10);
		plan.setDatum(Calendar.getInstance().getTime());
		plan.setNutricionista((Nutricionista) ucitajNutricioniste.getLista().get(0));
		plan.setPacijent((Pacijent) ucitajPacijente.getLista().get(0));
		StavkaPlanaIshrane st1 = new StavkaPlanaIshrane();
		st1.setJelo((Jelo) ucitajJela.vratiListu().get(0));
		st1.setKolicina(33);
		st1.setPlanIshrane(plan);
		st1.setCena(new BigDecimal(200));

		StavkaPlanaIshrane st2 = new StavkaPlanaIshrane();
		st2.setJelo((Jelo) ucitajJela.vratiListu().get(1));
		st2.setKolicina(12);
		st2.setPlanIshrane(plan);
		st2.setCena(new BigDecimal(400));
		List<StavkaPlanaIshrane> stavke = new ArrayList<>();
		stavke.add(st1);
		stavke.add(st2);
		plan.setStavke(stavke);
		plan.setCena(new BigDecimal(1000));

		sviPlanovi.izvrsiOperaciju(new PlanIshrane());
		assertNotNull(sviPlanovi.vratiListu());
		for (OpstaDomenskaKlasa p : sviPlanovi.vratiListu()) {
			assertFalse(plan.equals((PlanIshrane) p));
		}

		kreirajNovi.izvrsiOperaciju(plan);
		assertTrue(kreirajNovi.isUspeh());
		sviPlanovi.izvrsiOperaciju(new PlanIshrane());
		assertNotNull(sviPlanovi.vratiListu());
		assertTrue(sviPlanovi.vratiListu().size() > 0);
		int poslednji = sviPlanovi.vratiListu().size() - 1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		assertEquals(sdf.format(plan.getDatum()),
				sdf.format(((PlanIshrane) sviPlanovi.vratiListu().get(poslednji)).getDatum()));
		assertEquals(plan.getNutricionista(),
				((PlanIshrane) sviPlanovi.vratiListu().get(poslednji)).getNutricionista());
		assertEquals(plan.getPacijent(), ((PlanIshrane) sviPlanovi.vratiListu().get(poslednji)).getPacijent());
		assertEquals(plan.getCena(), ((PlanIshrane) sviPlanovi.vratiListu().get(poslednji)).getCena());
		plan = (PlanIshrane)sviPlanovi.vratiListu().get(poslednji);
		plan.setBrojDana(Integer.MAX_VALUE);
		izmeniPlan.izvrsiOperaciju(plan);
		assertTrue(izmeniPlan.isUspeh());
		obrisiPlan.izvrsiOperaciju(plan);
		assertTrue(obrisiPlan.isUspeh());
	}

	@Test
	@DisplayName("Menjanje plana ishrane koji ne postoji")
	void testizvrsiSpecificnuOperacijuIzmeniPlanIshraneNema() throws Exception {
		sviPlanovi.izvrsiOperaciju(new PlanIshrane());
		assertNotNull(sviPlanovi.vratiListu());
		assertTrue(sviPlanovi.vratiListu().size() > 0);
		int brojPlanova = sviPlanovi.vratiListu().size();
		Long poslednjiId = ((PlanIshrane)sviPlanovi.vratiListu().get(brojPlanova-1)).getPlanIshraneId();
		assertThrows(Exception.class, ()->izmeniPlan.izvrsiOperaciju(new PlanIshrane(poslednjiId+1)));
	}
	
	@Test
	void testIzmeniPlanIshraneNullObjekat() {
		assertThrows(Exception.class, () -> izmeniPlan.izvrsiOperaciju(null));
	}

	@Test
	void testIzmeniPlanIshraneLosaKlasa() {
		assertThrows(Exception.class, () -> izmeniPlan.izvrsiOperaciju(new Kuvar()));
	}
}
