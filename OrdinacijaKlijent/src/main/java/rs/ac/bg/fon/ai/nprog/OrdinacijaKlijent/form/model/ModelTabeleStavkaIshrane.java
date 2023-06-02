package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 * Predstavlja model tabele za prikaz svih stavki na planu ishrane
 * 
 * Implementira apstraktnu klasu AbstractTableModel
 * 
 * @author Iva Stanisic
 */
public class ModelTabeleStavkaIshrane extends AbstractTableModel {
	/**
	 * Imena kolona na tabeli, implementirane kao niz String vrednosti
	 */
	private String[] kolone = { "Rb", "Naziv jela", "Vrsta jela", "Kuvar", "Cena", "Količina" };
	/**
	 * Lista stavki plana ishrane koja se koristi u modelu
	 */
	private List<StavkaPlanaIshrane> stavke;

	/**
	 * Bezparametarski konstruktor koji inicijalizuje objekat klase
	 * ModelTabeleStavkaIshrane
	 */
	public ModelTabeleStavkaIshrane() {
		stavke = new ArrayList<>();
	}

	/**
	 * Konstruktor koji inicijalizuje ModelTabeleStavkaIshrane sa datom listom
	 * stavki plana ishrane
	 * 
	 * @param lista lista objekata klase StavkaPlanaIshrane koja se prikazuje u
	 *              tabeli
	 */
	public ModelTabeleStavkaIshrane(List<StavkaPlanaIshrane> stavke) {
		this.stavke = stavke;
	}

	/**
	 * Vraca broj redova
	 * 
	 * @return broj redova
	 */
	@Override
	public int getRowCount() {
		return stavke.size();
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
	 * Vraca vrednost na odredjenoj poziciji u tabeli, koja je prosledjena preko
	 * parametara
	 * 
	 * @param rowIndex    broj reda u tabeli
	 * @param columnIndex broj kolone u tabeli
	 * @return zahtevana vrednost na datom redu i koloni
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		StavkaPlanaIshrane stavka = stavke.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return stavka.getRb();
		case 1:
			return stavka.getJelo().getNaziv();
		case 2:
			return stavka.getJelo().getTip().getVrsta();
		case 3:
			return stavka.getJelo().getKuvar().getIme() + " " + stavka.getJelo().getKuvar().getPrezime();
		case 4:
			return stavka.getCena();
		case 5:
			return stavka.getKolicina();
		default:
			return "";
		}
	}

	/**
	 * Vraca listu stavki na planu ishrane
	 * 
	 * @return lista stavki na planu ishrane
	 */
	public List<StavkaPlanaIshrane> getStavke() {
		return stavke;
	}

	/**
	 * Dodaje redni broj stavki plana
	 */
	public void dodajRB() {
		Long rb = 1L;
		for (StavkaPlanaIshrane st : stavke) {
			st.setRb(rb);
			rb++;
		}
	}

	/**
	 * Vraca stavku plana za prosledjeni red
	 * 
	 * @param red red u tabeli stavki
	 * @return stavka u prosledjenom redu
	 */
	public StavkaPlanaIshrane vratiStavku(int red) {
		return stavke.get(red);
	}

	/**
	 * Dodaje stavku na tabelu
	 * 
	 * @param st stavka koja se dodaje na plan ishrane
	 */
	public void dodaj(StavkaPlanaIshrane st) {
		stavke.add(st);
		dodajRB();
		fireTableDataChanged();
	}

	/**
	 * Brise stavku sa plana ishrane
	 * 
	 * @param red red u tabeli na kom se nalazi stavka za brisanje
	 */
	public void obrisi(int red) {
		stavke.remove(red);
		dodajRB();
		fireTableDataChanged();
	}

	/**
	 * Proverava da li se jelo nalazi na stavki plana
	 * 
	 * @param j jelo za koje se proverava da li je na stavki plana ishrane
	 * @return true - nalazi se na stavki, false inace
	 */
	public boolean postoji(Jelo j) {
		for (StavkaPlanaIshrane s : stavke) {
			if (s.getJelo().equals(j))
				return true;
		}
		return false;
	}
}
