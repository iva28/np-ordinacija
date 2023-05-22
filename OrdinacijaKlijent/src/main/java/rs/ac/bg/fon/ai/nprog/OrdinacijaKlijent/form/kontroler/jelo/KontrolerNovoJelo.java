/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.jelo;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.jelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

/**
 *
 * @author Iva
 */
public class KontrolerNovoJelo {

    private final FrmNovoJelo frmNovoJelo;

    public KontrolerNovoJelo(FrmNovoJelo frmNovoJelo) {
        this.frmNovoJelo = frmNovoJelo;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremaForme();
        frmNovoJelo.setVisible(true);
    }

    private void addActionListener() {
        frmNovoJelo.addbtnJeloActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novoJelo();
            }

            private void novoJelo() {
                try {
                    String naziv = frmNovoJelo.getTxtNaziv().getText().trim();
                    TipJela tip = (TipJela) frmNovoJelo.getCbTipJela().getSelectedItem();
                    Kuvar kuvar = (Kuvar) frmNovoJelo.getCbKuvar().getSelectedItem();
                    if (naziv.isEmpty() || frmNovoJelo.getTxtCena().getText().trim().isEmpty()
                            || frmNovoJelo.getTxtKolicina().getText().isEmpty()
                            || frmNovoJelo.getCbKuvar().getSelectedItem() == null
                            || frmNovoJelo.getCbTipJela().getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(frmNovoJelo, "Sva polja moraju biti popunjena!");
                        return;
                    }
                    if(validnostNaziva(frmNovoJelo.getTxtNaziv().getText().trim())) {
                         JOptionPane.showMessageDialog(frmNovoJelo, "Nema brojeva u nazivu jela");
                         frmNovoJelo.getTxtNaziv().setText("");
                         return;
                    }
                    if (!frmNovoJelo.getTxtCena().getText().trim().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(frmNovoJelo, "Cena jela se izražava u brojevima");
                        frmNovoJelo.getTxtCena().setText("");
                        return;
                    }
                    BigDecimal cena = new BigDecimal(frmNovoJelo.getTxtCena().getText().trim().replaceAll(" ", ""));
                    if (!frmNovoJelo.getTxtKolicina().getText().trim().matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(frmNovoJelo, "Gramaža jela se izražava u brojevima");
                        frmNovoJelo.getTxtKolicina().setText("");
                        return;
                    }
                    int kolicina = Integer.parseInt(frmNovoJelo.getTxtKolicina().getText().trim());

                    Jelo jelo = new Jelo(Long.MIN_VALUE, tip, naziv, cena, kolicina, kuvar);
                    boolean rez = Komunikacija.vratiInstancu().sacuvajJelo(jelo);
                    if (rez) {
                        JOptionPane.showMessageDialog(null, "Novo jelo je kreirano!");
                    } else {
                        JOptionPane.showMessageDialog(null, "GREŠKA u kreiranju novog jela, već postoji u bazi!");
                    }
                    frmNovoJelo.dispose();
                } catch (Exception ex) {
                    System.err.println("Greška u čuvanju jela!\n" + ex.getMessage());
                }
            }

            private boolean validnostNaziva(String jelo) {
                for(int i = 0; i < jelo.length(); i++)
                    if (Character.isDigit(jelo.charAt(i)))
                        return true;
                return false;
            }
        });
    }

    private void pripremaForme() {
        vratiTipoveJela();
        vratiKuvare();
    }

    private void vratiTipoveJela() {
        try {
            frmNovoJelo.getCbTipJela().removeAllItems();
            List<TipJela> tipovi = Komunikacija.vratiInstancu().vratiTipoveJela();
            if (tipovi == null) {
                return;
            }
            for (TipJela t : tipovi) {
                frmNovoJelo.getCbTipJela().addItem(t);
            }
            frmNovoJelo.getCbTipJela().setSelectedItem(null);
        } catch (Exception ex) {
            System.err.println("Greška u učitavanju tipova jela! " + ex.getMessage());
        }
    }

    private void vratiKuvare() {
        try {
            frmNovoJelo.getCbKuvar().removeAllItems();
            List<Kuvar> kuvari = Komunikacija.vratiInstancu().vratiKuvare();
            if (kuvari == null) {
                return;
            }
            for (Kuvar k : kuvari) {
                frmNovoJelo.getCbKuvar().addItem(k);
            }
            frmNovoJelo.getCbKuvar().setSelectedItem(null);
        } catch (Exception ex) {
            System.err.println("Greška u učitavanju kuvara! " + ex.getMessage());
        }
    }

}
