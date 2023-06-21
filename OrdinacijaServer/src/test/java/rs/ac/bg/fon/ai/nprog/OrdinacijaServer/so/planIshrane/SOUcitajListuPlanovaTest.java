package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.planIshrane;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

class SOUcitajListuPlanovaTest {

	SOUcitajListuPlanova ucitajPlanove;
	DBBroker broker;
	
	@BeforeEach
	void setUp() throws Exception {
		ucitajPlanove = new SOUcitajListuPlanova();
		broker = new DBBroker();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajPlanove = null;
		broker = null;
	}
	
	@Test
	void testizvrsiSpecificnuOperaciju() throws Exception {
//		List<OpstaDomenskaKlasa> planovi = broker.svi(new PlanIshrane());
//		assertNotNull(planovi);
//		System.out.println(planovi);
		ucitajPlanove.izvrsiOperaciju(new PlanIshrane());
		assertNotNull(ucitajPlanove.vratiListu());
		System.out.println("Ucitani planovi: "+ucitajPlanove.vratiListu());
		assertTrue(ucitajPlanove.vratiListu().size() > 0);
//		for (OpstaDomenskaKlasa p : ucitajPlanove.vratiListu()) {
//			assertNotNull(((PlanIshrane) p).getPlanIshraneId());
//			assertNotNull(((PlanIshrane) p).getDatum());
//			assertNotNull(((PlanIshrane) p).getCena());
//			assertNotNull(((PlanIshrane) p).getBrojDana());
//			assertNotNull(((PlanIshrane) p).getPacijent());
//			assertNotNull(((PlanIshrane) p).getNutricionista());
//			for (OpstaDomenskaKlasa st : ((PlanIshrane) p).getStavke()) {
//				assertNotNull(((StavkaPlanaIshrane) st).getRb());
//				assertNotNull(((StavkaPlanaIshrane) st).getCena());
//				assertNotNull(((StavkaPlanaIshrane) st).getKolicina());
//				assertNotNull(((StavkaPlanaIshrane) st).getJelo());
//				assertNotNull(((StavkaPlanaIshrane) st).getPlanIshrane());
//			}
//		}
	}
		
	@Test
	void testUcitajPacijentaNullObjekat() {
		assertThrows(Exception.class, () -> ucitajPlanove.izvrsiOperaciju(null));
	}
	
	@Test
	void testUcitajPacijentaLosaKlasa() {
		assertThrows(Exception.class, () -> ucitajPlanove.izvrsiOperaciju(new Kuvar()));
	}


}
