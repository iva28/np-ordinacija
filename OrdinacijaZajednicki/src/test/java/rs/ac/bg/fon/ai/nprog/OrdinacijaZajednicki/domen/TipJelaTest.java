package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TipJelaTest {

	TipJela tj;

	@BeforeEach
	void setUp() throws Exception {
		tj = new TipJela();
	}

	@AfterEach
	void tearDown() throws Exception {
		tj = null;
	}

	@Test
	void testSetTipJelaIdOk() {
		tj.setTipId(1L);
		assertEquals(1L, tj.getTipId());
	}

	@Test
	void testSetTipJelaIdNull() {
		assertThrows(NullPointerException.class, () -> tj.setTipId(null));
	}

	@Test
	void testSetTipJelaIdManjeNula() {
		assertThrows(IllegalArgumentException.class, () -> tj.setTipId(-1L));
	}

	@Test
	void testSetVrstaTipaJela() {
		tj.setVrsta("vrsta");
		assertEquals("vrsta", tj.getVrsta());
	}
	
	@Test
	void testToString() {
		tj.setVrsta("vrsta");
		String s = tj.toString();
		assertTrue(s.contains("vrsta"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"1,2,false"
	})
	void testEquals(Long id1, Long id2, boolean isti) {
		tj.setTipId(id1);
		TipJela novo = new TipJela();
		novo.setTipId(id2);
		assertEquals(isti, tj.equals(novo));
	}

}
