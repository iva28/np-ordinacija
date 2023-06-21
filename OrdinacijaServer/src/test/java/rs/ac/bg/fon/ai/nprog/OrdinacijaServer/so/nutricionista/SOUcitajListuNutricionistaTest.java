package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.nutricionista;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;

class SOUcitajListuNutricionistaTest {

	SOUcitajListuNutricionista sviNutricionisti;
	
	@BeforeEach
	void setUp() throws Exception {
		sviNutricionisti = new SOUcitajListuNutricionista();
	}

	@AfterEach
	void tearDown() throws Exception {
		sviNutricionisti = null;
	}

	@Test
	void testizvrsiSpecificnuOperaciju() throws Exception {
		sviNutricionisti.izvrsiSpecificnuOperaciju(new Nutricionista());
		assertNotNull(sviNutricionisti.getLista());
		assertTrue(sviNutricionisti.getLista().size() > 0);
		for (OpstaDomenskaKlasa k : sviNutricionisti.getLista()) {
			assertNotNull(((Nutricionista) k).getNutricionistaId());
			assertNotNull(((Nutricionista) k).getIme());
			assertNotNull(((Nutricionista) k).getPrezime());
			assertNotNull(((Nutricionista) k).getPrezime());
			assertNotNull(((Nutricionista) k).getUsername());
			assertNotNull(((Nutricionista) k).getPassword());
			//assertNotNull(((Nutricionista) k).getOrdinacija());
		}
	}

	@Test
	void testUcitajListuNutricionistaNullObjekat() {
		assertThrows(Exception.class, () -> sviNutricionisti.izvrsiOperaciju(null));
	}

	@Test
	void testUcitajListuNutricionistaLosaKlasa() {
		assertThrows(Exception.class, () -> sviNutricionisti.izvrsiOperaciju(new Kuvar()));
	}

}
