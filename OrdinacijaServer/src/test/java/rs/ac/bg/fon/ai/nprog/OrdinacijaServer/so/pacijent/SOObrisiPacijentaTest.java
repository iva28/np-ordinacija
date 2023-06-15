package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.IRepozitorijum;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pol;

class SOObrisiPacijentaTest {

	SOObrisiPacijenta obrisiPacijenta;
	SOKreirajPacijenta kreirajPacijenta;
	SOUcitajPacijenta ucitajPacijenta;

	@BeforeEach
	void setUp() throws Exception {
		obrisiPacijenta = new SOObrisiPacijenta();
		kreirajPacijenta = new SOKreirajPacijenta();
		ucitajPacijenta = new SOUcitajPacijenta();
	}

	@AfterEach
	void tearDown() throws Exception {
		obrisiPacijenta = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuObrisiPacijenta() throws Exception {
		Pacijent novi = new Pacijent();
		novi.setIme("Mirna");
		novi.setPrezime("Mirov");
		novi.setEmail("mirkov@gmail.com");
		novi.setPol(Pol.muški);
		novi.setTelefon("99999999");
		kreirajPacijenta.izvrsiOperaciju(novi);
		assertTrue(kreirajPacijenta.isUspeh() == true);
		ucitajPacijenta.izvrsiOperaciju(novi);
		assertNotNull(ucitajPacijenta.getPacijent());
		assertEquals(novi, (Pacijent) ucitajPacijenta.getPacijent());
		obrisiPacijenta.izvrsiOperaciju(ucitajPacijenta.getPacijent());
		assertEquals(true, obrisiPacijenta.isUspeh());
	}

//	@Test
//	void testizvrsiSpecificnuOperacijuObrisiPacijentaNema() throws Exception {
//			Pacijent novi = new Pacijent();
//			assertThrows(Exception.class, () -> obrisiPacijenta.izvrsiOperaciju(novi));
//	}

	@Test
	void testUcitajPacijentaNullObjekat() {
		assertThrows(Exception.class, () -> obrisiPacijenta.izvrsiOperaciju(null));
	}

	@Test
	void testUcitajPacijentaLosaKlasa() {
		assertThrows(Exception.class, () -> obrisiPacijenta.izvrsiOperaciju(new Kuvar()));
	}
}
