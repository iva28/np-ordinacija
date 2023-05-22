/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Jelo;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.StavkaPlanaIshrane;

/**
 *
 * @author Iva
 */
public class ModelTabeleStavkaIshrane extends AbstractTableModel{
    private String[] kolone = {"Rb","Naziv jela","Vrsta jela","Kuvar","Cena","Količina"};
    private List<StavkaPlanaIshrane> stavke;

    public ModelTabeleStavkaIshrane() {
        stavke = new ArrayList<>();
    }

    public ModelTabeleStavkaIshrane(List<StavkaPlanaIshrane> stavke) {
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        if (column > kolone.length) return "n/a";
        return kolone[column];
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPlanaIshrane stavka = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0: return stavka.getRb();
            case 1: return stavka.getJelo().getNaziv();
            case 2: return stavka.getJelo().getTip().getVrsta();
            case 3: return stavka.getJelo().getKuvar().getIme()+" "+stavka.getJelo().getKuvar().getPrezime();
            case 4: return stavka.getCena();
            case 5: return stavka.getKolicina();
            default: return "";
        }
    }

    public List<StavkaPlanaIshrane> getStavke() {
        return stavke;
    }
 
    public void dodajRB(){
        Long rb = 1L;
        for (StavkaPlanaIshrane st : stavke) {
            st.setRb(rb);
            rb++;
        }
    }
    
    public StavkaPlanaIshrane vratiStavku(int red) {
        return stavke.get(red);
    }
    public void dodaj(StavkaPlanaIshrane st) {
        stavke.add(st);
        dodajRB();
        fireTableDataChanged();
    }
    
    public void obrisi (int red) {
        stavke.remove(red);
        dodajRB();
        fireTableDataChanged();
    }
    
    public boolean postoji (Jelo j) {
        for (StavkaPlanaIshrane s : stavke) {
            if (s.getJelo().equals(j))
                return true;
        }
        return false;
    }
}
