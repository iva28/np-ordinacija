/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.FrmGlavna;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.konstante.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Iva
 */
public class KontrolerGlavna {

    private final FrmGlavna frmGlavna;

    public KontrolerGlavna(FrmGlavna frmGlavna) {
        this.frmGlavna = frmGlavna;
        addActionListeners();
    }

    public FrmGlavna getFrmGlavna() {
        return frmGlavna;
    }

    public void otvoriFormu() {
        Nutricionista n = (Nutricionista) Koordinator.vratiInstancu().uzmiParametar(Konstante.NUTRICIONISTA);
        frmGlavna.getTxtIme().setText(n.getIme());
        frmGlavna.getTxtIme().setEnabled(false);

        frmGlavna.getTxtPrezime().setText(n.getPrezime());
        frmGlavna.getTxtPrezime().setEnabled(false);

        frmGlavna.getTxtOrd().setText(n.getOrdinacija().getNaziv());
        frmGlavna.getTxtOrd().setEnabled(false);

        frmGlavna.setVisible(true);
    }

    private void addActionListeners() {
        frmGlavna.jMenuItemDodajacijentaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Koordinator.vratiInstancu().otvoriFrmNoviPacijent(null);
            }
        });

        frmGlavna.jMenuItemIzmeniPacijentaAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemIzmeniPacijentaActionListener(e);
            }

            private void jMenuItemIzmeniPacijentaActionListener(ActionEvent e) {
                Koordinator.vratiInstancu().otvoriFrmSviPacijenti();
            }

        });

        frmGlavna.jMenuItemDodajJeloAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemDodajJeloActionListener(e);
            }

            private void jMenuItemDodajJeloActionListener(ActionEvent e) {
                Koordinator.vratiInstancu().otvoriFrmNovoJelo();
            }
        });

        frmGlavna.jMenuItemPretragaJelaAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemPretragaJelaActionListener(e);
            }

            private void jMenuItemPretragaJelaActionListener(ActionEvent e) {
                Koordinator.vratiInstancu().otvoriFrmPretragaJela();
            }
        });

        frmGlavna.jMenuItemKreirajPlanIshraneAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemKreirajPlanIshraneActionListener(e);
            }

            private void jMenuItemKreirajPlanIshraneActionListener(ActionEvent e) {
                Koordinator.vratiInstancu().otvoriFrmKreirajPlanIshrane();
            }
        });

        frmGlavna.jMenuItemManipulacijaPlanIshraneAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemManipulacijaPlanIshraneActionListener(e);
            }

            private void jMenuItemManipulacijaPlanIshraneActionListener(ActionEvent e) {
                Koordinator.vratiInstancu().otvoriFrmPlanIshranePrikaz();
            }
        });

        frmGlavna.jMenuItemPretragaPlanaAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemPretragaPlanaActionListener(e);
            }

            private void jMenuItemPretragaPlanaActionListener(ActionEvent e) {
                Koordinator.vratiInstancu().otvoriFrmPretragaPlanaIshrane();
            }
        });

        frmGlavna.jMenuItemOdjavaAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemOdjavaActionListener(e);
            }

            private void jMenuItemOdjavaActionListener(ActionEvent e) {
                Koordinator.vratiInstancu().odjaviSe();
            }
        });

        frmGlavna.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Koordinator.vratiInstancu().odjaviSe();
            }
        });
    }


}
