package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Predstavlja formu za izmene parametara serverskog soketa
 * 
 * @author Iva Stanisic
 */
public class FrmKonfiguracijaKonekcije extends javax.swing.JDialog {

	/**
	 * Kreira novu instancu klase FrmKonfiguracijaKonekcije
	 * 
	 * @param parent roditeljska forma
	 * @param model modalnost dialoga
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

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray,
						java.awt.Color.darkGray, null, null),
				"Podaci konekcije:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12),
				new java.awt.Color(51, 0, 255))); // NOI18N

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
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(lblAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 317,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6)
												.addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 317,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnIzmeni, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnSacuvajPromene, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
						.addContainerGap(23, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(36, 36, 36)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(36, 36, 36)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(26, 26, 26)
						.addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26).addComponent(btnSacuvajPromene, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(75, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(14, 14, 14)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(18, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(22, 22, 22)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	/**
	 * Dugme za izmenu parametra za povezivanje na serverski soket
	 */
	private javax.swing.JButton btnIzmeni;

	/**
	 * Dugme za cuvanje promena u property fajlu na zajednickom projektu
	 */
	private javax.swing.JButton btnSacuvajPromene;

	/**
	 * Panel
	 */
	private javax.swing.JPanel jPanel1;

	/**
	 * Labela za adresu
	 */
	private javax.swing.JLabel lblAdresa;

	/**
	 * Labela za port
	 */
	private javax.swing.JLabel lblPort;

	/**
	 * Polje za unos adrese
	 */
	private javax.swing.JTextField txtAdresa;

	/**
	 * Polje za unos porta
	 */
	private javax.swing.JTextField txtPort;

	// End of variables declaration
	/**
	 * Vraca dugme za izmenu parametara servera
	 * 
	 * @return btnIzmeni dugme za izmenu
	 */
	public JButton getBtnIzmeni() {
		return btnIzmeni;
	}

	/**
	 * Vraca dugme za cuvanje izmena
	 * 
	 * @return btnSacuvajPromene dugme za cuvanje izmena
	 */
	public JButton getBtnSacuvajPromene() {
		return btnSacuvajPromene;
	}

	/**
	 * Vraca panel
	 * 
	 * @return jPanel1 panel
	 */
	public JPanel getjPanel1() {
		return jPanel1;
	}

	/**
	 * Vraca JLabel komponentu za prikazivanje adrese servera
	 *
	 * @return JLabel komponenta za prikazivanje adrese servera
	 */
	public JLabel getLblAdresa() {
		return lblAdresa;
	}

	/**
	 * Vraca JLabel komponentu za prikazivanje porta servera
	 *
	 * @return JLabel komponenta za prikazivanje porta servera
	 */
	public JLabel getLblPort() {
		return lblPort;
	}

	/**
	 * Vraca polje za unos adrese serverskog soketa
	 * 
	 * @return txtAdresa za unos adrese
	 */
	public JTextField getTxtAdresa() {
		return txtAdresa;
	}

	/**
	 * Vraca polje za unos porta serverskog soketa
	 * 
	 * @return txtPort za unos adrese
	 */
	public JTextField getTxtPort() {
		return txtPort;
	}

	/**
	 * Postavlja dugme za izmenu parametara servera
	 * 
	 * @param btnIzmeni dugme za izmenu parametara
	 */
	public void setBtnIzmeni(JButton btnIzmeni) {
		this.btnIzmeni = btnIzmeni;
	}

	/**
	 * Postavja dugme za cuvanje izmena
	 * 
	 * @param btnSacuvajPromene dugme za cuvanje izmena
	 */
	public void setBtnSacuvajPromene(JButton btnSacuvajPromene) {
		this.btnSacuvajPromene = btnSacuvajPromene;
	}

	/**
	 * Postavlja panel na formu
	 * 
	 * @param jPanel1 panel
	 */
	public void setjPanel1(JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	/**
	 * Postavlja labelu za adresu
	 * 
	 * @param lblAdresa adresa
	 */
	public void setLblAdresa(JLabel lblAdresa) {
		this.lblAdresa = lblAdresa;
	}

	/**
	 * Postavlja labelu za port
	 * 
	 * @param lblPort labela za port
	 */
	public void setLblPort(JLabel lblPort) {
		this.lblPort = lblPort;
	}

	/**
	 * Postavja polje za unos adrese
	 * 
	 * @param txtAdresa polje za unos adrese
	 */
	public void setTxtAdresa(JTextField txtAdresa) {
		this.txtAdresa = txtAdresa;
	}

	/**
	 * Postavlja polje za unos porta
	 * 
	 * @param txtPort polje za unos porta
	 */
	public void setTxtPort(JTextField txtPort) {
		this.txtPort = txtPort;
	}

	/**
	 * Dodaje ActionListener na dugme btnIzmeni
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addBtnIzmeniActionListener(ActionListener actionListener) {
		btnIzmeni.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnSacuvajPromene
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addBtnSacuvajPromeneActionListener(ActionListener actionListener) {
		btnSacuvajPromene.addActionListener(actionListener);
	}

}
