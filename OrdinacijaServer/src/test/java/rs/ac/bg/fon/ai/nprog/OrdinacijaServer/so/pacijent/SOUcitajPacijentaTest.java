package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

class SOUcitajPacijentaTest {
	SOUcitajPacijenta ucitajPacijenta;
	SOUcitajListuPacijenata sviPacijenti;

	@BeforeEach
	void setUp() throws Exception {
		ucitajPacijenta = new SOUcitajPacijenta();
		sviPacijenti = new SOUcitajListuPacijenata();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajPacijenta = null;
		sviPacijenti = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuUcitajPacijenta() throws Exception {
		sviPacijenti.izvrsiOperaciju(new Pacijent());
		assertNotNull(sviPacijenti.getLista());
		assertTrue(sviPacijenti.getLista().size() > 0);
		Pacijent pacijent = ((Pacijent)sviPacijenti.getLista().get(0));
		ucitajPacijenta.izvrsiOperaciju(pacijent);
		assertNotNull(ucitajPacijenta.getPacijent());
		assertEquals(pacijent,ucitajPacijenta.getPacijent());
	}
	
	@Test
	void testizvrsiSpecificnuOperacijuUcitajPacijentaNema() throws Exception {
		Pacijent pacijent = new Pacijent();
		ucitajPacijenta.izvrsiOperaciju(pacijent);
		assertNull(ucitajPacijenta.getPacijent());
	}
	
	@Test
	void testUcitajPacijentaNullObjekat() {
		assertThrows(Exception.class, () -> ucitajPacijenta.izvrsiOperaciju(null));
	}
	
	@Test
	void testUcitajPacijentaLosaKlasa() {
		assertThrows(Exception.class, () -> ucitajPacijenta.izvrsiOperaciju(new Kuvar()));
	}

}
