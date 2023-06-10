package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.niti;

import java.net.Socket;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.koordinator.KoordinatorS;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.kontroler.Kontroler;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija.Receiver;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija.Sender;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.transfer.*;

/**
 * Nit koja predstavlja komunikaciju sa jednim klijentom
 * 
 * Svaki nutricionista pri prijavljivanju na sistem dobija svoju nit
 * 
 * @author Iva Stanisic
 */
public class KlijentNit extends Thread {

	/**
	 * Predstavlja soket koji se koristi za komunikaciju sa klijentom
	 */
	private final Socket soket;
	/**
	 * Predstavlja objekat Receiver koji se koristi za primanje poruka klijenta
	 */
	private final Receiver receiver;
	/**
	 * Predstavlja objekat Sender koji se koristi za slanje poruka klijentu
	 */
	private final Sender sender;

	/**
	 * Predstavlja administratora sistema
	 */
	private Nutricionista administrator;

	/**
	 * Vraca nutricionistu koji predstavlja administratora sistema
	 * 
	 * @return administrator nutricionista koji predstavlja administratora
	 */
	public Nutricionista getAdministrator() {
		return administrator;
	}

	/**
	 * Konstruktor za inicijalizaciju klase KlijentNit
	 * 
	 * @param soket Soket koji se koristi za komunikaciju sa klijentom
	 */
	public KlijentNit(Socket soket) {
		this.soket = soket;
		receiver = new Receiver(soket);
		sender = new Sender(soket);
	}

	/**
	 * Vraca soket koji se koristi za komunikaciju sa klijentom
	 * 
	 * @return Objekat Socket koji predstavlja soket za komunikaciju
	 */
	public Socket getSoket() {
		return soket;
	}

