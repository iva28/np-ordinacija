package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;

/**
 *
 * @author Iva
 */
public class ModelTabeleLogovani extends AbstractTableModel {

    private final String[] kolone = {"Ime", "Prezime", "Username", "Broj prijava"};
    private List<Nutricionista> lista;
    private List<Nutricionista> listaSvi = new ArrayList<>();

    public ModelTabeleLogovani() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

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
            case 3: return brojPrijavaNutricioniste(n);
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    private int brojPrijavaNutricioniste(Nutricionista nutricionista) {
        int i = 0;
        for (Nutricionista n : listaSvi) {
            if (n.equals(nutricionista))
                i++;
        }
        return i;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Nutricionista> getLista() {
        return lista;
    }
    
    private boolean postojiNaTableli(Nutricionista n) {
        for(Nutricionista nutr : lista) {
            if(nutr.equals(n))
                return true;
        }
        return false;
    }
    public void dodaj(Nutricionista n) {
        listaSvi.add(n);
        if(!postojiNaTableli(n))        
             lista.add(n);
        fireTableDataChanged();
    }

    public void obrisi(Nutricionista n) {
        lista.remove(n);
        fireTableDataChanged();
    }
    
    public void obrisiSve() {
        lista = new ArrayList<>();
        listaSvi = new ArrayList<>();
    }

}
