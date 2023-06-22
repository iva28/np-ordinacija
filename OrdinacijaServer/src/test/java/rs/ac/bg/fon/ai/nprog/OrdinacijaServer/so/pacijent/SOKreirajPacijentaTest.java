package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pol;

class SOKreirajPacijentaTest {
	SOKreirajPacijenta kreirajPacijenta;
	SOObrisiPacijenta obrisiPacijenta;
	SOUcitajPacijenta ucitajPacijenta;
	SOUcitajListuPacijenata sviPacijenti;

	@BeforeEach
	void setUp() throws Exception {
		kreirajPacijenta = new SOKreirajPacijenta();
		obrisiPacijenta = new SOObrisiPacijenta();
		ucitajPacijenta = new SOUcitajPacijenta();
		sviPacijenti = new SOUcitajListuPacijenata();
	}

	@AfterEach
	void tearDown() throws Exception {
		kreirajPacijenta = null;
		obrisiPacijenta = null;
		ucitajPacijenta = null;
		sviPacijenti = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuKreirajPacijenta() throws Exception {
		sviPacijenti.izvrsiOperaciju(new Pacijent());
		assertNotNull(sviPacijenti.getLista());
		assertTrue(sviPacijenti.getLista().size() > 0);

		Pacijent novi = new Pacijent();
		novi.setIme("Mirna");
		novi.setPrezime("Krkin");
		novi.setEmail("mirko@gmail.com");
		novi.setPol(Pol.ženski);
		novi.setTelefon("99999999");
		for (OpstaDomenskaKlasa p : sviPacijenti.getLista()) {
			assertFalse(novi.equals((Pacijent) p));
		}

		kreirajPacijenta.izvrsiOperaciju(novi);
		assertTrue(kreirajPacijenta.isUspeh());
		ucitajPacijenta.izvrsiOperaciju(novi);
		assertNotNull(ucitajPacijenta.getPacijent());
		assertEquals(novi, (Pacijent) ucitajPacijenta.getPacijent());
		// brisemo
		obrisiPacijenta.izvrsiOperaciju(ucitajPacijenta.getPacijent());
		assertEquals(true, obrisiPacijenta.isUspeh());
	}

	@Test
	void testizvrsiSpecificnuOperacijuKreirajPacijentaPostoji() throws Exception {
		sviPacijenti.izvrsiOperaciju(new Pacijent());
		assertNotNull(sviPacijenti.getLista());
		assertTrue(sviPacijenti.getLista().size() > 0);
		System.out.println("Pacijenti u testu: "+sviPacijenti.getLista());
		Pacijent novi = (Pacijent) sviPacijenti.getLista().get(0);
		assertThrows(Exception.class, () -> kreirajPacijenta.izvrsiOperaciju(novi));
	}

	@Test
	void testKreirajPacijentaNullObjekat() {
		assertThrows(Exception.class, () -> kreirajPacijenta.izvrsiOperaciju(null));
	}

	@Test
	void testKreirajPacijentaLosaKlasa() {
		assertThrows(Exception.class, () -> kreirajPacijenta.izvrsiOperaciju(new Kuvar()));
	}

}
