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
		p.setIme("ime");
		p.setPrezime("prezime");
		plan.setPacijent(p);
		assertFalse(plan.getPacijent() == null);
		assertEquals(p, plan.getPacijent());
	}
	
	@Test
	void testSetPlanNutricionista() {
		Nutricionista n = new Nutricionista();
		n.setIme("ime");
		n.setPrezime("prezime");
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
	
	@Test
	void testSeDatumNull() {
		assertThrows(NullPointerException.class, () -> plan.setDatum(null));
	}
	
	@Test
	void testSetCenaNull() {
		assertThrows(NullPointerException.class, () -> plan.setCena(null));
	}
	
	@Test
	void testSetPacijentNull() {
		assertThrows(NullPointerException.class, () -> plan.setPacijent(null));
	}
	
	@Test
	void testSetNutricionistaNull() {
		assertThrows(NullPointerException.class, () -> plan.setNutricionista(null));
	}
	
	@Test
	void testSetStavkeNull() {
		assertThrows(NullPointerException.class, () -> plan.setStavke(null));
	}
	
	@Test
	void testSetCenaNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setCena(new BigDecimal(0L)));
		assertEquals(ex.getMessage(), "Cena ne sme biti 0 ili manja od 0");
	}
	
	@Test
	void testSetCenaManjeNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setCena(new BigDecimal(-1L)));
		assertEquals(ex.getMessage(), "Cena ne sme biti 0 ili manja od 0");
	}
	
	@Test
	void testSetBrojDanaNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setBrojDana(0));
		assertEquals(ex.getMessage(), "Broj dana ne sme biti 0 ili manje 0");
	}
	
	@Test
	void testSetBrojDanaManjeNula() {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setBrojDana(-1));
		assertEquals(ex.getMessage(), "Broj dana ne sme biti 0 ili manje 0");
	}
	
	@Test
	void testSetPacijentNemaImeImaPrezime() {
		Pacijent pacijent = new Pacijent();
		pacijent.setPrezime("prezime");
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setPacijent(pacijent));
		assertEquals(ex.getMessage(), "Pacijent mora da ime i prezime");
	}
	
	@Test
	void testSetPacijentImaImeNemaPrezime() {
		Pacijent pacijent = new Pacijent();
		pacijent.setIme("ime");
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setPacijent(pacijent));
		assertEquals(ex.getMessage(), "Pacijent mora da ime i prezime");
	}
	
	@Test
	void testSetPacijentNemaImeNemaPrezime() {
		Pacijent pacijent = new Pacijent();
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setPacijent(pacijent));
		assertEquals(ex.getMessage(), "Pacijent mora da ime i prezime");
	}
	
	@Test
	void testSetNutricionistaNemaImeImaPrezime() {
		Nutricionista n = new Nutricionista();
		n.setPrezime("prezime");
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setNutricionista(n));
		assertEquals(ex.getMessage(), "Nutricionista mora da ime i prezime");
	}
	
	@Test
	void testSetNutricionistaImaImeNemaPrezime() {
		Nutricionista n = new Nutricionista();
		n.setIme("ime");
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setNutricionista(n));
		assertEquals(ex.getMessage(), "Nutricionista mora da ime i prezime");
	}
	
	@Test
	void testSetNutricionistaNemaImeNemaPrezime() {
		Nutricionista n = new Nutricionista();
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setNutricionista(n));
		assertEquals(ex.getMessage(), "Nutricionista mora da ime i prezime");
	}
	
	@Test
	void testSetStavkePraznaLista() {
		List<StavkaPlanaIshrane> stavke = new ArrayList<>();
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> plan.setStavke(stavke));
		assertEquals(ex.getMessage(), "Plan mora imati stavke");
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime, maja, maja, majic, majic,true",
		"1,21,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime,maja, maja, majic, majic,false",
		"1,1,11.08.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime,maja, maja, majic, majic,false",
		"1,11,11.11.2022,11.11.2022,mejl2@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime,maja, maja, majic, majic,false",
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime2,prezime,prezime,maja, maja, majic, majic,false",
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime2,maja, maja, majic, majic,false",
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime2,maja, nikola, majic, majic,false",
		"1,1,11.11.2022,11.11.2022,mejl@gmail.com,mejl@gmail.com,ime,ime,prezime,prezime2,maja, maja, majic, nikolic,false",
		})
	void testEquals(int brojDana1, int brojDana2, String datum1, String datum2, String email1,String email2,
			String ime1, String ime2, String prez1,String prez2, String imePac1, String imePac2, String prezPac1, String prezPac2,
			boolean isti) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		PlanIshrane drugi = new PlanIshrane();
		try {
			Date 	datumPlan1 = sdf.parse(datum1);
			Nutricionista n1 = new Nutricionista();
			n1.setIme(ime1);
			n1.setPrezime(prez1);
			Pacijent p1 = new Pacijent();
			p1.setIme(imePac1);
			p1.setPrezime(prez1);
			p1.setEmail(email1);
			plan.setNutricionista(n1);
			plan.setPacijent(p1);
			plan.setBrojDana(brojDana1);
			plan.setDatum(datumPlan1);
			Date datumPlan2 = sdf.parse(datum2);
			Nutricionista n2 = new Nutricionista();
			n2.setIme(ime2);
			n2.setPrezime(prez2);
			Pacijent p2 = new Pacijent();
			p2.setIme(imePac2);
			p2.setPrezime(prezPac2);
			p2.setEmail(email2);
			drugi.setNutricionista(n2);
			drugi.setPacijent(p2);
			drugi.setBrojDana(brojDana2);
			drugi.setDatum(datumPlan2);
		} catch (ParseException e) {
		}
		
		assertEquals(isti, plan.equals(drugi));
	}
}
