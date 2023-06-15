package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pol;

class SOKreirajPacijentaTest {
	SOKreirajPacijenta kreirajPacijenta;
	SOObrisiPacijenta obrisiPacijenta;
	SOUcitajPacijenta ucitajPacijenta;

	@BeforeEach
	void setUp() throws Exception {
		kreirajPacijenta = new SOKreirajPacijenta();
		obrisiPacijenta = new SOObrisiPacijenta();
		ucitajPacijenta = new SOUcitajPacijenta();
	}

	@AfterEach
	void tearDown() throws Exception {
		kreirajPacijenta = null;
		obrisiPacijenta = null;
		ucitajPacijenta = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuIzmeniPacijenta() throws Exception {
		Pacijent novi = new Pacijent();
		novi.setIme("Mirna");
		novi.setPrezime("Krkin");
		novi.setEmail("mirko@gmail.com");
		novi.setPol(Pol.ženski);
		novi.setTelefon("99999999");
		kreirajPacijenta.izvrsiOperaciju(novi);
		assertTrue(kreirajPacijenta.isUspeh() == true);
		ucitajPacijenta.izvrsiOperaciju(novi);
		assertNotNull(ucitajPacijenta.getPacijent());
		assertEquals(novi, (Pacijent) ucitajPacijenta.getPacijent());
		//brisemo
		obrisiPacijenta.izvrsiOperaciju(ucitajPacijenta.getPacijent());
		assertEquals(true, obrisiPacijenta.isUspeh());
	}
	
	
	@Test
	void testUcitajPacijentaNullObjekat() {
		assertThrows(Exception.class, () -> kreirajPacijenta.izvrsiOperaciju(null));
	}

	@Test
	void testUcitajPacijentaLosaKlasa() {
		assertThrows(Exception.class, () -> kreirajPacijenta.izvrsiOperaciju(new Kuvar()));
	}

}
