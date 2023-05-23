package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.kontroler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.FrmGlavna;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.koordinator.KoordinatorS;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form.model.ModelTabeleLogovani;
import rs.ac.bg.fon.ai.nprog.OrdinacijaServer.server.Server;
import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.Nutricionista;

/**
 *
 * @author Iva
 */
public class KontrolerPokreniServer {

    private final FrmGlavna frmGlavna;
    Server server;

    public FrmGlavna getFrmGlavna() {
        return frmGlavna;
    }

    public Server getServer() {
        return server;
    }

    public KontrolerPokreniServer(FrmGlavna frmMain) {
        this.frmGlavna = frmMain;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        frmGlavna.pack();
        frmGlavna.setVisible(true);
    }

    private void pripremiFormu() {
        frmGlavna.getBtnStop().setEnabled(false);
        frmGlavna.getLblServer().setText("Server nije pokrenut..");
        frmGlavna.getLblServer().setForeground(Color.red);
        pripremiTabele();
    }

    private void pripremiTabele() {
        frmGlavna.getTblLogovani().setModel(new ModelTabeleLogovani());
        frmGlavna.getTblLogovani().setEnabled(false);

        frmGlavna.getTblAktivni().setModel(new ModelTabeleLogovani());
        frmGlavna.getTblAktivni().setEnabled(false);
        TableColumn tc = frmGlavna.getTblAktivni().getColumnModel().getColumn(3);
        frmGlavna.getTblAktivni().getColumnModel().removeColumn(tc);
    }

    private void addActionListeners() {
        frmGlavna.addbtnStartActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokreniServer();
            }

            private void pokreniServer() {
                if (server == null || !server.isAlive()) {
                    try {
                        server = new Server();
                        server.start();
                        frmGlavna.getBtnStart().setEnabled(false);
                        frmGlavna.getBtnStop().setEnabled(true);
                        frmGlavna.getBtnPodesiKonekciju().setEnabled(false);
                        frmGlavna.getLblServer().setText("Server je pokrenut :)");
                        frmGlavna.getLblServer().setForeground(Color.green);
                    } catch (Exception e) {
                        System.err.println("Greška u pokretanju servera " + e.getMessage());
                        JOptionPane.showMessageDialog(frmGlavna, "GREŠKA u pokretanju servera...", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        frmGlavna.addbtnStopActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zaustaviServer();
            }

            private void zaustaviServer() {
                if (server.getServerSocket() != null) {
                    try {
                        server.zatvoriServerskiSoket();
                        KoordinatorS.vratiInstancu().setAktivniKorisnici(new ArrayList<>());
                        pripremiTabele();
                        frmGlavna.getBtnStop().setEnabled(false);
                        frmGlavna.getBtnStart().setEnabled(true);
                        frmGlavna.getBtnPodesiKonekciju().setEnabled(true);
                        frmGlavna.getLblServer().setText("Server je prekinut...");
                        frmGlavna.getLblServer().setForeground(Color.red);
                    } catch (Exception ex) {
                        System.err.println("Greška pri gašenju servera " + ex.getMessage());
                        JOptionPane.showMessageDialog(frmGlavna, "GREŠKA u zaustavljanju servera...", "GREŠKA",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        frmGlavna.addbtnPodesiKonekcijuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!frmGlavna.getBtnStart().isEnabled()) {
                    JOptionPane.showMessageDialog(frmGlavna, "Server je već pokrenut");
                    return;
                }
                KoordinatorS.vratiInstancu().otvoriFormuKonfiguracijeKonekcije();
            }
        });
        frmGlavna.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    server.zatvoriServerskiSoket();
                } catch (NullPointerException ne) {
                }
            }
        });
    }

    public void dodajNutricionistu(Nutricionista n) {
        ModelTabeleLogovani mt = (ModelTabeleLogovani) frmGlavna.getTblLogovani().getModel();
        mt.dodaj(n);
        ModelTabeleLogovani mt1 = (ModelTabeleLogovani) frmGlavna.getTblAktivni().getModel();
        mt1.dodaj(n);
    }

    public void odjavaNutricioniste(Nutricionista n) {
        ModelTabeleLogovani mt = (ModelTabeleLogovani) frmGlavna.getTblAktivni().getModel();
        mt.obrisi(n);
    }

}
