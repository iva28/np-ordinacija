package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NutricionistaTest {
	Nutricionista n;

	@BeforeEach
	void setUp() throws Exception {
		n = new Nutricionista();
	}

	@AfterEach
	void tearDown() throws Exception {
		n = null;
	}

	@Test
	void testSetIdOk() {
		n.setNutricionistaId(1L);
		assertEquals(1L, n.getNutricionistaId());
	}
	
	@Test
	void testSetIdNull() {
		assertThrows(NullPointerException.class, () -> n.setNutricionistaId(null));
	}
	
	@Test
	void testSetIdManjeula() {
		assertThrows(IllegalArgumentException.class, () -> n.setNutricionistaId(-1L));
	}
	
	@Test
	void testSetIme() {
		n.setIme("ime");
		assertEquals("ime", n.getIme());
	}
	
	@Test
	void testSetPrezime() {
		n.setPrezime("prezime");
		assertEquals("prezime", n.getPrezime());
	}
	
	@Test
	void testSetUsername() {
		n.setUsername("username");
		assertEquals("username", n.getUsername());
	}
	
	@Test
	void testSetPassword() {
		n.setPassword("pass");
		assertEquals("pass", n.getPassword());
	}
	
	@Test
	void testSetOrdinacija() {
		Ordinacija o = new Ordinacija(1L);
		n.setOrdinacija(o);
		assertFalse(n.getOrdinacija() == null);
		assertEquals(o, n.getOrdinacija());
	}
	
	@Test
	void testToString() {
		n.setIme("ime");
		n.setPrezime("prezime");
		String s = n.toString();
		assertTrue(s.contains("ime"));
		assertTrue(s.contains("prezime"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"ime,ime,prezime,prezime,true",
		"ime,ime2,prezime,prezime,false",
		"ime,ime,prezime2,prezime,false",
		"ime,ime2,prezime2,prezime,false",
	})
	void testEquals(String ime1, String ime2,String prezime1,
			String prezime2, boolean isti) {
		n.setIme(ime1);
		n.setPrezime(prezime1);
		Nutricionista drugi = new Nutricionista();
		drugi.setIme(ime2);
		drugi.setPrezime(prezime2);
		assertEquals(isti, n.equals(drugi));
	}

}
