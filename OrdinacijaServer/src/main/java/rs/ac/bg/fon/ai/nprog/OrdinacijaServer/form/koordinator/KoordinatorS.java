package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.koordinator;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.FrmGlavna;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.FrmKonfiguracijaKonekcije;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.kontroler.KontrolerKonfiguracijaKonekcije;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.kontroler.KontrolerPokreniServer;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.niti.KlijentNit;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;

/**
 * Predstavlja koordinator servera.
 *
 * Ova klasa implementira singleton pattern, sto znaci da moze postojati samo
 * jedna instanca klase. Sluzi za upravljanje aktivnim korisnicima servera i
 * komunikaciju sa kontrolerima.
 * 
 * @author Iva Stanisic
 */
public class KoordinatorS {

	/**
	 * Predstavlja instancu klase KoordinatorS 
	 */
	private static KoordinatorS instanca;
	/**
	 * Predstavlja kontrolera za pokretanje servera
	 */
	private final KontrolerPokreniServer kontrolerPokreniServer;
	/**
	 * Predstavlja listu aktivnih korisnika servera
	 */
	private List<KlijentNit> aktivniKorisnici;

	/**
	 * Privatni konstruktor klase KoordinatorS
	 * 
	 * Inicijalizuje kontrolerPokreniServer i listu aktivnih korisnika
	 */
	private KoordinatorS() {
		kontrolerPokreniServer = new KontrolerPokreniServer(new FrmGlavna());
		aktivniKorisnici = new ArrayList<>();
	}

	/**
	 * Vraca listu aktivnih korisnika servera
	 *
	 * @return Lista aktivnih korisnika servera
	 */
	public List<KlijentNit> getAktivniKorisnici() {
		return aktivniKorisnici;
	}

	/**
	 * Postavlja listu aktivnih korisnika servera
	 *
	 * @param aktivniKorisnici Lista aktivnih korisnika servera
	 */
	public void setAktivniKorisnici(List<KlijentNit> aktivniKorisnici) {
		this.aktivniKorisnici = aktivniKorisnici;
	}

	/**
	 * Vraca instancu klase KoordinatorS
	 * 
	 * Implementirana je kao singleton
	 *
	 * @return Instanca klase KoordinatorS.
	 */
	public static KoordinatorS vratiInstancu() {
		if (instanca == null) {
			instanca = new KoordinatorS();
		}
		return instanca;
	}

	/**
	 * Vraca kontroler za pokretanje servera
	 *
	 * @return KontrolerPokreniServer kontroler za pokretanje servera
	 */
	public KontrolerPokreniServer getKontrolerPokreniServer() {
		return kontrolerPokreniServer;
	}

	/**
	 * Otvara glavnu formu na server strani
	 */
	public void otvoriServerFormu() {
		kontrolerPokreniServer.otvoriFormu();
	}
	/**
     * Otvara formu za konfiguraciju konekcije
     */
	public void otvoriFormuKonfiguracijeKonekcije() {
		KontrolerKonfiguracijaKonekcije kontrolerKonekcije = new KontrolerKonfiguracijaKonekcije(
				new FrmKonfiguracijaKonekcije(kontrolerPokreniServer.getFrmGlavna(), true));
		kontrolerKonekcije.otvoriFormu();
	}
	/**
	 * Proverava da li je odredjeni nutricionista vec ulogovan
	 *
	 * @param n Nutricionista koji se proverava
	 * @return true ako je nutricionista vec ulogovan, false inace
	 */
	public boolean vecJeUlogovan(Nutricionista n) {
		for (KlijentNit klijent : aktivniKorisnici) {
			if (klijent.getAdministrator().equals(n)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Odjavljuje nutricionistu sa servera
	 *
	 * @param nutricionista Nutricionista koji se odjavljuje
	 * @return true ako je nutricionista uspesno odjavljen, false inace
	 */
	public boolean odjaviSe(Nutricionista nutricionista) {
		for (KlijentNit klijent : aktivniKorisnici) {
			if (nutricionista.equals(klijent.getAdministrator())) {
				kontrolerPokreniServer.odjavaNutricioniste(nutricionista);
				return true;
			}
		}
		return false;
	}
	/**
	 * Dodaje klijenta nutricionistu na server
	 *
	 * @param n Nutricionista koji se dodaje
	 */
	public void dodajKlijentaNutricionistu(Nutricionista n) {
		kontrolerPokreniServer.dodajNutricionistu(n);
	}

}
