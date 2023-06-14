package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.IRepozitorijum;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.TipJela;

class SOKreirajJeloTest {

	SOKreirajJelo kreirajJelo;
	IRepozitorijum<OpstaDomenskaKlasa> repozitorijum;

	@BeforeEach
	void setUp() throws Exception {
		kreirajJelo = new SOKreirajJelo();
		repozitorijum = new DBBroker();
	}

	@AfterEach
	void tearDown() throws Exception {
		kreirajJelo = null;
		repozitorijum = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuNemaJela() throws Exception {
		try {
			Jelo jelo = new Jelo();
			jelo.setNaziv("keleraba slatka");
			jelo.setKolicina(120);
			jelo.setKuvar(new Kuvar(1L, null, null));
			jelo.setTip(new TipJela(2L, ""));
			jelo.setCena(new BigDecimal(340));
			kreirajJelo.izvrsiOperaciju(jelo);
			assertTrue(kreirajJelo.isUspeh() == true);
		} catch (Exception e) {
		}
	}
	
	@Test
	void testizvrsiSpecificnuOperacijuJeloPostoji() throws Exception {
		Jelo jelo = new Jelo();
		jelo.setNaziv("cvekla");
		jelo.setKolicina(20);
		jelo.setKuvar(new Kuvar(1L, null, null));
		jelo.setTip(new TipJela(2L, ""));
		jelo.setCena(new BigDecimal(50));
		assertThrows(Exception.class, () -> kreirajJelo.izvrsiOperaciju(jelo));
	}
	
	@Test
	void testKreirajJeloNullObjekat() {
		assertThrows(Exception.class, () -> kreirajJelo.izvrsiOperaciju(null));
	}
	
	@Test
	void testKreirajJeloLosaKlasa() {
		assertThrows(Exception.class, () -> kreirajJelo.izvrsiOperaciju(new Kuvar()));
	}

}
