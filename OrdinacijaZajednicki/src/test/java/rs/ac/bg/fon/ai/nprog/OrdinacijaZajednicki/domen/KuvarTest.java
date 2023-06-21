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
		k.setTelefon("123445777");
		assertEquals("123445777", k.getTelefon());
	}
	@Test
	void testSetKuvarIdNull() {
		assertThrows(NullPointerException.class, () -> k.setKuvarId(null));
	}
	
	@Test
	void testSetKuvarIdNula() {
		assertThrows(IllegalArgumentException.class, () -> k.setKuvarId(0L));
	}
	
	@Test
	void testSetKuvarIdManjeNula() {
		assertThrows(IllegalArgumentException.class, () -> k.setKuvarId(-1L));
	}
	
	@Test
	void testSetKuvarImeNull() {
		assertThrows(NullPointerException.class, () -> k.setIme(null));
	}
	
	@Test
	void testSetKuvarPrezimeNull() {
		assertThrows(NullPointerException.class, () -> k.setPrezime(null));
	}
	
	@Test
	void testSetKuvarImeKratko() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> k.setIme("a"));
		assertEquals(ex.getMessage(), "Ime ne sme biti manje od 2 char");
	}
	
	@Test
	void testSetKuvarPrezimeKratko() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> k.setPrezime("acc"));
		assertEquals(ex.getMessage(), "Prezime ne sme biti manje od 5 char");
	}
	
	@Test
	void testSetKuvarAdresaNull() {
		assertThrows(NullPointerException.class, () -> k.setAdresa(null));
	}
	
	@Test
	void testSetKuvarTelefonNull() {
		assertThrows(NullPointerException.class, () -> k.setTelefon(null));
	}
	
	@Test
	void testSetKuvarTelefonKratko() {
		assertThrows(IllegalArgumentException.class, () -> k.setTelefon("122"));
	}
	
	@Test
	void testSetTelefonImaSlova() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> k.setTelefon("accdffff"));
		assertEquals(ex.getMessage(), "Samo brojevi");
	}
	
	@Test
	void testSetTelefonImaSlovaIBrojeve() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> k.setTelefon("accd334ff4ffff"));
		assertEquals(ex.getMessage(), "Samo brojevi");
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
