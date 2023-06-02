package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Predstavlja model tabele za prikaz pacijenata
 * 
 * Implementira apstraktnu klasu AbstractTableModel
 * 
 * @author Iva Stanisic
 */
public class ModelTableSviPacijenti extends AbstractTableModel {
	/**
	 * Imena kolona na tabeli, implementirane kao niz String vrednosti
	 */
	private String[] kolone = { "Ime", "Prezime", "Email", "Telefon", "Pol" };
	/**
	 * Lista pacijenata koja se koristi u modelu
	 */
	private List<Pacijent> pacijenti;
	/**
	 * Da li je dozvoljeno menjanje polja u tabeli
	 * 
	 * True- jeste, false inace
	 */
	private boolean editable = false;

	/**
	 * Konstruktor koji inicijalizuje ModelTableSviPacijenti sa datom listom
	 * pacijenata
	 * 
	 * @param lista lista objekata klase Pacijent koja se prikazuje u tabeli
	 */
	public ModelTableSviPacijenti(List<Pacijent> patients) {
		this.pacijenti = patients;
	}

	/**
	 * Vraca imena kolona
	 * 
	 * @param column broj kolone cije se ime vraca
	 * @return ime kolone kao String
	 */
	@Override
	public String getColumnName(int column) {
		if (column > kolone.length)
			return "n/a";
		return kolone[column];
	}

	/**
	 * Vraca da li je dozvoljeno menjanje polja na odredjenom mestu u tabeli
	 * 
	 * True ako je dozvoljeno menjanje, false u suprotnom
	 * 
	 * @return boolean vrednost
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return editable;
	}

	/**
	 * Vraca da li je dozvoljeno menjanje polja generalno
	 * 
	 * True ako je dozvoljeno menjanje, false u suprotnom
	 * 
	 * @return boolean vrednost
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Postavlja da li je dozvoljeno menjanje polja na prosledjenu boolean vrednost
	 * 
	 * @param menjanje boolean vrednost da li je ili nije dozvoljeno menjanje polja
	 *                 u tabeli
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	/**
	 * Vraca broj redova
	 * 
	 * @return broj redova
	 */
	@Override
	public int getRowCount() {
		if (pacijenti == null)
			return 0;
		return pacijenti.size();
	}

	/**
	 * Vraca broj kolona
	 * 
	 * @return broj kolona
	 */
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	/**
	 * Vraca vrednost na odredjenoj poziciji u tabeli, koja je prosledjena preko
	 * parametara
	 * 
	 * @param rowIndex    broj reda u tabeli
	 * @param columnIndex broj kolone u tabeli
	 * @return zahtevana vrednost na datom redu i koloni
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pacijent p = pacijenti.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getIme();
		case 1:
			return p.getPrezime();
		case 2:
			return p.getEmail();
		case 3:
			return p.getTelefon();
		case 4:
			return p.getPol();
		default:
			return "n/a";
		}
	}

	/**
	 * Vraca pacijenta u prosledjenom redu u tabeli
	 * 
	 * @param row red u tabeli za koji se trazi pacijent
	 * @return pacijent u datom redu
	 */
	public Pacijent getPacijentAt(int row) {
		return pacijenti.get(row);
	}

}
