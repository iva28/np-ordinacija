/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent.FrmSviPacijenti;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.*;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.pacijent.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.*;

/**
 *
 * @author Iva
 */
public class KontrolerSviPacijenti {

    private final FrmSviPacijenti frmSviPacijenti;

    public KontrolerSviPacijenti(FrmSviPacijenti frmSviPacijenti) {
        this.frmSviPacijenti = frmSviPacijenti;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremaForme();
        frmSviPacijenti.setVisible(true);
    }

    private void addActionListeners() {
        frmSviPacijenti.addbtnDodajActionListener((ActionEvent e) -> {
            Koordinator.vratiInstancu().otvoriFrmNoviPacijent(null);
            pripremaForme();
        });
        frmSviPacijenti.addbtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiPacijenta();
            }

            private void obrisiPacijenta() {
                int red = frmSviPacijenti.getTblPacijenti().getSelectedRow();
                ModelTableSviPacijenti model = (ModelTableSviPacijenti) frmSviPacijenti.getTblPacijenti().getModel();
                if (red >= 0 && red < model.getRowCount()) {
                    try {
                        Pacijent p = model.getPacijentAt(red);
                        PlanIshrane planPostoji = proveriJelPacijentImaPlan(p);
                        boolean brisanje = false;
                        if (planPostoji != null) {
                            int opcija = JOptionPane.showConfirmDialog(frmSviPacijenti,
                                    "Pacijent " + p + " ima plan ishrane, da li želite da ga obrišete?", "Brisanje pacijenta", JOptionPane.YES_NO_OPTION);
                            if (opcija == JOptionPane.YES_OPTION) {
                                brisanje = Komunikacija.vratiInstancu().obrisiPlan(planPostoji);
                            } 
                        }
                        if ((planPostoji == null) ||  brisanje) {
                            int provera = JOptionPane.showConfirmDialog(frmSviPacijenti,
                                    "Da li ste sigurni da želite da obrišete pacijenta", "PROVERA",JOptionPane.YES_NO_OPTION);
                            if (provera == JOptionPane.NO_OPTION) return;
                            boolean rezultat = Komunikacija.vratiInstancu().obrisiPacijenta(p);
                            if (rezultat) {
                                JOptionPane.showMessageDialog(frmSviPacijenti, "Uspeh u brisanju pacijenta");
                                pripremaForme();
                            }
                        }
                    } catch (Exception ex) {
                        System.err.println("Greška pri brisanju pacijenta! "+ex.getMessage());
                    }
                } else{
                    JOptionPane.showMessageDialog(frmSviPacijenti, "Selektujte pacijenta za brisanje!");
                }
            }

