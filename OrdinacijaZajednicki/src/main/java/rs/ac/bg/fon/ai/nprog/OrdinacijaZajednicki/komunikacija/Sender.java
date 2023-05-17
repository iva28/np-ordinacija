package rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class Sender {
	private final Socket socket;

	public Sender(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

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
