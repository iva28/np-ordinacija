/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.konstante.*;
/**
 *
 * @author Iva
 */
public class KontrolerPrijava {

    private  FrmPrijava frmPrijava;

    public KontrolerPrijava(FrmPrijava frmPrijava) {
        this.frmPrijava = frmPrijava;
        addActionListeners();
    }
    
    public void otvoriFormu() {
        frmPrijava.setVisible(true);
    }

    private void addActionListeners() {
        frmPrijava.prijavaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijaviNutricionistu(e);
            }

            private void prijaviNutricionistu(ActionEvent e) {
                try {
                    String username = frmPrijava.getTxtKorisnickoIme().getText().trim();
                    String password = String.valueOf(frmPrijava.getTxtLozinka().getPassword());
                    validiraj(username, password);

                    Nutricionista n = Komunikacija.vratiInstancu().login(username, password);
                    if (n == null) {
                        JOptionPane.showMessageDialog(frmPrijava, 
                                "Sistem ne može da nađe nutricionistu na osnovu unetih podataka!");
                        resetujPolja();
                        return;
                    }
                    if (n.getNutricionistaId() == -1L) {
                        JOptionPane.showMessageDialog(frmPrijava, "Nutricionista je već prijavljen i nije odlogovan!");
                        resetujPolja();
                        return;
                    }
                    JOptionPane.showMessageDialog(frmPrijava, "Uspešno ste se prijavili na sistem :) " + n.getUsername());
                    frmPrijava.dispose();
                    Koordinator.vratiInstancu().dodajParametar(Konstante.NUTRICIONISTA , n);
                    Koordinator.vratiInstancu().otvoriGlavnuFormu();
                } catch (Exception ex) {
                    System.err.println("Greška u formi za prijavu "+ex.getMessage());
                    JOptionPane.showMessageDialog(frmPrijava, ex.getMessage(),"GREŠKA",JOptionPane.ERROR_MESSAGE);
                }

            }

            private void validiraj(String username, String password) throws Exception {
                String error = "";
                frmPrijava.getLblUsernameError().setText("");
                frmPrijava.getLblPasswordError().setText("");
                if (username == null || username.isEmpty()) {
                    frmPrijava.getLblUsernameError().setText("Korisničko ime mora biti popunjeno!");
                    error += "Korisničko ime mora biti popunjeno!\n";
                }
                if (password == null || password.isEmpty()) {
                    frmPrijava.getLblPasswordError().setText("Šifra mora biti popunjena!");
                    error += "Šifra mora biti popunjena!\n";
                }
                if (!error.isEmpty()) {
                    throw new Exception(error);
                }
            }

            private void resetujPolja() {
                frmPrijava.getTxtKorisnickoIme().setText("");
                frmPrijava.getTxtLozinka().setText("");
            }

        });
    }
}
