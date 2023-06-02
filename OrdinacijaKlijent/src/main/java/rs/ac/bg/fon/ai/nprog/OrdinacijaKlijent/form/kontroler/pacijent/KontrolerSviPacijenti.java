package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent.FrmSviPacijenti;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.pacijent.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na formi
 * za upravljanje svim pacijentima na sistemu
 * 
 * @author Iva Stanisic
 */
public class KontrolerSviPacijenti {
	/**
	 * Instanca forme za manipulaciju pacijentima
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private final FrmSviPacijenti frmSviPacijenti;

	/**
	 * Konstruktor klase KontrolerSviPacijenti
	 * 
	 * Kontroler ima referencu ka klasi FrmSviPacijenti
	 * 
	 * @param frmSviPacijenti FrmSviPacijenti objekat koji predstavlja formu za
	 *                        manipulaciju podacima o pacijentima
	 */
	public KontrolerSviPacijenti(FrmSviPacijenti frmSviPacijenti) {
		this.frmSviPacijenti = frmSviPacijenti;
		addActionListeners();
	}

	/**
	 * Koristi se za otvaranje forme FrmSviPacijenti
	 * 
	 * Prethodno se poziva metoda pripremaForme() koja vrsi odredjene pripreme
	 * forme, a zatim se postavlja vidljivost forme na true, cime se forma prikazuje
	 * korisniku.
	 */
	public void otvoriFormu() {
		pripremaForme();
		frmSviPacijenti.setVisible(true);
	}

	/**
	 * Dodaje ActionListener-e na elemente na formi frmSviPacijenti
	 */
	private void addActionListeners() {
		/**
		 * Dodaje ActionListener na dugme "Dodaj" u formi frmSviPacijenti
		 * 
		 * Otvora formu frmNoviPacijent za dodavanje novog pacijenta. Nakon dodavanja,
		 * vrsi pripremu forme frmSviPacijenti.
		 */
		frmSviPacijenti.addbtnDodajActionListener((ActionEvent e) -> {
			Koordinator.vratiInstancu().otvoriFrmNoviPacijent(null);
			pripremaForme();
		});

		/**
		 * Dodaje ActionListener na dugme btnDelete u formi frmSviPacijenti
		 * 
		 * Poziva metodu obrisiPacijenta() koja se izvrsava prilikom klika na dugme.
		 */
		frmSviPacijenti.addbtnDeleteActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obrisiPacijenta();
			}

