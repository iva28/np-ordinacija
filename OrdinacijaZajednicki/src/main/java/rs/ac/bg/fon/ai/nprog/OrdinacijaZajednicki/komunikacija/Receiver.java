package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {

	 private final Socket socket;

	    public Receiver(Socket socket) {
	        this.socket = socket;
	    }

	    public Socket getSocket() {
	        return socket;
	    }

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
