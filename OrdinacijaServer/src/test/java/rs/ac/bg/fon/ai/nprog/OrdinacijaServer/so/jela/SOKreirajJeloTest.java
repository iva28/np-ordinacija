package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.IRepozitorijum;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.KonekcijaSaBazom;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.repozitorijum.db.impl.DBBroker;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.TipJela;

class SOKreirajJeloTest {

	SOKreirajJelo kreirajJelo;
	SOUcitajListuJela svaJela;
	IRepozitorijum<OpstaDomenskaKlasa> repozitorijum;

	@BeforeEach
	void setUp() throws Exception {
		kreirajJelo = new SOKreirajJelo();
		svaJela = new SOUcitajListuJela();
		repozitorijum = new DBBroker();
	}

	@AfterEach
	void tearDown() throws Exception {
		kreirajJelo = null;
		svaJela = null;
		repozitorijum = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuNemaJela() throws Exception {
		svaJela.izvrsiOperaciju(new Jelo());
		assertNotNull(svaJela.vratiListu());
		assertTrue(svaJela.vratiListu().size() > 0);
		Jelo jelo = new Jelo();
		jelo.setNaziv("kelerabilic");
		jelo.setKolicina(120);
		jelo.setKuvar(new Kuvar(1L, null, null));
		jelo.setTip(new TipJela(2L, ""));
		jelo.setCena(new BigDecimal(340));
		for (OpstaDomenskaKlasa p : svaJela.vratiListu()) {
			assertFalse(jelo.equals((Jelo) p));
		}
		kreirajJelo.izvrsiOperaciju(jelo);
		assertTrue(kreirajJelo.isUspeh());
		List<OpstaDomenskaKlasa> lista = repozitorijum.svi(new Jelo());
		assertNotNull(lista);
		assertTrue(lista.size() > 0);
		for (OpstaDomenskaKlasa o : lista) 
			if (((Jelo) o).equals(jelo)) {
				KonekcijaSaBazom.getInstanca().otvoriKonekciju();
				repozitorijum.obrisi((Jelo) o);
				KonekcijaSaBazom.getInstanca().potvrdiTransakciju();

			}
	}

	@Test
	void testizvrsiSpecificnuOperacijuJeloPostoji() throws Exception {
		svaJela.izvrsiOperaciju(new Jelo());
		assertNotNull(svaJela.vratiListu());
		assertTrue(svaJela.vratiListu().size() > 0);
		assertThrows(Exception.class, () -> kreirajJelo.izvrsiOperaciju(svaJela.vratiListu().get(0)));
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
