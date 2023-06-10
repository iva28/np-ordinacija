package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.kontroler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.FrmGlavna;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.koordinator.KoordinatorS;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.model.ModelTabeleLogovani;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.server.Server;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;

/**
 * Predstavlja kontrolera za pokretanje servera
 *
 * @author Iva Stanisic
 */
public class KontrolerPokreniServer {
	/**
	 * Glavna forma aplikacije
	 */
	private final FrmGlavna frmGlavna;
	/**
	 * Instanca servera
	 */
	Server server;

	/**
	 * Vraca glavnu formu server dela aplikacije
	 *
	 * @return Glavna forma server dela aplikacije
	 */
	public FrmGlavna getFrmGlavna() {
		return frmGlavna;
	}

	/**
	 * Vraca instancu servera
	 *
	 * @return server Instanca servera
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * Konstruktor koji inicijalizuje kontroler
	 *
	 * @param frmMain Glavna forma server dela aplikacije
	 */
	public KontrolerPokreniServer(FrmGlavna frmMain) {
		this.frmGlavna = frmMain;
		addActionListeners();
	}

	/**
	 * Otvara formu glavne aplikacije i priprema je za prikaz
	 */
	public void otvoriFormu() {
		pripremiFormu();
		frmGlavna.pack();
		frmGlavna.setVisible(true);
	}

	/**
	 * Priprema formu glavne aplikacije i postavlja pocetno stanje komponenata na
	 * formi
	 * 
	 */
	private void pripremiFormu() {
		frmGlavna.getBtnStop().setEnabled(false);
		frmGlavna.getLblServer().setText("Server nije pokrenut..");
		frmGlavna.getLblServer().setForeground(Color.red);
		pripremiTabele();
	}

	/**
	 * Priprema tabela za prikaz svih i trenutno ulogovanih nutricionista
	 * 
	 */
	private void pripremiTabele() {
		frmGlavna.getTblLogovani().setModel(new ModelTabeleLogovani());
		frmGlavna.getTblLogovani().setEnabled(false);

		frmGlavna.getTblAktivni().setModel(new ModelTabeleLogovani());
		frmGlavna.getTblAktivni().setEnabled(false);
		TableColumn tc = frmGlavna.getTblAktivni().getColumnModel().getColumn(3);
		frmGlavna.getTblAktivni().getColumnModel().removeColumn(tc);
	}

	/**
	 * Dodaje listenere na odgovarajuce komponente
	 */
	private void addActionListeners() {
		/**
		 * Dodaje ActionListener na dugme btnStart na glavnoj formi
		 * 
		 * Kada se dugme klikne, poziva se metoda pokreniServer()
		 */
		frmGlavna.addbtnStartActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pokreniServer();
			}
			 /**
		     * Pokrece server
		     * 
		     * Ako server nije pokrenut ili nije aktivan, kreira novu instancu servera i pokrece je.
		     * Nakon pokretanja, azurira odgovarajuce komponente na formi.
		     */
			private void pokreniServer() {
				if (server == null || !server.isAlive()) {
					try {
						server = new Server();
						server.start();
						frmGlavna.getBtnStart().setEnabled(false);
						frmGlavna.getBtnStop().setEnabled(true);
						frmGlavna.getBtnPodesiKonekciju().setEnabled(false);
						frmGlavna.getLblServer().setText("Server je pokrenut :)");
						frmGlavna.getLblServer().setForeground(Color.green);
					} catch (Exception e) {
						System.err.println("Greška u pokretanju servera " + e.getMessage());
						JOptionPane.showMessageDialog(frmGlavna, "GREŠKA u pokretanju servera...", "GREŠKA",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		/**
		 * Dodaje ActionListener na dugme btnStop na glavnoj formi
		 * 
		 * Kada se dugme klikne, poziva se metoda zaustaviServer()
		 */
		frmGlavna.addbtnStopActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zaustaviServer();
			}
			 /**
		     * Zaustavlja server
		     * 
		     * Ako serverski soket postoji, zatvara ga, azurira stanje tabele i komponenti na formi
		     */
			private void zaustaviServer() {
				if (server.getServerSocket() != null) {
					try {
						server.zatvoriServerskiSoket();
						KoordinatorS.vratiInstancu().setAktivniKorisnici(new ArrayList<>());
						pripremiTabele();
						frmGlavna.getBtnStop().setEnabled(false);
						frmGlavna.getBtnStart().setEnabled(true);
						frmGlavna.getBtnPodesiKonekciju().setEnabled(true);
						frmGlavna.getLblServer().setText("Server je prekinut...");
						frmGlavna.getLblServer().setForeground(Color.red);
					} catch (Exception ex) {
						System.err.println("Greška pri gašenju servera " + ex.getMessage());
						JOptionPane.showMessageDialog(frmGlavna, "GREŠKA u zaustavljanju servera...", "GREŠKA",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		/**
		 * Dodaje ActionListener na dugme btnPodesiKonekciju na glavnoj formi
		 * 
		 * Kada se dugme klikne, proverava se stanje dugmeta za pokretanje servera i otvara se forma za konfiguraciju konekcije.
		 * Ako dugme za pokretanje servera nije omoguceno, prikazuje se poruka da je server vec pokrenut.
		 */
		frmGlavna.addbtnPodesiKonekcijuActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!frmGlavna.getBtnStart().isEnabled()) {
					JOptionPane.showMessageDialog(frmGlavna, "Server je već pokrenut");
					return;
				}
				KoordinatorS.vratiInstancu().otvoriFormuKonfiguracijeKonekcije();
			}
		});
		/**
		 * Dodaje WindowListener na glavnu formu
		 * 
		 * Kada se prozor zatvara, poziva se metoda windowClosing(WindowEvent e).
		 */
		frmGlavna.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					server.zatvoriServerskiSoket();
				} catch (NullPointerException ne) {
				}
			}
		});
	}

	/**
	 * Dodaje nutricionistu u tabele svih i aktivnih nutricionista
	 *
	 * @param n Nutricionista koji se dodaje.
	 */
	public void dodajNutricionistu(Nutricionista n) {
		ModelTabeleLogovani mt = (ModelTabeleLogovani) frmGlavna.getTblLogovani().getModel();
		mt.dodaj(n);
		ModelTabeleLogovani mt1 = (ModelTabeleLogovani) frmGlavna.getTblAktivni().getModel();
		mt1.dodaj(n);
	}

	/**
	 * Odjavljuje nutricionistu iz tabele aktivnih nutricionista
	 *
	 * @param n Nutricionista koji se odjavljuje
	 */
	public void odjavaNutricioniste(Nutricionista n) {
		ModelTabeleLogovani mt = (ModelTabeleLogovani) frmGlavna.getTblAktivni().getModel();
		mt.obrisi(n);
	}

}
