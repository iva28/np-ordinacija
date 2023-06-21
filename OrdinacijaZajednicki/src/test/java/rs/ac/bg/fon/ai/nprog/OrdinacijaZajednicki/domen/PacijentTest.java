package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PacijentTest {
	Pacijent p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Pacijent();
	}

	@AfterEach
	void tearDown() throws Exception {
		p = null;
	}

	@Test
	void testSetPacijentIdOk() {
		p.setPacijentId(1L);
		assertEquals(1L, p.getPacijentId());
	}
	
	@Test
	void testSetPacijentIdNull() {
		assertThrows(NullPointerException.class, () -> p.setPacijentId(null));
	}
	
	@Test
	void testSetPacijentIdManjeNula() {
		assertThrows(IllegalArgumentException.class, () -> p.setPacijentId(-1L));
	}
	
	@Test
	void testSetPacijentIme() {
		p.setIme("ime");
		assertEquals("ime",p.getIme());
	}
	
	@Test
	void testSetPacijentPrezime() {
		p.setPrezime("prezime");
		assertEquals("prezime",p.getPrezime());
	}
	
	@Test 
	void testPacijentEmail() {
		p.setEmail("email@mejl.com");
		assertEquals("email@mejl.com", p.getEmail());
	}
	
	@Test
	void testSetPacijentTelefon() {
		p.setTelefon("12234455");
		assertEquals("12234455", p.getTelefon());
	}
	
	@Test
	void testSetPacijentPol() {
		Pol pol = Pol.muški;
		p.setPol(pol);
		assertEquals(Pol.muški, p.getPol());
	}
	
	
	@Test
	void testSetImeNull() {
		assertThrows(NullPointerException.class, () -> p.setIme(null));
	}
	

	@Test
	void testSetPrezimeNull() {
		assertThrows(NullPointerException.class, () -> p.setPrezime(null));
	}
	
	@Test
	void testSetImeKratko() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> p.setIme("a"));
		assertEquals(ex.getMessage(), "Prekratko ime");
	}
	
	@Test
	void testSetPrezimeKratko() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> p.setPrezime("a"));
		assertEquals(ex.getMessage(), "Prekratko prezime");
	}
	

	@Test
	void testSetTelefonNull() {
		assertThrows(NullPointerException.class, () -> p.setTelefon(null));
	}
	
	
//	@Test
//	void testSetTelefonImaSlova() {
//		Throwable ex = assertThrows(IllegalArgumentException.class, () -> p.setTelefon("accdffff"));
//		assertEquals(ex.getMessage(), "Samo brojevi");
//	}
	
//	@Test
//	void testSetTelefonImaSlovaIBrojeve() {
//		Throwable ex = assertThrows(IllegalArgumentException.class, () -> p.setTelefon("accd334ff4ffff"));
//		assertEquals(ex.getMessage(), "Samo brojevi");
//	}
//	
	@Test
	void testSetEmailNull() {
		assertThrows(NullPointerException.class, () -> p.setEmail(null));
	}
	
	@Test
	void testSetEmailKratak() {
		assertThrows(IllegalArgumentException.class, () -> p.setEmail("11"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"email@mejl.com,email@mejl.com,true",
		"email@mejl.com,email2@mejl.com,false",
	})
	void testEquals(String email1, String email2, boolean isti) {
		p.setEmail(email1);
		Pacijent drugi = new Pacijent();
		drugi.setEmail(email2);
		assertEquals(isti, p.equals(drugi));
	}
	
	@Test
	void testToString() {
		p.setIme("ime");
		p.setPrezime("prezime");
		String s = p.toString();
		assertTrue(s.contains("ime"));
		assertTrue(s.contains("prezime"));
	}
}
