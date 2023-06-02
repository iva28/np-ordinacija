package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija.Receiver;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija.Sender;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.konstante.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.operacije.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.podesavanja.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.transfer.*;

/**
 * Klasa za komunikaciju sa serverskom stranom aplikacije
 * 
 * @author Iva Stanisic
 */
public class Komunikacija {
	/**
	 * Instanca komunikacije (singleton pattern).
	 */
	private static Komunikacija instance;
	/**
	 * Socket za komunikaciju sa serverom
	 */
	private Socket soket;
	/**
	 * Za slanje poruka serveru
	 */
	private Sender sender;
	/**
	 * Za primanje poruka sa serverom
	 */
	private Receiver receiver;

	/**
	 * Privatni konstruktor koji inicijalizuje komunikaciju sa serverom
	 * 
	 * Kreira socket i sender i receiver objekte za slanje i primanje poruka
	 * 
	 * @throws IOException u slucaju greske prilikom uspostavljanja veze sa serverom
	 */
	private Komunikacija() {
		String adresa = KonekcijaPodaci.vratiInstancu().vratiProperti("adresa");
		int port = Integer.parseInt(KonekcijaPodaci.vratiInstancu().vratiProperti("port"));
		try {
			this.soket = new Socket(adresa, port);
			this.sender = new Sender(soket);
			this.receiver = new Receiver(soket);
			System.out.println("Povezao se sa serverom");
		} catch (IOException ex) {
			System.out.println("Greška u klijentskoj aplikaciji pri povezivanju sa serverom!\n");
		}
	}

	/**
	 * Vraca instancu objekta Komunikacija (singleton pattern).
	 *
	 * @return instanca objekta Komunikacija
	 */
	public static Komunikacija vratiInstancu() {
		if (instance == null) {
			instance = new Komunikacija();
		}
		return instance;
	}

	/**
	 * Vraca objekat Sender koji se koristi za slanje poruka serveru
	 *
	 * @return Objekat Sender za slanje poruka
	 */
	public Sender getSender() {
		return sender;
	}

	/**
	 * Vraca objekat Receiver koji se koristi za primanje poruka od servera
	 *
	 * @return Objekat Receiver za primanje poruka
	 */

	public Receiver getReceiver() {
		return receiver;
	}

	/**
	 * Vraca soket preko koga se razmenjuju informacije preko mreze
	 * 
	 * @return soket preko kojeg se komunicira izmedju klijenta i servera
	 */
	public Socket getSoket() {
		return soket;
	}

