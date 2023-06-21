package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela.SOUcitajListuJela;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista.SOUcitajListuNutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent.SOUcitajListuPacijenata;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

class SOObrisiPlanIshraneTest {

	SOKreirajPlanIshrane kreirajPlan;
	SOObrisiPlanIshrane obrisiPlan;
	SOUcitajListuPacijenata ucitajPacijente;
	SOUcitajListuNutricionista ucitajNutricioniste;
	SOUcitajListuJela ucitajJela;
	SOUcitajListuPlanova ucitajPlan;
	
	@BeforeEach
	void setUp() throws Exception {
		kreirajPlan = new SOKreirajPlanIshrane();
		obrisiPlan = new SOObrisiPlanIshrane();
		ucitajPlan = new SOUcitajListuPlanova();
		ucitajPacijente = new SOUcitajListuPacijenata();
		ucitajNutricioniste = new SOUcitajListuNutricionista();
		ucitajJela = new SOUcitajListuJela();
	}

	@AfterEach
	void tearDown() throws Exception {
		kreirajPlan = null;
		obrisiPlan = null;
		ucitajPlan = null;
		ucitajPacijente = null;
		ucitajNutricioniste = null;
		ucitajJela = null;
	}
//
//	@Test
//	void testizvrsiSpecificnuOperaciju() throws Exception {
//		ucitajPacijente.izvrsiOperaciju(new Pacijent());
//		assertNotNull(ucitajPacijente.getLista());
//		assertTrue(ucitajPacijente.getLista().size() > 0);
//		ucitajNutricioniste.izvrsiOperaciju(new Nutricionista());
//		assertNotNull(ucitajNutricioniste.getLista());
//		assertTrue(ucitajNutricioniste.getLista().size() > 0);
//		PlanIshrane plan = new PlanIshrane();
//		plan.setBrojDana(10);
//		plan.setDatum(Calendar.getInstance().getTime());
//		System.out.println(plan.getDatum());
//		plan.setNutricionista((Nutricionista) ucitajNutricioniste.getLista().get(0));
//		plan.setPacijent((Pacijent) ucitajPacijente.getLista().get(0));
//
//		ucitajJela.izvrsiOperaciju(new Jelo());
//		assertNotNull(ucitajJela.vratiListu());
//		assertTrue(ucitajJela.vratiListu().size() > 1);
//		StavkaPlanaIshrane st1 = new StavkaPlanaIshrane();
//		st1.setJelo((Jelo) ucitajJela.vratiListu().get(0));
//		st1.setKolicina(33);
//		st1.setPlanIshrane(plan);
//		st1.setCena(new BigDecimal(200));
//
//		StavkaPlanaIshrane st2 = new StavkaPlanaIshrane();
//		st2.setJelo((Jelo) ucitajJela.vratiListu().get(1));
//		st2.setKolicina(12);
//		st2.setPlanIshrane(plan);
//		st2.setCena(new BigDecimal(400));
//
//		List<StavkaPlanaIshrane> stavke = new ArrayList<>();
//		stavke.add(st1);
//		stavke.add(st2);
//		plan.setStavke(stavke);
//		plan.setCena(new BigDecimal(1000));
//		kreirajPlan.izvrsiOperaciju(plan);
//		assertTrue(kreirajPlan.isUspeh());
//		ucitajPlan.izvrsiOperaciju(new PlanIshrane());
//		assertNotNull(ucitajPlan.vratiListu());
//		assertTrue(ucitajPlan.vratiListu().size() > 0);
//		int poslednji = ucitajPlan.vratiListu().size() - 1;
//		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//		assertEquals(sdf.format(plan.getDatum()),sdf.format(((PlanIshrane)ucitajPlan.vratiListu().get(poslednji)).getDatum()));
//		assertEquals(plan.getNutricionista(), ((PlanIshrane)ucitajPlan.vratiListu().get(poslednji)).getNutricionista());
//		assertEquals(plan.getPacijent(), ((PlanIshrane)ucitajPlan.vratiListu().get(poslednji)).getPacijent());
//		assertEquals(plan.getCena(), ((PlanIshrane)ucitajPlan.vratiListu().get(poslednji)).getCena());
//		obrisiPlan.izvrsiOperaciju(ucitajPlan.vratiListu().get(poslednji));
//		assertTrue(obrisiPlan.isUspeh());
//	}
//	
//	@Test
//	void testizvrsiSpecificnuOperacijuNemaPlanaZaBrisanje() throws Exception {
//		ucitajPlan.izvrsiOperaciju(new PlanIshrane());
//		assertNotNull(ucitajPlan.vratiListu());
//		assertTrue(ucitajPlan.vratiListu().size() > 0);
//		int brojPlanova = ucitajPlan.vratiListu().size();
//		Long max_id = ((PlanIshrane)ucitajPlan.vratiListu().get(brojPlanova - 1)).getPlanIshraneId();
//		obrisiPlan.izvrsiOperaciju(new PlanIshrane(max_id+1));
//		assertEquals(false, obrisiPlan.isUspeh());
//	}

	@Test
	void testObrisiPlanIshraneNullObjekat() {
		assertThrows(Exception.class, () -> kreirajPlan.izvrsiOperaciju(null));
	}

	@Test
	void testObrisiPlanIshraneLosaKlasa() {
		assertThrows(Exception.class, () -> kreirajPlan.izvrsiOperaciju(new Kuvar()));
	}

}
