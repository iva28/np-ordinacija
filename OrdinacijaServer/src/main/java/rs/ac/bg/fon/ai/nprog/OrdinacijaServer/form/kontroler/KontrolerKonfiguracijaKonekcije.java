package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.FrmKonfiguracijaKonekcije;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.podesavanja.KonekcijaPodaci;

/**
 *
 * @author Iva
 */
public class KontrolerKonfiguracijaKonekcije {
    private final FrmKonfiguracijaKonekcije frmKonekcija;

    public KontrolerKonfiguracijaKonekcije(FrmKonfiguracijaKonekcije frmKonekcija) {
        this.frmKonekcija = frmKonekcija;
        addActionListeners();
    }
    public void otvoriFormu() {
        pripremaForme();
        frmKonekcija.setVisible(true);
    }

    private void pripremaForme() {
        frmKonekcija.getTxtAdresa().setText(KonekcijaPodaci.vratiInstancu().vratiProperti("adresa"));
        frmKonekcija.getTxtAdresa().setEditable(false);
        frmKonekcija.getTxtPort().setText(KonekcijaPodaci.vratiInstancu().vratiProperti("port"));
        frmKonekcija.getTxtPort().setEditable(false);
        frmKonekcija.getBtnSacuvajPromene().setEnabled(false);
    }

    private void addActionListeners() {
        frmKonekcija.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmKonekcija.getBtnSacuvajPromene().setEnabled(true);
//                frmKonekcija.getTxtAdresa().setEditable(true);
                frmKonekcija.getTxtPort().setEditable(true);
                frmKonekcija.getTxtPort().setText("");
            }
        });
        frmKonekcija.addBtnSacuvajPromeneActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacuvajPodatkeOKonekciji();
            }

            private void sacuvajPodatkeOKonekciji() {
                String adresa = frmKonekcija.getTxtAdresa().getText().trim();
                if (adresa == null || adresa.isEmpty()) {
                    JOptionPane.showMessageDialog(frmKonekcija, "Postavite adresu!");
                    return;
                }
                String port = frmKonekcija.getTxtPort().getText().trim();
                if (port == null || port.isEmpty() || !port.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(frmKonekcija, "Postavite ispravno broj porta!");
                    frmKonekcija.getTxtPort().setText("");
                    return;
                }
                try {
					KonekcijaPodaci.vratiInstancu().postaviAdresu(adresa);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					KonekcijaPodaci.vratiInstancu().postaviPort(port);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                JOptionPane.showMessageDialog(frmKonekcija,"Uspešno izvršena promena podataka za konekciju!");
                frmKonekcija.dispose();
            }
        });
    }
    
}
