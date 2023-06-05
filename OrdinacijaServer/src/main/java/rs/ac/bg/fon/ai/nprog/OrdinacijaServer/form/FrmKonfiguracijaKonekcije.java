package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Iva
 */
public class FrmKonfiguracijaKonekcije extends javax.swing.JDialog {

    /**
     * Creates new form FrmKonfiguracijaKonekcije
     */
    public FrmKonfiguracijaKonekcije(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jPanel1 = new javax.swing.JPanel();
        lblAdresa = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        lblPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnIzmeni = new javax.swing.JButton();
        btnSacuvajPromene = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.darkGray, null, null), "Podaci konekcije:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12), new java.awt.Color(51, 0, 255))); // NOI18N

        lblAdresa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAdresa.setText("Adresa:");

        txtAdresa.setText(" ");

        lblPort.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPort.setText("Port:");

        txtPort.setText(" ");

        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzmeni.setForeground(new java.awt.Color(51, 0, 255));
        btnIzmeni.setText("Izmeni");
        btnIzmeni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204), 2));

        btnSacuvajPromene.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvajPromene.setForeground(new java.awt.Color(51, 0, 255));
        btnSacuvajPromene.setText("Sačuvaj promene");
        btnSacuvajPromene.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSacuvajPromene, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSacuvajPromene, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnSacuvajPromene;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblPort;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtPort;
    // End of variables declaration                   

    public JButton getBtnIzmeni() {
        return btnIzmeni;
    }

    public JButton getBtnSacuvajPromene() {
        return btnSacuvajPromene;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JLabel getLblAdresa() {
        return lblAdresa;
    }

    public JLabel getLblPort() {
        return lblPort;
    }

    public JTextField getTxtAdresa() {
        return txtAdresa;
    }

    public JTextField getTxtPort() {
        return txtPort;
    }

    public void setBtnIzmeni(JButton btnIzmeni) {
        this.btnIzmeni = btnIzmeni;
    }

    public void setBtnSacuvajPromene(JButton btnSacuvajPromene) {
        this.btnSacuvajPromene = btnSacuvajPromene;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public void setLblAdresa(JLabel lblAdresa) {
        this.lblAdresa = lblAdresa;
    }

    public void setLblPort(JLabel lblPort) {
        this.lblPort = lblPort;
    }

    public void setTxtAdresa(JTextField txtAdresa) {
        this.txtAdresa = txtAdresa;
    }

    public void setTxtPort(JTextField txtPort) {
        this.txtPort = txtPort;
    }

    public void addBtnIzmeniActionListener(ActionListener actionListener) {
        btnIzmeni.addActionListener(actionListener);
    }
    public void addBtnSacuvajPromeneActionListener(ActionListener actionListener) {
        btnSacuvajPromene.addActionListener(actionListener);
    }

}