            private PlanIshrane proveriJelPacijentImaPlan(Pacijent pacijent) {
                try {
                    List<PlanIshrane> planovi = Komunikacija.vratiInstancu().ucitajListuPlanova();
                    for (PlanIshrane p : planovi) {
                        if (p.getPacijent().equals(pacijent)) {
                            return p;
                        }
                    }
                } catch (Exception ex) {
                    System.err.println("Greška u učitavanju planova ishrana prilikom pokušaja brisanja pacijenta! "
                            +ex.getMessage());
                }
                return null;
            }
        }
        );
        frmSviPacijenti.addbtnChangeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeniPacijenta();
            }

            private void izmeniPacijenta() {
                try {
                    Pacijent p = nadjiPacijenta();
                    if (p != null) {
                        Koordinator.vratiInstancu().otvoriFrmNoviPacijent(p);
                    }
                    pripremaForme();
                } catch (Exception ex) {
                    System.err.println("Greška pri izmeni pacijenta! "+ex.getMessage());
                }
            }
        }
        );
        frmSviPacijenti.addbtnSearchModeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                omoguciPretragu();
            }

            private void omoguciPretragu() {
                frmSviPacijenti.getPnlSearch().setVisible(true);
                frmSviPacijenti.getTblSearch().setModel(new ModelTableSviPacijenti(null));
            }
        });
        frmSviPacijenti.addbtnCloseSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zatvoriPretragu();
            }

            private void zatvoriPretragu() {
                frmSviPacijenti.getTxtSearch().setText("");
                frmSviPacijenti.getLblSearchError().setText("");
                frmSviPacijenti.getPnlSearch().setVisible(false);
                pripremaForme();
            }
        });
        frmSviPacijenti.addbtnRefreshActionListener((ActionEvent e) -> {
            pripremaForme();
        });
        frmSviPacijenti.addbtnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziPacijenta();
            }

            private void pretraziPacijenta() {
                boolean rezultat = validirajPoljeZaPretragu();
                if (rezultat) {
                    try {
                        String ime = frmSviPacijenti.getTxtSearch().getText().trim();
                        List<Pacijent> lista = Komunikacija.vratiInstancu().nadjiPacijente(ime);
                        if (lista == null || lista.isEmpty()) {
                            JOptionPane.showMessageDialog(frmSviPacijenti, "Sistem ne može da nađe pacijente po zadatoj vrednosti");
                            frmSviPacijenti.getTxtSearch().setText("");
                            return;
                        }
                        JOptionPane.showMessageDialog(frmSviPacijenti, "Sistem je našao pacijente po zadatoj vrednosti");
                        ModelTableSviPacijenti model = new ModelTableSviPacijenti(lista);
                        frmSviPacijenti.getTblSearch().setModel(model);
                        frmSviPacijenti.getTxtSearch().setText("");
                    } catch (Exception ex) {
                        System.err.println("Greška prilikom traženja pacijenata! "+ex.getMessage());
                        JOptionPane.showMessageDialog(frmSviPacijenti, "Greška u traženju pacijenata!" + ex.getMessage(),
                                "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    frmSviPacijenti.getTxtSearch().setText("");
                }
            }

            private boolean validirajPoljeZaPretragu() {
                frmSviPacijenti.getLblSearchError().setText("");
                if (frmSviPacijenti.getTxtSearch().getText().trim().isEmpty()) {
                    frmSviPacijenti.getLblSearchError().setText("Polje za pretragu ne može biti prazno!");
                    frmSviPacijenti.getLblSearchError().setForeground(Color.red);
                    return false;
                }
                if (!frmSviPacijenti.getTxtSearch().getText().trim().matches("[a-zA-Z]+")) {
                    frmSviPacijenti.getLblSearchError().setText("U polje za pretragu unesite ime pacijenta!");
                    frmSviPacijenti.getLblSearchError().setForeground(Color.red);
                    return false;
                }
                frmSviPacijenti.getLblSearchError().setText("");
                return true;
            }
        });
        frmSviPacijenti.addbtnDetaljiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ucitajPacijenta();
            }

            private void ucitajPacijenta() {
                try {
                    int red = frmSviPacijenti.getTblSearch().getSelectedRow();
                    if (red == -1) {
                        JOptionPane.showMessageDialog(frmSviPacijenti, "Sistem ne može da učita pacijenta\nSelektujte red u tabeli za pretragu pacijenata");
                        return;
                    }
                    ModelTableSviPacijenti model = (ModelTableSviPacijenti) frmSviPacijenti.getTblSearch().getModel();
                    Pacijent selektovan = model.getPacijentAt(red);
                    selektovan = Komunikacija.vratiInstancu().ucitajPacijenta(selektovan);
                    if (selektovan == null) {
                        JOptionPane.showMessageDialog(frmSviPacijenti, "Sistem ne može da učita pacijenta", "", JOptionPane.ERROR);
                    } else {
                        JOptionPane.showMessageDialog(frmSviPacijenti, "Sistem je učitao pacijenta");
                        Koordinator.vratiInstancu().otvoriFrmNoviPacijent(selektovan);
//                        pripremaForme();
                    }
                } catch (Exception ex) {
                    System.err.println("Sistem ne može da učita pacijenta! "+ex.getMessage());
                }
            }
        });
    }

    private void pripremaForme() {
        try {
            List<Pacijent> lista;
            lista = Komunikacija.vratiInstancu().ucitajListuPacijenata();
            ModelTableSviPacijenti model = new ModelTableSviPacijenti(lista);
            frmSviPacijenti.getTblPacijenti().setModel(model);
            frmSviPacijenti.getPnlSearch().setVisible(false);
            frmSviPacijenti.getPnlSearch().setEnabled(false);
        } catch (Exception ex) {
            System.err.println("Greška pri preuzimanju pacijenata! "+ex.getMessage());
        }
    }

    private Pacijent nadjiPacijenta() throws Exception {
        int red = frmSviPacijenti.getTblPacijenti().getSelectedRow();
        ModelTableSviPacijenti model = (ModelTableSviPacijenti) frmSviPacijenti.getTblPacijenti().getModel();
        if (red >= 0 && red < model.getRowCount()) {
            Pacijent p = model.getPacijentAt(red);
            return p;
        } else {
            JOptionPane.showMessageDialog(frmSviPacijenti, "Selektujte pacijenta!");
        }
        throw new Exception("Selektujte pacijenta za izmenu sa tabele!");
    }

}
