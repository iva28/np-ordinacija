package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.jelo.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.jelo.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.pacijent.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.planIshrane.KontrolerKreirajPlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.planIshrane.KontrolerPlanIshranePrikaz;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.planIshrane.KontrolerPretragaPlanaIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent.FrmNoviPacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent.FrmSviPacijenti;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.planIshrane.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

/**
 * Predstavlja koordinatora koji upravlja razlicitim komponentama aplikacije.
 * 
 * Pruza metode za otvaranje formi, kao i pristup kontrolerima.
 * 
 * @author Iva Stanisic
 */
public class Koordinator {
	/**
	 * Predstavlja instancu klase Koordinator
	 */
	private static Koordinator instanca;
	/**
	 * Predstavlja instancu klase KontrolerGlavna
	 */
	private final KontrolerGlavna kontrolerGlavna;
	/**
	 * Mapa u kojoj se cuvaju nutricionista, pacijent i plan ishrane
	 */
	// u ovom nizu ces da cuvas nutricionistu,izabranog pacijenta,plan ishrane
	private final Map<String, Object> parametri;

	/**
	 * Privatni konstruktor koji primenjuje obrazac singleton
	 * 
	 * Kreira instancu klase KontrolerGlavna i inicijalizuje mapu parametri
	 */
	private Koordinator() {
		kontrolerGlavna = new KontrolerGlavna(new FrmGlavna());
		parametri = new HashMap<>();
	}
	 /**
     * Vraca jedinstvenu instancu klase Koordinator
     *
     * @return instanca klase Koordinator
     */
	public static Koordinator vratiInstancu() {
		if (instanca == null) {
			instanca = new Koordinator();
		}
		return instanca;
	}

	/**
	 * Vraca instancu klase KontrolerGlavna
	 *
	 * @return instanca klase KontrolerGlavna
	 */
	public KontrolerGlavna getKontrolerGlavna() {
		return kontrolerGlavna;
	}

	/**
	 * Otvara formu za prijavu nutricioniste
	 * 
	 * Kreira novu instancu klase KontrolerPrijava sa datom formom FrmPrijava i
	 * otvara je
	 */
	public void otvoriLoginFormu() {
		KontrolerPrijava kontrolerPrijava = new KontrolerPrijava(new FrmPrijava());
		kontrolerPrijava.otvoriFormu();
	}

	/**
	 * Otvara glavnu formu aplikacije
	 */
	public void otvoriGlavnuFormu() {
		kontrolerGlavna.otvoriFormu();
	}

	/**
	 * Otvara formu za unos novog pacijenta
	 * 
	 * Kreira novu instancu klase KontrolerNoviPacijent sa datom formom
	 * FrmNoviPacijent i otvara je
	 * 
	 * @param p pacijent
	 */
	public void otvoriFrmNoviPacijent(Pacijent p) {
		KontrolerNoviPacijent kontrolerNoviP = new KontrolerNoviPacijent(
				new FrmNoviPacijent(kontrolerGlavna.getFrmGlavna(), true, p));
		kontrolerNoviP.otvoriFormu();
	}

	/**
	 * Otvara formu za prikaz svih pacijenata
	 * 
	 * Kreira novu instancu klase KontrolerSviPacijenti sa datom formom
	 * FrmSviPacijenti i otvara je
	 */
	public void otvoriFrmSviPacijenti() {
		KontrolerSviPacijenti kontrolerSviPacijenti = new KontrolerSviPacijenti(new FrmSviPacijenti());
		kontrolerSviPacijenti.otvoriFormu();
	}

	/**
	 * Otvara formu za unos novog jela
	 * 
	 * Kreira novu instancu klase KontrolerNovoJelo sa datom formom FrmNovoJelo i
	 * otvara je
	 */
	public void otvoriFrmNovoJelo() {
		KontrolerNovoJelo kontrolerNovoJelo = new KontrolerNovoJelo(
				new FrmNovoJelo(kontrolerGlavna.getFrmGlavna(), true));
		kontrolerNovoJelo.otvoriFormu();
	}

