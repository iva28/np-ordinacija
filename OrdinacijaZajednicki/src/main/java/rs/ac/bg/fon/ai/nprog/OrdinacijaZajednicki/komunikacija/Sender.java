package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Predstavlja posiljaoca (sender) za slanje zahteva do klijenta aplikacije
 * 
 * @author Iva Stanisic
 *
 */
public class Sender {
	/**
	 * Soket za komunikaciju preko mreze
	 */
	private final Socket socket;

	/**
	 * Konstruise novu instancu klase i postavlja atribut socket na prosledjenu
	 * vrednost
	 * 
	 * @param socket soket za komunikaciju
	 */
	public Sender(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Vraca soket preko koga se obavlja komunikacija preko mreze
	 * 
	 * @return soket za komunikaciju
	 */
	public Socket getSocket() {
		return socket;
	}
 /**
  * Salje zahtev preko mreze
  * 
  * @param object objekat koji se salje
  *  
  * @throws SocketException ako dodje do greske soketa
  * @throws IOException ako dodje do greske u IO streamu
  * @throws NullPointerException ako nije prosledjen objekat object
  */
	public void posaljiZahtev(Object object) throws SocketException, IOException {
		try {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(object);
			out.flush();
		} catch (NullPointerException ne) {
			System.err.println(ne.getMessage());
		}
	}

}
