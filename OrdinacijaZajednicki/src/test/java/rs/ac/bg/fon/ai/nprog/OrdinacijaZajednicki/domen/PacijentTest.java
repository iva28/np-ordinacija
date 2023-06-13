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
		p.setEmail("email");
		assertEquals("email", p.getEmail());
	}
	
	@Test
	void testSetPacijentTelefon() {
		p.setTelefon("telefon");
		assertEquals("telefon", p.getTelefon());
	}
	
	@Test
	void testSetPacijentPol() {
		Pol pol = Pol.muški;
		p.setPol(pol);
		assertEquals(Pol.muški, p.getPol());
	}
	
	@Test
	void testToString() {
		p.setIme("ime");
		p.setPrezime("prezime");
		String s = p.toString();
		assertTrue(s.contains("ime"));
		assertTrue(s.contains("prezime"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"email,email,true",
		"email,email2,false",
	})
	void testEquals(String email1, String email2, boolean isti) {
		p.setEmail(email1);
		Pacijent drugi = new Pacijent();
		drugi.setEmail(email2);
		assertEquals(isti, p.equals(drugi));
	}
	
}
