package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.planIshrane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.konstante.Konstante;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.koordinator.Koordinator;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabeleJela;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabeleStavkaIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.planIshrane.FrmKreirajPlanIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;

/**
 *
 * @author Iva
 */
public class KontrolerKreirajPlanIshrane {

    private final FrmKreirajPlanIshrane frmKreirajPlanIshrane;

    public KontrolerKreirajPlanIshrane(FrmKreirajPlanIshrane frmKreirajPlanIshrane) {
        this.frmKreirajPlanIshrane = frmKreirajPlanIshrane;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremaForme();
        frmKreirajPlanIshrane.pack();
        frmKreirajPlanIshrane.setVisible(true);
    }

    private void addActionListeners() {

        frmKreirajPlanIshrane.addbtnAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajJeloUStavku();
            }

            private void dodajJeloUStavku() {
                int red = frmKreirajPlanIshrane.getTblJela().getSelectedRow();
                if (red != -1) {
                    int kolicina = (int) frmKreirajPlanIshrane.getSpiner().getValue();
                    if (kolicina <= 0) {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Postavite količinu!");
                        return;
                    }
                    ModelTabeleJela modelPretraga = (ModelTabeleJela) frmKreirajPlanIshrane.getTblJela().getModel();
                    Jelo jelo = modelPretraga.vratiJelo(red);
                    BigDecimal cena = BigDecimal.valueOf(kolicina).multiply(new BigDecimal(Integer.parseInt(jelo.getCena().toString())));
                    StavkaPlanaIshrane stavka = new StavkaPlanaIshrane(0L, cena, kolicina, jelo);
                    ModelTabeleStavkaIshrane modelStavke = (ModelTabeleStavkaIshrane) frmKreirajPlanIshrane.getTblStavke().getModel();
                    if (!modelStavke.postoji(jelo)) {
                        modelStavke.dodaj(stavka);
                    } else {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Već je dodato  jelo " + jelo.getNaziv() + " u stavke");
                    }
                } else {
                    JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Selektujte red u tabeli jela!");
                }
            }
        });

        frmKreirajPlanIshrane.addbtnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pronadjiJelo();
            }

            private void pronadjiJelo() {
                try {
                    TipJela tip = (TipJela) frmKreirajPlanIshrane.getCbTipJela().getSelectedItem();
                    Kuvar kuvar = (Kuvar) frmKreirajPlanIshrane.getCbKuvar().getSelectedItem();
                    if (tip == null && kuvar == null) {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Mora se popuniti bar jedna opcija");
                        return;
                    }
                    Jelo jelo = new Jelo(null, tip, "", null, 0, kuvar);

                    List<Jelo> listа = Komunikacija.vratiInstancu().nadjiJela(jelo);
                    if (listа == null) {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Nema jela po fatom filteru!");
                    } else {
                        ModelTabeleJela model = new ModelTabeleJela(listа);
                        frmKreirajPlanIshrane.getTblJela().setModel(model);
                    }
                } catch (Exception ex) {
                    System.err.println("Problem u pretrazi jela!\n"+ex.getMessage());
                }
            }
        });

        frmKreirajPlanIshrane.addbtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiStavku();
            }

            private void obrisiStavku() {
                int red = frmKreirajPlanIshrane.getTblStavke().getSelectedRow();
                if (red != -1) {
                    ModelTabeleStavkaIshrane modelStavke = (ModelTabeleStavkaIshrane) frmKreirajPlanIshrane.getTblStavke().getModel();
                    modelStavke.obrisi(red);
                } else {
                    JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Selektujte red u tabeli stavki!");
                }
            }
        });

        frmKreirajPlanIshrane.addbtnIzaberiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postaviPacijenta();
            }

            private void postaviPacijenta() {
                Pacijent pacijent = (Pacijent) frmKreirajPlanIshrane.getCmbPacijenti().getSelectedItem();
                if (pacijent == null) {
                    JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Izaberite pacijenta iz combo box-a");
                    return;
                }
                Koordinator.vratiInstancu().dodajParametar(Konstante.PACIJENT, pacijent);
                postaviPanelPacijent();
            }
        });

        frmKreirajPlanIshrane.addbtnKreirajPlansActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kreirajPlanIshrane();
            }

            private void kreirajPlanIshrane() {
                try {
                    Pacijent pacijent = (Pacijent) Koordinator.vratiInstancu().uzmiParametar(Konstante.PACIJENT);
                    List<PlanIshrane> trenutniPlanovi;
                    try {
                        trenutniPlanovi = Komunikacija.vratiInstancu().ucitajListuPlanova();
                        for (PlanIshrane pi : trenutniPlanovi) {
                            if (pi.getPacijent().equals(pacijent)) {
                                Calendar kalendar = Calendar.getInstance();
                                kalendar.setTime(pi.getDatum());
                                kalendar.add(Calendar.DATE, pi.getBrojDana());
                                if (frmKreirajPlanIshrane.getTxtDate().getText().trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Unesite datum");
                                    return;
                                }
                                if (kalendar.getTime().after(new SimpleDateFormat("dd.MM.yyyy").parse(frmKreirajPlanIshrane.getTxtDate().getText().trim()))) {
                                    JOptionPane.showMessageDialog(frmKreirajPlanIshrane,
                                            "Plan ishrane već postoji za pacijenta " + pacijent + " i još traje");
                                    return;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        System.err.println("Greška pri učitavanju planova ishrane! "+ex.getMessage());
                    }
                    if (!validirajZaKreiranje()) {
                        return;
                    }

                    try {
                        validirajDatum();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Unesite valjano datum u formatu dd.MM.yyyy\n");
                        frmKreirajPlanIshrane.getTxtDate().setText("");
                        return;
                    }
                    Date datum = new SimpleDateFormat("dd.MM.yyyy").parse(frmKreirajPlanIshrane.getTxtDate().getText().trim());
                    if (datum.before(new Date())) {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Unesite datum nakon današnjeg");
                        frmKreirajPlanIshrane.getTxtDate().setText("");
                        return;
                    }
                    int brojDana;
                    try {
                        brojDana = Integer.parseInt(frmKreirajPlanIshrane.getTxtDay().getText().trim());
                    } catch (Exception pe) {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Unesite broj u polje broj dana\n");
                        return;
                    }
                    BigDecimal ukupnaCena = BigDecimal.valueOf(0);
                    for (StavkaPlanaIshrane st : ((ModelTabeleStavkaIshrane) frmKreirajPlanIshrane.getTblStavke().getModel()).getStavke()) {
                        ukupnaCena = ukupnaCena.add(st.getCena());
                    }

                    if (brojDana > 0) {
                        ukupnaCena = ukupnaCena.multiply(BigDecimal.valueOf(brojDana));
                        Nutricionista nutricionista = (Nutricionista) Koordinator.vratiInstancu().uzmiParametar(Konstante.NUTRICIONISTA);
                        List<StavkaPlanaIshrane> lista = ((ModelTabeleStavkaIshrane) frmKreirajPlanIshrane.getTblStavke().getModel()).getStavke();
                        PlanIshrane plan = new PlanIshrane(0L, datum, ukupnaCena, brojDana, pacijent, nutricionista, lista);
                        try {
                            boolean rez = Komunikacija.vratiInstancu().kreirajPlanIshrane(plan);
                            if (rez) {
                                JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Sistem je zapamtio plan ishrane!");
                                frmKreirajPlanIshrane.dispose();
                            } else {
                                JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Sistem ne može da zapamti plan ishrane!");
                            }
                        } catch (Exception ex) {
                            System.err.println("Greška pri kreiranju plana ishrane! "+ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Broj dana za plan ishrane ne sme biti jednak nuli!");
                    }
                } catch (ParseException ex) {
                    System.err.println("Greška pri konvertovanju datuma "+ex.getMessage());
                }
            }

            private void validirajDatum() throws Exception {
                DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                try {
                    formater.parse(frmKreirajPlanIshrane.getTxtDate().getText().trim());

                } catch (Exception e) {
                    throw new Exception("Unesite ispravno datum");
                }
            }

            private boolean validirajZaKreiranje() {
                String poruka = "";
                if (((ModelTabeleStavkaIshrane) frmKreirajPlanIshrane.getTblStavke().getModel()).getStavke().isEmpty()) {
                    poruka += "Morate izabrati jela za kreiranje plana ishrane!\n";
                }
                if (Koordinator.vratiInstancu().uzmiParametar(Konstante.PACIJENT) == null) {
                    poruka += "Morate izabrati pacijenta klikom na dugme Izaberi pacijenta!\n";
                }
                if (frmKreirajPlanIshrane.getTxtDate().getText().trim().isEmpty()) {
                    poruka += "Postavite datum\n";
                }
                if (frmKreirajPlanIshrane.getTxtDay().getText().trim().equals("")) {
                    poruka += "Unesite broj dana trajanja plana\n";
                }
                if (!poruka.isEmpty()) {
                    JOptionPane.showMessageDialog(frmKreirajPlanIshrane, poruka);
                    return false;
                }
                return true;
            }
        });
        frmKreirajPlanIshrane.addbtnPromeniDatumActionListener((ActionEvent e) -> {
            frmKreirajPlanIshrane.getTxtDate().setEnabled(true);
            frmKreirajPlanIshrane.getTxtDate().setText("");
        });

        frmKreirajPlanIshrane.addbtnFreshPlansActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetujPretragu();
            }

            private void resetujPretragu() {
                frmKreirajPlanIshrane.getCbTipJela().setSelectedItem(null);
                frmKreirajPlanIshrane.getCbKuvar().setSelectedItem(null);
                popuniTabeluJela();
            }
        });
    }

    private void pripremaForme() {
        popuniTabeluJela();
        popuniCbTipJela();
        popuniCbKuvari();
        popuniCbPacijenti();
        srediTabeluStavki();
        pripremiPanelNutricioniste();
        pripremiPanelKlijent();
        postaviDatum();
    }

    private void popuniTabeluJela() {
        try {
            List<Jelo> lista = Komunikacija.vratiInstancu().vratiJela();
            ModelTabeleJela model = new ModelTabeleJela(lista);
            frmKreirajPlanIshrane.getTblJela().setModel(model);
        } catch (Exception ex) {
            System.err.println("Greska u ucitavanju jela "+ex.getMessage());
        }
    }

    private void popuniCbTipJela() {
        try {
            frmKreirajPlanIshrane.getCbTipJela().removeAllItems();
            List<TipJela> tipovi = Komunikacija.vratiInstancu().vratiTipoveJela();
            if (tipovi == null) {
                return;
            }
            for (TipJela t : tipovi) {
                frmKreirajPlanIshrane.getCbTipJela().addItem(t);
            }
            frmKreirajPlanIshrane.getCbTipJela().setSelectedItem(null);
        } catch (Exception ex) {
            System.err.println("Greska u učitavanju tipova jela "+ex.getMessage());
        }
    }

    private void popuniCbKuvari() {
        try {
            frmKreirajPlanIshrane.getCbKuvar().removeAllItems();
            List<Kuvar> kuvari = Komunikacija.vratiInstancu().vratiKuvare();
            if (kuvari == null) {
                return;
            }
            for (Kuvar k : kuvari) {
                frmKreirajPlanIshrane.getCbKuvar().addItem(k);
            }
            frmKreirajPlanIshrane.getCbKuvar().setSelectedItem(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Greska u ucitavanju kuvara");
        }
    }

    private void srediTabeluStavki() {
        frmKreirajPlanIshrane.getTblStavke().setModel(new ModelTabeleStavkaIshrane());
    }

    private void pripremiPanelNutricioniste() {
        Nutricionista n = (Nutricionista) Koordinator.vratiInstancu().uzmiParametar(Konstante.NUTRICIONISTA);
        frmKreirajPlanIshrane.getTxtImeNutricioniste().setText(n.getIme());
        frmKreirajPlanIshrane.getTxtImeNutricioniste().setEnabled(false);
        frmKreirajPlanIshrane.getTxtPrezimeNutricioniste().setText(n.getPrezime());
        frmKreirajPlanIshrane.getTxtPrezimeNutricioniste().setEnabled(false);

    }

    private void pripremiPanelKlijent() {
        frmKreirajPlanIshrane.getPnlPatient().setVisible(false);

    }

    private void postaviDatum() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar kalendar = Calendar.getInstance();
        kalendar.setTime(new Date());
        kalendar.add(Calendar.DATE, 1);
        frmKreirajPlanIshrane.getTxtDate().setText(sdf.format(kalendar.getTime()));
        frmKreirajPlanIshrane.getTxtDate().setEnabled(false);
    }

    private void popuniCbPacijenti() {
        try {
            frmKreirajPlanIshrane.getCmbPacijenti().removeAllItems();
            List<Pacijent> pacijenti = Komunikacija.vratiInstancu().ucitajListuPacijenata();
            if (pacijenti == null || pacijenti.isEmpty()) {
                JOptionPane.showMessageDialog(frmKreirajPlanIshrane, "Greška pri učitavanju pacijenata");
                return;
            }
            for (Pacijent p : pacijenti) {
                frmKreirajPlanIshrane.getCmbPacijenti().addItem(p);
            }
            frmKreirajPlanIshrane.getCmbPacijenti().setSelectedItem(null);
        } catch (Exception ex) {
            System.err.println("Greška pri učitavanju pacijenata iz baze "+ex.getMessage());
        }
    }

    private void postaviPanelPacijent() {
        if (Koordinator.vratiInstancu().uzmiParametar(Konstante.PACIJENT) != null) {
            Pacijent pacijent = (Pacijent) Koordinator.vratiInstancu().uzmiParametar(Konstante.PACIJENT);
            frmKreirajPlanIshrane.getTxtImePacijenta().setText(pacijent.getIme());
            frmKreirajPlanIshrane.getTxtImePacijenta().setEnabled(false);
            frmKreirajPlanIshrane.getTxtPrezimePacijenta().setText(pacijent.getPrezime());
            frmKreirajPlanIshrane.getTxtPrezimePacijenta().setEnabled(false);
            frmKreirajPlanIshrane.getPnlPatient().setVisible(true);
        }
    }

}
