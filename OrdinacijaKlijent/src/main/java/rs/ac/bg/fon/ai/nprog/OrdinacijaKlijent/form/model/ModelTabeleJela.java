package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;

/**
 * Predstavlja model tabele za prikaz jela
 * 
 * Implementira apstraktnu klasu AbstractTableModel
 * 
 * @author Iva Stanisic
 */
public class ModelTabeleJela extends AbstractTableModel {
	/**
	 * Imena kolona na tabeli, implementirane kao niz String vrednosti
	 */
	private String[] kolone = { "Naziv", "Cena", "Količina(grami)", "Vrsta", "Kuvar" };
	/**
	 * Lista jela koja se koristi u modelu
	 */
	private List<Jelo> jela;

	/**
	 * Konstruktor koji inicijalizuje ModelTabeleJela sa datom listom jelima
	 * 
	 * @param jela lista objekata klase Jelo koja se prikazuje u tabeli
	 */
	public ModelTabeleJela(List<Jelo> jela) {
		this.jela = jela;
	}

	/**
	 * Prazan konstruktor koji inicijalizuje objekat klase ModelTabeleJela
	 */
	public ModelTabeleJela() {
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
	 * Vraca broj redova
	 * 
	 * @return broj redova
	 */
	@Override
	public int getRowCount() {
		if (jela == null)
			return 0;
		return jela.size();
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
  * Vraca vrednost na odredjenoj poziciji u tabeli, koja je prosledjena preko parametara
  * 
  * @param rowIndex broj reda u tabeli
  * @param columnIndex broj kolone u tabeli
  * @return zahtevana vrednost na datom redu i koloni
  */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Jelo j = jela.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return j.getNaziv();
		case 1:
			return j.getCena();
		case 2:
			return j.getKolicina();
		case 3:
			return j.getTip().getVrsta();
		case 4:
			return j.getKuvar().getIme() + " " + j.getKuvar().getPrezime();
		default:
			return "n/a";
		}
	}
/**
 * Vraca jelo koje se nalazi na tabeli, za prosledjeni red kao parametar
 * 
 * @param red red u tabeli
 * @return jelo na datom redu
 */
	public Jelo vratiJelo(int red) {
		return jela.get(red);
	}

}
