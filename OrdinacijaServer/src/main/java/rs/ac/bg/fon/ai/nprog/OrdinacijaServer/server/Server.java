package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.niti.KlijentNit;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.podesavanja.KonekcijaPodaci;

/**
 * Predstavlja serversku nit koja osluskuje dolazne konekcije i upravlja
 * klijentima
 * 
 * Implementira interfejs Thread
 * 
 * @author Iva Stanisic
 */
public class Server extends Thread {
	/**
	 * Predstavlja server socket
	 */
	private ServerSocket serverSocket;
	/**
	 * Predstavlja listu klijenata na serveru
	 */
	private List<KlijentNit> klijenti;

	/**
	 * Konstruktor klase Server
	 * 
	 * Inicijalizuje serverski soket i listu klijent niti. Port za server soket se
	 * čita iz konfiguracionog fajla preko klase KonekcijaPodaci.
	 */
	public Server() {
		int port = Integer.parseInt(KonekcijaPodaci.vratiInstancu().vratiProperti("port"));
		try {
			serverSocket = new ServerSocket(port);
			klijenti = new ArrayList<>();
			System.out.println("Server je pokrenut na portu " + port + "...");
		} catch (IOException ex) {
			System.err.println("Problem u pokretanju servera! " + ex.getMessage());
		}
	}

	/**
	 * Vraca objekat klase ServerSocket koji predstavlja server soket
	 *
	 * @return Objekat klase ServerSocket koji predstavlja server soket
	 */
	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	@Override
	public void run() {
		while (!serverSocket.isClosed()) {
			try {
				Socket socket = serverSocket.accept();
				int i = klijenti.size() + 1;
				System.out.println("Klijent: " + i + " se povezao! :)\n");
				obradaKlijentskogZahteva(socket);
			} catch (SocketException ex) {
				System.err.println("Server je zaustavljen!");
			} catch (Exception e) {
			}

		}
	}
	/**
	 * Obradjuje zahteve klijenta.
	 *
	 * @param socket Socket koji predstavlja konekciju sa klijentom
	 */
	private void obradaKlijentskogZahteva(Socket socket) {
		KlijentNit klijentNit = new KlijentNit(socket);
		klijentNit.start();
		klijenti.add(klijentNit);
	}
	/**
	 * Zatvara serverski soket
	 * 
	 * Prvo se proverava da li je serverski soket vec zatvoren, a zatim se iterira kroz listu klijenata i zatvaraju se njihovi soketi.
	 * Nakon toga, serverski soket se zatvara.
	 * U slucaju greske prilikom zatvaranja soketa klijenta ili serverskog soketa, ispisuje se odgovarajuca poruka.
	 */
	public void zatvoriServerskiSoket() {
		try {
			if (serverSocket.isClosed()) {
				return;
			}
			for (KlijentNit kn : klijenti) {
				try {
					kn.getSoket().close();
					System.out.println("Klijent se odpovezao jer se server zatvorio");
				} catch (IOException ex) {
					System.err.println("Problem u zatvaranju soketa klijenta! " + ex.getMessage());
				}
			}
			serverSocket.close();
			System.out.println("Server soket se zatvorio..");
		} catch (Exception e) {
			System.err.println("Server ne može da se zatvori\n" + e.getMessage());
		}
	}

}
