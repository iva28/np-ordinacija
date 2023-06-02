package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.jelo;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.jelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na formi
 * za dodavanje novog jela na sistem
 * 
 * @author Iva Stanisic
 */
public class KontrolerNovoJelo {
	/**
	 * Instanca forme za dodelu jela
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private final FrmNovoJelo frmNovoJelo;

	/**
	 * Konstruktor klase KontrolerNovoJelo
	 * 
	 * Kontroler ima referencu ka dialogu klase FrmNovoJelo
	 * 
	 * @param frmNovoJelo FrmNovoJelo objekat koji predstavlja dijalog za unos novog
	 *                    jela
	 */
	public KontrolerNovoJelo(FrmNovoJelo frmNovoJelo) {
		this.frmNovoJelo = frmNovoJelo;
		addActionListener();
	}

	/**
	 * Koristi se za otvaranje forme FrmNovoJelo
	 * 
	 * Prethodno se poziva metoda pripremaForme() koja vrsi odredjene pripreme
	 * forme, a zatim se postavlja vidljivost forme na true, cime se forma prikazuje
	 * korisniku.
	 */
	public void otvoriFormu() {
		pripremaForme();
		frmNovoJelo.setVisible(true);
	}
	/**
	 * Dodaje ActionListener-e na elemente na formi frmNovoJelo
	 */
	private void addActionListener() {
		frmNovoJelo.addbtnJeloActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				novoJelo();
			}
			/**
		     * Poziva kada se izvrsi akcija na dugmetu btnJelo i kreira novo jelo 
		     * 
		     * Prvo se vrsi validacija unetih podataka, kao sto su naziv jela, cena i kolicina.
		     * Ako su sva polja pravilno popunjena, kreira se objekat Jelo sa unetim podacima.
		     * Zatim se poziva metoda sacuvajJelo() iz klase Komunikacija kako bi se jelo sacuvalo u bazi podataka.
		     * Na kraju se prikazuje odgovarajuća poruka korisniku, a forma se zatvara.
		     * 
		     * @throws Exception ako dodje do greske pri cuvanju jela
		     */
			private void novoJelo() {
				try {
					String naziv = frmNovoJelo.getTxtNaziv().getText().trim();
					TipJela tip = (TipJela) frmNovoJelo.getCbTipJela().getSelectedItem();
					Kuvar kuvar = (Kuvar) frmNovoJelo.getCbKuvar().getSelectedItem();
					if (naziv.isEmpty() || frmNovoJelo.getTxtCena().getText().trim().isEmpty()
							|| frmNovoJelo.getTxtKolicina().getText().isEmpty()
							|| frmNovoJelo.getCbKuvar().getSelectedItem() == null
							|| frmNovoJelo.getCbTipJela().getSelectedItem() == null) {
						JOptionPane.showMessageDialog(frmNovoJelo, "Sva polja moraju biti popunjena!");
						return;
					}
					if (validnostNaziva(frmNovoJelo.getTxtNaziv().getText().trim())) {
						JOptionPane.showMessageDialog(frmNovoJelo, "Nema brojeva u nazivu jela");
						frmNovoJelo.getTxtNaziv().setText("");
						return;
					}
					if (!frmNovoJelo.getTxtCena().getText().trim().matches("[0-9]+")) {
						JOptionPane.showMessageDialog(frmNovoJelo, "Cena jela se izražava u brojevima");
						frmNovoJelo.getTxtCena().setText("");
						return;
					}
					BigDecimal cena = new BigDecimal(frmNovoJelo.getTxtCena().getText().trim().replaceAll(" ", ""));
					if (!frmNovoJelo.getTxtKolicina().getText().trim().matches("[0-9]+")) {
						JOptionPane.showMessageDialog(frmNovoJelo, "Gramaža jela se izražava u brojevima");
						frmNovoJelo.getTxtKolicina().setText("");
						return;
					}
					int kolicina = Integer.parseInt(frmNovoJelo.getTxtKolicina().getText().trim());

					Jelo jelo = new Jelo(Long.MIN_VALUE, tip, naziv, cena, kolicina, kuvar);
					boolean rez = Komunikacija.vratiInstancu().sacuvajJelo(jelo);
					if (rez) {
						JOptionPane.showMessageDialog(null, "Novo jelo je kreirano!");
					} else {
						JOptionPane.showMessageDialog(null, "GREŠKA u kreiranju novog jela, već postoji u bazi!");
					}
					frmNovoJelo.dispose();
				} catch (Exception ex) {
					System.err.println("Greška u čuvanju jela!\n" + ex.getMessage());
				}
			}
			/**
			 * Proverava validnost naziva jela
			 * 
			 * Proverava se da li naziv jela sadrzi bilo koji broj.
			 * 
			 * @param jelo Naziv jela koji se proverava
			 * @return boolean vrednost, ako naziv jela sadrži brojeve vraca se true, false inace
			 */
			private boolean validnostNaziva(String jelo) {
				for (int i = 0; i < jelo.length(); i++)
					if (Character.isDigit(jelo.charAt(i)))
						return true;
				return false;
			}
		});
	}

	/**
	 * Priprema forme za prikazivanje
	 * 
	 * Ova metoda se poziva pre otvaranja dijaloga FrmNovoJelo. Sluzi za
	 * inicijalizaciju i podesavanje komponenti dijaloga pre nego sto bude prikazan
	 */
	private void pripremaForme() {
		vratiTipoveJela();
		vratiKuvare();
	}

	/**
	 * Koristi se za popunjavanje ComboBox-a cbTipJela sa tipovima jela
	 * 
	 * Metoda prvo uklanja sve stavke iz ComboBox-a, a zatim preko objekta klase
	 * Komunikacija i njegove staticke metode vratiInstancu() poziva metodu
	 * vratiTipoveJela() koja vraca listu svih tipova jela.
	 * 
	 * Ukoliko lista tipova jela nije null, petljom se prolazi kroz listu i svaki
	 * tip jela se dodaje kao stavka u ComboBox cbTipJela. Na kraju se postavlja
	 * selektovana stavka na null.
	 * 
	 * @throws Exception ako dodje do greske prilikom ucitavanja jela
	 */
	private void vratiTipoveJela() {
		try {
			frmNovoJelo.getCbTipJela().removeAllItems();
			List<TipJela> tipovi = Komunikacija.vratiInstancu().vratiTipoveJela();
			if (tipovi == null) {
				return;
			}
			for (TipJela t : tipovi) {
				frmNovoJelo.getCbTipJela().addItem(t);
			}
			frmNovoJelo.getCbTipJela().setSelectedItem(null);
		} catch (Exception ex) {
			System.err.println("Greška u učitavanju tipova jela! " + ex.getMessage());
		}
	}

	/**
	 * Koristi se za popunjavanje ComboBox-a cbKuvar sa kuvarima
	 * 
	 * Metoda prvo uklanja sve stavke iz ComboBox-a, a zatim preko objekta klase
	 * Komunikacija i njegove staticke metode vratiInstancu() poziva metodu
	 * vratiKuvare() koja vraca listu svih kuvara.
	 * 
	 * Ukoliko lista kuvara nije null, petljom se prolazi kroz listu i svaki kuvar
	 * se dodaje kao stavka u ComboBox cbKuvar. Na kraju se postavlja selektovana
	 * stavka na null.
	 * 
	 * @throws Exception ako dodje do greske prilikom ucitavanja kuvara
	 */
	private void vratiKuvare() {
		try {
			frmNovoJelo.getCbKuvar().removeAllItems();
			List<Kuvar> kuvari = Komunikacija.vratiInstancu().vratiKuvare();
			if (kuvari == null) {
				return;
			}
			for (Kuvar k : kuvari) {
				frmNovoJelo.getCbKuvar().addItem(k);
			}
			frmNovoJelo.getCbKuvar().setSelectedItem(null);
		} catch (Exception ex) {
			System.err.println("Greška u učitavanju kuvara! " + ex.getMessage());
		}
	}

}