	/**
	 * Pokrece izvrsavanje klijentske niti
	 * 
	 * Tokom izvrsavanja niti, prihvata zahteve od klijenta i vrsi odgovarajuce operacije. 
	 * Ukoliko se soket zatvori, nit se zaustavlja.
	 */
	@Override
	public void run() {
		while (!soket.isClosed()) {
			try {
				Zahtev zahtev = (Zahtev) receiver.primiZahtev();
				Odgovor odgovor = new Odgovor();
				try {
					switch (zahtev.getOperacija()) {
					case PRIJAVI_SE:
						Nutricionista nutricionistaPrijava = (Nutricionista) zahtev.getObjekat();
						nutricionistaPrijava = Kontroler.vratiInstancu().prijaviSe(nutricionistaPrijava);
						if (nutricionistaPrijava != null) {
							this.administrator = nutricionistaPrijava;
							boolean aktivan = KoordinatorS.vratiInstancu().vecJeUlogovan(nutricionistaPrijava);
							if (aktivan) {
								odgovor.setRezultat(new Nutricionista(-1L));
							} else {
								KoordinatorS.vratiInstancu().getAktivniKorisnici().add(this);
								KoordinatorS.vratiInstancu().getKontrolerPokreniServer()
										.dodajNutricionistu(nutricionistaPrijava);
								odgovor.setRezultat(nutricionistaPrijava);
							}
						} else {
							odgovor.setRezultat(null);
						}
						break;
					case ODJAVI_SE:
						Nutricionista nutricionistaOdjava = (Nutricionista) zahtev.getObjekat();
						boolean rezultatOdjave = KoordinatorS.vratiInstancu().odjaviSe(nutricionistaOdjava);
						if (rezultatOdjave) {
							KoordinatorS.vratiInstancu().getAktivniKorisnici().remove(this);
						}
						odgovor.setRezultat(rezultatOdjave);
						break;
					case VRATI_NUTRICIONISTE:
						List<OpstaDomenskaKlasa> listaSviNutricionisti = Kontroler.vratiInstancu()
								.ucitajListuNutricionista();
						odgovor.setRezultat(listaSviNutricionisti);
						break;
					case SVI_PACIJENTI:
						List<OpstaDomenskaKlasa> listaSviPacijenti = Kontroler.vratiInstancu().ucitajListuPacijenata();
						odgovor.setRezultat(listaSviPacijenti);
						break;
					case KREIRAJ_PACIJENTA:
						Pacijent pacijentNovi = (Pacijent) zahtev.getObjekat();
						boolean rezultatKreiranjaPacijenta = Kontroler.vratiInstancu().kreirajPacijenta(pacijentNovi);
						odgovor.setRezultat(rezultatKreiranjaPacijenta);
						break;
					case OBRISI_PACIJENTA:
						Pacijent pacijentObrisi = (Pacijent) zahtev.getObjekat();
						boolean rezultatBrisanjaPacijenta = Kontroler.vratiInstancu().obrisiPacijenta(pacijentObrisi);
						odgovor.setRezultat(rezultatBrisanjaPacijenta);
						break;
					case IZMENI_PACIJENTA:
						Pacijent pacijentIzmena = (Pacijent) zahtev.getObjekat();
						boolean rezultatIzmenePacijenta = Kontroler.vratiInstancu().izmeniPacijenta(pacijentIzmena);
						odgovor.setRezultat(rezultatIzmenePacijenta);
						break;
					case NADJI_PACIJENTE:
						Pacijent pacijentUslov = (Pacijent) zahtev.getObjekat();
						List<OpstaDomenskaKlasa> listaNadjenihPacijenata = Kontroler.vratiInstancu()
								.nadjiPacijente(pacijentUslov);
						odgovor.setRezultat(listaNadjenihPacijenata);
						break;
					case UCITAJ_PACIJENTA:
						Pacijent pacijentUcitaj = (Pacijent) zahtev.getObjekat();
						pacijentUcitaj = Kontroler.vratiInstancu().ucitajPacijenta(pacijentUcitaj);
						odgovor.setRezultat(pacijentUcitaj);
						break;
					case VRATI_TIP_JELA:
						List<OpstaDomenskaKlasa> listaSviTipoviJela = Kontroler.vratiInstancu().ucitajTipoveJela();
						odgovor.setRezultat(listaSviTipoviJela);
						break;
					case VRATI_KUVARE:
						List<OpstaDomenskaKlasa> listaSviKuvari = Kontroler.vratiInstancu().ucitajKuvare();
						odgovor.setRezultat(listaSviKuvari);
						break;
					case KREIRAJ_JELO:
						Jelo jeloKreiraj = (Jelo) zahtev.getObjekat();
						boolean rezultatKreirajJelo = Kontroler.vratiInstancu().kreirajJelo(jeloKreiraj);
						odgovor.setRezultat(rezultatKreirajJelo);
						break;
					case VRATI_JELA:
						List<OpstaDomenskaKlasa> listaSvaJela = Kontroler.vratiInstancu().ucitajListuJela();
						odgovor.setRezultat(listaSvaJela);
						break;
					case NADJI_JELA:
						Jelo jeloUslov = (Jelo) zahtev.getObjekat();
						List<OpstaDomenskaKlasa> listaNadjiJela = Kontroler.vratiInstancu().nadjiJela(jeloUslov);
						odgovor.setRezultat(listaNadjiJela);
						break;
					case KREIRAJ_PLAN_ISHRANE:
						PlanIshrane planKreiraj = (PlanIshrane) zahtev.getObjekat();
						boolean rezultatKreirajPlan = Kontroler.vratiInstancu().kreirajPlanIshrane(planKreiraj);
						odgovor.setRezultat(rezultatKreirajPlan);
						break;
					case VRATI_PLANOVE:
						List<OpstaDomenskaKlasa> listaSviPlanovi = Kontroler.vratiInstancu().ucitajListuPlanova();
						odgovor.setRezultat(listaSviPlanovi);
						break;
					case NADJI_PLAN_ISHRANE:
						PlanIshrane planUslov = (PlanIshrane) zahtev.getObjekat();
						List<OpstaDomenskaKlasa> listaNadjiPlanove = Kontroler.vratiInstancu().nadjiPlanove(planUslov);
						odgovor.setRezultat(listaNadjiPlanove);
						break;
					case UCITAJ_PLAN_ISHRANE:
						PlanIshrane planUcitaj = (PlanIshrane) zahtev.getObjekat();
						planUcitaj = Kontroler.vratiInstancu().ucitajPlanIshrane(planUcitaj);
						odgovor.setRezultat(planUcitaj);
						break;
					case OBRISI_PLAN_ISHRANE:
						PlanIshrane planObrisi = (PlanIshrane) zahtev.getObjekat();
						boolean rezultatObrisiPlan = Kontroler.vratiInstancu().obrisiPlan(planObrisi);
						odgovor.setRezultat(rezultatObrisiPlan);
						break;
					case IZMENI_PLAN_ISHRANE:
						PlanIshrane planIzmena = (PlanIshrane) zahtev.getObjekat();
						boolean rezultatIzmenaPlana = Kontroler.vratiInstancu().izmeniPlanIshrane(planIzmena);
						odgovor.setRezultat(rezultatIzmenaPlana);
						break;
					}
				} catch (Exception ex) {
					odgovor.setException(ex);
				}
				sender.posaljiZahtev(odgovor);
			} catch (Exception e) {
			}
		}
	}

}
