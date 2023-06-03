package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.jelo;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Forma koja umogucuje nutricionisti da unese nova jela za kreiranje planova
 * ishrana
 * 
 * @author Iva Stanisic
 */
public class FrmNovoJelo extends javax.swing.JDialog {

	/**
	 * Kreira novu instancu klase FrmNovoJelo
	 * 
	 * @param parent roditeljski okvir za dialog
	 * @param modal  postavlja da li je dialog modalan (true) ili nije (false)
	 */
	public FrmNovoJelo(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/**
	 * Inicijalizuje komponente forme.
	 * 
	 * WARNING: Ne menjaj kod. Sadrzaj ove metode uvek automatski generise Form
	 * Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		lblNaziv = new javax.swing.JLabel();
		txtNaziv = new javax.swing.JTextField();
		lblTipJela = new javax.swing.JLabel();
		cbTipJela = new javax.swing.JComboBox<>();
		lblCena = new javax.swing.JLabel();
		txtCena = new javax.swing.JTextField();
		lblKuvar = new javax.swing.JLabel();
		cbKuvar = new javax.swing.JComboBox<>();
		btnJelo = new javax.swing.JButton();
		lblKolicina = new javax.swing.JLabel();
		txtKolicina = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Novo jelo");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray,
						java.awt.Color.darkGray, null, null),
				"Novi jelo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12),
				new java.awt.Color(0, 0, 204))); // NOI18N

		lblNaziv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblNaziv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblNaziv.setText("Naziv:");

		txtNaziv.setText(" ");

		lblTipJela.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblTipJela.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblTipJela.setText("Tip jela:");

		cbTipJela.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		lblCena.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblCena.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblCena.setText("Cena:");

		txtCena.setText(" ");

		lblKuvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblKuvar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblKuvar.setText("Kuvar:");

		cbKuvar.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		btnJelo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnJelo.setForeground(new java.awt.Color(255, 0, 0));
		btnJelo.setText("Novo jelo");
		btnJelo.setBorder(null);
		btnJelo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnJeloActionPerformed(evt);
			}
		});

		lblKolicina.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblKolicina.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblKolicina.setText("Gramaža jela:");

		txtKolicina.setText(" ");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(78, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblCena, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipJela, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblKuvar, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNaziv, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 69,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblKolicina, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 128,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(btnJelo, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, 322,
												Short.MAX_VALUE)
										.addComponent(txtCena).addComponent(txtNaziv))
								.addComponent(cbTipJela, javax.swing.GroupLayout.PREFERRED_SIZE, 262,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbKuvar, javax.swing.GroupLayout.PREFERRED_SIZE, 262,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(16, 16, 16)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblCena, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblTipJela, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbTipJela, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblKuvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbKuvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(29, 29, 29).addComponent(btnJelo, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(27, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(55, 55, 55)));

		pack();
	}// </editor-fold>

	private void btnJeloActionPerformed(java.awt.event.ActionEvent evt) {
	}
	/*
	 * /**
	 * 
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton btnJelo;
	private javax.swing.JComboBox<Object> cbKuvar;
	private javax.swing.JComboBox<Object> cbTipJela;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblCena;
	private javax.swing.JLabel lblKolicina;
	private javax.swing.JLabel lblKuvar;
	private javax.swing.JLabel lblNaziv;
	private javax.swing.JLabel lblTipJela;
	private javax.swing.JTextField txtCena;
	private javax.swing.JTextField txtKolicina;
	private javax.swing.JTextField txtNaziv;

	// End of variables declaration
	/**
	 * Vraca JButton btnJelo
	 *
	 * @return JButton btnJelo
	 */
	public JButton getBtnJelo() {
		return btnJelo;
	}

	/**
	 * Vraca JComboBox cbKuvar
	 *
	 * @return JComboBox cbKuvar
	 */
	public JComboBox<Object> getCbKuvar() {
		return cbKuvar;
	}

	/**
	 * Vraca JComboBox cbTipJela
	 *
	 * @return JComboBox cbTipJela
	 */
	public JComboBox<Object> getCbTipJela() {
		return cbTipJela;
	}

	/**
	 * Vraca JTextField txtCena
	 *
	 * @return JTextField txtCena
	 */
	public JTextField getTxtCena() {
		return txtCena;
	}

	/**
	 * Vraca JTextField txtKolicina
	 *
	 * @return JTextField txtKolicina
	 */
	public JTextField getTxtKolicina() {
		return txtKolicina;
	}

	/**
	 * Vraca JTextField txtNaziv
	 *
	 * @return JTextField txtNaziv
	 */
	public JTextField getTxtNaziv() {
		return txtNaziv;
	}

	/**
	 * Postavlja JComboBox cbKuvar
	 *
	 * @param cbKuvar JComboBox cbKuvar koji treba postaviti
	 */
	public void setCbKuvar(JComboBox<Object> cbKuvar) {
		this.cbKuvar = cbKuvar;
	}

	/**
	 * Postavlja JComboBox cbTipJela
	 *
	 * @param cbTipJela JComboBox cbTipJela koji treba postaviti
	 */
	public void setCbTipJela(JComboBox<Object> cbTipJela) {
		this.cbTipJela = cbTipJela;
	}

	/**
	 * Postavlja JTextField txtCena
	 *
	 * @param txtCena JTextField txtCena koji treba postaviti
	 */
	public void setTxtCena(JTextField txtCena) {
		this.txtCena = txtCena;
	}

	/**
	 * Postavlja JTextField txtKolicina
	 *
	 * @param txtKolicina JTextField txtKolicina koji treba postaviti
	 */
	public void setTxtKolicina(JTextField txtKolicina) {
		this.txtKolicina = txtKolicina;
	}

	/**
	 * Postavlja JTextField txtNaziv
	 *
	 * @param txtNaziv JTextField txtNaziv koji treba postaviti
	 */
	public void setTxtNaziv(JTextField txtNaziv) {
		this.txtNaziv = txtNaziv;
	}

	/**
	 * Dodaje ActionListener na dugme btnJelo
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnJeloActionListener(ActionListener actionListener) {
		btnJelo.addActionListener(actionListener);
	}

}
