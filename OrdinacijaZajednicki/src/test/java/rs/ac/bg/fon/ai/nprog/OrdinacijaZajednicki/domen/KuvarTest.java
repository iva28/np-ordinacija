package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KuvarTest {

	Kuvar k;
	
	@BeforeEach
	void setUp() throws Exception {
		k = new Kuvar();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}

	@Test
	void testSetKuvarId() {
		k.setKuvarId(1L);
		assertEquals(1L, k.getKuvarId());
	}
	
	@Test
	void testSetKuvarIme() {
		k.setIme("ime");
		assertEquals("ime", k.getIme());
	}
	
	@Test
	void testSetKuvarPrezime() {
		k.setPrezime("prezime");
		assertEquals("prezime", k.getPrezime());
	}
	
	@Test
	void testSetKuvarAdresa() {
		k.setAdresa("adresa");
		assertEquals("adresa", k.getAdresa());
	}
	
	@Test
	void testSetKuvarTelefon() {
		k.setTelefon("telefon");
		assertEquals("telefon", k.getTelefon());
	}
	
	@Test
	void testToString() {
		
		k.setIme("ime");
		k.setPrezime("prezime");
		
		String s = k.toString();
		assertTrue(s.contains("ime"));
		assertTrue(s.contains("prezime"));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"1,2,false"
	})
	void testEquals(Long id1, Long id2, boolean isti) {
		k.setKuvarId(id1);
		
		Kuvar kuvar2 = new Kuvar();
		kuvar2.setKuvarId(id2);
		assertEquals(isti, k.equals(kuvar2));
	}
}
