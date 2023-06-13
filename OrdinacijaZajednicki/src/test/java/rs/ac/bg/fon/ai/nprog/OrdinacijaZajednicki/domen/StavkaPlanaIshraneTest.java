package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		Jelo jelo = new Jelo(1L, null, "naziv", null, 0, null);
		stavka.setJelo(jelo);
		assertEquals(jelo, stavka.getJelo());
	}
	
	@Test
	void testSetStavkaPlanIshrane() {
		PlanIshrane plan = new PlanIshrane(1L);
		stavka.setPlanIshrane(plan);
		assertEquals(plan, stavka.getPlanIshrane());
	}
}
