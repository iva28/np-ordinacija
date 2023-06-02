package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.konstante.*;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na formi
 * za prijavu nutricioniste na sistem
 * 
 * @author Iva Stanisic
 */
public class KontrolerPrijava {
	/**
	 * Instanca forme za prijavu nutricioniste na sistem
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private FrmPrijava frmPrijava;

	/**
	 * Konstruktor koji inicijalizuje kontroler forme za prijavu na sistem
	 * 
	 * @param frmPrijava referenca na formu za prijavu na sistem
	 */
	public KontrolerPrijava(FrmPrijava frmPrijava) {
		this.frmPrijava = frmPrijava;
		addActionListeners();
	}

	/**
	 * Otvara formu za prijavu na sistem frmPrijava i prikazuje njen sadrzaj
	 */
	public void otvoriFormu() {
		frmPrijava.setVisible(true);
	}

	/**
	 * Dodaje ActionListener-e na elemente na login formi
	 */
	private void addActionListeners() {
		frmPrijava.prijavaAddActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prijaviNutricionistu(e);
			}

			/**
			 * ActionListener koji se aktivira kada se izvrsi akcija prijave na sistem
			 * 
			 * Prijavljuje nutricionistu na osnovu unetih podataka iz forme za prijavu. Vrsi
			 * validaciju unetih podataka, komunikaciju sa serverom i otvaranje glavne forme
			 * u slucaju uspesne prijave.
			 *
			 * @param e Objekat klase ActionEvent koji predstavlja akciju prijave
			 */
			private void prijaviNutricionistu(ActionEvent e) {
				try {
					String username = frmPrijava.getTxtKorisnickoIme().getText().trim();
					String password = String.valueOf(frmPrijava.getTxtLozinka().getPassword());
					validiraj(username, password);

					Nutricionista n = Komunikacija.vratiInstancu().login(username, password);
					if (n == null) {
						JOptionPane.showMessageDialog(frmPrijava,
								"Sistem ne može da nađe nutricionistu na osnovu unetih podataka!");
						resetujPolja();
						return;
					}
					if (n.getNutricionistaId() == -1L) {
						JOptionPane.showMessageDialog(frmPrijava, "Nutricionista je već prijavljen i nije odlogovan!");
						resetujPolja();
						return;
					}
					JOptionPane.showMessageDialog(frmPrijava,
							"Uspešno ste se prijavili na sistem :) " + n.getUsername());
					frmPrijava.dispose();
					Koordinator.vratiInstancu().dodajParametar(Konstante.NUTRICIONISTA, n);
					Koordinator.vratiInstancu().otvoriGlavnuFormu();
				} catch (Exception ex) {
					System.err.println("Greška u formi za prijavu " + ex.getMessage());
					JOptionPane.showMessageDialog(frmPrijava, ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE);
				}

			}

			/**
			 * Vrsi validaciju unetog username-a i password-a nutricioniste
			 * 
			 * @param username korisnicko ime nutricioniste
			 * @param password sifra nutricioniste
			 * @throws Exception ukoliko dodje do greske prilikom unosa parametara za prijavu
			 */
			private void validiraj(String username, String password) throws Exception {
				String error = "";
				frmPrijava.getLblUsernameError().setText("");
				frmPrijava.getLblPasswordError().setText("");
				if (username == null || username.isEmpty()) {
					frmPrijava.getLblUsernameError().setText("Korisničko ime mora biti popunjeno!");
					error += "Korisničko ime mora biti popunjeno!\n";
				}
				if (password == null || password.isEmpty()) {
					frmPrijava.getLblPasswordError().setText("Šifra mora biti popunjena!");
					error += "Šifra mora biti popunjena!\n";
				}
				if (!error.isEmpty()) {
					throw new Exception(error);
				}
			}

			/**
			 * Resetuje polja na formi za prijavu
			 */
			private void resetujPolja() {
				frmPrijava.getTxtKorisnickoIme().setText("");
				frmPrijava.getTxtLozinka().setText("");
			}

		});
	}
}
