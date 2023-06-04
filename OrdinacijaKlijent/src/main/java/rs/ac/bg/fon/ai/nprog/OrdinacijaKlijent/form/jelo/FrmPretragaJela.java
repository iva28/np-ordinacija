package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.jelo;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Forma koja umogucuje nutricionisti da pretrazi postojeca jela za kreiranje
 * planova ishrana
 * 
 * @author Iva Stanisic
 */
public class FrmPretragaJela extends javax.swing.JFrame {
	/**
	 * Kreira novu instancu klase FrmPretragaJela
	 */
	public FrmPretragaJela() {
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
		lblJela = new javax.swing.JLabel();
		lblKuvar = new javax.swing.JLabel();
		cbTipJela = new javax.swing.JComboBox<>();
		cbKuvar = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblJela = new javax.swing.JTable();
		btnNewJelo = new javax.swing.JButton();
		btnSearch = new javax.swing.JButton();
		btnRefresh = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Pretraga jela");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white,
						java.awt.Color.blue, null, null),
				"U ponudi:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12),
				new java.awt.Color(51, 0, 204))); // NOI18N
		jPanel1.setToolTipText("");

		lblJela.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblJela.setText("Tip jela:");

		lblKuvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblKuvar.setText("Kuvar:");

		cbTipJela.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		cbKuvar.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		tblJela.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tblJela);

		btnNewJelo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnNewJelo.setForeground(new java.awt.Color(51, 0, 204));
		btnNewJelo.setText(" Novo jelo");
		btnNewJelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204), 2));
		btnNewJelo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNewJeloActionPerformed(evt);
			}
		});

		btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnSearch.setForeground(new java.awt.Color(204, 0, 51));
		btnSearch.setText(" Pretraži");
		btnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 2));
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSearchActionPerformed(evt);
			}
		});

		btnRefresh.setBackground(new java.awt.Color(255, 255, 204));
		btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnRefresh.setForeground(new java.awt.Color(204, 0, 51));
		btnRefresh.setText("Osveži");
		btnRefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 2));
		btnRefresh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRefreshActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(lblKuvar, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(cbKuvar, javax.swing.GroupLayout.PREFERRED_SIZE, 164,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(lblJela, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(cbTipJela, javax.swing.GroupLayout.PREFERRED_SIZE, 164,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394,
										Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 141,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 141,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(14, 14, 14))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnNewJelo, javax.swing.GroupLayout.PREFERRED_SIZE, 141,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblJela, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(cbTipJela, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(cbKuvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(lblKuvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btnNewJelo,
								javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(172, 172, 172)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(24, 24, 24)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(60, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(20, 20, 20).addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(62, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void btnNewJeloActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
	}
	/*
	 * /**
	 * 
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	/**
	 * Referenca na JButton objekat koji predstavlja dugme za dodavanje novog jela.
	 */
	private javax.swing.JButton btnNewJelo;

	/**
	 * Referenca na JButton objekat koji predstavlja dugme za osvežavanje podataka.
	 */
	private javax.swing.JButton btnRefresh;

	/**
	 * Referenca na JButton objekat koji predstavlja dugme za pretragu.
	 */
	private javax.swing.JButton btnSearch;

	/**
	 * Referenca na JComboBox objekat koji predstavlja izbor kuvara.
	 */
	private javax.swing.JComboBox<Object> cbKuvar;

	/**
	 * Referenca na JComboBox objekat koji predstavlja izbor tipa jela.
	 */
	private javax.swing.JComboBox<Object> cbTipJela;

	/**
	 * Referenca na JPanel objekat koji predstavlja panel.
	 */
	private javax.swing.JPanel jPanel1;

	/**
	 * Referenca na JScrollPane objekat koji omogućava klizanje za tabelu jela.
	 */
	private javax.swing.JScrollPane jScrollPane1;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za jela.
	 */
	private javax.swing.JLabel lblJela;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za kuvara.
	 */
	private javax.swing.JLabel lblKuvar;

	/**
	 * Referenca na JTable objekat koji predstavlja tabelu jela.
	 */
	private javax.swing.JTable tblJela;

	// End of variables declaration

	/**
	 * Vraca dugme btnNewJelo
	 *
	 * @return Dugme btnNewJelo
	 */
	public JButton getBtnNewJelo() {
		return btnNewJelo;
	}

	/**
	 * Vraca dugme btnRefresh
	 *
	 * @return Dugme btnRefresh
	 */
	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	/**
	 * Vraca dugme btnSearch
	 *
	 * @return Dugme btnSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
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
	 * Vraca JPanel jPanel1
	 *
	 * @return JPanel jPanel1
	 */
	public JPanel getjPanel1() {
		return jPanel1;
	}

	/**
	 * Vraca JScrollPane jScrollPane1.
	 *
	 * @return JScrollPane jScrollPane1
	 */
	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	/**
	 * Vraca JLabel lblJela.
	 *
	 * @return JLabel lblJela
	 */
	public JLabel getLblJela() {
		return lblJela;
	}

	/**
	 * Vraca JLabel lblKuvar
	 *
	 * @return JLabel lblKuvar
	 */
	public JLabel getLblKuvar() {
		return lblKuvar;
	}

	/**
	 * Vraca JTable tblJela
	 *
	 * @return JTable tblJela
	 */
	public JTable getTblJela() {
		return tblJela;
	}

	/**
	 * Postavlja dugme btnNewJelo
	 *
	 * @param btnNewJelo Dugme btnNewJelo koje treba postaviti
	 */
	public void setBtnNewJelo(JButton btnNewJelo) {
		this.btnNewJelo = btnNewJelo;
	}

	/**
	 * Postavlja dugme btnRefresh
	 *
	 * @param btnRefresh Dugme btnRefresh koje treba postaviti
	 */
	public void setBtnRefresh(JButton btnRefresh) {
		this.btnRefresh = btnRefresh;
	}

	/**
	 * Postavlja dugme btnSearch
	 *
	 * @param btnSearch Dugme btnSearch koje treba postaviti
	 */
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
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
	 * Postavlja JPanel jPanel1
	 *
	 * @param jPanel1 JPanel koji treba postaviti
	 */
	public void setjPanel1(JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	/**
	 * Postavlja JScrollPane jScrollPane1
	 * 
	 * @param jScrollPane1 JScrollPane jScrollPane1 koji treba postaviti
	 */
	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	/**
	 * Postavlja JLabel lblJela
	 *
	 * @param lblJela JLabel lblJela koji treba postaviti
	 */
	public void setLblJela(JLabel lblJela) {
		this.lblJela = lblJela;
	}

	/**
	 * Postavlja JLabel lblKuvar
	 *
	 * @param lblKuvar JLabel lblKuvar koji treba postaviti
	 */
	public void setLblKuvar(JLabel lblKuvar) {
		this.lblKuvar = lblKuvar;
	}

	/**
	 * Postavlja JTable tblJela
	 *
	 * @param tblJela JTable tblJela koji treba postaviti
	 */
	public void setTblJela(JTable tblJela) {
		this.tblJela = tblJela;
	}

	/**
	 * Dodaje ActionListener na dugme btnSearch
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnSearchActionListener(ActionListener actionListener) {
		btnSearch.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnRefresh
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnRefreshActionListener(ActionListener actionListener) {
		btnRefresh.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnNewJelo
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnNewJeloActionListener(ActionListener actionListener) {
		btnNewJelo.addActionListener(actionListener);
	}

}