	/**
	 * Prijavljuje nutricionistu na serveru sa datim korisnickim imenom i lozinkom
	 *
	 * @param username Korisnicko ime nutricioniste
	 * @param password Lozinka nutricioniste
	 * @return Nutricionista koji je prijavljen na serveru
	 * @throws Exception U slučaju greske prilikom prijavljivanja
	 */
	public Nutricionista login(String username, String password) throws Exception {
		if (soket == null) {
			zatvoriKlijentaZaustavljenServer();
		}
		Nutricionista n = new Nutricionista();
		n.setUsername(username);
		n.setPassword(password);
		Zahtev zahtev = new Zahtev(Operacije.PRIJAVI_SE, n);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (Nutricionista) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException e) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}

	}

	/**
	 * Ucitava listu pacijenata sa servera
	 *
	 * @return Lista pacijenata
	 * @throws Exception U slucaju greske prilikom ucitavanja
	 */
	public List<Pacijent> ucitajListuPacijenata() throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.SVI_PACIJENTI, null);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<Pacijent>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Kreira novog pacijenta na serveru
	 *
	 * @param p Pacijent koji se kreira
	 * @return {@code true} ako je pacijent uspesno kreiran, {@code false} ako nije
	 * @throws Exception U slucaju greske prilikom kreiranja pacijenta
	 */
	public boolean kreirajPacijenta(Pacijent p) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_PACIJENTA, p);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}

	/**
	 * Brise pacijenta sa servera
	 *
	 * @param p Pacijent koji se brise
	 * @return {@code true} ako je pacijent uspesno obrisan, {@code false} ako nije
	 * @throws Exception U slucaju greske prilikom brisanja pacijenta
	 */
	public boolean obrisiPacijenta(Pacijent p) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.OBRISI_PACIJENTA, p);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}

	/**
	 * Izmenjuje podatke o pacijentu na serveru
	 *
	 * @param p Pacijent ciji se podaci menjaju
	 * @return {@code true} ako su podaci o pacijentu uspesno izmenjeni,
	 *         {@code false} ako nije
	 * @throws Exception U slusaju greske prilikom izmene podataka o pacijentu
	 */
	public boolean izmeniPacijenta(Pacijent p) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.IZMENI_PACIJENTA, p);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}

	/**
	 * Pronalazi pacijente sa datim imenom na serveru
	 *
	 * @param ime Ime pacijenta koji se trazi
	 * @return Lista pacijenata sa datim imenom
	 * @throws Exception U slucaju greske prilikom pretrage pacijenata
	 */
	public List<Pacijent> nadjiPacijente(String ime) throws Exception {
		Pacijent p = new Pacijent();
		p.setIme(ime);
		Zahtev zahtev = new Zahtev(Operacije.NADJI_PACIJENTE, p);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<Pacijent>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Vraca sve tipove jela sa servera.
	 *
	 * @return Lista svih tipova jela
	 * @throws Exception U slucaju greske pri preuzimanju tipova jela
	 */
	public List<TipJela> vratiTipoveJela() throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.VRATI_TIP_JELA, null);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<TipJela>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Vraca sve kuvare na serveru
	 *
	 * @return Lista svih kuvara
	 * @throws Exception U slucaju greske pri preuzimanju kuvara
	 */
	public List<Kuvar> vratiKuvare() throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.VRATI_KUVARE, null);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<Kuvar>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Cuva informacije o jelu na serveru
	 *
	 * @param jelo Jelo koje se cuva
	 * @return {@code true} ako je jelo uspesno sacuvano, {@code false} ako nije
	 * @throws Exception U slucaju greske pri cuvanju jela
	 */
	public boolean sacuvajJelo(Jelo jelo) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_JELO, jelo);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}

	/**
	 * Vraca sva jela sa servera.
	 *
	 * @return Lista svih jela
	 * @throws Exception U slucaju greske pri preuzimanju jela
	 */
	public List<Jelo> vratiJela() throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.VRATI_JELA, null);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<Jelo>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Pretrazuje jela na serveru na osnovu zadatih kriterijuma
	 *
	 * @param jelo Jelo sa zadatim kriterijumima pretrage
	 * @return Lista pronadjenih jela
	 * @throws Exception U slucaju greske pri pretrazi jela
	 */
	public List<Jelo> nadjiJela(Jelo jelo) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.NADJI_JELA, jelo);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<Jelo>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Kreira novi plan ishrane na serveru
	 *
	 * @param plan Plan ishrane koji se kreira
	 * @return {@code true} ako je plan ishrane uspesno kreiran, {@code false} ako
	 *         nije
	 * @throws Exception U slucaju greske pri kreiranju plana ishrane
	 */
	public boolean kreirajPlanIshrane(PlanIshrane plan) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_PLAN_ISHRANE, plan);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}

	/**
	 * Ucitava listu planova ishrane sa servera
	 *
	 * @return Lista svih planova ishrane
	 * @throws Exception U slucaju greske pri preuzimanju planova ishrane
	 */
	public List<PlanIshrane> ucitajListuPlanova() throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.VRATI_PLANOVE, null);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<PlanIshrane>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Odjavljuje ulogovanog nutricionistu sa servera
	 *
	 * @return {@code true} ako je odjavljivanje uspesno, {@code false} ako nije
	 * @throws Exception U slucaju greske pri odjavljivanju
	 */
	public boolean odjaviSe() throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.ODJAVI_SE,
				Koordinator.vratiInstancu().uzmiParametar(Konstante.NUTRICIONISTA));
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}

	/**
	 * Pronalazi planove ishrane na serveru koji odgovaraju kriterijumu
	 *
	 * @param plan Plan ishrane koji se koristi za pretragu
	 * @return Lista pronadjenih planova ishrane
	 * @throws Exception U slucaju greske pri pretrazi planova ishrane
	 */
	public List<PlanIshrane> nadjiPlanove(PlanIshrane plan) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.NADJI_PLAN_ISHRANE, plan);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<PlanIshrane>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}

	/**
	 * Brise plan ishrane sa servera
	 *
	 * @param plan Plan ishrane koji se brise
	 * @return {@code true} ako je plan ishrane uspesno obrisan, {@code false} ako
	 *         nije
	 * @throws Exception U slucaju greske pri brisanju plana ishrane
	 */
	public boolean obrisiPlan(PlanIshrane plan) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.OBRISI_PLAN_ISHRANE, plan);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}

	/**
	 * Azurira plan ishrane na serveru
	 *
	 * @param p Plan ishrane koji se azurira
	 * @return {@code true} ako je plan ishrane uspešno azuriran, {@code false} ako nije.
	 * @throws Exception U slucaju greske pri azuriranju plana ishrane
	 */
	public boolean azurirajPlan(PlanIshrane p) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.IZMENI_PLAN_ISHRANE, p);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (boolean) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return false;
		}
	}
	/**
	 * Ucitava listu nutricionista sa servera
	 *
	 * @return Lista nutricionista
	 * @throws Exception U slucaju greske pri ucitavanju liste nutricionista
	 */
	public List<Nutricionista> ucitajListuNutricionista() throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.VRATI_NUTRICIONISTE, null);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (List<Nutricionista>) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}
	/**
	 * Ucitava pacijenta sa servera
	 *
	 * @param selektovan Pacijent koji se ucitava
	 * @return Ucitani pacijent
	 * @throws Exception U slucaju greske pri ucitavanju pacijenta
	 */
	public Pacijent ucitajPacijenta(Pacijent selektovan) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.UCITAJ_PACIJENTA, selektovan);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (Pacijent) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}
	/**
	 * Ucitava plan ishrane sa servera
	 *
	 * @param plan Plan ishrane koji se ucitava
	 * @return Ucitani plan ishrane
	 * @throws Exception U slucaju greske pri ucitavanju plana ishrane
	 */
	public PlanIshrane ucitajPlanIshrane(PlanIshrane plan) throws Exception {
		Zahtev zahtev = new Zahtev(Operacije.UCITAJ_PLAN_ISHRANE, plan);
		try {
			sender.posaljiZahtev(zahtev);
			Odgovor odgovor = (Odgovor) receiver.primiZahtev();
			if (odgovor.getException() == null) {
				return (PlanIshrane) odgovor.getRezultat();
			} else {
				throw odgovor.getException();
			}
		} catch (SocketException se) {
			zatvoriKlijentaZaustavljenServer();
			return null;
		}
	}
	/**
	 * Zatvara klijenta u slucaju da je server zatvoren
	 */
	private void zatvoriKlijentaZaustavljenServer() {
		JOptionPane.showMessageDialog(null, "Server je zatvoren!", "PREKID", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}

}
