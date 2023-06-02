package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.jelo;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.jelo.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabeleJela;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.Komunikacija;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na formi
 * za pretragu jela na sistemu
 * 
 * @author Iva Stanisic
 */
public class KontrolerPretragaJela {
	/**
	 * Instanca forme za pretragu jela
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private final FrmPretragaJela frmPretragaJela;

	/**
	 * Konstruktor klase KontrolerPretragaJela
	 * 
	 * Kontroler ima referencu ka formi klase FrmPretragaJela
	 * 
	 * @param frmPretragaJela FrmPretragaJela objekat koji predstavlja formu za pretragu jela
	 * 
	 */
	public KontrolerPretragaJela(FrmPretragaJela frmPretragaJela) {
		this.frmPretragaJela = frmPretragaJela;
		addActionListeners();
	}

	/**
	 * Koristi se za otvaranje forme FrmPretragaJela
	 * 
	 * Prethodno se poziva metoda pripremaForme() koja vrsi odredjene pripreme
	 * forme, a zatim se postavlja vidljivost forme na true, cime se forma prikazuje
	 * korisniku.
	 */
	public void otvoriFormu() {
		pripremaForme();
		frmPretragaJela.setVisible(true);
	}

	/**
	 * Dodaje ActionListener-e na elemente na formi frmPretragaJela
	 */
	private void addActionListeners() {
		/**
		 * Dodaje ActionListener na dugme btnNewJelo na formi FrmPretragaJela
		 * 
		 * Kada se dugme pritisne, poziva se metoda otvoriFrmNovoJelo() iz objekta
		 * Koordinator kako bi se otvorila forma za dodavanje novog jela.
		 */
		frmPretragaJela.addbtnNewJeloActionListener((ActionEvent e) -> {
			Koordinator.vratiInstancu().otvoriFrmNovoJelo();
		});

		/**
		 * Dodaje ActionListener na dugme btnRefresh na formi FrmPretragaJela
		 * 
		 * Kada se dugme pritisne, poziva se metoda pripremaForme() kako bi se
		 * pripremila forma za pretragu jela.
		 */
		frmPretragaJela.addbtnRefreshActionListener((ActionEvent e) -> {
			pripremaForme();
		});
		/**
		 * Dodaje ActionListener na dugme btnSearch na formi FrmPretragaJela
		 * 
		 * Kada se dugme pritisne, poziva se metoda pretragaJela() koja pretrazuje jela na osnovu izabranih opcija u combo box-ovima.
		 */
		frmPretragaJela.addbtnSearchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pretragaJela();
			}
			 /**
		     * Metoda za pretragu jela na osnovu izabranih opcija u combo box-ovima
		     * 
		     * Prvo se dobavljaju izabrani tip jela i kuvar iz combo box-ova.
		     * Ako nijedna opcija nije izabrana, prikazuje se odgovarajuca poruka.
		     * Nakon toga se kreira objekat Jelo sa izabranim tipom jela i kuvarom.
		     * Poziva se metoda nadjiJela() iz objekta Komunikacija kako bi se dobila lista jela
		     * koja zadovoljavaju zadati filter. Ako lista jela nije prazna, kreira se
		     * ModelTabeleJela i postavlja se kao model tabele na formi FrmPretragaJela.
		     * U suprotnom se prikazuje poruka da nema jela po datom filteru.
		     * 
		     * @throws Exception ako dodje do greske prilikom pretrage jela
		     */
			private void pretragaJela() {
				try {
					TipJela tip = (TipJela) frmPretragaJela.getCbTipJela().getSelectedItem();
					Kuvar kuvar = (Kuvar) frmPretragaJela.getCbKuvar().getSelectedItem();
					if (tip == null && kuvar == null) {
						JOptionPane.showMessageDialog(frmPretragaJela, "Mora se popuniti bar jedna opcija");
						return;
					}
					Jelo jelo = new Jelo(null, tip, "", null, 0, kuvar);
					List<Jelo> listа = Komunikacija.vratiInstancu().nadjiJela(jelo);
					if (listа == null)
						JOptionPane.showMessageDialog(frmPretragaJela, "Nema jela po datom filteru!");
					else {
						ModelTabeleJela model = new ModelTabeleJela(listа);
						frmPretragaJela.getTblJela().setModel(model);
					}

				} catch (Exception ex) {
					System.err.println("Greška pri pretrazi jela! " + ex.getMessage());
				}
			}
		});

	}

	/**
	 * Koristi se za pripremu forme FrmPretragaJela
	 * 
	 * Poziva se prilikom otvaranja forme i obavlja neophodne inicijalizacije i
	 * popunjavanje podataka na formi.
	 */
	private void pripremaForme() {
		popuniTabelu();
		popuniCbTipJela();
		popuniCbKuvari();
	}

	/**
	 * Popunjava tabelu na formi FrmPretragaJela sa podacima o jelima
	 * 
	 * @throws Exception ako dodje do greske prilikom ucitavanja jela
	 */
	private void popuniTabelu() {
		try {
			List<Jelo> lista = Komunikacija.vratiInstancu().vratiJela();
			ModelTabeleJela model = new ModelTabeleJela(lista);
			frmPretragaJela.getTblJela().setModel(model);
		} catch (Exception ex) {
			System.err.println("Greška u učitavanju jela! " + ex.getMessage());
		}
	}

	/**
	 * Popunjava comboBox cbTipJela na formi FrmPretragaJela sa svim dostupnim
	 * tipovima jela
	 * 
	 * @throws Exception ako dodje do greske prilikom ucitavanja tipova jela
	 */
	private void popuniCbTipJela() {
		try {
			frmPretragaJela.getCbTipJela().removeAllItems();
			List<TipJela> tipovi = Komunikacija.vratiInstancu().vratiTipoveJela();
			if (tipovi == null) {
				return;
			}
			for (TipJela t : tipovi) {
				frmPretragaJela.getCbTipJela().addItem(t);
			}
			frmPretragaJela.getCbTipJela().setSelectedItem(null);
		} catch (Exception ex) {
			System.err.println("Greška u popunjavanju combo boxa za tip jela! " + ex.getMessage());
		}
	}

	/**
	 * Popunjava comboBox cbKuvari na formi FrmPretragaJela sa svim dostupnim
	 * kuvarima jela
	 * 
	 * @throws Exception ako dodje do greske prilikom ucitavanja kuvara
	 */

	private void popuniCbKuvari() {
		try {
			frmPretragaJela.getCbKuvar().removeAllItems();
			List<Kuvar> kuvari = Komunikacija.vratiInstancu().vratiKuvare();
			if (kuvari == null) {
				return;
			}
			for (Kuvar k : kuvari) {
				frmPretragaJela.getCbKuvar().addItem(k);
			}
			frmPretragaJela.getCbKuvar().setSelectedItem(null);
		} catch (Exception ex) {
			System.err.println("Greška u popunjavanju combo boxa za kuvare! " + ex.getMessage());
		}
	}

}
