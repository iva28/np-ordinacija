package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pacijent;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Pol;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na formi
 * za dodavanje novog pacijenta na sistem
 * 
 * @author Iva Stanisic
 */
public class KontrolerNoviPacijent {
	/**
	 * Instanca forme za dodavanje pacijenta
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private final FrmNoviPacijent frmNoviPacijent;

	/**
	 * Konstruktor klase KontrolerNoviPacijent
	 * 
	 * Kontroler ima referencu ka klasi FrmNoviPacijent
	 * 
	 * @param frmNoviPacijent FrmNoviPacijent objekat koji predstavlja formu za unos
	 *                        novog pacijenta
	 */
	public KontrolerNoviPacijent(FrmNoviPacijent frmNoviPacijent) {
		this.frmNoviPacijent = frmNoviPacijent;
		addActionListeners();
	}

	/**
	 * Koristi se za otvaranje forme FrmNoviPacijent
	 * 
	 * Prethodno se poziva metoda pripremaForme() koja vrsi odredjene pripreme
	 * forme, a zatim se postavlja vidljivost forme na true, cime se forma prikazuje
	 * korisniku.
	 */
	public void otvoriFormu() {
		pripremaForme();
		frmNoviPacijent.setVisible(true);
	}

	/**
	 * Dodaje ActionListener-e na elemente na formi frmNoviPacijent
	 */
	private void addActionListeners() {
		/**
		 * Dodaje ActionListener na dugme "addbtn" u okviru klase FrmNoviPacijent
		 * 
		 * Kada se dogodi akcija, poziva se metoda kreirajPacijenta() koja vrsi proces
		 * kreiranja pacijenta. U slucaju greske, hvata se Exception i prikazuje se
		 * odgovarajuca poruka.
		 */
		frmNoviPacijent.addbtnInsertActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kreirajPacijenta();

			}

