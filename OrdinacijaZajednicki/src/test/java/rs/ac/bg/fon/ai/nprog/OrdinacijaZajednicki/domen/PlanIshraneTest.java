package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlanIshraneTest {

	PlanIshrane plan;
	
	@BeforeEach
	void setUp() throws Exception {
		plan = new PlanIshrane();
	}

	@AfterEach
	void tearDown() throws Exception {
		plan = null;
	}
	
	@Test
	void testSetPlanIdOk() {
		plan.setPlanIshraneId(1L);
		assertEquals(1L, plan.getPlanIshraneId());
	}
	@Test
	void testSetPlanIdNull() {
		assertThrows(NullPointerException.class, () -> plan.setPlanIshraneId(null));
	}
	@Test
	void testSetPlanIdManjeNula() {
		assertThrows(IllegalArgumentException.class, () -> plan.setPlanIshraneId(-1L));
	}
	
	@Test
	void testSetPlanDatum() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		Date datum = calendar.getTime();
		plan.setDatum(datum);
		assertEquals(datum, plan.getDatum());
	}
	
	@Test
	void testSetPlanCena() {
		BigDecimal cena = new BigDecimal(10);
		plan.setCena(cena);
		assertEquals(cena, plan.getCena());
	}
	
	@Test
	void testSetPlanBrojDana() {
		plan.setBrojDana(10);
		assertEquals(10, plan.getBrojDana());
	}
	
	@Test
	void testSetPlanPacijent() {
		Pacijent p = new Pacijent();
		plan.setPacijent(p);
		assertFalse(plan.getPacijent() == null);
		assertEquals(p, plan.getPacijent());
	}
	
	@Test
	void testSetPlanNutricionista() {
		Nutricionista n = new Nutricionista();
		plan.setNutricionista(n);
		assertFalse(plan.getNutricionista() == null);
		assertEquals(n, plan.getNutricionista());
	}
	
	@Test
	void testSetPlanStavkePlana() {
		StavkaPlanaIshrane stavka1 = new StavkaPlanaIshrane();
		StavkaPlanaIshrane stavka2 = new StavkaPlanaIshrane();
		List<StavkaPlanaIshrane> stavke = new ArrayList<>();
		stavke.add(stavka1);
		stavke.add(stavka2);
		plan.setStavke(stavke);
		assertFalse(plan.getStavke() == null);
		assertTrue(plan.getStavke().contains(stavka1));
		assertTrue(plan.getStavke().contains(stavka2));
	}
	
	@Test
	void testToString() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		Date datum = calendar.getTime();
		Pacijent pacijent = new Pacijent();
		pacijent.setIme("ime");
		pacijent.setPrezime("prezime");
		Nutricionista nutricionista = new Nutricionista();
		nutricionista.setIme("nutricionista");
		nutricionista.setPrezime("nutricionista2");
		plan.setPlanIshraneId(1L);
		plan.setDatum(datum);
		plan.setCena(new BigDecimal(100));
		plan.setPacijent(pacijent);
		plan.setNutricionista(nutricionista);
		String s = plan.toString();
		assertTrue(s.contains("1"));
		assertTrue(s.contains(datum.toString()));
		assertTrue(s.contains("100"));
		assertTrue(s.contains("ime"));
		assertTrue(s.contains("prezime"));
		assertTrue(s.contains("nutricionista"));
		assertTrue(s.contains("nutricionista2"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime,true",
		"1,21,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime,false",
		"1,1,11.08.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime,false",
		"1,11,11.11.2022,11.11.2022,mejl2@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime,false",
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime2,prezime,prezime,false",
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime2,false",
		})
	void testEquals(int brojDana1, int brojDana2, String datum1, String datum2, String email1,String email2,
			String ime1, String ime2, String prez1,String prez2, boolean isti) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		PlanIshrane drugi = new PlanIshrane();
		try {
			Date 	datumPlan1 = sdf.parse(datum1);
			Nutricionista n1 = new Nutricionista(null, ime1, prez1, null, null, null);
			Pacijent p1 = new Pacijent(null, null, email1, null, null);
			plan.setNutricionista(n1);
			plan.setPacijent(p1);
			plan.setBrojDana(brojDana1);
			plan.setDatum(datumPlan1);
			Date datumPlan2 = sdf.parse(datum2);
			Nutricionista n2 = new Nutricionista(null, ime2, prez2, null, null, null);
			Pacijent p2 = new Pacijent(null, null, email2, null, null);
			drugi.setNutricionista(n2);
			drugi.setPacijent(p2);
			drugi.setBrojDana(brojDana2);
			drugi.setDatum(datumPlan2);
		} catch (ParseException e) {
		}
		
		assertEquals(isti, plan.equals(drugi));
	}
}
