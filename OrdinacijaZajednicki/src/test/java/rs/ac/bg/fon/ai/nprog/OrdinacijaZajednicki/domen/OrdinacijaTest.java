package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrdinacijaTest {

	Ordinacija o;

	@BeforeEach
	void setUp() throws Exception {
		o = new Ordinacija();
	}

	@AfterEach
	void tearDown() throws Exception {
		o = null;
	}

	@Test
	void testSetIdOk() {
		o.setOrdinacijaId(1L);
		assertEquals(1L, o.getOrdinacijaId());
	}

	@Test
	void testSetIdNull() {
		assertThrows(NullPointerException.class, () -> o.setOrdinacijaId(null));
	}

	@Test
	void testSetIdManjeNula() {
		assertThrows(IllegalArgumentException.class, () -> o.setOrdinacijaId(-1L));
	}

	@Test
	void testSetNaziv() {
		o.setNaziv("naziv");
		assertEquals("naziv", o.getNaziv());
	}

	@Test
	void testSetAdresa() {
		o.setAdresa("adresa");
		assertEquals("adresa", o.getAdresa());
	}

	@Test
	void testSetAdresaNull() {
		assertThrows(NullPointerException.class, () -> o.setAdresa(null));
	}
	
	@Test
	void testSetNazivNull() {
		assertThrows(NullPointerException.class, () -> o.setNaziv(null));
	}
	@Test
	void testSetNazivKratko() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> o.setNaziv("ddd"));
		assertEquals(ex.getMessage(), "Naziv ne sme biti manji od 5 char");
	}

	@Test
	void testToString() {
		o.setAdresa("adresa");
		o.setNaziv("naziv");
		o.setOrdinacijaId(1L);
		String s = o.toString();
		assertTrue(s.contains("adresa"));
		assertTrue(s.contains("naziv"));
		assertTrue(s.contains("1"));
	}
	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"1,2,false"
	})
	void testEquals(Long id1, Long id2, boolean isti) {
		o.setOrdinacijaId(id1);
		Ordinacija novo = new Ordinacija();
		novo.setOrdinacijaId(id2);
		assertEquals(isti, o.equals(novo));
	}
}
