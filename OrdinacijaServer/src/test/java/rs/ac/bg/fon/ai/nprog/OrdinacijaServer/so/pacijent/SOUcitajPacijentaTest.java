package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.TipJela;

class SOUcitajPacijentaTest {
	SOUcitajPacijenta ucitajPacijenta;

	@BeforeEach
	void setUp() throws Exception {
		ucitajPacijenta = new SOUcitajPacijenta();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajPacijenta = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuUcitajPacijenta() throws Exception {
		Pacijent pacijent = new Pacijent();
		pacijent.setEmail("maja@gmail.com");
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