			/**
			 * Metoda koja se izvrsava prilikom brisanja pacijenta
			 * 
			 * Preuzima selektovani red iz tabele pacijenata i pokusava da obrise pacijenta.
			 * Ako pacijent ima plan ishrane, prikazuje se dijalog za potvrdu brisanja
			 * plana. Nakon brisanja, vrsi se provera da li je pacijent uspesno obrisan i
			 * obavlja se priprema forme frmSviPacijenti. U slučaju greske, ispisuje se
			 * poruka o gresci.
			 * 
			 * @throws Exception ako dodje do greske pri brisanju pacijenta
			 */
			private void obrisiPacijenta() {
				int red = frmSviPacijenti.getTblPacijenti().getSelectedRow();
				ModelTableSviPacijenti model = (ModelTableSviPacijenti) frmSviPacijenti.getTblPacijenti().getModel();
				if (red >= 0 && red < model.getRowCount()) {
					try {
						Pacijent p = model.getPacijentAt(red);
						PlanIshrane planPostoji = proveriJelPacijentImaPlan(p);
						boolean brisanje = false;
						if (planPostoji != null) {
							int opcija = JOptionPane.showConfirmDialog(frmSviPacijenti,
									"Pacijent " + p + " ima plan ishrane, da li želite da ga obrišete?",
									"Brisanje pacijenta", JOptionPane.YES_NO_OPTION);
							if (opcija == JOptionPane.YES_OPTION) {
								brisanje = Komunikacija.vratiInstancu().obrisiPlan(planPostoji);
							}
						}
						if ((planPostoji == null) || brisanje) {
							int provera = JOptionPane.showConfirmDialog(frmSviPacijenti,
									"Da li ste sigurni da želite da obrišete pacijenta", "PROVERA",
									JOptionPane.YES_NO_OPTION);
							if (provera == JOptionPane.NO_OPTION)
								return;
							boolean rezultat = Komunikacija.vratiInstancu().obrisiPacijenta(p);
							if (rezultat) {
								JOptionPane.showMessageDialog(frmSviPacijenti, "Uspeh u brisanju pacijenta");
								pripremaForme();
							}
						}
					} catch (Exception ex) {
						System.err.println("Greška pri brisanju pacijenta! " + ex.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(frmSviPacijenti, "Selektujte pacijenta za brisanje!");
				}
			}

			/**
			 * Proverava da li pacijent ima pridruzen plan ishrane
			 * 
			 * @param pacijent Pacijent ciji se plan ishrane proverava
			 * @return PlanIshrane objekat ako pacijent ima plan, null ako pacijent nema
			 *         plan
			 * 
			 * @throws Exception ako dodje do greske pri ucitavanju planova ishrana
			 */
			private PlanIshrane proveriJelPacijentImaPlan(Pacijent pacijent) {
				try {
					List<PlanIshrane> planovi = Komunikacija.vratiInstancu().ucitajListuPlanova();
					for (PlanIshrane p : planovi) {
						if (p.getPacijent().equals(pacijent)) {
							return p;
						}
					}
				} catch (Exception ex) {
					System.err.println("Greška u učitavanju planova ishrana prilikom pokušaja brisanja pacijenta! "
							+ ex.getMessage());
				}
				return null;
			}
		});
		/**
		 * Dodaje ActionListener za dugme za izmenu pacijenta
		 * 
		 * Kada se dugme pritisne, poziva se metoda izmeniPacijenta().
		 */
		frmSviPacijenti.addbtnChangeActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				izmeniPacijenta();
			}

			/**
			 * Menja pacijenta
			 * 
			 * Pretrazuje selektovanog pacijenta i otvara formu za izmenu pacijenta. Nakon
			 * izmene, vrsi se priprema forme.
			 * 
			 * @throws Exception ako dodje do greske prilikom izmene pacijenta
			 */
			private void izmeniPacijenta() {
				try {
					Pacijent p = nadjiPacijenta();
					if (p != null) {
						Koordinator.vratiInstancu().otvoriFrmNoviPacijent(p);
					}
					pripremaForme();
				} catch (Exception ex) {
					System.err.println("Greška pri izmeni pacijenta! " + ex.getMessage());
				}
			}
		});
		/**
		 * Dodaje ActionListener za dugme za pretragu pacijenata
		 * 
		 * Kada se dugme pritisne, poziva se metoda omoguciPretragu().
		 */
		frmSviPacijenti.addbtnSearchModeActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				omoguciPretragu();
			}

			/**
			 * Omogucuje pretragu pacijenata. Prikazuje panel za pretragu i
			 * postavlja model tabele pretrage na null.
			 */
			private void omoguciPretragu() {
				frmSviPacijenti.getPnlSearch().setVisible(true);
				frmSviPacijenti.getTblSearch().setModel(new ModelTableSviPacijenti(null));
			}
		});
		/**
		 * Dodaje ActionListener za dugme za zatvaranje pretrage
		 * 
		 * Kada se dugme pritisne, poziva se metoda zatvoriPretragu().
		 */
		frmSviPacijenti.addbtnCloseSearchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zatvoriPretragu();
			}
			/**
		     * Zatvara pretragu pacijenata
		     * 
		     * Resetuje vrednosti polja za pretragu, postavlja labelu za gresku na prazan tekst
		     * i sakriva panel za pretragu. Nakon toga se vrsi priprema forme.
		     */
			private void zatvoriPretragu() {
				frmSviPacijenti.getTxtSearch().setText("");
				frmSviPacijenti.getLblSearchError().setText("");
				frmSviPacijenti.getPnlSearch().setVisible(false);
				pripremaForme();
			}
		});
		/**
		 * Dodaje ActionListener za dugme za osvezavanje forme
		 * 
		 * Kada se dugme pritisne, poziva se metoda pripremaForme().
		 */
		frmSviPacijenti.addbtnRefreshActionListener((ActionEvent e) -> {
			pripremaForme();
		});
		/**
		 * Dodaje ActionListener za dugme za pretragu pacijenata
		 * 
		 * Kada se dugme pritisne, poziva se metoda pretraziPacijenta().
		 */
		frmSviPacijenti.addbtnSearchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pretraziPacijenta();
			}
			/**
		     *Pretrazuje pacijenta
		     *
		     * Prvo se vrsi validacija polja za pretragu.
		     * Ako je validacija uspesna, vrši se pretraga pacijenata po zadatoj vrednosti.
		     * Ako se pronadju pacijenti, prikazuju se u tabeli za pretragu.
		     * U suprotnom, prikazuje se odgovarajuca poruka.
		     * U slucaju greske pri trazenju pacijenata, prikazuje se greska.
		     * 
		     * @throws Exception ako dodje do greske pri trazenju pacijenta
		     */
			private void pretraziPacijenta() {
				boolean rezultat = validirajPoljeZaPretragu();
				if (rezultat) {
					try {
						String ime = frmSviPacijenti.getTxtSearch().getText().trim();
						List<Pacijent> lista = Komunikacija.vratiInstancu().nadjiPacijente(ime);
						if (lista == null || lista.isEmpty()) {
							JOptionPane.showMessageDialog(frmSviPacijenti,
									"Sistem ne može da nađe pacijente po zadatoj vrednosti");
							frmSviPacijenti.getTxtSearch().setText("");
							return;
						}
						JOptionPane.showMessageDialog(frmSviPacijenti,
								"Sistem je našao pacijente po zadatoj vrednosti");
						ModelTableSviPacijenti model = new ModelTableSviPacijenti(lista);
						frmSviPacijenti.getTblSearch().setModel(model);
						frmSviPacijenti.getTxtSearch().setText("");
					} catch (Exception ex) {
						System.err.println("Greška prilikom traženja pacijenata! " + ex.getMessage());
						JOptionPane.showMessageDialog(frmSviPacijenti,
								"Greška u traženju pacijenata!" + ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					frmSviPacijenti.getTxtSearch().setText("");
				}
			}
			/**
			 * Vrsi validaciju polja za pretragu
			 * 
			 * Proverava da li je polje za pretragu prazno i da li je uneto ime pacijenta.
			 * Ako je validacija uspesna, vraca true. Inace, prikazuje odgovarajucu gresku i vraca false.
			 *
			 * @return true ako je validacija uspesna, false inace.
			 */
			private boolean validirajPoljeZaPretragu() {
				frmSviPacijenti.getLblSearchError().setText("");
				if (frmSviPacijenti.getTxtSearch().getText().trim().isEmpty()) {
					frmSviPacijenti.getLblSearchError().setText("Polje za pretragu ne može biti prazno!");
					frmSviPacijenti.getLblSearchError().setForeground(Color.red);
					return false;
				}
				if (!frmSviPacijenti.getTxtSearch().getText().trim().matches("[a-zA-Z]+")) {
					frmSviPacijenti.getLblSearchError().setText("U polje za pretragu unesite ime pacijenta!");
					frmSviPacijenti.getLblSearchError().setForeground(Color.red);
					return false;
				}
				frmSviPacijenti.getLblSearchError().setText("");
				return true;
			}
		});
		/**
		 * Dodaje ActionListener na dugme btnDetalji u formi frmSviPacijenti
		 * 
		 * Kada se dugme pritisne, poziva se metoda ucitajPacijenta() koja ucitava selektovanog pacijenta.
		 */
		frmSviPacijenti.addbtnDetaljiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ucitajPacijenta();
			}
			/**
			 * Ucitava pacijenta na osnovu selektovanog reda u tabeli za pretragu pacijenata.
			 * Ako red nije selektovan, prikazuje odgovarajucu poruku.
			 * U suprotnom, vrsi ucitavanje pacijenta i otvara formu za izmenu pacijenta.
			 * 
			 * @throws Exception ako dodje do greske pri ucitavanju pacijenta
			 */
			private void ucitajPacijenta() {
				try {
					int red = frmSviPacijenti.getTblSearch().getSelectedRow();
					if (red == -1) {
						JOptionPane.showMessageDialog(frmSviPacijenti,
								"Sistem ne može da učita pacijenta\nSelektujte red u tabeli za pretragu pacijenata");
						return;
					}
					ModelTableSviPacijenti model = (ModelTableSviPacijenti) frmSviPacijenti.getTblSearch().getModel();
					Pacijent selektovan = model.getPacijentAt(red);
					selektovan = Komunikacija.vratiInstancu().ucitajPacijenta(selektovan);
					if (selektovan == null) {
						JOptionPane.showMessageDialog(frmSviPacijenti, "Sistem ne može da učita pacijenta", "",
								JOptionPane.ERROR);
					} else {
						JOptionPane.showMessageDialog(frmSviPacijenti, "Sistem je učitao pacijenta");
						Koordinator.vratiInstancu().otvoriFrmNoviPacijent(selektovan);
//                        pripremaForme();
					}
				} catch (Exception ex) {
					System.err.println("Sistem ne može da učita pacijenta! " + ex.getMessage());
				}
			}
		});
	}

	/**
	 * Priprema forme za prikaz svih pacijenata. Ucitava listu pacijenata i
	 * prikazuje je u tabeli. Postavlja odgovarajuce postavke panela za pretragu.
	 * 
	 * @throws Exception ako dodje do greske pri preuzimanju podataka o pacijentima
	 */
	private void pripremaForme() {
		try {
			List<Pacijent> lista;
			lista = Komunikacija.vratiInstancu().ucitajListuPacijenata();
			ModelTableSviPacijenti model = new ModelTableSviPacijenti(lista);
			frmSviPacijenti.getTblPacijenti().setModel(model);
			frmSviPacijenti.getPnlSearch().setVisible(false);
			frmSviPacijenti.getPnlSearch().setEnabled(false);
		} catch (Exception ex) {
			System.err.println("Greška pri preuzimanju pacijenata! " + ex.getMessage());
		}
	}

	/**
	 * Pronalazi pacijenta na osnovu selektovanog reda u tabeli.
	 * 
	 * @return Pronadjeni pacijent
	 * 
	 * @throws Exception ako nije selektovan pacijent u tabeli
	 */
	private Pacijent nadjiPacijenta() throws Exception {
		int red = frmSviPacijenti.getTblPacijenti().getSelectedRow();
		ModelTableSviPacijenti model = (ModelTableSviPacijenti) frmSviPacijenti.getTblPacijenti().getModel();
		if (red >= 0 && red < model.getRowCount()) {
			Pacijent p = model.getPacijentAt(red);
			return p;
		} else {
			JOptionPane.showMessageDialog(frmSviPacijenti, "Selektujte pacijenta!");
		}
		throw new Exception("Selektujte pacijenta za izmenu sa tabele!");
	}

}
