package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Predstavlja prijemnik (receiver) za obradu zahteva od strane klijenta aplikacije
 * 
 * @author Iva Stanisic
 *
 */
public class Receiver {

	/**
	 * Soket za komunikaciju
	 */
	private final Socket socket;

	/**
	 * Konstruise novu instancu klase i postavlja atribut socket na prosledjenu vrednost
	 * 
	 * @param socket soket za komunikaciju
	 */
	public Receiver(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Vraca soket za komunikaciju preko mreze
	 * 
	 * @return soket za komunikaciju
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * Prima i obradjuje zahtev 
	 * 
	 * @return primljeni objekat sa mreze
	 * 
	 * @throws IOException ako dodje do greske u IO streamu
	 * @throws ClassNotFoundException ako je prosledjena instance pogresne klase
	 */
	public Object primiZahtev() {
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			return in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
//	            System.err.println("Greška pri primanju objekta! "+ex.getMessage());
			return null;
		}
	}
}
