package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.planIshrane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.konstante.Konstante;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.Koordinator;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabeleJela;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabelePlanoviIshrana;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabeleStavkaIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.planIshrane.FrmPlanIshranePrikaz;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na formi
 * za prikaz planova ishrana na sistemu
 * 
 * @author Iva Stanisic
 */
public class KontrolerPlanIshranePrikaz {

	/**
	 * Instanca forme za prikaz planova ishrana
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private final FrmPlanIshranePrikaz frmPlanIshranePrikaz;

	/**
	 * Konstruktor klase KontrolerPlanIshranePrikaz
	 * 
	 * Kontroler ima referencu ka formi klase FrmPlanIshranePrikaz
	 * 
	 * @param frmPlanIshranePrikaz FrmPlanIshranePrikaz objekat koji predstavlja
	 *                             formu za prikaz planova
	 */
	public KontrolerPlanIshranePrikaz(FrmPlanIshranePrikaz frmPlanIshranePrikaz) {
		this.frmPlanIshranePrikaz = frmPlanIshranePrikaz;
		addActionListeners();
	}

	/**
	 * Koristi se za otvaranje forme
	 * 
	 * Prethodno se poziva metoda pripremaForme() koja vrsi odredjene pripreme
	 * forme, a zatim se postavlja vidljivost forme na true, cime se forma prikazuje
	 * korisniku.
	 */
	public void otvoriFormu() {
		pripremaForme();
		frmPlanIshranePrikaz.setVisible(true);
	}

	/**
	 * Dodaje ActionListener-e na elemente na formi frmPlanIshranePrikaz
	 */
	private void addActionListeners() {
		/**
		 * Dodaje ActionListener na dugme btnPretragaPlana u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda pretraziPlanove()
		 */
		frmPlanIshranePrikaz.addbtnPretragaPlanaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pretraziPlanove();
			}

