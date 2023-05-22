package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.kontroler.planIshrane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.model.ModelTabelePlanoviIshrana;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.planIshrane.FrmPretragaPlanaIshrane;
import rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;

/**
 *
 * @author Iva
 */
public class KontrolerPretragaPlanaIshrane {

    private final FrmPretragaPlanaIshrane frmPretragaPlanaIsh;

    public KontrolerPretragaPlanaIshrane(FrmPretragaPlanaIshrane frmPretragaPlanaIsh) {
        this.frmPretragaPlanaIsh = frmPretragaPlanaIsh;
        addActionListeners();
    }

//    public void otvoriFormu() {
//        pripremiFormu();
//        frmPretragaPlanaIsh.setVisible(true);
//    }

    private void addActionListeners() {
        frmPretragaPlanaIsh.addbtnPretragaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nadjiPlanIshrane();
            }

            private void nadjiPlanIshrane() {
                try {
                    Nutricionista nutricionista = (Nutricionista) frmPretragaPlanaIsh.getCmbNutricionista().getSelectedItem();
                    Pacijent pacijent = (Pacijent) frmPretragaPlanaIsh.getCmbPacijenti().getSelectedItem();
                    if (nutricionista == null && pacijent == null) {
                        JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Selektujte ili pacijenta ili nutricionistu ili oba!", "GREŠKA",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    PlanIshrane plan = new PlanIshrane();
                    plan.setPacijent(pacijent);
                    plan.setNutricionista(nutricionista);
                    List<PlanIshrane> listа = Komunikacija.vratiInstancu().nadjiPlanove(plan);
                    if (listа == null || listа.isEmpty()) {
                        JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Sistem ne može da nađe planove po zadatoj vrednosti");
                    } else {
                        JOptionPane.showMessageDialog(frmPretragaPlanaIsh,"Sistem je našao planove po zadatoj vrednosti");
                        ModelTabelePlanoviIshrana model = new ModelTabelePlanoviIshrana(listа);
                        frmPretragaPlanaIsh.getTblPlan().setModel(model);
                    }
                } catch (Exception ex) {
                    System.err.println("Greška u pretrazi plana "+ex.getMessage());
                }
            }
        });
        frmPretragaPlanaIsh.addbtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetujPretragu();
            }

            private void resetujPretragu() {
                frmPretragaPlanaIsh.getCmbNutricionista().setSelectedItem(null);
                frmPretragaPlanaIsh.getCmbPacijenti().setSelectedItem(null);
                frmPretragaPlanaIsh.getTblPlan().setModel(new ModelTabelePlanoviIshrana());
            }
        });
        frmPretragaPlanaIsh.addbtnPrikaziSveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikatiSvePlanove();
            }

            private void prikatiSvePlanove() {
                try {
                    List<PlanIshrane> lista = Komunikacija.vratiInstancu().ucitajListuPlanova();
                    ModelTabelePlanoviIshrana model = new ModelTabelePlanoviIshrana(lista);
                    frmPretragaPlanaIsh.getTblPlan().setModel(model);
                } catch (Exception ex) {
                    System.err.println("Greška pri učitavanju planova ishrana! "+ex.getMessage());
                }
            }
        });
        frmPretragaPlanaIsh.addbtnUcitajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ucitajPlanIshrane();
            }

            private void ucitajPlanIshrane() {
                try {
                    int red = frmPretragaPlanaIsh.getTblPlan().getSelectedRow();
                    if (red == -1) {
                        JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Selektujte red u tabeli");
                        return;
                    }
                    ModelTabelePlanoviIshrana modelTabele = (ModelTabelePlanoviIshrana) frmPretragaPlanaIsh.getTblPlan().getModel();
                    PlanIshrane plan = modelTabele.vratiPlan(red);
                    plan = Komunikacija.vratiInstancu().ucitajPlanIshrane(plan);
                    if (plan != null) {
                        JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Sistem je učitao plan ishrane");
                        modelTabele.postaviJedan(plan);
                        frmPretragaPlanaIsh.getTblPlan().setModel(modelTabele);
                    } else {
                    JOptionPane.showMessageDialog(frmPretragaPlanaIsh, "Sistem ne može da učita plan ishrane");
                    frmPretragaPlanaIsh.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void pripremiFormu() {
        frmPretragaPlanaIsh.getTblPlan().setModel(new ModelTabelePlanoviIshrana());
        popuniCbNutricionista();
        popuniCbPacijenti();
    }

    private void popuniCbNutricionista() {
        try {
            frmPretragaPlanaIsh.getCmbNutricionista().removeAllItems();
            List<Nutricionista> lista = Komunikacija.vratiInstancu().ucitajListuNutricionista();
            if (lista == null) {
                return;
            }
            for (Nutricionista n : lista) {
                frmPretragaPlanaIsh.getCmbNutricionista().addItem(n);
            }
            frmPretragaPlanaIsh.getCmbNutricionista().setSelectedItem(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void popuniCbPacijenti() {
        try {
            frmPretragaPlanaIsh.getCmbPacijenti().removeAllItems();
            List<Pacijent> lista = Komunikacija.vratiInstancu().ucitajListuPacijenata();
            if (lista == null) {
                return;
            }
            for (Pacijent p : lista) {
                frmPretragaPlanaIsh.getCmbPacijenti().addItem(p);
            }
            frmPretragaPlanaIsh.getCmbPacijenti().setSelectedItem(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	public void otvoriFormu() {
		pripremiFormu();
        frmPretragaPlanaIsh.setVisible(true);		
	}

}
