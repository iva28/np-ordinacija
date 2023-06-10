package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.FrmKonfiguracijaKonekcije;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.podesavanja.KonekcijaPodaci;

/**
 * Kontroler za formu konfiguracije konekcije za serverski soket
 * 
 * @author Iva Stanisic
 */
public class KontrolerKonfiguracijaKonekcije {
	/**
	 * Forma za podesavanje konekcijskih parametara
	 */
    private final FrmKonfiguracijaKonekcije frmKonekcija;

    /**
     * Konstruktor klase KontrolerKonfiguracijaKonekcije
     * 
     * @param frmKonekcija FrmKonfiguracijaKonekcije objekat kojim se upravlja
     */
    public KontrolerKonfiguracijaKonekcije(FrmKonfiguracijaKonekcije frmKonekcija) {
        this.frmKonekcija = frmKonekcija;
        addActionListeners();
    }
    /**
	 * Otvara formu i priprema je za prikaz
	 */
    public void otvoriFormu() {
        pripremaForme();
        frmKonekcija.setVisible(true);
    }
	/**
	 * Priprema formu i postavlja pocetno stanje komponenata na formi
	 */
    private void pripremaForme() {
        frmKonekcija.getTxtAdresa().setText(KonekcijaPodaci.vratiInstancu().vratiProperti("adresa"));
        frmKonekcija.getTxtAdresa().setEditable(false);
        frmKonekcija.getTxtPort().setText(KonekcijaPodaci.vratiInstancu().vratiProperti("port"));
        frmKonekcija.getTxtPort().setEditable(false);
        frmKonekcija.getBtnSacuvajPromene().setEnabled(false);
    }
    /**
	 * Dodaje listenere na odgovarajuce komponente
	 */
    private void addActionListeners() {
    	/**
    	 * Dodaje ActionListener na dugme btnIzmeni na formi konfiguracije konekcije
    	 * 
    	 * Kada se dugme klikne, aktivira se mogucnost izmene polja za unos.
    	 * Takodje, omogucava se dugme "Sačuvaj promene" i brise se tekst iz polja za unos porta.
    	 */
        frmKonekcija.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmKonekcija.getBtnSacuvajPromene().setEnabled(true);
//                frmKonekcija.getTxtAdresa().setEditable(true);
                frmKonekcija.getTxtPort().setEditable(true);
                frmKonekcija.getTxtPort().setText("");
            }
        });
        /**
		 * Dodaje ActionListener na dugme btnSacuvajPromene na glavnoj formi
		 * 
		 * Kada se dugme klikne, poziva se metoda sacuvajPodatkeOKonekciji()
		 */
        frmKonekcija.addBtnSacuvajPromeneActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacuvajPodatkeOKonekciji();
            }

            /**
             * Cuva podataka o konekciji na serverski soket
             * 
             * Izvlaci podatke o adresi i portu sa forme.
             * Validira unesene podatke i prikazuje odgovarajuce poruke upozorenja.
             * Ako su podaci ispravni, azurira instancu KonekcijaPodaci sa novom adresom i portom.
             */
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