			private void pretraziPlanove() {
				try {
					Nutricionista nutricionista = (Nutricionista) frmPlanIshranePrikaz.getCmbNutricionisti()
							.getSelectedItem();
					Pacijent pacijent = (Pacijent) frmPlanIshranePrikaz.getCbPacijenti().getSelectedItem();
					if (nutricionista == null && pacijent == null) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte nutricionistu ili pacijenta");
						return;
					}
					PlanIshrane planIshrane = new PlanIshrane();
					if (nutricionista != null)
						planIshrane.setNutricionista(nutricionista);
					if (pacijent != null)
						planIshrane.setPacijent(pacijent);
					List<PlanIshrane> planovi = Komunikacija.vratiInstancu().nadjiPlanove(planIshrane);
					if (planovi == null || planovi.isEmpty()) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
								"Sistem ne može da nađe planove ishrana po zadatoj vrednosti");
						frmPlanIshranePrikaz.getCbPacijenti().setSelectedItem(null);
						frmPlanIshranePrikaz.getCmbNutricionisti().setSelectedItem(null);
						return;
					}
					JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
							"Sistem je našao planove ishrana po zadatoj vrednosti");

					ModelTabelePlanoviIshrana modelPlanovi = new ModelTabelePlanoviIshrana(planovi);
					frmPlanIshranePrikaz.getTblPlanovi().setModel(modelPlanovi);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		/**
		 * Dodaje ActionListener na dugme btnUcitajPlan u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda ucitajPlanIshrane()
		 */
		frmPlanIshranePrikaz.addbtnUcitajPlanActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ucitajPlanIshrane();
			}

			private void ucitajPlanIshrane() {
				try {
					int red = frmPlanIshranePrikaz.getTblPlanovi().getSelectedRow();
					ModelTabelePlanoviIshrana modelTabele = (ModelTabelePlanoviIshrana) frmPlanIshranePrikaz
							.getTblPlanovi().getModel();
					if (red == -1 && modelTabele.getRowCount() > 1) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
								"Sistem ne može da učita plan ishrane" + "\nSelektujte red u tabeli");
						return;
					}
					PlanIshrane plan;
					if (modelTabele.getRowCount() == 1) {
						plan = modelTabele.vratiPlan(0);
					} else {
						plan = modelTabele.vratiPlan(red);
					}
					plan = Komunikacija.vratiInstancu().ucitajPlanIshrane(plan);
					if (plan != null) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem je učitao plan ishrane");
						modelTabele.postaviJedan(plan);
						frmPlanIshranePrikaz.getTblPlanovi().setModel(modelTabele);
						Koordinator.vratiInstancu().dodajParametar(Konstante.PLAN_ISHRANE, plan);
						srediPanelDets();
					}
				} catch (Exception ex) {
					System.err.println("Greška pri učitavanju plana ishrane! " + ex.getMessage());
				}
			}
		});
		/**
		 * Dodaje ActionListener na dugme btnDetalji u formi frmPlanIshranePrikaz
		 * 
		 * Za izabrani plan ishrane, prikazuje njegove specificne informacije poput
		 * datuma, cene, pacijenta za kojeg je napravlje. Prikazuje i sve stavke koje se
		 * nalaze na planu.
		 * 
		 * Ukoliko nije selektovan red u tabeli planova, prikazuje se poruka klijentu da
		 * to ucini
		 */
		frmPlanIshranePrikaz.addbtnDetailActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = frmPlanIshranePrikaz.getTblPlanovi().getSelectedRow();
				if (red != -1) {
					ModelTabelePlanoviIshrana model = (ModelTabelePlanoviIshrana) frmPlanIshranePrikaz.getTblPlanovi()
							.getModel();
					PlanIshrane p = model.vratiPlan(red);
					Koordinator.vratiInstancu().dodajParametar(Konstante.PLAN_ISHRANE, p);
					srediPanelDets();
				} else {
					JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte red u tabeli");
				}
			}

		});
		/**
		 * Dodaje ActionListener na dugme btnDelete u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda obrisiPlan()
		 */
		frmPlanIshranePrikaz.addbtnDeleteActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obrisiPlan();
			}

			/**
			 * Brise plan ishrane iz sistema
			 * 
			 * Ako nije selektovan red u tabeli sa planovima obavestava se klijent da to
			 * ucini. Vrsi se provera mogucnosti brisanja plana i ukoliko je to moguce brise
			 * se iz sistema Ako je uspesno brisanje, obavestava se klijent o tome
			 * 
			 * @throws Exception ako dodje do greske pri brisanju plana ishrane
			 */
			private void obrisiPlan() {
				int red = frmPlanIshranePrikaz.getTblPlanovi().getSelectedRow();
				if (red != -1) {
					try {
						ModelTabelePlanoviIshrana model = (ModelTabelePlanoviIshrana) frmPlanIshranePrikaz
								.getTblPlanovi().getModel();
						PlanIshrane plan = model.vratiPlan(red);
						Koordinator.vratiInstancu().dodajParametar(Konstante.PLAN_ISHRANE, plan);
						boolean rezultat = proveraMogucnostiMenjanja();
						if (!rezultat) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
									"Ne smete brisati planove koji nisu vaši");
							return;
						}
						int provera = JOptionPane.showConfirmDialog(frmPlanIshranePrikaz,
								"Da li ste sigurni da želite da obrišete plan?", "PROVERA BRISANJA",
								JOptionPane.YES_NO_OPTION);
						if (provera == JOptionPane.NO_OPTION) {
							return;
						}
						boolean uspeh = Komunikacija.vratiInstancu().obrisiPlan(plan);
						if (uspeh) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem je obrisao plan ishrane!");
							pripremaForme();
						}
					} catch (Exception ex) {
						System.err.println("Greška pri brisanju plana! " + ex.getMessage());
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem ne može da obriše plan ishrane!");
					}

				} else {
					JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Morate selektovati red!");
				}
			}
		});
		/**
		 * Dodaje ActionListener na dugme btnIzmena u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda srediZaIzmenuPlana()
		 */
		frmPlanIshranePrikaz.addbtnIzmenaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				srediZaIzmenuPlana();
			}

			/**
			 * Sredjuje panel za izmenu plana ishrane kojeg je klijent selektovao
			 * 
			 * Prvo se proverava mogucnost vrsenja izmena nad planom. Zatim se ucitavaju
			 * jela iz baze i postavljaju na formu. Omogucuje se izmena broja dana trajanja
			 * plana, izmena datuma. Omogucuje se koriscenja dugmeta za brisanje plana i
			 * dugmeta za cuvanje plana, koji se nalaze na formi
			 * 
			 * @throws Exception ako dodje do greske pri preuzimanju jela
			 */
			private void srediZaIzmenuPlana() {
				try {
					boolean rezultat = proveraMogucnostiMenjanja();
					if (!rezultat) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
								"Zabranjeno menjanje planova koji nisu vaši!");
						frmPlanIshranePrikaz.getBtnSacuvajIzmene().setEnabled(false);
						return;
					}
					frmPlanIshranePrikaz.getTblStavke().setEnabled(true);
					frmPlanIshranePrikaz.getPnlJela().setVisible(true);
					List<Jelo> lista = Komunikacija.vratiInstancu().vratiJela();
					ModelTabeleJela model = new ModelTabeleJela(lista);
					frmPlanIshranePrikaz.getTblJela().setModel(model);
					frmPlanIshranePrikaz.getBtnDani().setEnabled(true);
					frmPlanIshranePrikaz.getBtnDatum().setEnabled(true);
					frmPlanIshranePrikaz.getBtnBrisi().setEnabled(true);
					frmPlanIshranePrikaz.getBtnSacuvajIzmene().setEnabled(true);

