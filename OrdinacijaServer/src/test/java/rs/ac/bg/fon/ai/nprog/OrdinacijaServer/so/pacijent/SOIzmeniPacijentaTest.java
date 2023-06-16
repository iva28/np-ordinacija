package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.pacijent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pol;

class SOIzmeniPacijentaTest {

	SOIzmeniPacijenta izmeniPacijenta;
	SOKreirajPacijenta kreirajPacijenta;
	SOUcitajPacijenta ucitajPacijenta;
	SOObrisiPacijenta obrisiPacijenta;
	SOUcitajListuPacijenata sviPacijenti;
	
	@BeforeEach
	void setUp() throws Exception {
		izmeniPacijenta = new SOIzmeniPacijenta();
		kreirajPacijenta = new SOKreirajPacijenta();
		ucitajPacijenta = new SOUcitajPacijenta();
		obrisiPacijenta = new SOObrisiPacijenta();
		sviPacijenti = new SOUcitajListuPacijenata();
	}

	@AfterEach
	void tearDown() throws Exception {
		izmeniPacijenta = null;
		kreirajPacijenta = null;
		ucitajPacijenta = null;
		obrisiPacijenta = null;
		sviPacijenti = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuIzmeniPacijenta() throws Exception {
		sviPacijenti.izvrsiOperaciju(new Pacijent());
		assertNotNull(sviPacijenti.getLista());
		assertTrue(sviPacijenti.getLista().size() > 0);
		Pacijent novi = new Pacijent();
		novi.setIme("Mirna");
		novi.setPrezime("Krkin");
		novi.setEmail("mirko@gmail.com");
		novi.setPol(Pol.ženski);
		novi.setTelefon("99999999");
		for (OpstaDomenskaKlasa p : sviPacijenti.getLista()){
			assertFalse(novi.equals((Pacijent) p));
		}
		kreirajPacijenta.izvrsiOperaciju(novi);
		assertTrue(kreirajPacijenta.isUspeh() == true);
		ucitajPacijenta.izvrsiOperaciju(novi);
		assertNotNull(ucitajPacijenta.getPacijent());
		assertEquals(novi, (Pacijent) ucitajPacijenta.getPacijent());
		//update
		novi = ucitajPacijenta.getPacijent();
		novi.setPrezime("Mirnin");
		izmeniPacijenta.izvrsiOperaciju(novi);
		assertTrue(izmeniPacijenta.isUspeh());
		//brisemo
		obrisiPacijenta.izvrsiOperaciju(novi);
		assertEquals(true, obrisiPacijenta.isUspeh());
	}
	
	@Test
	void testizvrsiSpecificnuOperacijuIzmeniPacijentaNema() throws Exception {
		sviPacijenti.izvrsiOperaciju(new Pacijent());
		assertNotNull(sviPacijenti.getLista());
		assertTrue(sviPacijenti.getLista().size() > 0);
		int brojPacijenata = sviPacijenti.getLista().size();
		Long poslednjiId = ((Pacijent)sviPacijenti.getLista().get(brojPacijenata-1)).getPacijentId();
		assertThrows(Exception.class,() -> izmeniPacijenta.izvrsiOperaciju(new Pacijent(poslednjiId+1)));
	}
	
	@Test
	void testIzmeniPacijentaNullObjekat() {
		assertThrows(Exception.class, () -> izmeniPacijenta.izvrsiOperaciju(null));
	}

	@Test
	void testIzmeniPacijentaLosaKlasa() {
		assertThrows(Exception.class, () -> izmeniPacijenta.izvrsiOperaciju(new Kuvar()));
	}
}
