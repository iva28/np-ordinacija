package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;

class SONadjiPacijenteTest {

	SONadjiPacijente nadjiPacijente;

	@BeforeEach
	void setUp() throws Exception {
		nadjiPacijente = new SONadjiPacijente();
	}

	@AfterEach
	void tearDown() throws Exception {
		nadjiPacijente = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuNadjiPacijente() throws Exception {
		Pacijent pacijent = new Pacijent();
		pacijent.setIme("Maja");
		nadjiPacijente.izvrsiOperaciju(pacijent);
		assertNotNull(nadjiPacijente.vratiListu());
		assertFalse(nadjiPacijente.vratiListu().isEmpty());
		for (OpstaDomenskaKlasa p : nadjiPacijente.vratiListu()) {
			assertNotNull(((Pacijent) p).getPacijentId());
			assertNotNull(((Pacijent) p).getIme());
			assertNotNull(((Pacijent) p).getPrezime());
			assertNotNull(((Pacijent) p).getPol());
			assertNotNull(((Pacijent) p).getTelefon());
			assertNotNull(((Pacijent) p).getEmail());
			assertEquals(((Pacijent) p).getIme(), pacijent.getIme());
		}
	}

	@Test
	void testizvrsiSpecificnuOperacijuNadjiPacijentaNema() throws Exception {
		Pacijent pacijent = new Pacijent();
		nadjiPacijente.izvrsiOperaciju(pacijent);
		assertTrue(nadjiPacijente.vratiListu().isEmpty());
	}

	@Test
	void testUcitajJelaNullObjekat() {
		assertThrows(Exception.class, () -> nadjiPacijente.izvrsiOperaciju(null));
	}

	@Test
	void testUcitajJelaLosaKlasa() {
		assertThrows(Exception.class, () -> nadjiPacijente.izvrsiOperaciju(new Kuvar()));
	}

}
