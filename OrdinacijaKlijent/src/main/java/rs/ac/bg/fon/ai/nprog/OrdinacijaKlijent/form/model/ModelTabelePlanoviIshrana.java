package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.PlanIshrane;

/**
 * Predstavlja model tabele za prikaz planova ishrana
 * 
 * Implementira apstraktnu klasu AbstractTableModel
 * 
 * @author Iva Stanisic
 */
public class ModelTabelePlanoviIshrana extends AbstractTableModel {
	/**
	 * Imena kolona na tabeli, implementirane kao niz String vrednosti
	 */
	private String[] kolone = { "Id", "Datum", "Cena", "Pacijent", "Nutricionista", "Broj dana" };
	/**
	 * Lista planova ishrana koja se koristi u modelu
	 */
	private List<PlanIshrane> lista;
	/**
	 * Da li je dozvoljeno menjanje polja u tabeli
	 * 
	 * True- jeste, false inace
	 */
	private boolean menjanje = false;

	/**
	 * Bezparametarski konstruktor koji inicijalizuje objekat klase ModelTabelePlanoviIshrana
	 */
	public ModelTabelePlanoviIshrana() {
		lista = new ArrayList<>();
	}

	/**
	 * Konstruktor koji inicijalizuje ModelTabelePlanoviIshrana sa datom listom
	 * planova ishrana
	 * 
	 * @param lista lista objekata klase PlanIshrane koja se prikazuje u tabeli
	 */
	public ModelTabelePlanoviIshrana(List<PlanIshrane> lista) {
		this.lista = lista;
	}

	/**
	 * Vraca da li je dozvoljeno menjanje polja
	 * 
	 * True ako je dozvoljeno menjanje, false u suprotnom
	 * 
	 * @return boolean vrednost
	 */
	public boolean isMenjanje() {
		return menjanje;
	}

	/**
	 * Postavlja da li je dozvoljeno menjanje polja na prosledjenu boolean vrednost
	 * 
	 * @param menjanje boolean vrednost da li je ili nije dozvoljeno menjanje polja
	 *                 u tabeli
	 */
	public void setMenjanje(boolean menjanje) {
		this.menjanje = menjanje;
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
	 * Vraca listu planova ishrana
	 * 
	 * @return lista planova ishrana
	 */
	public List<PlanIshrane> getLista() {
		return lista;
	}

	/**
	 * Postavlja listu planova ishrana na prosledjenu listu
	 * 
	 * @param lista lista planova
	 */
	public void setLista(List<PlanIshrane> lista) {
		this.lista = lista;
	}

	/**
	 * Postavlja jedan plan ishrane na tabelu
	 * 
	 * @param plan plan ishrane koji se postavlja
	 */
	public void postaviJedan(PlanIshrane plan) {
		lista = new ArrayList<>();
		lista.add(plan);
		fireTableDataChanged();
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
		PlanIshrane p = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getPlanIshraneId();
		case 1:
			return p.getDatum();
		case 2:
			return p.getCena();
		case 3:
			return p.getPacijent().getIme() + " " + p.getPacijent().getPrezime();
		case 4:
			return p.getNutricionista().getIme() + " " + p.getNutricionista().getPrezime();
		case 5:
			return p.getBrojDana();
		default:
			return "n/a";
		}
	}

	/**
	 * Vraca plan ishrane za prosledjeni red u tabeli planova ishrana
	 * 
	 * @param red red u tabeli planova ishrana
	 * @return plan ishrane u datom redu
	 */
	public PlanIshrane vratiPlan(int red) {
		return lista.get(red);
	}
}
