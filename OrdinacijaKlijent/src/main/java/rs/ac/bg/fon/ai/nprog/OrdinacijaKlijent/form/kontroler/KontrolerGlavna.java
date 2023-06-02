package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.FrmGlavna;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.konstante.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Predstavlja kontrolera koji upravlja dogadjajima i funkcionalnostima na
 * glavnoj formi
 * 
 * @author Iva Stanisic
 */
public class KontrolerGlavna {

	/**
	 * Instanca glavne forme
	 * 
	 * Nakon inicijalizacije nema promene vrednosti
	 */
	private final FrmGlavna frmGlavna;

	/**
	 * Konstruktor koji inicijalizuje kontroler glavne forme
	 * 
	 * @param frmGlavna referenca na glavnu formu
	 */
	public KontrolerGlavna(FrmGlavna frmGlavna) {
		this.frmGlavna = frmGlavna;
		addActionListeners();
	}

	/**
	 * Vraca referencu na glavnu formu
	 * 
	 * @return referenca na frmGlavna
	 */
	public FrmGlavna getFrmGlavna() {
		return frmGlavna;
	}

	/**
	 * Otvara glavnu formu frmGlavna i prikazuje njen sadrzaj
	 */
	public void otvoriFormu() {
		Nutricionista n = (Nutricionista) Koordinator.vratiInstancu().uzmiParametar(Konstante.NUTRICIONISTA);
		frmGlavna.getTxtIme().setText(n.getIme());
		frmGlavna.getTxtIme().setEnabled(false);

		frmGlavna.getTxtPrezime().setText(n.getPrezime());
		frmGlavna.getTxtPrezime().setEnabled(false);

		frmGlavna.getTxtOrd().setText(n.getOrdinacija().getNaziv());
		frmGlavna.getTxtOrd().setEnabled(false);

		frmGlavna.setVisible(true);
	}

	/**
	 * Dodaje ActionListener-e na elemente u glavnoj formi
	 */
	private void addActionListeners() {
		/**
		 * Dodaje ActionListener na dugme "Dodaj pacijenta" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za otvaranje forme za unos novog pacijenta
		 */
		frmGlavna.jMenuItemDodajacijentaAddActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Koordinator.vratiInstancu().otvoriFrmNoviPacijent(null);
			}
		});
		/**
		 * Dodaje ActionListener na dugme "Izmeni pacijenta" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za otvaranje forme za izmenu pacijenata
		 */
		frmGlavna.jMenuItemIzmeniPacijentaAddActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuItemIzmeniPacijentaActionListener(e);
			}

			private void jMenuItemIzmeniPacijentaActionListener(ActionEvent e) {
				Koordinator.vratiInstancu().otvoriFrmSviPacijenti();
			}

		});
		/**
		 * Dodaje ActionListener na dugme "Dodaj jelo" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za otvaranje forme za dodavanje jela
		 */
		frmGlavna.jMenuItemDodajJeloAddActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuItemDodajJeloActionListener(e);
			}

			private void jMenuItemDodajJeloActionListener(ActionEvent e) {
				Koordinator.vratiInstancu().otvoriFrmNovoJelo();
			}
		});
		/**
		 * Dodaje ActionListener na dugme "Pretraga jela" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za otvaranje forme za pretragu jela
		 */
		frmGlavna.jMenuItemPretragaJelaAddActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuItemPretragaJelaActionListener(e);
			}

			private void jMenuItemPretragaJelaActionListener(ActionEvent e) {
				Koordinator.vratiInstancu().otvoriFrmPretragaJela();
			}
		});
		/**
		 * Dodaje ActionListener na dugme "Kreiraj plan ishrane" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za otvaranje forme za kreiranje plana ishrane
		 */
		frmGlavna.jMenuItemKreirajPlanIshraneAddActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuItemKreirajPlanIshraneActionListener(e);
			}

			private void jMenuItemKreirajPlanIshraneActionListener(ActionEvent e) {
				Koordinator.vratiInstancu().otvoriFrmKreirajPlanIshrane();
			}
		});
		/**
		 * Dodaje ActionListener na dugme "Manipulacija planom" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za otvaranje forme za prikaz planova ishrana
		 */
		frmGlavna.jMenuItemManipulacijaPlanIshraneAddActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuItemManipulacijaPlanIshraneActionListener(e);
			}

			private void jMenuItemManipulacijaPlanIshraneActionListener(ActionEvent e) {
				Koordinator.vratiInstancu().otvoriFrmPlanIshranePrikaz();
			}
		});
		/**
		 * Dodaje ActionListener na dugme "Pretraga plana" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za otvaranje forme za pretragu planova ishrana
		 */
		frmGlavna.jMenuItemPretragaPlanaAddActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuItemPretragaPlanaActionListener(e);
			}

			private void jMenuItemPretragaPlanaActionListener(ActionEvent e) {
				Koordinator.vratiInstancu().otvoriFrmPretragaPlanaIshrane();
			}
		});
		/**
		 * Dodaje ActionListener na dugme "Odjavi se" na glavnoj formi
		 * 
		 * Klikom na dugme, poziva se metoda za odjavljivanje nutricioniste sa sistema
		 */
		frmGlavna.jMenuItemOdjavaAddActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jMenuItemOdjavaActionListener(e);
			}

			private void jMenuItemOdjavaActionListener(ActionEvent e) {
				Koordinator.vratiInstancu().odjaviSe();
			}
		});
		/**
		 * Klikom na exit dugme automatski se odjavljuje prijavljeni nutricionista
		 * 
		 */
		frmGlavna.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Koordinator.vratiInstancu().odjaviSe();
			}
		});
	}

}
