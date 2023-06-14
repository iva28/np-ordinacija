package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

class SOUcitajListuJelaTest {

	SOUcitajListuJela ucitajJela;

	@BeforeEach
	void setUp() throws Exception {
		ucitajJela = new SOUcitajListuJela();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajJela = null;
	}

	@Test
	void testizvrsiSpecificnuOperaciju() throws Exception {
		ucitajJela.izvrsiSpecificnuOperaciju(new Jelo());
		assertNotNull(ucitajJela.vratiListu());
		assertTrue(ucitajJela.vratiListu().size() > 0);
		for (OpstaDomenskaKlasa j : ucitajJela.vratiListu()) {
			assertNotNull(((Jelo) j).getJeloId());
			assertNotNull(((Jelo) j).getTip());
			assertNotNull(((Jelo) j).getNaziv());
			assertNotNull(((Jelo) j).getCena());
			assertNotNull(((Jelo) j).getKolicina());
			assertNotNull(((Jelo) j).getKuvar());
		}
	}
	
	@Test
	void testUcitajJelaNullObjekat() {
		assertThrows(Exception.class, () -> ucitajJela.izvrsiOperaciju(null));
	}
	
	@Test
	void testUcitajJelaLosaKlasa() {
		assertThrows(Exception.class, () -> ucitajJela.izvrsiOperaciju(new Kuvar()));
	}

}
