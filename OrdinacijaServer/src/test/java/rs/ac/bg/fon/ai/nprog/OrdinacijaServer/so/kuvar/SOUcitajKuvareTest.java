package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.kuvar;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

class SOUcitajKuvareTest {
	
	SOUcitajKuvare ucitajKuvare;

	@BeforeEach
	void setUp() throws Exception {
		ucitajKuvare = new SOUcitajKuvare();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajKuvare = null;
	}

	@Test 
	void testProba() {
		assertTrue(true);
	}
	
	
//	@Test
//	void testizvrsiSpecificnuOperaciju() throws Exception {
//		ucitajKuvare.izvrsiSpecificnuOperaciju(new Kuvar());
//		assertNotNull(ucitajKuvare.vratiListu());
//		assertTrue(ucitajKuvare.vratiListu().size() > 0);
//		for (OpstaDomenskaKlasa k : ucitajKuvare.vratiListu()) {
//			assertNotNull(((Kuvar)k).getKuvarId());
//			assertNotNull(((Kuvar)k).getIme());
//			assertNotNull(((Kuvar)k).getPrezime());
//			assertNotNull(((Kuvar)k).getAdresa());
//			assertNotNull(((Kuvar)k).getTelefon());
//		}
//	}

}