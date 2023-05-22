/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;

/**
 *
 * @author Iva
 */
public class ModelTabeleJela extends AbstractTableModel{
    private String[] kolone = {"Naziv","Cena","Količina(grami)","Vrsta","Kuvar"};
    private List<Jelo> jela;

    public ModelTabeleJela(List<Jelo> jela) {
        this.jela = jela;
    }

    public ModelTabeleJela() {
    }

    
    @Override
    public String getColumnName(int column) {
        if (column > kolone.length) return "n/a";
        return kolone[column];
    }
    
    
    @Override
    public int getRowCount() {
        if(jela == null)
            return 0;
        return jela.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jelo j = jela.get(rowIndex);
        switch (columnIndex) {
            case 0: return j.getNaziv();
            case 1: return j.getCena();
            case 2: return j.getKolicina();
            case 3: return j.getTip().getVrsta();
            case 4: return j.getKuvar().getIme() +" "+j.getKuvar().getPrezime();
            default: return "n/a";
        }
    }
    
    public Jelo vratiJelo (int red) {
        return jela.get(red);
    }
    
}
