/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class ModelTableSviPacijenti extends AbstractTableModel{
    private String[] kolone = {"Ime","Prezime","Email","Telefon","Pol"};
    private List<Pacijent> pacijenti;
    private boolean editable = false;

    public ModelTableSviPacijenti(List<Pacijent> patients) {
        this.pacijenti = patients;
    }

    @Override
    public String getColumnName(int column) {
        if (column > kolone.length) return "n/a";
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    @Override
    public int getRowCount() {
        if (pacijenti == null)
            return 0;
        return pacijenti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacijent p = pacijenti.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getIme();
            case 1: return p.getPrezime();
            case 2: return p.getEmail();
            case 3: return p.getTelefon();
            case 4: return p.getPol();
            default:
                return "n/a";
        }
    }
    
    public Pacijent getPacijentAt(int row) {
        return pacijenti.get(row);
    }
    
}
