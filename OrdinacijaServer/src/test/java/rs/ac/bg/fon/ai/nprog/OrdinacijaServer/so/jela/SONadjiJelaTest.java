package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.so.jela;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Kuvar;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.OpstaDomenskaKlasa;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.TipJela;

class SONadjiJelaTest {

	SONadjiJela nadjiJela;
	Jelo jelo;

	@BeforeEach
	void setUp() throws Exception {
		nadjiJela = new SONadjiJela();
		jelo = new Jelo();
	}

	@AfterEach
	void tearDown() throws Exception {
		nadjiJela = null;
		jelo = null;
	}

	@Test
	void testizvrsiSpecificnuOperacijuPoKuvarima() throws Exception {
		Kuvar k = new Kuvar();
		k.setKuvarId(1L);
		jelo.setKuvar(k);

		nadjiJela.izvrsiOperaciju(jelo);
		assertNotNull(nadjiJela.vratiListu());
		assertNotNull(nadjiJela.vratiListu().size() > 0);
		for (OpstaDomenskaKlasa j : nadjiJela.vratiListu()) {
			assertNotNull(((Jelo) j).getJeloId());
			assertNotNull(((Jelo) j).getTip());
			assertNotNull(((Jelo) j).getNaziv());
			assertNotNull(((Jelo) j).getCena());
			assertNotNull(((Jelo) j).getKolicina());			
			assertEquals(((Jelo) j).getKuvar(), jelo.getKuvar());
		}
	}
	
	@Test
	void testizvrsiSpecificnuOperacijuPoTipovimaJela() throws Exception {
		TipJela tip = new TipJela();
		tip.setTipId(1L);
		jelo.setTip(tip);
		nadjiJela.izvrsiOperaciju(jelo);
		assertNotNull(nadjiJela.vratiListu());
		assertNotNull(nadjiJela.vratiListu().size() > 0);
		for (OpstaDomenskaKlasa j : nadjiJela.vratiListu()) {
			assertNotNull(((Jelo) j).getJeloId());
			assertNotNull(((Jelo) j).getTip());
			assertNotNull(((Jelo) j).getNaziv());
			assertNotNull(((Jelo) j).getCena());
			assertNotNull(((Jelo) j).getKolicina());
			assertNotNull(((Jelo) j).getKuvar());
			assertEquals(((Jelo)j).getTip().getTipId(),jelo.getTip().getTipId());
		}
	}
	
	@Test
	void testUcitajJelaNullObjekat() {
		assertThrows(Exception.class, () -> nadjiJela.izvrsiOperaciju(null));
	}
	
	@Test
	void testUcitajJelaLosaKlasa() {
		assertThrows(Exception.class, () -> nadjiJela.izvrsiOperaciju(new Kuvar()));
	}

}
