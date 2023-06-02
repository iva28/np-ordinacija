package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.planIshrane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabelePlanoviIshrana;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.planIshrane.FrmPretragaPlanaIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na formi
 * za pretragu planova ishrana na sistemu
 * 
 * @author Iva Stanisic
 */
public class KontrolerPretragaPlanaIshrane {
	/**
	 * Instanca forme za pretragu planova ishrana
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private final FrmPretragaPlanaIshrane frmPretragaPlanaIsh;

	/**
	 * Konstruktor klase KontrolerPretragaPlanaIshrane
	 * 
	 * Kontroler ima referencu ka formi klase FrmPretragaPlanaIshrane
	 * 
	 * @param frmPretragaPlanaIsh FrmPretragaPlanaIshrane objekat koji predstavlja
	 *                            formu za pretragu planova
	 */
	public KontrolerPretragaPlanaIshrane(FrmPretragaPlanaIshrane frmPretragaPlanaIsh) {
		this.frmPretragaPlanaIsh = frmPretragaPlanaIsh;
		addActionListeners();
	}

	/**
	 * Dodaje ActionListener-e na elemente na formi frmPretragaPlanaIsh
	 */
	private void addActionListeners() {
		/**
		 * Dodaje ActionListener na dugme btnPretraga u formi frmPretragaPlanaIsh
		 * 
		 * Kada se dugme pritisne, poziva se metoda nadjiPlanIshrane()
		 */
		frmPretragaPlanaIsh.addbtnPretragaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nadjiPlanIshrane();
			}