			/**
			 * Metoda koja se poziva prilikom kreiranja pacijenta na osnovu unetih podataka
			 * 
			 * Preuzima vrednosti unete u tekstualna polja, kreira novi objekat klase
			 * Pacijent sa preuzetim vrednostima. Vrsi validaciju podataka pacijenta.
			 * Ukoliko je validacija uspesna, novi pacijent se kreira u sistemu pozivom
			 * metode kreirajPacijenta() iz klase Komunikacija. U suprotnom, prikazuje se
			 * odgovarajuca poruka o gresci. Na kraju, zatvara prozor forme.
			 * 
			 * @throws Exception ako dodje do greske prilikom dodavanja novog pacijenta
			 */
			private void kreirajPacijenta() {
				try {
					String ime = frmNoviPacijent.getTxtIme().getText().trim();
					String prezime = frmNoviPacijent.getTxtPrezime().getText().trim();
					String email = frmNoviPacijent.getTxtEmail().getText().trim();
					String telefon = frmNoviPacijent.getTxtTelefon().getText().trim();
					Pol pol = (Pol) frmNoviPacijent.getCmbPol().getSelectedItem();
					Pacijent p = new Pacijent(ime, prezime, email, telefon, pol);
					validiraj(p);
					System.out.println("Pacijent: " + p);
					boolean rezultat = Komunikacija.vratiInstancu().kreirajPacijenta(p);
					if (rezultat) {
						JOptionPane.showMessageDialog(frmNoviPacijent, "Sistem je kreirao pacijenta!");
					} else {
						JOptionPane.showMessageDialog(frmNoviPacijent,
								"Sistem ne može da kreira pacijenta, već postoji pacijent sa datim email-om!");
					}
					frmNoviPacijent.dispose();
				} catch (Exception ex) {
					System.err.println("Greška pri dodavanju novog pacijenta! " + ex.getMessage());
					JOptionPane.showMessageDialog(Koordinator.vratiInstancu().getKontrolerGlavna().getFrmGlavna(),
							"Greška u FrmNoviPacijent!\n" + ex.getMessage());
				}
			}

		});
		/**
		 * Dodaje ActionListener na dugme "addbtn" u okviru klase FrmNoviPacijent
		 * 
		 * Kada se dogodi akcija, poziva se metoda resetujPolja(), koja resetuje polja
		 * forme.
		 */
		frmNoviPacijent.addbtnResetActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetujPolja();
			}

			/**
			 * Resetovanja polja forme
			 * 
			 * Postavlja prazan tekst u tekstualna polja "ime", "prezime", "email" i
			 * "telefon" klase FrmNoviPacijent. Postavlja null vrednost za izabrani element
			 * "cmbPol" klase "frmNoviPacijent". Omogucava dugme "btnInsert", dok dugme
			 * "btnSaveChanges" ostaje onemoguceno.
			 */
			private void resetujPolja() {
				frmNoviPacijent.getTxtIme().setText("");
				frmNoviPacijent.getTxtPrezime().setText("");
				frmNoviPacijent.getTxtEmail().setText("");
				frmNoviPacijent.getTxtTelefon().setText("");
				frmNoviPacijent.getCmbPol().setSelectedItem(null);
				frmNoviPacijent.getBtnInsert().setEnabled(true);

				frmNoviPacijent.getBtnSaveChanges().setEnabled(false);
			}
		});
		/**
		 * Dodaje ActionListener na dugme "addbtn" u okviru klase FrmNoviPacijent
		 * 
		 * Kada se dogodi akcija, poziva se metoda omoguciIzmene(), koja omogucava
		 * izmene na formi.
		 */
		frmNoviPacijent.addbtnSetChangeModeActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				omoguciIzmene();
			}

			/**
			 * Omogucava izmene na formi
			 * 
			 * Omogucava uredjivanje tekstualnih polja "ime", "prezime", "email" i "telefon"
			 * klase FrmNoviPacijent. Omogucava izmenu izabrane vrednosti "cmbPol" klase.
			 * Omogucava pritisak na dugma "btnReset" i "btnInsert". Ako postoji pacijent
			 * koji je vec unet, omogucava pritisak na dugme "btnSaveChanges" i onemogucava
			 * dugme "btnInsert".
			 */
			private void omoguciIzmene() {
				frmNoviPacijent.getTxtIme().setEnabled(true);
				frmNoviPacijent.getTxtPrezime().setEnabled(true);
				frmNoviPacijent.getTxtEmail().setEnabled(true);
				frmNoviPacijent.getTxtTelefon().setEnabled(true);
				frmNoviPacijent.getCmbPol().setEnabled(true);

				frmNoviPacijent.getBtnReset().setEnabled(true);
				frmNoviPacijent.getBtnInsert().setEnabled(true);
				if (frmNoviPacijent.getPacijent() != null) {
					frmNoviPacijent.getBtnSaveChanges().setEnabled(true);
					frmNoviPacijent.getBtnInsert().setEnabled(false);
				}
			}
		});
		/**
		 * Dodaje ActionListener na dugme "addbtn" u okviru klase FrmNoviPacijent
		 * 
		 * Kada se dogodi akcija, poziva se metoda sacuvajIzmenjenogPacijenta(), koja
		 * vrsi cuvanje izmenjenih podataka o pacijentu.
		 */
		frmNoviPacijent.addbtnSaveChangesModeActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sacuvajIzmenjenogPacijenta();
			}

			/**
			 * Cuva izmenjene podatke o pacijentu
			 * 
			 * Kreira se novi objekat klase Pacijent sa izmenjenim vrednostima polja i
			 * validira se. Ako je validacija uspesna, poziva se metoda izmeniPacijenta()
			 * klase Komunikacija radi cuvanja izmena. Na osnovu rezultata cuvanja,
			 * prikazuje se odgovarajuca poruka korisniku. Na kraju, zatvara se prozor
			 * forme.
			 *
			 * @throws Exception ako dodje do greske pri azuriranju pacijenta.
			 */
			private void sacuvajIzmenjenogPacijenta() {
				try {
					Pacijent p = new Pacijent();
					p.setPacijentId(frmNoviPacijent.getPacijent().getPacijentId());
					p.setIme(frmNoviPacijent.getTxtIme().getText().trim());
					p.setPrezime(frmNoviPacijent.getTxtPrezime().getText().trim());
					p.setEmail(frmNoviPacijent.getTxtEmail().getText().trim());
					p.setTelefon(frmNoviPacijent.getTxtTelefon().getText().trim());
					p.setPol((Pol) frmNoviPacijent.getCmbPol().getSelectedItem());
					System.out.println("Izmenjen pacijent: " + p);
					validiraj(p);
					boolean rezultat = Komunikacija.vratiInstancu().izmeniPacijenta(p);
					if (rezultat) {
						JOptionPane.showMessageDialog(frmNoviPacijent, "Sistem je izmenio pacijenta!");
					} else {
						JOptionPane.showMessageDialog(frmNoviPacijent,
								"Sistem ne može da izmeni pacijenta, dati email već postoji u bazi!");
					}
					frmNoviPacijent.dispose();
				} catch (Exception ex) {
					System.err.println("Greška pri ažuriranju pacijenta!\n" + ex.getMessage());
				}
			}
		});
		/**
		 * Dodaje ActionListener na dugme "addbtn" u okviru klase FrmNoviPacijent
		 * 
		 * Kada se dogodi akcija, poziva se metoda obrisiPacijenta() koja brise pacijenta.
		 */
		frmNoviPacijent.addbtnObrisiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obrisiPacijenta();
			}
			  /**
		     * Brise pacijenta iz sistema 
		     * 
		     * Kreira se novi objekat klase Pacijent sa identifikatorom pacijenta i proverava se da li dati pacijent ima plan ishrane
		     * Ako pacijent ima plan ishrane, prikazuje se dijalog za potvrdu brisanja plana.
		     * Ako korisnik potvrdi brisanje plana, poziva se metoda obrisiPlan() klase Komunikacija, radi brisanja plana.
		     * Ako brisanje plana nije uspelo, zatvara se prozor forme.
		     * Ako pacijent nema plan ishrane ili je brisanje plana uspesno, prikazuje se dijalog za potvrdu brisanja pacijenta.
		     * Ako korisnik odustane od brisanja pacijenta, zatvara se prozor forme.
		     * Ako korisnik potvrdi brisanje pacijenta, poziva se metoda obrisiPacijenta() klase Komunikacija, radi brisanja pacijenta.
		     * Na osnovu rezultata brisanja, prikazuje se odgovarajuca poruka korisniku.
		     * Na kraju, zatvara se prozor forme.
		     *
		     * @throws Exception ako dodje do greske pri brisanju pacijenta.
		     */
			private void obrisiPacijenta() {
				try {
					Pacijent p = new Pacijent();
					p.setPacijentId(frmNoviPacijent.getPacijent().getPacijentId());
					PlanIshrane plan = proveriDaLiPacijentImaPlan(p);
					boolean brisanje = false;
					if (plan != null) {
						int opcija = JOptionPane.showConfirmDialog(frmNoviPacijent,
								"Pacijent ima plan ishrane, da li želite da ga obrišete?", "Brisanje pacijenta",
								JOptionPane.YES_NO_OPTION);
						if (opcija == JOptionPane.YES_OPTION) {
							System.out.println("Da opcija");
							brisanje = Komunikacija.vratiInstancu().obrisiPlan(plan);
						}
					}
					if (plan != null && !brisanje) {
						frmNoviPacijent.dispose();
					} else {
						int provera_sigurnosti = JOptionPane.showConfirmDialog(frmNoviPacijent,
								"Da li ste sigurni da želite da obrišete pacijenta?", "POTVRDA BRISANJA",
								JOptionPane.YES_NO_OPTION);
						if (provera_sigurnosti == JOptionPane.NO_OPTION) {
							frmNoviPacijent.dispose();
							return;
						}
						boolean rezultat = Komunikacija.vratiInstancu().obrisiPacijenta(p);
						if (!rezultat) {
							JOptionPane.showMessageDialog(frmNoviPacijent, "Sistem ne može da obriše pacijenta");
						} else {
							JOptionPane.showMessageDialog(frmNoviPacijent, "Sistem je obrisao pacijenta");
							frmNoviPacijent.dispose();
						}
					}
				} catch (Exception ex) {
					System.err.println("Greška pri brisanju pacijenta! " + ex.getMessage());
				}
			}

			private PlanIshrane proveriDaLiPacijentImaPlan(Pacijent pacijent) {
				try {
					List<PlanIshrane> planovi = Komunikacija.vratiInstancu().ucitajListuPlanova();
					for (PlanIshrane p : planovi) {
						if (Objects.equals(p.getPacijent().getPacijentId(), pacijent.getPacijentId())) {
							return p;
						}
					}
				} catch (Exception ex) {
					System.out.println("Greška u učitavanju planova ishrana prilikom pokušaja brisanja pacijenta");
				}
				return null;
			}
		});
	}

	/**
	 * Priprema formu FrmNoviPacijent za prikaz ili izmenu podataka o pacijentu
	 * 
	 * Popunjava combo box za pol, podesava dostupnost i stanje dugmadi na formi.
	 * Ukoliko postoje podaci o pacijentu, popunjava tekstualna polja i omogucava
	 * brisanje pacijenta.
	 */
	private void pripremaForme() {
		popuniCbPol();
		frmNoviPacijent.getBtnReset().setEnabled(false);
		frmNoviPacijent.getBtnInsert().setEnabled(false);
		frmNoviPacijent.getBtnSaveChanges().setEnabled(false);
		frmNoviPacijent.getBtnSetChangeMode().setEnabled(true);
		frmNoviPacijent.getBtnObrisi().setEnabled(false);

		if (frmNoviPacijent.getPacijent() == null) {

		} else {
			Pacijent p = frmNoviPacijent.getPacijent();
			frmNoviPacijent.getTxtIme().setText(p.getIme());
			frmNoviPacijent.getTxtIme().setEnabled(false);

			frmNoviPacijent.getTxtPrezime().setText(p.getPrezime());
			frmNoviPacijent.getTxtPrezime().setEnabled(false);

			frmNoviPacijent.getTxtEmail().setText(p.getEmail());
			frmNoviPacijent.getTxtEmail().setEnabled(false);

			frmNoviPacijent.getTxtTelefon().setText(p.getTelefon());
			frmNoviPacijent.getTxtTelefon().setEnabled(false);

			frmNoviPacijent.getCmbPol().setSelectedItem(p.getPol());
			frmNoviPacijent.getCmbPol().setEnabled(false);

			frmNoviPacijent.getBtnObrisi().setEnabled(true);
		}

	}

	/**
	 * Popunjava combo box za pol sa svim mogucim vrednostima pola
	 * 
	 * Postavlja selektovanu vrednost na null
	 */
	private void popuniCbPol() {
		frmNoviPacijent.getCmbPol().removeAllItems();
		for (Pol pol : Pol.values()) {
			frmNoviPacijent.getCmbPol().addItem(pol);
		}
		frmNoviPacijent.getCmbPol().setSelectedItem(null);
	}

	/**
	 * Vrsi validaciju podataka o pacijentu
	 * 
	 * Proverava ispravnost unetih vrednosti za ime, prezime, telefon, email i pol.
	 * Ukoliko se detektuje greska, postavlja odgovarajuce poruke o greskama na
	 * formi.
	 *
	 * @param p Pacijent ciji se podaci validiraju
	 * @throws Exception ako postoji greska u unetim podacima
	 */
	private void validiraj(Pacijent p) throws Exception {
		String error = "";
		frmNoviPacijent.getLblErrorIme().setText("");
		frmNoviPacijent.getLblErrorIme().setForeground(Color.red);

		frmNoviPacijent.getLblErrorPrezime().setText("");
		frmNoviPacijent.getLblErrorPrezime().setForeground(Color.red);

		frmNoviPacijent.getLblEmailError().setText("");
		frmNoviPacijent.getLblEmailError().setForeground(Color.red);

		frmNoviPacijent.getLblTelefonError().setText("");
		frmNoviPacijent.getLblTelefonError().setForeground(Color.red);

		frmNoviPacijent.getLblPolError().setText("");
		frmNoviPacijent.getLblPolError().setForeground(Color.red);

		if (p.getIme() == null || p.getIme().isEmpty() || !p.getIme().matches("[a-zA-Z]+")) {
			frmNoviPacijent.getLblErrorIme().setText("Ime mora biti popunjeno validno!");
			error += "Ime mora biti popunjeno validno!\n";
			frmNoviPacijent.getTxtIme().setText("");
		}
		if (p.getPrezime() == null || p.getPrezime().isEmpty()
				|| (!p.getPrezime().matches("[a-zA-Z]+") && !p.getPrezime().toLowerCase().contains("ć"))) {
			frmNoviPacijent.getLblErrorPrezime().setText("Prezime mora biti popunjeno validno!");
			error += "Prezime mora biti popunjeno validno!\n";
			frmNoviPacijent.getTxtPrezime().setText("");
		}
		if (p.getTelefon() == null || p.getTelefon().isEmpty() || p.getTelefon().length() < 8
				|| (!p.getTelefon().matches("^[0-9]*$"))) {
			frmNoviPacijent.getLblTelefonError()
					.setText("Telefon mora biti popunjen, mora da ima samo brojeve i to najmanje 8!");
			error += "Telefon mora biti popunjen, mora da ima samo brojeve i to najmanje 8!\n";
			frmNoviPacijent.getTxtTelefon().setText("");
		}
		if (p.getEmail() == null || p.getEmail().isEmpty() || !p.getEmail().contains("@")) {
			frmNoviPacijent.getLblEmailError().setText("Email mora biti popunjen i mora da ima znak @!");
			error += "Email mora biti popunjen!\n";
			frmNoviPacijent.getTxtEmail().setText("");
		}
		if (p.getPol() == null) {
			frmNoviPacijent.getLblPolError().setText("Pol mora biti izabran!");
			error += "Pol mora biti izabran!\n";
		}
		if (!error.isEmpty()) {
			throw new Exception(error);
		}
	}
}
