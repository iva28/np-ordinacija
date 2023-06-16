package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;

class SOPrijaviSeTest {

	SOPrijaviSe prijava;
	SOUcitajListuNutricionista sviNutricionisti;

	@BeforeEach
	void setUp() throws Exception {
		prijava = new SOPrijaviSe();
		sviNutricionisti = new SOUcitajListuNutricionista();
	}

	@AfterEach
	void tearDown() throws Exception {
		prijava = null;
		sviNutricionisti = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuPrijaviNutricionistu() throws Exception {
		sviNutricionisti.izvrsiOperaciju(new Nutricionista());
		assertNotNull(sviNutricionisti.getLista());
		assertTrue(sviNutricionisti.getLista().size() > 0);
		Nutricionista nutricionista = (Nutricionista) sviNutricionisti.getLista().get(0);
		prijava.izvrsiOperaciju(nutricionista);
		assertNotNull(prijava.vratiNutricionistu());
		assertEquals(nutricionista, prijava.vratiNutricionistu());
	}

	@Test
	@DisplayName("Proverava kad pokusava da se uloguje nepostojeci nutricionista")
	void testizvrsiSpecificnuOperacijuPrijaviNutricionistuNema() throws Exception {
		sviNutricionisti.izvrsiOperaciju(new Nutricionista());
		assertNotNull(sviNutricionisti.getLista());
		assertTrue(sviNutricionisti.getLista().size() > 0);
		prijava.izvrsiOperaciju(new Nutricionista());
		assertNull(prijava.vratiNutricionistu());
	}

	@Test
	void testPrijaviSeNullObjekat() {
		assertThrows(Exception.class, () -> prijava.izvrsiOperaciju(null));
	}

	@Test
	void testPrijaviSeLosaKlasa() {
		assertThrows(Exception.class, () -> prijava.izvrsiOperaciju(new Kuvar()));
	}
}
