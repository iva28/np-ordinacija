package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;

/**
 * Predstavlja model tabele za prikaz ulogovanih nutricionista na sistem
 * 
 * Implementira apstraktnu klasu AbstractTableModel
 * 
 * @author Iva Stanisic
 */
public class ModelTabeleLogovani extends AbstractTableModel {

	/**
	 * Imena kolona na tabeli, implementirane kao niz String vrednosti
	 */
	private final String[] kolone = { "Ime", "Prezime", "Username", "Broj prijava" };
	/**
	 * Lista trenutno ulogovanih nutricionista koja se koristi u modelu
	 */
	private List<Nutricionista> lista;
	/**
	 * Lista svih nutricionista koji su se ulogovani dok je radio server
	 */
	private List<Nutricionista> listaSvi = new ArrayList<>();

	/**
	 * Konstruktor koji inicijalizuje ModelTabeleLogovani
	 * 
	 */
	public ModelTabeleLogovani() {
		lista = new ArrayList<>();
	}

	/**
	 * Vraca broj redova
	 * 
	 * @return broj redova
	 */
	@Override
	public int getRowCount() {
		return lista.size();
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
		Nutricionista n = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return n.getIme();
		case 1:
			return n.getPrezime();
		case 2:
			return n.getUsername();
		case 3:
			return brojPrijavaNutricioniste(n);
		default:
			return "n/a";
		}
	}

	/**
	 * Vraca da li je dozvoljeno menjanje polja generalno
	 * 
	 * True ako je dozvoljeno menjanje, false u suprotnom
	 * 
	 * @return boolean vrednost
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * Vraca broj trenutno prijavljenih nutricionista na serveru
	 * 
	 * @param nutricionista nutricionista na serveru
	 * @return broj prijavljenih nutricionista
	 */
	private int brojPrijavaNutricioniste(Nutricionista nutricionista) {
		int i = 0;
		for (Nutricionista n : listaSvi) {
			if (n.equals(nutricionista))
				i++;
		}
		return i;
	}

	/**
	 * Vraca imena kolona
	 * 
	 * @param column broj kolone cije se ime vraca
	 * @return ime kolone kao String
	 */
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	/**
	 * Vraca listu ulogovanih nutricionista
	 * 
	 * @return lista ulogovanih nutricionista
	 */
	public List<Nutricionista> getLista() {
		return lista;
	}

	/**
	 * Proverava da li je nutricionista prikazan na tabeli ulogovanih
	 * 
	 * @param n nutricionista
	 * @return true-jeste, false-nije
	 */
	private boolean postojiNaTableli(Nutricionista n) {
		for (Nutricionista nutr : lista) {
			if (nutr.equals(n))
				return true;
		}
		return false;
	}

	/**
	 * Dodaje nutricionistu u listu i na tabelu
	 * 
	 * @param n nutricionista koji se dodaje
	 */
	public void dodaj(Nutricionista n) {
		listaSvi.add(n);
		if (!postojiNaTableli(n))
			lista.add(n);
		fireTableDataChanged();
	}

	/**
	 * Brise nutricionistu iz liste i sa tabele
	 * 
	 * @param n nutricionista koji se brise
	 */
	public void obrisi(Nutricionista n) {
		lista.remove(n);
		fireTableDataChanged();
	}

	/**
	 * Brise sve nutricioniste
	 */
	public void obrisiSve() {
		lista = new ArrayList<>();
		listaSvi = new ArrayList<>();
	}

}