//                    frmPlanIshranePrikaz.getTxtCena().setText("");
					srediDatum();
				} catch (Exception ex) {
					System.err.println("Problem u preuzimanju jela! " + ex.getMessage());
				}
			}

			/**
			 * Sredjuje datum na formi za prikaz planova ishrana
			 */
			private void srediDatum() {
				String godina = frmPlanIshranePrikaz.getTxtDatum().getText().substring(0, 4);
				String mesec = frmPlanIshranePrikaz.getTxtDatum().getText().substring(5, 7);
				String dan = frmPlanIshranePrikaz.getTxtDatum().getText().substring(8);
				String datum = dan + "." + mesec + "." + godina;
				frmPlanIshranePrikaz.getTxtDatum().setText(datum);
			}

		});
		/**
		 * Dodaje ActionListener na dugme btnDani u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, nutricionista moze da menja broj dana trajanja plana
		 */
		frmPlanIshranePrikaz.addbtnDaniActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
					"Promenite broj dana samo ako ste zavrsili za izmenama");
			frmPlanIshranePrikaz.getTxtDani().setEnabled(true);
			frmPlanIshranePrikaz.getTxtDani().setText("");
		});

		/**
		 * Dodaje ActionListener na dugme btnDodajUPlan u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda dodajUPlan()
		 */
		frmPlanIshranePrikaz.addbtnDodajUPlanActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dodajUPlan();
			}

			/**
			 * Dodaje stavku plana u plan ishrane
			 * 
			 * Na osnovu izabrane stavke i broja dana racuna se cena
			 * 
			 */
			private void dodajUPlan() {
				int red = frmPlanIshranePrikaz.getTblJela().getSelectedRow();
				if (red != -1) {
					ModelTabeleStavkaIshrane modelStavke = (ModelTabeleStavkaIshrane) frmPlanIshranePrikaz
							.getTblStavke().getModel();
					ModelTabeleJela modelJela = (ModelTabeleJela) frmPlanIshranePrikaz.getTblJela().getModel();
					Jelo jelo = modelJela.vratiJelo(red);
					if (modelStavke.postoji(jelo)) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Dato jelo već postoji u stavkama");
					} else {
						int kolicina = (int) frmPlanIshranePrikaz.getSpiner().getValue();
						if (kolicina == 0) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Postavite kolicinu vecu od 0");
							return;
						}
						BigDecimal cena = BigDecimal.valueOf(kolicina)
								.multiply(new BigDecimal(Integer.parseInt(jelo.getCena().toString())));
						BigDecimal preCena = new BigDecimal(frmPlanIshranePrikaz.getTxtCena().getText());
						preCena = preCena.add(cena);
						frmPlanIshranePrikaz.getTxtCena().setText(preCena.toString());
						StavkaPlanaIshrane stavka = new StavkaPlanaIshrane(0L, cena, kolicina, jelo);
						modelStavke.dodaj(stavka);
					}

				} else {
					JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte red u tabeli jela");
				}
			}
		});
		/**
		 * Dodaje ActionListener na dugme btnBrisi u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda brisiStavku()
		 */
		frmPlanIshranePrikaz.addbtnBrisiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				brisiStavku();
			}

			/**
			 * Brise stavku iz plana ishrane
			 *
			 * Klijent prvo mora da selektuje red u tabeli sa stavkama planova ishrana.
			 * 
			 */
			private void brisiStavku() {
				int red = frmPlanIshranePrikaz.getTblStavke().getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte red za brisanje");
				} else {
					ModelTabeleStavkaIshrane modelStavke = (ModelTabeleStavkaIshrane) frmPlanIshranePrikaz
							.getTblStavke().getModel();
					StavkaPlanaIshrane stavka = modelStavke.vratiStavku(red);
					modelStavke.obrisi(red);
					int brojDana = Integer.parseInt(frmPlanIshranePrikaz.getTxtDani().getText());
					int kolicina = stavka.getKolicina() * brojDana;
					BigDecimal cena = stavka.getCena();
					cena = cena.multiply(BigDecimal.valueOf(kolicina));
					BigDecimal preCena = new BigDecimal(frmPlanIshranePrikaz.getTxtCena().getText());
					preCena = preCena.subtract(cena);
					frmPlanIshranePrikaz.getTxtCena().setEnabled(true);
					frmPlanIshranePrikaz.getTxtCena().setText(preCena.toString());
					frmPlanIshranePrikaz.getTxtCena().setEnabled(false);
				}
			}
		});
		/**
		 * Dodaje ActionListener na dugme btnSacuvajIzmene u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda sacuvajIzmenjenPlan()
		 */
		frmPlanIshranePrikaz.addbtnSacuvajIzmeneActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sacuvajIzmenjenPlan();
			}

			/**
			 * Cuva izmenjen plan ishrane u bazi podataka
			 * 
			 * Prvo se proverava mogucnost menjanja plana, ako nije omoguceno menjanje
			 * obavestava se nutricionista o tome.
			 *
			 * Ako su obrisane sve stavke plana, brise se plan ishrane iz sistema. Ako plan
			 * ishrane vec postoji u sistemu, vrse se neophodne validacije i azurira se u
			 * bazi.
			 * 
			 * @throws Exception ako dodje do greske pri izmeni plana ishrane
			 */
			private void sacuvajIzmenjenPlan() {
				boolean rezultat = proveraMogucnostiMenjanja();
				if (!rezultat) {
					JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Zabranjeno menjanje planova koji nisu vaši!");
					return;
				}
				if (frmPlanIshranePrikaz.getTblStavke().getRowCount() == 0) {
					try {
						// obrisane su sve stavke pa brisemo plan
						boolean uspeh = Komunikacija.vratiInstancu().azurirajPlan(
								(PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE));
						System.out.println(
								(PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE));
						if (uspeh) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Uspeh u brisanju plana ishrane");
							pripremaForme();
						} else {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Greška u brisanju plana ishrane");
						}
					} catch (Exception ex) {
						System.err.println("Greška pri brisanju plana ishrane!" + ex.getMessage());
					}
				} else {
					if (!validirajZaIzmenu()) {
						return;
					}
					PlanIshrane plan = (PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE);
					int dani;
					try {
						dani = Integer.parseInt(frmPlanIshranePrikaz.getTxtDani().getText());
						if (dani <= 0) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
									"Broj dana za koji je kreiran plan mora biti veći od 0");
							return;
						}
						plan.setBrojDana(dani);
						List<StavkaPlanaIshrane> stavke = ((ModelTabeleStavkaIshrane) frmPlanIshranePrikaz
								.getTblStavke().getModel()).getStavke();
						plan.setStavke(stavke);
						BigDecimal ukupnaCena = BigDecimal.valueOf(0);
						for (StavkaPlanaIshrane st : stavke) {
							ukupnaCena = ukupnaCena.add(st.getCena());
						}
						ukupnaCena = ukupnaCena.multiply(BigDecimal.valueOf(dani));
						plan.setCena(ukupnaCena);
						frmPlanIshranePrikaz.getTxtCena().setText(ukupnaCena.toString());
					} catch (Exception pe) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Unesite broj u polje broj dana");
						return;
					}
					try {
						Date datum;
						boolean signal = false;
						if (frmPlanIshranePrikaz.getTxtDatum().isEnabled()) {
							validirajDatum();
							signal = true;
						}
						datum = new SimpleDateFormat("dd.MM.yyyy")
								.parse(frmPlanIshranePrikaz.getTxtDatum().getText().trim());
						if (!validirajPostojeciDatum()) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
									"Plan koji menjate je istekao postavite nov datum i broj dana");
							frmPlanIshranePrikaz.getTxtDatum().setText("");
							frmPlanIshranePrikaz.getTxtDani().setText("");
							return;
						}
						if (signal && datum.before(new Date())) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Unesite datum nakon današnjeg");
							return;
						}
						plan.setDatum(datum);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Unesite valjano datum");
						frmPlanIshranePrikaz.getTxtDatum().setText("");
						return;
					}
					try {
						boolean rez = Komunikacija.vratiInstancu().azurirajPlan(plan);
						if (rez) {
							JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem je zapamtio plan ishrane!");
							pripremaForme();
						}
					} catch (Exception ex) {
						System.err.println("Sistem ne može da kreira plan ishrane " + ex.getMessage());
						JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem ne može da zapamti plan ishrane!");
					}
				}
			}

			/**
			 * Provera da li je unet datum u validnom formatu
			 * 
			 * @throws Exception ako nije pravilno unesen datum
			 */
			private void validirajDatum() throws Exception {
				DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				try {
					formater.parse(frmPlanIshranePrikaz.getTxtDatum().getText().trim());
				} catch (Exception e) {
					System.err.println("Unesite valjano datum " + e.getMessage());
					throw new Exception("Unesite ispravno datum");
				}
			}

			/**
			 * Proverava da li su uneti svi podaci za plan
			 * 
			 * @return true-ako su uneti svi podaci, false suprotno.
			 */
			private boolean validirajZaIzmenu() {
				String poruka = "";
				if (frmPlanIshranePrikaz.getTxtDani().getText().trim().isEmpty()) {
					poruka += "Unesite broj dana za plan\n";
				}
				if (frmPlanIshranePrikaz.getTxtDatum().getText().trim().isEmpty()) {
					poruka += "Postavite datum\n";
				}
				if (!poruka.isEmpty()) {
					JOptionPane.showMessageDialog(frmPlanIshranePrikaz, poruka);
					return false;
				}
				return true;
			}

			/**
			 * Proverava da li je unet datum pre danasnjeg
			 * 
			 * @return true - ako je unet datum posle tekuceg, false inace
			 */
			private boolean validirajPostojeciDatum() {
				try {
					Date datum = new SimpleDateFormat("dd.MM.yyyy").parse(frmPlanIshranePrikaz.getTxtDatum().getText());
					int broj = Integer.parseInt(frmPlanIshranePrikaz.getTxtDani().getText());
					Calendar kalendar = Calendar.getInstance();
					kalendar.setTime(datum);
					kalendar.add(Calendar.DATE, broj);
					System.out.println(kalendar.getTime());
					if (kalendar.getTime().before(new Date())) {
						return false;
					}
				} catch (ParseException ex) {
				}
				return true;
			}

		});
		/**
		 * Dodaje ActionListener na dugme btnPromeniDatum u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda promeniDatum()
		 */
		frmPlanIshranePrikaz.addbtnPromeniDatumActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promeniDatum();
			}

			/**
			 * Omogucuje nutricionisti da unese datum na formi
			 */
			private void promeniDatum() {
				frmPlanIshranePrikaz.getTxtDatum().setEnabled(true);
				frmPlanIshranePrikaz.getTxtDatum().setText("");
			}
		});
		/**
		 * Dodaje ActionListener na dugme btnResetuj u formi frmPlanIshranePrikaz
		 * 
		 * Kada se dugme pritisne, poziva se metoda pripremaForme()
		 */
		frmPlanIshranePrikaz.addbtnResetujActionListener((ActionEvent e) -> {
			pripremaForme();
		});
	}

	/**
	 * Koristi se za pripremu forme FrmPlanIshranePrikaz
	 * 
	 * Poziva se prilikom otvaranja forme i obavlja neophodne inicijalizacije i
	 * popunjavanje podataka na formi.
	 */
	private void pripremaForme() {
		popuniTabelu();
		popuniCmbNutricionisti();
		popuniCbPacijenti();
		frmPlanIshranePrikaz.getPnlDets().setVisible(false);
	}

	/**
	 * Popunjava tabelu planova ishrana
	 * 
	 * @throws Exception ako dodje do greske pri ucitavanju planova iz baze
	 */
	private void popuniTabelu() {
		try {
			List<PlanIshrane> lista = Komunikacija.vratiInstancu().ucitajListuPlanova();
			ModelTabelePlanoviIshrana model = new ModelTabelePlanoviIshrana(lista);
			frmPlanIshranePrikaz.getTblPlanovi().setModel(model);
		} catch (Exception ex) {
			System.err.println("Greška u učitavanju planova!\n" + ex.getMessage());
		}
	}

	/**
	 * Proverava da li se izabrani plan ishrane moze menjati
	 * 
	 * Proverava da li je ulogovani nutricionista i kreator plana, ako jeste moze da
	 * ga menja
	 * 
	 * @return true ako moze da se menja plan, false inace
	 */
	private boolean proveraMogucnostiMenjanja() {
		PlanIshrane tekuciPlan = (PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE);
		Nutricionista tekuciAdministrator = (Nutricionista) Koordinator.vratiInstancu()
				.uzmiParametar(Konstante.NUTRICIONISTA);
		return tekuciAdministrator.equals(tekuciPlan.getNutricionista());
	}

	/**
	 * Popunjava ComboBox cmbNutricionista sa svim nutricionistima iz sistema
	 * 
	 * Prvo se uklanjaju svi postojeci elementi iz ComboBox-a. Zatim se ucitava
	 * lista nutricionista iz sistema. Ako lista nije prazna, dodaju se svi
	 * nutricionisti kao elementi ComboBox-a. Nakon dodavanja elemenata, ne
	 * postavlja se selektovani element.
	 * 
	 * @throws Exception ako dodje do greske prilikom ucitavanja
	 */
	private void popuniCmbNutricionisti() {
		try {
			frmPlanIshranePrikaz.getCmbNutricionisti().removeAllItems();
			List<Nutricionista> lista = Komunikacija.vratiInstancu().ucitajListuNutricionista();
			if (lista == null) {
				return;
			}
			for (Nutricionista n : lista) {
				frmPlanIshranePrikaz.getCmbNutricionisti().addItem(n);
			}
			frmPlanIshranePrikaz.getCmbNutricionisti().setSelectedItem(null);
		} catch (Exception ex) {
			System.err.println("Greška pri učitavanju nutricionista iz baze " + ex.getMessage());
		}
	}

	/**
	 * Popunjava ComboBox cmbPacijenti sa svim pacijentima iz sistema
	 * 
	 * Prvo se uklanjaju svi postojeci elementi iz ComboBox-a. Zatim se ucitava
	 * lista pacijenata iz sistema. Ako lista nije prazna, dodaju se svi pacijenti
	 * kao elementi ComboBox-a. Nakon dodavanja elemenata, ne postavlja se
	 * selektovani element.
	 * 
	 * @throws Exception ako dodje do greske prilikom ucitavanja
	 */
	private void popuniCbPacijenti() {
		try {
			frmPlanIshranePrikaz.getCbPacijenti().removeAllItems();
			List<Pacijent> lista = Komunikacija.vratiInstancu().ucitajListuPacijenata();
			if (lista == null) {
				return;
			}
			for (Pacijent p : lista) {
				frmPlanIshranePrikaz.getCbPacijenti().addItem(p);
			}
			frmPlanIshranePrikaz.getCbPacijenti().setSelectedItem(null);
		} catch (Exception ex) {
			System.err.println("Greška pri učitavanju pacijenata iz baze " + ex.getMessage());
		}
	}

	/**
	 * Sredjuje panel sa detaljima plana ishrane
	 * 
	 * Prikazuje cenu plana, datum pocetka plana, cenu, ime i prezime nutricioniste.
	 * Prikazuje podatke o pacijentu za koji je kreiran plan. Popunjava tabelu
	 * stavki plana ishrane sa stavkama izabranog plana.
	 * 
	 * Ako nije izabran plan za koji se prikazuju detalji dolazi do kraja metode
	 */
	private void srediPanelDets() {
		frmPlanIshranePrikaz.getPnlDets().setVisible(true);
		frmPlanIshranePrikaz.getTxtCena().setEnabled(false);
		frmPlanIshranePrikaz.getTxtDatum().setEnabled(false);
		frmPlanIshranePrikaz.getTxtDani().setEnabled(false);
		frmPlanIshranePrikaz.getTxtImeN().setEnabled(false);
		frmPlanIshranePrikaz.getTxtPrezimeN().setEnabled(false);
		frmPlanIshranePrikaz.getTxtImeP().setEnabled(false);
		frmPlanIshranePrikaz.getTxtPrezimeP().setEnabled(false);
		frmPlanIshranePrikaz.getTblStavke().setEnabled(false);
		frmPlanIshranePrikaz.getBtnDani().setEnabled(false);
		frmPlanIshranePrikaz.getBtnDatum().setEnabled(false);
		frmPlanIshranePrikaz.getBtnBrisi().setEnabled(false);

		PlanIshrane p = (PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE);
		if (p == null) {
			System.out.println("Nije izabran plan");
			return;
		}
		frmPlanIshranePrikaz.getTxtCena().setText(p.getCena().toString());
		frmPlanIshranePrikaz.getTxtDatum().setText(p.getDatum().toString());
		frmPlanIshranePrikaz.getTxtDani().setText("" + p.getBrojDana());
		frmPlanIshranePrikaz.getTxtImeN().setText(p.getNutricionista().getIme());
		frmPlanIshranePrikaz.getTxtPrezimeN().setText(p.getNutricionista().getPrezime());
		frmPlanIshranePrikaz.getTxtImeP().setText(p.getPacijent().getIme());
		frmPlanIshranePrikaz.getTxtPrezimeP().setText(p.getPacijent().getPrezime());
		ModelTabeleStavkaIshrane modelStavke = new ModelTabeleStavkaIshrane(p.getStavke());
		modelStavke.dodajRB();
		frmPlanIshranePrikaz.getTblStavke().setModel(modelStavke);
		frmPlanIshranePrikaz.getPnlJela().setVisible(false);
	}
}
