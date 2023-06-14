package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.TipJela;

class SOUcitajTipoveJelaTest {

	SOUcitajTipoveJela ucitajTipoveJela;
	
	@BeforeEach
	void setUp() throws Exception {
		ucitajTipoveJela = new SOUcitajTipoveJela();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajTipoveJela = null;
	}

	@Test
	void testizvrsiSpecificnuOperaciju() throws Exception {
		ucitajTipoveJela.izvrsiOperaciju(new TipJela());
		assertNotNull(ucitajTipoveJela.vratiListu());
		assertTrue(ucitajTipoveJela.vratiListu().size() > 0);
		for (OpstaDomenskaKlasa j : ucitajTipoveJela.vratiListu()) {
			assertNotNull(((TipJela) j).getTipId());
			assertNotNull(((TipJela) j).getVrsta());
		}
	}
	
	@Test
	void testUcitajTipJelaNullObjekat() {
		assertThrows(Exception.class, () -> ucitajTipoveJela.izvrsiOperaciju(null));
	}
	
	@Test
	void testUcitajTipJelaLosaKlasa() {
		assertThrows(Exception.class, () -> ucitajTipoveJela.izvrsiOperaciju(new Kuvar()));
	}
}
