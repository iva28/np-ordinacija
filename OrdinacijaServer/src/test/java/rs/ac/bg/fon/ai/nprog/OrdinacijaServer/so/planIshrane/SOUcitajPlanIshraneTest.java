package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

class SOUcitajPlanIshraneTest {

	SOUcitajPlanIshrane ucitajPlan;
	SOUcitajListuPlanova sviPlanovi;

	@BeforeEach
	void setUp() throws Exception {
		ucitajPlan = new SOUcitajPlanIshrane();
		sviPlanovi = new SOUcitajListuPlanova();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajPlan = null;
		sviPlanovi = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuUcitajPlanIshrane() throws Exception {
		sviPlanovi.izvrsiSpecificnuOperaciju(new PlanIshrane());
		assertNotNull(sviPlanovi.vratiListu());
		System.out.println("Lista u ucitaj plan ishrane test:"+sviPlanovi.vratiListu());
		assertTrue(sviPlanovi.vratiListu().size() > 0);
		PlanIshrane plan = (PlanIshrane) sviPlanovi.vratiListu().get(0);
		assertNotNull(plan);
		ucitajPlan.izvrsiOperaciju(plan);
		assertNotNull(ucitajPlan.getPlanIshrane());
		assertEquals(plan.getPlanIshraneId(), ucitajPlan.getPlanIshrane().getPlanIshraneId());
		for (OpstaDomenskaKlasa st : ((PlanIshrane) ucitajPlan.getPlanIshrane()).getStavke()) {
			assertNotNull(((StavkaPlanaIshrane) st).getRb());
			assertNotNull(((StavkaPlanaIshrane) st).getCena());
			assertNotNull(((StavkaPlanaIshrane) st).getKolicina());
			assertNotNull(((StavkaPlanaIshrane) st).getJelo());
			assertNotNull(((StavkaPlanaIshrane) st).getPlanIshrane());
		}
	}

	@Test
	void testizvrsiSpecificnuOperacijuUcitajPlanIshraneNema() throws Exception {
		sviPlanovi.izvrsiOperaciju(new PlanIshrane());
		assertNotNull(sviPlanovi.vratiListu());
		assertTrue(sviPlanovi.vratiListu().size() > 0);
		int brojPlanova = sviPlanovi.vratiListu().size();
		Long maxId = ((PlanIshrane) sviPlanovi.vratiListu().get(brojPlanova - 1)).getPlanIshraneId();
		PlanIshrane plan = new PlanIshrane(maxId + 1);
		assertThrows(NullPointerException.class, () -> ucitajPlan.izvrsiOperaciju(plan));
	}

	@Test
	void testizvrsiSpecificnuOperacijuUcitajPlanIshraneNull() throws Exception {
		PlanIshrane plan = new PlanIshrane();
		assertThrows(NullPointerException.class, () -> ucitajPlan.izvrsiOperaciju(plan));
	}

	@Test
	void testUcitajPlanIshraneNullObjekat() {
		assertThrows(Exception.class, () -> ucitajPlan.izvrsiOperaciju(null));
	}

	@Test
	void testUcitajPlanIshraneLosaKlasa() {
		assertThrows(Exception.class, () -> ucitajPlan.izvrsiOperaciju(new Kuvar()));
	}

}
