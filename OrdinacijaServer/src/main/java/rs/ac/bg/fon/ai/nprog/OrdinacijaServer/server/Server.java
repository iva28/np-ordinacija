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
 *
 * @author iva
 */
public class Server extends Thread {

    private ServerSocket serverSocket;
    private List<KlijentNit> klijenti;

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

    private void obradaKlijentskogZahteva(Socket socket) {
        KlijentNit klijentNit = new KlijentNit(socket);
        klijentNit.start();
        klijenti.add(klijentNit);
    }

    public void zatvoriServerskiSoket() {
        try {
            if (serverSocket.isClosed()){
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
