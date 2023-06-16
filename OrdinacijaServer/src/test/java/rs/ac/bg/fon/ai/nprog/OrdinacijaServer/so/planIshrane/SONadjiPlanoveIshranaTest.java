package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.IRepozitorijum;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

class SONadjiPlanoveIshranaTest {

	SONadjiPlanoveIshrana nadjeniPlanovi;
	SOUcitajListuPlanova sviPlanovi;
	IRepozitorijum<OpstaDomenskaKlasa> repozitorijum;

	@BeforeEach
	void setUp() throws Exception {
		nadjeniPlanovi = new SONadjiPlanoveIshrana();
		sviPlanovi = new SOUcitajListuPlanova();
		repozitorijum = new DBBroker();
	}

	@AfterEach
	void tearDown() throws Exception {
		nadjeniPlanovi = new SONadjiPlanoveIshrana();
	}

	@Test
	void testizvrsiSpecificnuOperaciju() throws Exception {
		sviPlanovi.izvrsiOperaciju(new PlanIshrane());
		assertNotNull(sviPlanovi.vratiListu());
		assertTrue(sviPlanovi.vratiListu().size() > 0);
		PlanIshrane plan = (PlanIshrane) sviPlanovi.vratiListu().get(0);
		assertNotNull(plan);
		nadjeniPlanovi.izvrsiOperaciju(plan);
		assertNotNull(nadjeniPlanovi.vratiListu());
		System.out.println(nadjeniPlanovi.vratiListu());
		for (OpstaDomenskaKlasa o : nadjeniPlanovi.vratiListu()) {
			List<OpstaDomenskaKlasa> stavke = repozitorijum.nadji(new StavkaPlanaIshrane((PlanIshrane) o));
			assertNotNull(stavke);
			for (OpstaDomenskaKlasa st : stavke) {
				assertNotNull(((StavkaPlanaIshrane) st).getRb());
				assertNotNull(((StavkaPlanaIshrane) st).getCena());
				assertNotNull(((StavkaPlanaIshrane) st).getKolicina());
				assertNotNull(((StavkaPlanaIshrane) st).getJelo());
				assertNotNull(((StavkaPlanaIshrane) st).getPlanIshrane());
			}
		}
	}

	@Test
	void testNadjiPlanNullObjekat() {
		assertThrows(Exception.class, () -> nadjeniPlanovi.izvrsiOperaciju(null));
	}

	@Test
	void testNadjiPlanoveLosaKlasa() {
		assertThrows(Exception.class, () -> nadjeniPlanovi.izvrsiOperaciju(new Kuvar()));
	}

}
