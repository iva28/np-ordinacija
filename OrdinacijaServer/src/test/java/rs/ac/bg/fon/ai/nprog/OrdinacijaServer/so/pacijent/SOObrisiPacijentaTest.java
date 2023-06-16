package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pol;

class SOObrisiPacijentaTest {

	SOObrisiPacijenta obrisiPacijenta;
	SOKreirajPacijenta kreirajPacijenta;
	SOUcitajPacijenta ucitajPacijenta;
	SOUcitajListuPacijenata sviPacijenti;

	@BeforeEach
	void setUp() throws Exception {
		obrisiPacijenta = new SOObrisiPacijenta();
		kreirajPacijenta = new SOKreirajPacijenta();
		ucitajPacijenta = new SOUcitajPacijenta();
		sviPacijenti = new SOUcitajListuPacijenata();
	}

	@AfterEach
	void tearDown() throws Exception {
		obrisiPacijenta = null;
		kreirajPacijenta = null;
		ucitajPacijenta = null;
		sviPacijenti = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuObrisiPacijenta() throws Exception {
		sviPacijenti.izvrsiOperaciju(new Pacijent());
		assertNotNull(sviPacijenti.getLista());
		assertTrue(sviPacijenti.getLista().size() > 0);
	
		Pacijent novi = new Pacijent();
		novi.setIme("Mirna");
		novi.setPrezime("Mirov");
		novi.setEmail("mirkov@gmail.com");
		novi.setPol(Pol.muški);
		novi.setTelefon("99999999");
		for (OpstaDomenskaKlasa p : sviPacijenti.getLista()){
			assertFalse(novi.equals((Pacijent) p));
		}
		
		kreirajPacijenta.izvrsiOperaciju(novi);
		assertTrue(kreirajPacijenta.isUspeh());
		ucitajPacijenta.izvrsiOperaciju(novi);
		assertNotNull(ucitajPacijenta.getPacijent());
		assertEquals(novi, (Pacijent) ucitajPacijenta.getPacijent());
		Pacijent ucitani = (Pacijent) ucitajPacijenta.getPacijent();
		obrisiPacijenta.izvrsiOperaciju(ucitajPacijenta.getPacijent());
		assertEquals(true, obrisiPacijenta.isUspeh());
		ucitajPacijenta.izvrsiOperaciju(ucitani);
		assertNull(ucitajPacijenta.getPacijent());
	}

	@Test
	void testizvrsiSpecificnuOperacijuObrisiPacijentaNema() throws Exception {
			Pacijent novi = new Pacijent();
			obrisiPacijenta.izvrsiOperaciju(novi);
			assertFalse(obrisiPacijenta.isUspeh());
	}

	@Test
	void testObrisiPacijentaNullObjekat() {
		assertThrows(Exception.class, () -> obrisiPacijenta.izvrsiOperaciju(null));
	}

	@Test
	void testObrisiPacijentaLosaKlasa() {
		assertThrows(Exception.class, () -> obrisiPacijenta.izvrsiOperaciju(new Kuvar()));
	}
}
