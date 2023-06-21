package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StavkaPlanaIshraneTest {

	StavkaPlanaIshrane stavka;
	
	@BeforeEach
	void setUp() throws Exception {
		stavka = new StavkaPlanaIshrane();
	}

	@AfterEach
	void tearDown() throws Exception {
		stavka = null;
	}

	
	@Test
	void testSetStavkaRbOk() {
		stavka.setRb(1L);
		assertEquals(1L, stavka.getRb());
	}
	
	@Test
	void testSetStavkaRbNull() {
		assertThrows(NullPointerException.class, () -> stavka.setRb(null));
	}
	
	@Test
	void testSetStavkaRbManjeNula() {
		assertThrows(IllegalArgumentException.class, () -> stavka.setRb(-1L));
	}
	
	@Test
	void testSetStavkaCena() {
		BigDecimal cena = new BigDecimal(100);
		stavka.setCena(cena);
		assertEquals(cena, stavka.getCena());
	}
	
	@Test
	void testSetStavkaKolicina() {
		stavka.setKolicina(10);
		assertEquals(10, stavka.getKolicina());
	}
	
	@Test
	void testSetStavkaJelo() {
		Jelo jelo = new Jelo(1L,"jelo");
		stavka.setJelo(jelo);
		assertEquals(jelo, stavka.getJelo());
	}
	
	@Test
	void testSetStavkaPlanIshrane() {
		PlanIshrane plan = new PlanIshrane(1L);
		stavka.setPlanIshrane(plan);
		assertEquals(plan, stavka.getPlanIshrane());
	}
	
	@Test
	void testSetStavkaCenaNull() {
		assertThrows(NullPointerException.class, () -> stavka.setCena(null));
	}
	
	@Test
	void testSetStavkaCenaNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> stavka.setCena(new BigDecimal(0)));
		assertEquals(ex.getMessage(), "Cena ne sme bit manja ili jednaka 0");
	}
	
	@Test
	void testSetStavkaCenaManjeNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> stavka.setCena(new BigDecimal(-1)));
		assertEquals(ex.getMessage(), "Cena ne sme bit manja ili jednaka 0");
	}
	
	@Test
	void testSetStavkaKolicinaNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> stavka.setKolicina(0));
		assertEquals(ex.getMessage(), "Kolicina ne sme biti null");
	}
	
	@Test
	void testSetStavkaKolicinaManjeNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> stavka.setKolicina(-1));
		assertEquals(ex.getMessage(), "Kolicina ne sme biti null");
	}
	
	@Test
	void testSetStavkaJelaNull() {
		assertThrows(NullPointerException.class, () -> stavka.setJelo(null));
	}
	
	@Test
	void testSetPlanIshrane() {
		assertThrows(NullPointerException.class, () -> stavka.setPlanIshrane(null));
	}
	
	@Test
	void testToString() {
		stavka.setRb(1L);
		stavka.setCena(new BigDecimal("100"));
		stavka.setKolicina(122);
		Jelo j = new Jelo();
		j.setJeloId(1L);
		j.setNaziv("jelo");
		stavka.setJelo(j);
		PlanIshrane plan = new PlanIshrane(12L);
		stavka.setPlanIshrane(plan);
		String s = stavka.toString();
		assertTrue(s.contains("1"));
		assertTrue(s.contains("12"));
		assertTrue(s.contains("jelo"));
		assertTrue(s.contains("122"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"naziv,naziv,true",
		"naziv,naziv2,false"
	})
	void testEquals(String naziv1, String naziv2, boolean isti) {
		Jelo jelo1 = new Jelo();
		jelo1.setNaziv(naziv1);
		Jelo jelo2 = new Jelo();
		jelo2.setNaziv(naziv2);
		stavka.setJelo(jelo1);
		StavkaPlanaIshrane druga = new StavkaPlanaIshrane();
		druga.setJelo(jelo2);
		assertEquals(isti, stavka.equals(druga));
	}
}
