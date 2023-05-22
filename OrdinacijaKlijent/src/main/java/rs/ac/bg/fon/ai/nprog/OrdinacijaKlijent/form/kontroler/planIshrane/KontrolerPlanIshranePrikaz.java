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
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabelePlanoviIshrana;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabeleStavkaIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.planIshrane.FrmPlanIshranePrikaz;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;

/**
 *
 * @author Iva
 */
public class KontrolerPlanIshranePrikaz {

    private final FrmPlanIshranePrikaz frmPlanIshranePrikaz;

    public KontrolerPlanIshranePrikaz(FrmPlanIshranePrikaz frmPlanIshranePrikaz) {
        this.frmPlanIshranePrikaz = frmPlanIshranePrikaz;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremaForme();
        frmPlanIshranePrikaz.setVisible(true);
    }

    private void addActionListeners() {
        frmPlanIshranePrikaz.addbtnPretragaPlanaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziPlanove();
            }

            private void pretraziPlanove() {
                try {
                    Nutricionista nutricionista = (Nutricionista) frmPlanIshranePrikaz.getCmbNutricionisti().getSelectedItem();
                    Pacijent pacijent = (Pacijent) frmPlanIshranePrikaz.getCbPacijenti().getSelectedItem();
                    if (nutricionista == null && pacijent == null) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte nutricionistu ili pacijenta");
                        return;
                    }
                    PlanIshrane planIshrane = new PlanIshrane();
                    planIshrane.setNutricionista(nutricionista);
                    planIshrane.setPacijent(pacijent);
                    List<PlanIshrane> planovi = Komunikacija.vratiInstancu().nadjiPlanove(planIshrane);
                    if (planovi == null || planovi.isEmpty()) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
                                "Sistem ne može da nađe planove ishrana po zadatoj vrednosti");
                        frmPlanIshranePrikaz.getCbPacijenti().setSelectedItem(null);
                        frmPlanIshranePrikaz.getCmbNutricionisti().setSelectedItem(null);
                        return;
                    }
                    JOptionPane.showMessageDialog(frmPlanIshranePrikaz,
                            "Sistem je našao planove ishrana po zadatoj vrednosti");

                    ModelTabelePlanoviIshrana modelPlanovi = new ModelTabelePlanoviIshrana(planovi);
                    frmPlanIshranePrikaz.getTblPlanovi().setModel(modelPlanovi);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frmPlanIshranePrikaz.addbtnUcitajPlanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ucitajPlanIshrane();
            }

            private void ucitajPlanIshrane() {
                try {
                    int red = frmPlanIshranePrikaz.getTblPlanovi().getSelectedRow();
                    ModelTabelePlanoviIshrana modelTabele = (ModelTabelePlanoviIshrana) frmPlanIshranePrikaz.getTblPlanovi().getModel();
                    if (red == -1 && modelTabele.getRowCount() > 1) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem ne može da učita plan ishrane"
                                + "\nSelektujte red u tabeli");
                        return;
                    }
                    PlanIshrane plan;
                    if (modelTabele.getRowCount() == 1) {
                        plan = modelTabele.vratiPlan(0);
                    } else {
                        plan = modelTabele.vratiPlan(red);
                    }
                    plan = Komunikacija.vratiInstancu().ucitajPlanIshrane(plan);
                    if (plan != null) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem je učitao plan ishrane");
                        modelTabele.postaviJedan(plan);
                        frmPlanIshranePrikaz.getTblPlanovi().setModel(modelTabele);
                        Koordinator.vratiInstancu().dodajParametar(Konstante.PLAN_ISHRANE, plan);
                        srediPanelDets();
                    }
                } catch (Exception ex) {
                    System.err.println("Greška pri učitavanju plana ishrane! " + ex.getMessage());
                }
            }
        });
        frmPlanIshranePrikaz.addbtnDetailActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = frmPlanIshranePrikaz.getTblPlanovi().getSelectedRow();
                if (red != -1) {
                    ModelTabelePlanoviIshrana model = (ModelTabelePlanoviIshrana) frmPlanIshranePrikaz.getTblPlanovi().getModel();
                    PlanIshrane p = model.vratiPlan(red);
                    Koordinator.vratiInstancu().dodajParametar(Konstante.PLAN_ISHRANE, p);
                    srediPanelDets();
                } else {
                    JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte red u tabeli");
                }
            }

        });
        frmPlanIshranePrikaz.addbtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiPlan();
            }

            private void obrisiPlan() {
                int red = frmPlanIshranePrikaz.getTblPlanovi().getSelectedRow();
                if (red != -1) {
                    try {
                        ModelTabelePlanoviIshrana model = (ModelTabelePlanoviIshrana) frmPlanIshranePrikaz.getTblPlanovi().getModel();
                        PlanIshrane plan = model.vratiPlan(red);
                        Koordinator.vratiInstancu().dodajParametar(Konstante.PLAN_ISHRANE, plan);
                        boolean rezultat = proveraMogucnostiMenjanja();
                        if (!rezultat) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Ne smete brisati planove koji nisu vaši");
                            return;
                        }
                        int provera = JOptionPane.showConfirmDialog(frmPlanIshranePrikaz,
                                "Da li ste sigurni da želite da obrišete plan?", "PROVERA BRISANJA", JOptionPane.YES_NO_OPTION);
                        if (provera == JOptionPane.NO_OPTION) {
                            return;
                        }
                        boolean uspeh = Komunikacija.vratiInstancu().obrisiPlan(plan);
                        if (uspeh) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem je obrisao plan ishrane!");
                            pripremaForme();
                        }
                    } catch (Exception ex) {
                        System.err.println("Greška pri brisanju plana! " + ex.getMessage());
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem ne može da obriše plan ishrane!");
                    }

                } else {
                    JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Morate selektovati red!");
                }
            }
        });
        frmPlanIshranePrikaz.addbtnIzmenaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                srediZaIzmenuPlana();
            }

            private void srediZaIzmenuPlana() {
                try {
                    boolean rezultat = proveraMogucnostiMenjanja();
                    if (!rezultat) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Zabranjeno menjanje planova koji nisu vaši!");
                        frmPlanIshranePrikaz.getBtnSacuvajIzmene().setEnabled(false);
                        return;
                    }
                    frmPlanIshranePrikaz.getTblStavke().setEnabled(true);
                    frmPlanIshranePrikaz.getPnlJela().setVisible(true);
                    List<Jelo> lista = Komunikacija.vratiInstancu().vratiJela();
                    ModelTabeleJela model = new ModelTabeleJela(lista);
                    frmPlanIshranePrikaz.getTblJela().setModel(model);
                    frmPlanIshranePrikaz.getBtnDani().setEnabled(true);
                    frmPlanIshranePrikaz.getBtnDatum().setEnabled(true);
                    frmPlanIshranePrikaz.getBtnBrisi().setEnabled(true);
                    frmPlanIshranePrikaz.getBtnSacuvajIzmene().setEnabled(true);

//                    frmPlanIshranePrikaz.getTxtCena().setText("");
                    srediDatum();
                } catch (Exception ex) {
                    System.err.println("Problem u preuzimanju jela! " + ex.getMessage());
                }
            }

            private void srediDatum() {
                String godina = frmPlanIshranePrikaz.getTxtDatum().getText().substring(0, 4);
                String mesec = frmPlanIshranePrikaz.getTxtDatum().getText().substring(5, 7);
                String dan = frmPlanIshranePrikaz.getTxtDatum().getText().substring(8);
                String datum = dan + "." + mesec + "." + godina;
                frmPlanIshranePrikaz.getTxtDatum().setText(datum);
            }

        });
        frmPlanIshranePrikaz.addbtnDaniActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Promenite broj dana samo ako ste zavrsili za izmenama");
            frmPlanIshranePrikaz.getTxtDani().setEnabled(true);
            frmPlanIshranePrikaz.getTxtDani().setText("");
        });
        frmPlanIshranePrikaz.addbtnDodajUPlanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajUPlan();
            }

            private void dodajUPlan() {
                int red = frmPlanIshranePrikaz.getTblJela().getSelectedRow();
                if (red != -1) {
                    ModelTabeleStavkaIshrane modelStavke = (ModelTabeleStavkaIshrane) frmPlanIshranePrikaz.getTblStavke().getModel();
                    ModelTabeleJela modelJela = (ModelTabeleJela) frmPlanIshranePrikaz.getTblJela().getModel();
                    Jelo jelo = modelJela.vratiJelo(red);
                    if (modelStavke.postoji(jelo)) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Dato jelo već postoji u stavkama");
                    } else {
                        int kolicina = (int) frmPlanIshranePrikaz.getSpiner().getValue();
                        if (kolicina == 0) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Postavite kolicinu vecu od 0");
                            return;
                        }
                        BigDecimal cena = BigDecimal.valueOf(kolicina).multiply(new BigDecimal(Integer.parseInt(jelo.getCena().toString())));
                        BigDecimal preCena = new BigDecimal(frmPlanIshranePrikaz.getTxtCena().getText());
                        preCena = preCena.add(cena);
                        frmPlanIshranePrikaz.getTxtCena().setText(preCena.toString());
                        StavkaPlanaIshrane stavka = new StavkaPlanaIshrane(0L, cena, kolicina, jelo);
                        modelStavke.dodaj(stavka);
                    }

                } else {
                    JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte red u tabeli jela");
                }
            }
        });
        frmPlanIshranePrikaz.addbtnBrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brisiStavku();
            }

            private void brisiStavku() {
                int red = frmPlanIshranePrikaz.getTblStavke().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Selektujte red za brisanje");
                } else {
                    ModelTabeleStavkaIshrane modelStavke = (ModelTabeleStavkaIshrane) frmPlanIshranePrikaz.getTblStavke().getModel();
                    StavkaPlanaIshrane stavka = modelStavke.vratiStavku(red);
                    modelStavke.obrisi(red);
                    int brojDana = Integer.parseInt(frmPlanIshranePrikaz.getTxtDani().getText());
                    int kolicina = stavka.getKolicina() * brojDana;
                    BigDecimal cena = stavka.getCena();
                    cena = cena.multiply(BigDecimal.valueOf(kolicina));
                    BigDecimal preCena = new BigDecimal(frmPlanIshranePrikaz.getTxtCena().getText());
                    preCena = preCena.subtract(cena);
                    frmPlanIshranePrikaz.getTxtCena().setEnabled(true);
                    frmPlanIshranePrikaz.getTxtCena().setText(preCena.toString());
                    frmPlanIshranePrikaz.getTxtCena().setEnabled(false);
                }
            }
        });
        frmPlanIshranePrikaz.addbtnSacuvajIzmeneActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacuvajIzmenjenPlan();
            }

            private void sacuvajIzmenjenPlan() {
                boolean rezultat = proveraMogucnostiMenjanja();
                if (!rezultat) {
                    JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Zabranjeno menjanje planova koji nisu vaši!");
                    return;
                }
                if (frmPlanIshranePrikaz.getTblStavke().getRowCount() == 0) {
                    try {
                        //obrisane su sve stavke pa brisemo plan
                        boolean uspeh = Komunikacija.vratiInstancu().azurirajPlan((PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE));
                        System.out.println((PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE));
                        if (uspeh) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Uspeh u brisanju plana ishrane");
                            pripremaForme();
                        } else {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Greška u brisanju plana ishrane");
                        }
                    } catch (Exception ex) {
                        System.err.println("Greška pri brisanju plana ishrane!" + ex.getMessage());
                    }
                } else {
                    if (!validirajZaIzmenu()) {
                        return;
                    }
                    PlanIshrane plan = (PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE);
                    int dani;
                    try {
                        dani = Integer.parseInt(frmPlanIshranePrikaz.getTxtDani().getText());
                        if (dani <= 0) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Broj dana za koji je kreiran plan mora biti veći od 0");
                            return;
                        }
                        plan.setBrojDana(dani);
                        List<StavkaPlanaIshrane> stavke = ((ModelTabeleStavkaIshrane) frmPlanIshranePrikaz.getTblStavke().getModel()).getStavke();
                        plan.setStavke(stavke);
                        BigDecimal ukupnaCena = BigDecimal.valueOf(0);
                        for (StavkaPlanaIshrane st : stavke) {
                            ukupnaCena = ukupnaCena.add(st.getCena());
                        }
                        ukupnaCena = ukupnaCena.multiply(BigDecimal.valueOf(dani));
                        plan.setCena(ukupnaCena);
                        frmPlanIshranePrikaz.getTxtCena().setText(ukupnaCena.toString());
                    } catch (Exception pe) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Unesite broj u polje broj dana");
                        return;
                    }
                    try {
                        Date datum;
                        boolean signal = false;
                        if (frmPlanIshranePrikaz.getTxtDatum().isEnabled()) {
                            validirajDatum();
                            signal = true;
                        }
                        datum = new SimpleDateFormat("dd.MM.yyyy").parse(frmPlanIshranePrikaz.getTxtDatum().getText().trim());
                        if (!validirajPostojeciDatum()) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Plan koji menjate je istekao postavite nov datum i broj dana");
                            frmPlanIshranePrikaz.getTxtDatum().setText("");
                            frmPlanIshranePrikaz.getTxtDani().setText("");
                            return;
                        }
                        if (signal && datum.before(new Date())) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Unesite datum nakon današnjeg");
                            return;
                        }
                        plan.setDatum(datum);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Unesite valjano datum");
                        frmPlanIshranePrikaz.getTxtDatum().setText("");
                        return;
                    }
                    try {
                        boolean rez = Komunikacija.vratiInstancu().azurirajPlan(plan);
                        if (rez) {
                            JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem je zapamtio plan ishrane!");
                            pripremaForme();
                        }
                    } catch (Exception ex) {
                        System.err.println("Sistem ne može da kreira plan ishrane " + ex.getMessage());
                        JOptionPane.showMessageDialog(frmPlanIshranePrikaz, "Sistem ne može da zapamti plan ishrane!");
                    }
                }
            }

            private void validirajDatum() throws Exception {
                DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                try {
                    formater.parse(frmPlanIshranePrikaz.getTxtDatum().getText().trim());
                } catch (Exception e) {
                    System.err.println("Unesite valjano datum " + e.getMessage());
                    throw new Exception("Unesite ispravno datum");
                }
            }

            private boolean validirajZaIzmenu() {
                String poruka = "";
                if (frmPlanIshranePrikaz.getTxtDani().getText().trim().isEmpty()) {
                    poruka += "Unesite broj dana za plan\n";
                }
                if (frmPlanIshranePrikaz.getTxtDatum().getText().trim().isEmpty()) {
                    poruka += "Postavite datum\n";
                }
                if (!poruka.isEmpty()) {
                    JOptionPane.showMessageDialog(frmPlanIshranePrikaz, poruka);
                    return false;
                }
                return true;
            }

            private boolean validirajPostojeciDatum() {
                try {
                    Date datum = new SimpleDateFormat("dd.MM.yyyy").parse(frmPlanIshranePrikaz.getTxtDatum().getText());
                    int broj = Integer.parseInt(frmPlanIshranePrikaz.getTxtDani().getText());
                    Calendar kalendar = Calendar.getInstance();
                    kalendar.setTime(datum);
                    kalendar.add(Calendar.DATE, broj);
                    System.out.println(kalendar.getTime());
                    if (kalendar.getTime().before(new Date())) {
                        return false;
                    }
                } catch (ParseException ex) {
                }
                return true;
            }

        });
        frmPlanIshranePrikaz.addbtnPromeniDatumActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeniDatum();
            }

            private void promeniDatum() {
                frmPlanIshranePrikaz.getTxtDatum().setEnabled(true);
                frmPlanIshranePrikaz.getTxtDatum().setText("");
            }
        });
        frmPlanIshranePrikaz.addbtnResetujActionListener((ActionEvent e) -> {
            pripremaForme();
        });
    }

    private void pripremaForme() {
        popuniTabelu();
        popuniCmbNutricionisti();
        popuniCbPacijenti();
        frmPlanIshranePrikaz.getPnlDets().setVisible(false);
    }

    private void popuniTabelu() {
        try {
            List<PlanIshrane> lista = Komunikacija.vratiInstancu().ucitajListuPlanova();
            ModelTabelePlanoviIshrana model = new ModelTabelePlanoviIshrana(lista);
            frmPlanIshranePrikaz.getTblPlanovi().setModel(model);
        } catch (Exception ex) {
            System.err.println("Greška u učitavanju planova!\n" + ex.getMessage());
        }
    }

    private boolean proveraMogucnostiMenjanja() {
        PlanIshrane tekuciPlan = (PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE);
        Nutricionista tekuciAdministrator = (Nutricionista) Koordinator.vratiInstancu().uzmiParametar(Konstante.NUTRICIONISTA);
        return tekuciAdministrator.equals(tekuciPlan.getNutricionista());
    }

    private void popuniCmbNutricionisti() {
        try {
            frmPlanIshranePrikaz.getCmbNutricionisti().removeAllItems();
            List<Nutricionista> lista = Komunikacija.vratiInstancu().ucitajListuNutricionista();
            if (lista == null) {
                return;
            }
            for (Nutricionista n : lista) {
                frmPlanIshranePrikaz.getCmbNutricionisti().addItem(n);
            }
            frmPlanIshranePrikaz.getCmbNutricionisti().setSelectedItem(null);
        } catch (Exception ex) {
            System.err.println("Greška pri učitavanju nutricionista iz baze " + ex.getMessage());
        }
    }

    private void popuniCbPacijenti() {
        try {
            frmPlanIshranePrikaz.getCbPacijenti().removeAllItems();
            List<Pacijent> lista = Komunikacija.vratiInstancu().ucitajListuPacijenata();
            if (lista == null) {
                return;
            }
            for (Pacijent p : lista) {
                frmPlanIshranePrikaz.getCbPacijenti().addItem(p);
            }
            frmPlanIshranePrikaz.getCbPacijenti().setSelectedItem(null);
        } catch (Exception ex) {
            System.err.println("Greška pri učitavanju pacijenata iz baze " + ex.getMessage());
        }
    }

    private void srediPanelDets() {
        frmPlanIshranePrikaz.getPnlDets().setVisible(true);
        frmPlanIshranePrikaz.getTxtCena().setEnabled(false);
        frmPlanIshranePrikaz.getTxtDatum().setEnabled(false);
        frmPlanIshranePrikaz.getTxtDani().setEnabled(false);
        frmPlanIshranePrikaz.getTxtImeN().setEnabled(false);
        frmPlanIshranePrikaz.getTxtPrezimeN().setEnabled(false);
        frmPlanIshranePrikaz.getTxtImeP().setEnabled(false);
        frmPlanIshranePrikaz.getTxtPrezimeP().setEnabled(false);
        frmPlanIshranePrikaz.getTblStavke().setEnabled(false);
        frmPlanIshranePrikaz.getBtnDani().setEnabled(false);
        frmPlanIshranePrikaz.getBtnDatum().setEnabled(false);
        frmPlanIshranePrikaz.getBtnBrisi().setEnabled(false);

        PlanIshrane p = (PlanIshrane) Koordinator.vratiInstancu().uzmiParametar(Konstante.PLAN_ISHRANE);
        if (p == null) {
            System.out.println("Nije izabran plan");
            return;
        }
        frmPlanIshranePrikaz.getTxtCena().setText(p.getCena().toString());
        frmPlanIshranePrikaz.getTxtDatum().setText(p.getDatum().toString());
        frmPlanIshranePrikaz.getTxtDani().setText("" + p.getBrojDana());
        frmPlanIshranePrikaz.getTxtImeN().setText(p.getNutricionista().getIme());
        frmPlanIshranePrikaz.getTxtPrezimeN().setText(p.getNutricionista().getPrezime());
        frmPlanIshranePrikaz.getTxtImeP().setText(p.getPacijent().getIme());
        frmPlanIshranePrikaz.getTxtPrezimeP().setText(p.getPacijent().getPrezime());
        ModelTabeleStavkaIshrane modelStavke = new ModelTabeleStavkaIshrane(p.getStavke());
        modelStavke.dodajRB();
        frmPlanIshranePrikaz.getTblStavke().setModel(modelStavke);
        frmPlanIshranePrikaz.getPnlJela().setVisible(false);
    }
}