	/**
	 * Otvara formu za pretragu svih jela
	 * 
	 * Kreira novu instancu klase KontrolerPretragaJela sa datom formom
	 * FrmPretragaJela i otvara je
	 */
	public void otvoriFrmPretragaJela() {
		KontrolerPretragaJela kontrolerPretragaJela = new KontrolerPretragaJela(new FrmPretragaJela());
		kontrolerPretragaJela.otvoriFormu();
	}

	/**
	 * Otvara formu za kreiranje novog plana ishrane
	 * 
	 * Kreira novu instancu klase KontrolerKreirajPlanIshrane sa datom formom
	 * FrmKreirajPlanIshrane i otvara je
	 */
	public void otvoriFrmKreirajPlanIshrane() {
		KontrolerKreirajPlanIshrane kontrolerKreirajPI = new KontrolerKreirajPlanIshrane(new FrmKreirajPlanIshrane());
		kontrolerKreirajPI.otvoriFormu();
	}

	/**
	 * Otvara formu za prikaz planova ishrana
	 * 
	 * Kreira novu instancu klase KontrolerPlanIshranePrikaz sa datom formom
	 * FrmPlanIshranePrikaz i otvara je
	 */
	public void otvoriFrmPlanIshranePrikaz() {
		KontrolerPlanIshranePrikaz kontrolerPIPrikaz = new KontrolerPlanIshranePrikaz(new FrmPlanIshranePrikaz());
		kontrolerPIPrikaz.otvoriFormu();
	}

	/**
	 * Otvara formu za pretragu planova ishrana
	 * 
	 * Kreira novu instancu klase KontrolerPretragaPlanaIshrane sa datom formom
	 * FrmPretragaPlanaIshrane i otvara je
	 */
	public void otvoriFrmPretragaPlanaIshrane() {
		KontrolerPretragaPlanaIshrane kontrolerPretragaPlana = new KontrolerPretragaPlanaIshrane(
				new FrmPretragaPlanaIshrane());
		kontrolerPretragaPlana.otvoriFormu();
	}

	/**
	 * Odjavljuje trenutno prijavljenog nutricionistu sa sistema
	 * 
	 * Prvo poziva metodu odjaviSe() iz klase Komunikacija za odjavu sa servera. Ako
	 * odjavljivanje uspe, prikazuje dijalog sa porukom "Uspeh u odjavljivanju sa
	 * sistema!". Nakon toga, otvara formu za prijavu pozivajuci metodu
	 * otvoriLoginFormu(). U slucaju greske prilikom odjavljivanja, ispisuje poruku
	 * o gresci na standardni izlaz. Bez obzira na rezultat odjavljivanja, zatvara
	 * glavnu formu.
	 * 
	 */
	public void odjaviSe() {
		try {
			boolean rez = Komunikacija.vratiInstancu().odjaviSe();
			if (rez) {
				JOptionPane.showMessageDialog(kontrolerGlavna.getFrmGlavna(), "Uspeh u odjavljivanju sa sistema!");
				otvoriLoginFormu();
//                otvoriLoginFormu();
			}
		} catch (Exception ex) {
			System.err.println("Greška u odjavljivanju sa sistema " + ex.getMessage());
//            JOptionPane.showMessageDialog(kontrolerGlavna.getFrmGlavna(), "Greška pri odjavi sa sistema");
		} finally {
			kontrolerGlavna.getFrmGlavna().dispose();
		}
	}

	/**
	 * Dodaje parametar sa datim kljucem i vrednoscu u mapu parametara
	 *
	 * @param kljuc    kljuc parametra koji se dodaje.
	 * @param vrednost vrednost parametra koja se dodaje.
	 */
	public void dodajParametar(String kljuc, Object vrednost) {
		parametri.put(kljuc, vrednost);
	}

	/**
	 * Vraca vrednost parametra sa datim kljucem iz mape parametara
	 *
	 * @param kljuc kljuc parametra cija se vrednost traži.
	 * @return vrednost parametra sa datim kljucem ili null ako parametar ne postoji
	 *         u mapi.
	 */
	public Object uzmiParametar(String kljuc) {
		return parametri.get(kljuc);
	}

}
