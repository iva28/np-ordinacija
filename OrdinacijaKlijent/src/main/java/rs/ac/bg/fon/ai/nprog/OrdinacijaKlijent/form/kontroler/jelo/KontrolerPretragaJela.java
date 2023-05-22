/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.jelo;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.jelo.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabeleJela;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.Komunikacija;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Iva
 */
public class KontrolerPretragaJela {

    private final FrmPretragaJela frmPretragaJela;

    public KontrolerPretragaJela(FrmPretragaJela frmPretragaJela) {
        this.frmPretragaJela = frmPretragaJela;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremaForme();
        frmPretragaJela.setVisible(true);
    }

    private void addActionListeners() {

        frmPretragaJela.addbtnNewJeloActionListener((ActionEvent e) -> {
            Koordinator.vratiInstancu().otvoriFrmNovoJelo();
        });

        frmPretragaJela.addbtnRefreshActionListener((ActionEvent e) -> {
            pripremaForme();
        });

        frmPretragaJela.addbtnSearchActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
                pretragaJela();
            }

            private void pretragaJela() {
                try {
                    TipJela tip = (TipJela) frmPretragaJela.getCbTipJela().getSelectedItem();
                    Kuvar kuvar = (Kuvar) frmPretragaJela.getCbKuvar().getSelectedItem();
                    if (tip == null && kuvar == null) {
                        JOptionPane.showMessageDialog(frmPretragaJela, "Mora se popuniti bar jedna opcija");
                        return;
                    }
                    Jelo jelo = new Jelo(null, tip, "", null, 0, kuvar);
                    List<Jelo> listа = Komunikacija.vratiInstancu().nadjiJela(jelo);
                    if (listа == null) 
                        JOptionPane.showMessageDialog(frmPretragaJela, "Nema jela po datom filteru!");
                     else {
                        ModelTabeleJela model = new ModelTabeleJela(listа);
                        frmPretragaJela.getTblJela().setModel(model);
                    }

                } catch (Exception ex) {
                    System.err.println("Greška pri pretrazi jela! "+ex.getMessage());
                }
            }
        });
    
    }
    private void pripremaForme() {
        popuniTabelu();
        popuniCbTipJela();
        popuniCbKuvari();
    }

    private void popuniTabelu() {
        try {
            List<Jelo> lista = Komunikacija.vratiInstancu().vratiJela();
            ModelTabeleJela model = new ModelTabeleJela(lista);
            frmPretragaJela.getTblJela().setModel(model);
        } catch (Exception ex) {
            System.err.println("Greška u učitavanju jela! "+ex.getMessage());
        }
    }

    private void popuniCbTipJela() {
        try {
            frmPretragaJela.getCbTipJela().removeAllItems();
            List<TipJela> tipovi = Komunikacija.vratiInstancu().vratiTipoveJela();
            if (tipovi == null) {
                return;
            }
            for (TipJela t : tipovi) {
                frmPretragaJela.getCbTipJela().addItem(t);
            }
            frmPretragaJela.getCbTipJela().setSelectedItem(null);
        } catch (Exception ex) {
            System.err.println("Greška u popunjavanju combo boxa za tip jela! "+ex.getMessage());
        }
    }

    private void popuniCbKuvari() {
        try {
            frmPretragaJela.getCbKuvar().removeAllItems();
            List<Kuvar> kuvari = Komunikacija.vratiInstancu().vratiKuvare();
            if (kuvari == null) {
                return;
            }
            for (Kuvar k : kuvari) {
                frmPretragaJela.getCbKuvar().addItem(k);
            }
            frmPretragaJela.getCbKuvar().setSelectedItem(null);
        } catch (Exception ex) {
             System.err.println("Greška u popunjavanju combo boxa za kuvare! "+ex.getMessage());
        }
    }

}
