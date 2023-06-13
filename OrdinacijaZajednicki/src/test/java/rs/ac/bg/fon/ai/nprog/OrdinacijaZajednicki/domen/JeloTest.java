package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JeloTest {

	Jelo j;

	@BeforeEach
	void setUp() throws Exception {
		j = new Jelo();
	}

	@AfterEach
	void tearDown() throws Exception {
		j = null;
	}

	@Test
	void testSetJeloIdOk() {
		j.setJeloId(1L);
		assertEquals(1L, j.getJeloId());
	}
	
	@Test
	void testSetJeloIdNull() {
		assertThrows(NullPointerException.class, () -> j.setJeloId(null));
	}
	@Test
	void testSetJeloIdManjiOdNule() {
		assertThrows(IllegalArgumentException.class, () -> j.setJeloId(-1L));
	}

	@Test
	void testSetTipJelo() {
		TipJela tj = new TipJela(1L, "vegan");
		j.setTip(tj);
		assertEquals(tj, j.getTip());
	}

	@Test
	void testSetCenaJela() {
		BigDecimal cena = new BigDecimal(10);
		j.setCena(cena);
		assertEquals(cena, j.getCena());
	}

	@Test
	void testSetKolicinaJela() {
		j.setKolicina(10);
		assertEquals(10, j.getKolicina());
	}

	@Test
	void testSetKuvarJela() {
		Kuvar k = new Kuvar(1L, "", "");
		j.setKuvar(k);
		assertEquals(k, j.getKuvar());
	}
	@Test
	void testToString() {
		TipJela tj = new TipJela(1L, "");
		Kuvar k = new Kuvar(1L, "", "");
		
		j.setJeloId(1L);
		j.setTip(tj);
		j.setNaziv("naziv");
		j.setCena(new BigDecimal(100));
		j.setKolicina(10);
		j.setKuvar(k);
		
		String s = j.toString();
		assertTrue(s.contains(j.getJeloId().toString()));
		assertTrue(s.contains(j.getTip().toString()));
		assertTrue(s.contains("naziv"));
		assertTrue(s.contains("100"));
		assertTrue(s.contains("10"));
		assertTrue(s.contains(j.getKuvar().toString()));
	}
	
	@ParameterizedTest
	@CsvSource({
		"naziv,naziv,true",
		"naziv,naziv2,false"
	})
	void testEquals(String naziv1, String naziv2, boolean isti) {
		j.setNaziv(naziv1);
		Jelo novo = new Jelo();
		novo.setNaziv(naziv2);
		assertEquals(isti, j.equals(novo));
	}

}