			/**
			 * Pronalazi plana ishrane
			 * 
			 * Prikuplja selektovane vrednosti nutricioniste i pacijenta iz odgovarajucih
			 * komponenti forme frmPretragaPlanaIsh. Ukoliko nije selektovan ni
			 * nutricionista ni pacijent, prikazuje se odgovarajuća poruka. Kreira objekat
			 * PlanIshrane sa prikupljenim vrednostima nutricionista i pacijenta. Poziva
			 * metodu nadjiPlanove() iz klase Komunikacija koja vraca listu pronadjenih
			 * planova ishrane. Ukoliko lista nije prazna, prikazuje se poruka o uspesnom
			 * pronalazenju planova i azurira se tabela sa pronadjenim planovima. U
			 * suprotnom, prikazuje se poruka da nije pronadjen nijedan plan ishrane. U
			 * slucaju greske, ispisuje se odgovarajuca poruka na standardni izlaz.
			 * 
			 * @throws Exception ako dodje do greske prilikom pretrazivanja plana
			 */
			private void nadjiPlanIshrane() {
				try {
					Nutricionista nutricionista = (Nutricionista) frmPretragaPlanaIsh.getCmbNutricionista()
							.getSelectedItem();
					Pacijent pacijent = (Pacijent) frmPretragaPlanaIsh.getCmbPacijenti().getSelectedItem();
					if (nutricionista == null && pacijent == null) {
						JOptionPane.showMessageDialog(frmPretragaPlanaIsh,
								"Selektujte ili pacijenta ili nutricionistu ili oba!", "GREŠKA",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					PlanIshrane plan = new PlanIshrane();
					plan.setPacijent(pacijent);
					plan.setNutricionista(nutricionista);
					List<PlanIshrane> listа = Komunikacija.vratiInstancu().nadjiPlanove(plan);
					if (listа == null || listа.isEmpty()) {
						JOptionPane.showMessageDialog(frmPretragaPlanaIsh,
								"Sistem ne može da nađe planove po zadatoj vrednosti");
					} else {
						JOptionPane.showMessageDialog(frmPretragaPlanaIsh,
								"Sistem je našao planove po zadatoj vrednosti");
						ModelTabelePlanoviIshrana model = new ModelTabelePlanoviIshrana(listа);
						frmPretragaPlanaIsh.getTblPlan().setModel(model);
					}
				} catch (Exception ex) {
					System.err.println("Greška u pretrazi plana " + ex.getMessage());
				}
			}
		});
		/**
		 * Metoda koja se poziva prilikom resetovanja pretrage plana ishrane
		 * 
		 * Postavlja selektovane vrednosti nutricioniste i pacijenta na null u
		 * odgovarajucim komponentama forme frmPretragaPlanaIsh. Postavlja prazan model
		 * tabele za prikaz planova ishrane.
		 */
		frmPretragaPlanaIsh.addbtnResetujActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetujPretragu();
			}

			/**
			 * Resetuje polja za pretragu
			 */
			private void resetujPretragu() {
				frmPretragaPlanaIsh.getCmbNutricionista().setSelectedItem(null);
				frmPretragaPlanaIsh.getCmbPacijenti().setSelectedItem(null);
				frmPretragaPlanaIsh.getTblPlan().setModel(new ModelTabelePlanoviIshrana());
			}
		});
		/**
		 * Metoda koja se poziva prilikom pritiska na dugme btnPrikaziSve u formi
		 * frmPretragaPlanaIsh
		 * 
		 * Ova metoda ima zadatak da prikaze sve planove ishrane.
		 */
		frmPretragaPlanaIsh.addbtnPrikaziSveActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prikatiSvePlanove();
			}

			/**
			 * Prikazuje sve planove ishrane
			 * 
			 * @throws Exception ako dodje do greske prilikom ucitavanja planova ishrana
			 */
			private void prikatiSvePlanove() {
				try {
					List<PlanIshrane> lista = Komunikacija.vratiInstancu().ucitajListuPlanova();
					ModelTabelePlanoviIshrana model = new ModelTabelePlanoviIshrana(lista);
					frmPretragaPlanaIsh.getTblPlan().setModel(model);
				} catch (Exception ex) {
					System.err.println("Greška pri učitavanju planova ishrana! " + ex.getMessage());
				}
			}
		});
		/**
		 * Metoda koja se poziva prilikom pritiska na dugme btnUcitaj u formi
		 * frmPretragaPlanaIsh
		 * 
		 * Ova metoda ima zadatak da ucita selektovani plan ishrane
		 */
		frmPretragaPlanaIsh.addbtnUcitajActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ucitajPlanIshrane();
			}

			/**
			 * Ucitava plan ishrane
			 * 
			 * @throws Exception ako dodje do greske prilikom ucitavanja plana
			 */
			private void ucitajPlanIshrane() {
				try {
					int red = frmPretragaPlanaIsh.getTblPlan().getSelectedRow();
					if (red == -1) {
						JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Selektujte red u tabeli");
						return;
					}
					ModelTabelePlanoviIshrana modelTabele = (ModelTabelePlanoviIshrana) frmPretragaPlanaIsh.getTblPlan()
							.getModel();
					PlanIshrane plan = modelTabele.vratiPlan(red);
					plan = Komunikacija.vratiInstancu().ucitajPlanIshrane(plan);
					if (plan != null) {
						JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Sistem je učitao plan ishrane");
						modelTabele.postaviJedan(plan);
						frmPretragaPlanaIsh.getTblPlan().setModel(modelTabele);
					} else {
						JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Sistem ne može da učita plan ishrane");
						frmPretragaPlanaIsh.dispose();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	/**
	 * Koristi se za pripremu forme FrmPretragaPlanaIsh
	 * 
	 * Poziva se prilikom otvaranja forme i obavlja neophodne inicijalizacije i
	 * popunjavanje podataka na formi.
	 */
	private void pripremiFormu() {
		frmPretragaPlanaIsh.getTblPlan().setModel(new ModelTabelePlanoviIshrana());
		popuniCbNutricionista();
		popuniCbPacijenti();
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
	private void popuniCbNutricionista() {
		try {
			frmPretragaPlanaIsh.getCmbNutricionista().removeAllItems();
			List<Nutricionista> lista = Komunikacija.vratiInstancu().ucitajListuNutricionista();
			if (lista == null) {
				return;
			}
			for (Nutricionista n : lista) {
				frmPretragaPlanaIsh.getCmbNutricionista().addItem(n);
			}
			frmPretragaPlanaIsh.getCmbNutricionista().setSelectedItem(null);
		} catch (Exception ex) {
			ex.printStackTrace();
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
			frmPretragaPlanaIsh.getCmbPacijenti().removeAllItems();
			List<Pacijent> lista = Komunikacija.vratiInstancu().ucitajListuPacijenata();
			if (lista == null) {
				return;
			}
			for (Pacijent p : lista) {
				frmPretragaPlanaIsh.getCmbPacijenti().addItem(p);
			}
			frmPretragaPlanaIsh.getCmbPacijenti().setSelectedItem(null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Koristi se za otvaranje forme 
	 * 
	 * Prethodno se poziva metoda pripremaForme() koja vrsi odredjene pripreme
	 * forme, a zatim se postavlja vidljivost forme na true, cime se forma prikazuje
	 * korisniku.
	 */
	public void otvoriFormu() {
		pripremiFormu();
		frmPretragaPlanaIsh.setVisible(true);
	}

}
