/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Iva
 */
public class FrmNoviPacijent extends javax.swing.JDialog {
    
    Pacijent pacijent;

    /**
     * Creates new form FrmNoviPacijent
     * @param pacijent
     * @param parent
     * @param modal
     */
    

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public FrmNoviPacijent(java.awt.Frame parent, boolean modal, Pacijent pacijent) {
        super(parent,modal);
        this.pacijent = pacijent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        pnlPacijent = new javax.swing.JPanel();
        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblErrorIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        lblErrorPrezime = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailError = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        lblTelefonError = new javax.swing.JLabel();
        lblPol = new javax.swing.JLabel();
        cmbPol = new javax.swing.JComboBox<>();
        lblPolError = new javax.swing.JLabel();
        btnSetChangeMode = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSaveChanges = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novi pacijent");

        pnlPacijent.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.magenta), "Pacijent:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(51, 0, 204))); // NOI18N
        pnlPacijent.setToolTipText("");
        pnlPacijent.setName("Novi pacijent"); // NOI18N

        lblIme.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIme.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIme.setText("Ime");

        txtIme.setText(" ");

        lblErrorIme.setText(" ");

        lblPrezime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrezime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrezime.setText("Prezime");

        txtPrezime.setText(" ");

        lblErrorPrezime.setText(" ");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email");

        txtEmail.setText(" ");

        lblEmailError.setText(" ");

        lblTelefon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefon.setText("Telefon");

        txtTelefon.setText(" ");

        lblTelefonError.setText(" ");

        lblPol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPol.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPol.setText("Pol");

        cmbPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPolActionPerformed(evt);
            }
        });

        lblPolError.setText(" ");

        btnSetChangeMode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSetChangeMode.setText("Izmeni podatke");
        btnSetChangeMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetChangeModeActionPerformed(evt);
            }
        });

        btnInsert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsert.setText("Dodaj");
        btnInsert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 255, 204));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setText("Resetuj");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSaveChanges.setBackground(new java.awt.Color(209, 236, 255));
        btnSaveChanges.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveChanges.setText("Sačuvaj promene");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(255, 51, 0));
        btnObrisi.setText("Obriši");
        btnObrisi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0)));

        javax.swing.GroupLayout pnlPacijentLayout = new javax.swing.GroupLayout(pnlPacijent);
        pnlPacijent.setLayout(pnlPacijentLayout);
        pnlPacijentLayout.setHorizontalGroup(
            pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPacijentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSetChangeMode, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(pnlPacijentLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPacijentLayout.createSequentialGroup()
                        .addComponent(lblIme, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPacijentLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPacijentLayout.createSequentialGroup()
                        .addComponent(lblPol, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPacijentLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblErrorPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                                    .addComponent(lblEmailError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTelefonError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlPacijentLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPolError, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPol, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlPacijentLayout.createSequentialGroup()
                        .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPacijentLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPacijentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29)
                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        pnlPacijentLayout.setVerticalGroup(
            pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPacijentLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPacijentLayout.createSequentialGroup()
                        .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIme)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPrezime)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorPrezime)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPacijentLayout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(lblEmailError)
                .addGap(18, 18, 18)
                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lblTelefonError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPol, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPol, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPolError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSetChangeMode, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlPacijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(pnlPacijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void cmbPolActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {                                          
    }                                         

    private void btnSetChangeModeActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    }                                                

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JButton btnSetChangeMode;
    private javax.swing.JComboBox<Object> cmbPol;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblErrorIme;
    private javax.swing.JLabel lblErrorPrezime;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPol;
    private javax.swing.JLabel lblPolError;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblTelefonError;
    private javax.swing.JPanel pnlPacijent;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration                   

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JComboBox<Object> getCmbPol() {
        return cmbPol;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public JLabel getLblEmailError() {
        return lblEmailError;
    }

    public JLabel getLblErrorIme() {
        return lblErrorIme;
    }

    public JLabel getLblErrorPrezime() {
        return lblErrorPrezime;
    }

    public JLabel getLblIme() {
        return lblIme;
    }

    public JLabel getLblPol() {
        return lblPol;
    }

    public JLabel getLblPolError() {
        return lblPolError;
    }

    public JLabel getLblPrezime() {
        return lblPrezime;
    }

    public JLabel getLblTelefon() {
        return lblTelefon;
    }

    public JLabel getLblTelefonError() {
        return lblTelefonError;
    }

    public JPanel getPnlPacijent() {
        return pnlPacijent;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtIme() {
        return txtIme;
    }

    public JTextField getTxtPrezime() {
        return txtPrezime;
    }

    public JTextField getTxtTelefon() {
        return txtTelefon;
    }

    public JButton getBtnSaveChanges() {
        return btnSaveChanges;
    }

    public JButton getBtnSetChangeMode() {
        return btnSetChangeMode;
    }

    public void setCmbPol(JComboBox<Object> cmbPol) {
        this.cmbPol = cmbPol;
    }

    public void setLblEmailError(JLabel lblEmailError) {
        this.lblEmailError = lblEmailError;
    }

    public void setLblErrorIme(JLabel lblErrorIme) {
        this.lblErrorIme = lblErrorIme;
    }

    public void setLblErrorPrezime(JLabel lblErrorPrezime) {
        this.lblErrorPrezime = lblErrorPrezime;
    }

    public void setLblPolError(JLabel lblPolError) {
        this.lblPolError = lblPolError;
    }

    public void setLblTelefonError(JLabel lblTelefonError) {
        this.lblTelefonError = lblTelefonError;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setTxtIme(JTextField txtIme) {
        this.txtIme = txtIme;
    }

    public void setTxtPrezime(JTextField txtPrezime) {
        this.txtPrezime = txtPrezime;
    }

    public void setTxtTelefon(JTextField txtTelefon) {
        this.txtTelefon = txtTelefon;
    }

    public JButton getBtnObrisi() {
        return btnObrisi;
    }

    public void setBtnObrisi(JButton btnObrisi) {
        this.btnObrisi = btnObrisi;
    }
    

    public void addbtnInsertActionListener(ActionListener actionListener) {
        btnInsert.addActionListener(actionListener);
    }
    
    public void addbtnResetActionListener(ActionListener actionListener) {
        btnReset.addActionListener(actionListener);
    }
    
      public void addbtnSetChangeModeActionListener(ActionListener actionListener) {
        btnSetChangeMode.addActionListener(actionListener);
    }
      
      public void addbtnSaveChangesModeActionListener(ActionListener actionListener) {
        btnSaveChanges.addActionListener(actionListener);
    }
      public void addbtnObrisiActionListener(ActionListener actionListener) {
        btnObrisi.addActionListener(actionListener);
    }
}