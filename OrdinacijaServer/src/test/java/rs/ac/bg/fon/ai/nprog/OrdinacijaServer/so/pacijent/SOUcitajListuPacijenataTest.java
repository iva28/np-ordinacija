package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

class SOUcitajListuPacijenataTest {

	SOUcitajListuPacijenata ucitajPacijente;
	
	@BeforeEach
	void setUp() throws Exception {
		ucitajPacijente = new SOUcitajListuPacijenata();
	}

	@AfterEach
	void tearDown() throws Exception {
		ucitajPacijente = null;
	}

	@Test
	void testizvrsiSpecificnuOperaciju() throws Exception {
		ucitajPacijente.izvrsiOperaciju(new Pacijent());
		assertNotNull(ucitajPacijente.getLista());
		assertTrue(ucitajPacijente.getLista().size() > 0);
		for (OpstaDomenskaKlasa p : ucitajPacijente.getLista()) {
			assertNotNull(((Pacijent) p).getPacijentId());
			assertNotNull(((Pacijent) p).getIme());
			assertNotNull(((Pacijent) p).getPrezime());
			assertNotNull(((Pacijent) p).getPol());
			assertNotNull(((Pacijent) p).getTelefon());
			assertNotNull(((Pacijent) p).getEmail());
		}
	}
	
	@Test
	void testUcitajJelaNullObjekat() {
		assertThrows(Exception.class, () -> ucitajPacijente.izvrsiOperaciju(null));
	}
	
	@Test
	void testUcitajJelaLosaKlasa() {
		assertThrows(Exception.class, () -> ucitajPacijente.izvrsiOperaciju(new Kuvar()));
	}

	
}
