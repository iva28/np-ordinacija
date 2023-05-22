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
 *
 * @author Iva
 */
public class Komunikacija {

    private static Komunikacija instance;
    private Socket soket;
    private Sender sender;
    private Receiver receiver;

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

    public static Komunikacija vratiInstancu() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Socket getSoket() {
        return soket;
    }

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

    public boolean odjaviSe() throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.ODJAVI_SE, Koordinator.vratiInstancu().uzmiParametar(Konstante.NUTRICIONISTA));
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

    private void zatvoriKlijentaZaustavljenServer() {
        JOptionPane.showMessageDialog(null, "Server je zatvoren!", "PREKID", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

}
