package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Forma koja umogucuje nutricionisti da pretrazuje sve pacijente
 * 
 * @author Iva Stanisic
 */
public class FrmSviPacijenti extends javax.swing.JFrame {
	/**
	 * Konstruktor klase FrmSviPacijenti
	 * 
	 * Inicijalizuje i konfigurise formu za prikaz svih pacijenata.
	 */
	public FrmSviPacijenti() {
		initComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		tblPacijenti = new javax.swing.JTable();
		pnlOpcije = new javax.swing.JPanel();
		btnDodaj = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnChange = new javax.swing.JButton();
		btnSearchMode = new javax.swing.JButton();
		btnRefresh = new javax.swing.JButton();
		lblAdministrator = new javax.swing.JLabel();
		pnlSearch = new javax.swing.JPanel();
		txtSearch = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblSearch = new javax.swing.JTable();
		btnSearch = new javax.swing.JButton();
		lblSearchError = new javax.swing.JLabel();
		btnCloseSearch = new javax.swing.JButton();
		btnDetalji = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Pacijent");

		tblPacijenti
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tblPacijenti);

		pnlOpcije.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opcije:",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 12), new java.awt.Color(51, 0, 204))); // NOI18N

		btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnDodaj.setForeground(new java.awt.Color(51, 0, 204));
		btnDodaj.setText("Dodaj");
		btnDodaj.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDodajActionPerformed(evt);
			}
		});

		btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnDelete.setForeground(new java.awt.Color(51, 0, 204));
		btnDelete.setText("Obriši");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		btnChange.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnChange.setForeground(new java.awt.Color(51, 0, 204));
		btnChange.setText("Izmeni");
		btnChange.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChangeActionPerformed(evt);
			}
		});

		btnSearchMode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnSearchMode.setForeground(new java.awt.Color(51, 0, 204));
		btnSearchMode.setText("Pretraga");
		btnSearchMode.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSearchModeActionPerformed(evt);
			}
		});

		btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnRefresh.setForeground(new java.awt.Color(51, 0, 204));
		btnRefresh.setText("Osveži");
		btnRefresh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRefreshActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlOpcijeLayout = new javax.swing.GroupLayout(pnlOpcije);
		pnlOpcije.setLayout(pnlOpcijeLayout);
		pnlOpcijeLayout.setHorizontalGroup(pnlOpcijeLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlOpcijeLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlOpcijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSearchMode, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		pnlOpcijeLayout
				.setVerticalGroup(
						pnlOpcijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnlOpcijeLayout.createSequentialGroup().addContainerGap()
										.addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnSearchMode, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(84, Short.MAX_VALUE)));

		lblAdministrator.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
		lblAdministrator.setText(" ");

		pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pretraga:",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 12), new java.awt.Color(255, 51, 0))); // NOI18N

		txtSearch.setText(" ");

		tblSearch
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(tblSearch);

		btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnSearch.setForeground(new java.awt.Color(255, 51, 0));
		btnSearch.setText("Pretraži");
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSearchActionPerformed(evt);
			}
		});

		lblSearchError.setText(" ");

		btnCloseSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnCloseSearch.setForeground(new java.awt.Color(255, 51, 0));
		btnCloseSearch.setText("Zatvori pretragu");
		btnCloseSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCloseSearchActionPerformed(evt);
			}
		});

		btnDetalji.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnDetalji.setForeground(new java.awt.Color(255, 51, 0));
		btnDetalji.setText("Detalji");
		btnDetalji.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDetaljiActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
		pnlSearch.setLayout(pnlSearchLayout);
		pnlSearchLayout.setHorizontalGroup(pnlSearchLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlSearchLayout.createSequentialGroup().addGap(32, 32, 32).addGroup(pnlSearchLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlSearchLayout.createSequentialGroup()
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 982,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(128, Short.MAX_VALUE))
						.addGroup(pnlSearchLayout.createSequentialGroup()
								.addGroup(pnlSearchLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(lblSearchError, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCloseSearch).addGap(156, 156, 156)))));
		pnlSearchLayout.setVerticalGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlSearchLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCloseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblSearchError).addGap(18, 18, 18).addComponent(jScrollPane2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(38, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblAdministrator, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pnlOpcije, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(18, 18, 18)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(pnlOpcije, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGap(50, 50, 50)
						.addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(60, 60, 60)
						.addComponent(lblAdministrator, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnSearchModeActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnCloseSearchActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {
	}

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton btnChange;
	private javax.swing.JButton btnCloseSearch;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnDetalji;
	private javax.swing.JButton btnDodaj;
	private javax.swing.JButton btnRefresh;
	private javax.swing.JButton btnSearch;
	private javax.swing.JButton btnSearchMode;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblAdministrator;
	private javax.swing.JLabel lblSearchError;
	private javax.swing.JPanel pnlOpcije;
	private javax.swing.JPanel pnlSearch;
	private javax.swing.JTable tblPacijenti;
	private javax.swing.JTable tblSearch;
	private javax.swing.JTextField txtSearch;

	// End of variables declaration
	/**
	 * Vraca JButton komponentu za postavljanje rezima izmena
	 *
	 * @return JButton komponenta za postavljanje rezima izmena.
	 */
	public JButton getBtnChange() {
		return btnChange;
	}

	/**
	 * Vraca JButton komponentu za zatvaranje pretrage pacijenata
	 *
	 * @return JButton komponenta za zatvaranje pretrage pacijenata
	 */
	public JButton getBtnCloseSearch() {
		return btnCloseSearch;
	}

	/**
	 * Vraca JButton komponentu za brisanje
	 *
	 * @return JButton komponenta za brisanje
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * Vraca JButton komponentu za dodavanje
	 *
	 * @return JButton komponenta za dodavanje
	 */
	public JButton getBtnDodaj() {
		return btnDodaj;
	}

	/**
	 * Vraca JButton komponentu za osvezavanje forme
	 *
	 * @return JButton komponenta za osvezavanje forme
	 */
	public JButton getBtnRefresh() {
		return btnRefresh;
	}
	/**
	 * Vraca JButton komponentu za pretragu
	 *
	 * @return JButton komponenta za pretragu
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}
	/**
	 * Vraca JButton komponentu za prelazak u rezim pretrage
	 *
	 * @return JButton komponenta za prelazak u rezim pretrage
	 */
	public JButton getBtnSearchMode1() {
		return btnSearchMode;
	}
	/**
	 * Vraca JScrollPane komponentu koja se koristi u formi za tabelu pacijenata.
	 *
	 * @return JScrollPane komponenta za tabelu pacijenata
	 */
	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}
	/**
	 * Vraca JScrollPane komponentu koja se koristi u formi za tabelu pretrage
	 *
	 * @return JScrollPane komponenta za tabelu pretrage
	 */
	public JScrollPane getjScrollPane2() {
		return jScrollPane2;
	}
	/**
	 * Vraca JPanel komponentu koja sadrzi opcije
	 *
	 * @return JPanel komponenta sa opcijama
	 */
	public JPanel getPnlOpcije() {
		return pnlOpcije;
	}
	/**
	 * Vraca JPanel komponentu koja sadrzi sekciju za pretragu u formi
	 *
	 * @return JPanel komponenta sa sekcijom za pretragu
	 */
	public JPanel getPnlSearch() {
		return pnlSearch;
	}
	/**
	 * Vraca JTable komponentu koja se koristi za prikaz tabele pacijenata u formi
	 *
	 * @return JTable komponenta za prikaz tabele pacijenata
	 */
	public JTable getTblPacijenti() {
		return tblPacijenti;
	}
	/**
	 * Vraca JTable komponentu koja se koristi za prikaz tabele pretrage u formi
	 *
	 * @return JTable komponenta za prikaz tabele pretrage
	 */
	public JTable getTblSearch() {
		return tblSearch;
	}
	/**
	 * Vraca JTextField komponentu koja se koristi za unos teksta pretrage
	 *
	 * @return JTextField komponenta za unos teksta pretrage
	 */
	public JTextField getTxtSearch() {
		return txtSearch;
	}
	/**
	 * Postavlja JLabel komponentu za prikaz greske pretrage
	 *
	 * @param lblSearchError JLabel komponenta za prikaz greske pretrage
	 */
	public void setLblSearchError(JLabel lblSearchError) {
		this.lblSearchError = lblSearchError;
	}
	/**
	 * Vraca JLabel komponentu koja se koristi za prikaz greske pretrage
	 *
	 * @return JLabel komponenta za prikaz greske pretrage
	 */
	public JLabel getLblSearchError() {
		return lblSearchError;
	}
	/**
	 * Postavlja JTextField komponentu koja se koristi za unos teksta pretrage
	 *
	 * @param txtSearch JTextField komponenta za unos teksta pretrage
	 */
	public void setTxtSearch(JTextField txtSearch) {
		this.txtSearch = txtSearch;
	}
	/**
	 * Dodaje ActionListener na dugme btnDodaj
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnDodajActionListener(ActionListener actionListener) {
		btnDodaj.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener na dugme btnDelete
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnDeleteActionListener(ActionListener actionListener) {
		btnDelete.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener na dugme btnChange
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnChangeActionListener(ActionListener actionListener) {
		btnChange.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener na dugme btnSearchMode
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnSearchModeActionListener(ActionListener actionListener) {
		btnSearchMode.addActionListener(actionListener);
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
	 * Dodaje ActionListener na dugme btnSearch
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnSearchActionListener(ActionListener actionListener) {
		btnSearch.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener na dugme btnCloseSearch
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnCloseSearchActionListener(ActionListener actionListener) {
		btnCloseSearch.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener na dugme btnDetalji
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnDetaljiActionListener(ActionListener actionListener) {
		btnDetalji.addActionListener(actionListener);
	}

}
