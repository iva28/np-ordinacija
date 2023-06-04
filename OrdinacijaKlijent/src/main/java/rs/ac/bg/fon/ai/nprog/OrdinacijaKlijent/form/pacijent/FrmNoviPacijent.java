package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form.pacijent;

import rs.ac.bg.fon.ai.nprog.OrdinacijaZajednicki.domen.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Forma koja umogucuje nutricionisti da unese novog pacijenta za koje se
 * kreiraju planov ishrana
 * 
 * @author Iva Stanisic
 */
public class FrmNoviPacijent extends javax.swing.JDialog {
	/**
	 * Novokreirani pacijent
	 */
	Pacijent pacijent;

	/**
	 * Creates new form FrmNoviPacijent
	 * 
	 * @param pacijent
	 * @param parent
	 * @param modal
	 */

	/**
	 * Postavlja pacijenta
	 * 
	 * @param pacijent pacijent koji se unosi
	 */
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	/**
	 * Vraca pacijenta sa forme
	 * 
	 * @return pacijent sa forme
	 */
	public Pacijent getPacijent() {
		return pacijent;
	}

	/**
	 * Konstruktor klase FrmNoviPacijent
	 *
	 * @param parent   roditeljski okvir
	 * @param modal    modalnost prozora
	 * @param pacijent objekat klase Pacijent koji se koristi za inicijalizaciju
	 *                 forme
	 */
	public FrmNoviPacijent(java.awt.Frame parent, boolean modal, Pacijent pacijent) {
		super(parent, modal);
		this.pacijent = pacijent;
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

		pnlPacijent.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.magenta,
						java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.magenta),
				"Pacijent:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14),
				new java.awt.Color(51, 0, 204))); // NOI18N
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
		pnlPacijentLayout
				.setHorizontalGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								pnlPacijentLayout.createSequentialGroup().addContainerGap()
										.addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 184,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(
												btnSetChangeMode, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18))
						.addGroup(pnlPacijentLayout.createSequentialGroup().addGap(54, 54, 54)
								.addGroup(pnlPacijentLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(pnlPacijentLayout.createSequentialGroup()
												.addComponent(lblIme, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(pnlPacijentLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblErrorIme,
																javax.swing.GroupLayout.PREFERRED_SIZE, 434,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE,
																434, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												pnlPacijentLayout
														.createSequentialGroup().addGap(12, 12,
																12)
														.addComponent(
																lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
																434, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(pnlPacijentLayout.createSequentialGroup().addComponent(
												lblPol, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
												javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(pnlPacijentLayout.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(pnlPacijentLayout.createSequentialGroup().addGap(26,
																26, 26)
																.addGroup(pnlPacijentLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false).addComponent(lblErrorPrezime,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				434, Short.MAX_VALUE)
																		.addComponent(lblEmailError,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(lblTelefonError,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
														.addGroup(pnlPacijentLayout.createSequentialGroup()
																.addGap(18, 18, 18)
																.addGroup(pnlPacijentLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(lblPolError,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				434,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(cmbPol,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				434,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))))
										.addGroup(pnlPacijentLayout.createSequentialGroup().addGroup(pnlPacijentLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblTelefon, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 66,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(pnlPacijentLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(pnlPacijentLayout.createSequentialGroup().addGap(4, 4,
																4)
																.addComponent(txtTelefon,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 434,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(pnlPacijentLayout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(txtPrezime,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 434,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addGap(29, 29, 29)
								.addGroup(pnlPacijentLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 88,
												Short.MAX_VALUE))
								.addGap(0, 6, Short.MAX_VALUE)));
		pnlPacijentLayout.setVerticalGroup(pnlPacijentLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlPacijentLayout.createSequentialGroup().addGap(12, 12, 12)
						.addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pnlPacijentLayout.createSequentialGroup()
										.addGroup(pnlPacijentLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblIme).addComponent(txtIme,
														javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lblErrorIme, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(11, 11, 11)
										.addGroup(pnlPacijentLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(lblPrezime).addComponent(txtPrezime,
														javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lblErrorPrezime).addGap(18, 18, 18)
										.addGroup(pnlPacijentLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(pnlPacijentLayout.createSequentialGroup()
										.addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addComponent(lblEmailError).addGap(18, 18, 18)
						.addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(3, 3, 3).addComponent(lblTelefonError)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblPol, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbPol, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblPolError)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
						.addGroup(pnlPacijentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnSetChangeMode, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(31, 31, 31)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(17, 17, 17)
						.addComponent(pnlPacijent, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(48, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(38, 38, 38)
						.addComponent(pnlPacijent, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(44, Short.MAX_VALUE)));

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
	/*
	 * /**
	 * 
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	/**
	 * Referenca na JButton objekat koji predstavlja dugme za dodavanje.
	 */
	private javax.swing.JButton btnInsert;

	/**
	 * Referenca na JButton objekat koji predstavlja dugme za brisanje.
	 */
	private javax.swing.JButton btnObrisi;

	/**
	 * Referenca na JButton objekat koji predstavlja dugme za resetovanje.
	 */
	private javax.swing.JButton btnReset;

	/**
	 * Referenca na JButton objekat koji predstavlja dugme za čuvanje izmena.
	 */
	private javax.swing.JButton btnSaveChanges;

	/**
	 * Referenca na JButton objekat koji predstavlja dugme za promenu režima izmena.
	 */
	private javax.swing.JButton btnSetChangeMode;

	/**
	 * Referenca na JComboBox objekat koji predstavlja izbor pola.
	 */
	private javax.swing.JComboBox<Object> cmbPol;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za email.
	 */
	private javax.swing.JLabel lblEmail;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za grešku pri unosu emaila.
	 */
	private javax.swing.JLabel lblEmailError;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za grešku pri unosu imena.
	 */
	private javax.swing.JLabel lblErrorIme;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za grešku pri unosu prezimena.
	 */
	private javax.swing.JLabel lblErrorPrezime;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za ime.
	 */
	private javax.swing.JLabel lblIme;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za pol.
	 */
	private javax.swing.JLabel lblPol;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za grešku pri unosu pola.
	 */
	private javax.swing.JLabel lblPolError;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za prezime.
	 */
	private javax.swing.JLabel lblPrezime;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za telefon.
	 */
	private javax.swing.JLabel lblTelefon;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za grešku pri unosu telefona.
	 */
	private javax.swing.JLabel lblTelefonError;

	/**
	 * Referenca na JPanel objekat koji predstavlja panel pacijenta.
	 */
	private javax.swing.JPanel pnlPacijent;

	/**
	 * Referenca na JTextField objekat koji predstavlja tekstualno polje za email.
	 */
	private javax.swing.JTextField txtEmail;

	/**
	 * Referenca na JTextField objekat koji predstavlja tekstualno polje za ime.
	 */
	private javax.swing.JTextField txtIme;

	/**
	 * Referenca na JTextField objekat koji predstavlja tekstualno polje za prezime.
	 */
	private javax.swing.JTextField txtPrezime;

	/**
	 * Referenca na JTextField objekat koji predstavlja tekstualno polje za telefon.
	 */
	private javax.swing.JTextField txtTelefon;


	// End of variables declaration
	/**
	 * Vraca JButton komponentu za unos (insert) koja se koristi u formi
	 *
	 * @return JButton komponenta za unos (insert)
	 */
	public JButton getBtnInsert() {
		return btnInsert;
	}

	/**
	 * Vraca JButton komponentu za resetovanje koja se koristi u formi
	 *
	 * @return JButton komponenta za resetovanje
	 */
	public JButton getBtnReset() {
		return btnReset;
	}

	/**
	 * Vraca JComboBox komponentu za pol koja se koristi u formi
	 *
	 * @return JComboBox komponenta za pol
	 */
	public JComboBox<Object> getCmbPol() {
		return cmbPol;
	}

	/**
	 * Vraca JLabel komponentu za email koja se koristi u formi
	 *
	 * @return JLabel komponenta za email
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * Vraca JLabel komponentu za prikaz greske pri unosu emaila
	 *
	 * @return JLabel komponenta za prikaz greske pri unosu emaila
	 */
	public JLabel getLblEmailError() {
		return lblEmailError;
	}

	/**
	 * Vraca JLabel komponentu za prikaz greske pri unosu imena
	 *
	 * @return JLabel komponenta za prikaz greske pri unosu imena
	 */
	public JLabel getLblErrorIme() {
		return lblErrorIme;
	}

	/**
	 * Vraca JLabel komponentu za prikaz greske pri unosu prezimena
	 *
	 * @return JLabel komponenta za prikaz greske pri unosu prezimena
	 */
	public JLabel getLblErrorPrezime() {
		return lblErrorPrezime;
	}

	/**
	 * Vraca JLabel komponentu za prikaz imena
	 *
	 * @return JLabel komponenta za prikaz imena
	 */
	public JLabel getLblIme() {
		return lblIme;
	}

	/**
	 * Vraca JLabel komponentu za prikaz pola koja se koristi u formi
	 *
	 * @return JLabel komponenta za prikaz pola
	 */
	public JLabel getLblPol() {
		return lblPol;
	}

	/**
	 * Vraca JLabel komponentu za prikaz greske pri unosu pola
	 *
	 * @return JLabel komponenta za prikaz greske pri unosu pola
	 */
	public JLabel getLblPolError() {
		return lblPolError;
	}

	/**
	 * Vraca JLabel komponentu za prikaz prezimena koja se koristi u formi
	 *
	 * @return JLabel komponenta za prikaz prezimena
	 */
	public JLabel getLblPrezime() {
		return lblPrezime;
	}

	/**
	 * Vraca JLabel komponentu za prikaz telefona koja se koristi u formi
	 *
	 * @return JLabel komponenta za prikaz telefona
	 */
	public JLabel getLblTelefon() {
		return lblTelefon;
	}

	/**
	 * Vraca JLabel komponentu za prikaz greske pri unosu telefona
	 *
	 * @return JLabel komponenta za prikaz greske pri unosu telefona
	 */
	public JLabel getLblTelefonError() {
		return lblTelefonError;
	}

	/**
	 * Vraca JPanel komponentu za prikaz informacija o pacijentu
	 *
	 * @return JPanel komponenta za prikaz informacija o pacijentu
	 */
	public JPanel getPnlPacijent() {
		return pnlPacijent;
	}

	/**
	 * Vraca JTextField komponentu za unos emaila koja se koristi u formi
	 *
	 * @return JTextField komponenta za unos emaila
	 */
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * Vraca JTextField komponentu za unos imena koja se koristi u formi
	 *
	 * @return JTextField komponenta za unos imena
	 */
	public JTextField getTxtIme() {
		return txtIme;
	}

	/**
	 * Vraca JTextField komponentu za unos prezimena koja se koristi u formi
	 *
	 * @return JTextField komponenta za unos prezimena
	 */
	public JTextField getTxtPrezime() {
		return txtPrezime;
	}

	/**
	 * Vraca JTextField komponentu za unos telefona koja se koristi u formi
	 *
	 * @return JTextField komponenta za unos telefona
	 */
	public JTextField getTxtTelefon() {
		return txtTelefon;
	}

	/**
	 * Vraca JButton komponentu za cuvanje promena
	 *
	 * @return JButton komponenta za cuvanje promena
	 */
	public JButton getBtnSaveChanges() {
		return btnSaveChanges;
	}

	/**
	 * Vraca JButton komponentu za postavljanje rezima izmena
	 *
	 * @return JButton komponenta za postavljanje rezima izmena.
	 */
	public JButton getBtnSetChangeMode() {
		return btnSetChangeMode;
	}

	/**
	 * Postavlja JComboBox komponentu za pol koja se koristi u formi
	 *
	 * @param cmbPol JComboBox komponenta za pol
	 */
	public void setCmbPol(JComboBox<Object> cmbPol) {
		this.cmbPol = cmbPol;
	}

	/**
	 * Postavlja JLabel komponentu za prikaz greske pri unosu emaila
	 *
	 * @param lblEmailError JLabel komponenta za prikaz greske pri unosu emaila
	 */
	public void setLblEmailError(JLabel lblEmailError) {
		this.lblEmailError = lblEmailError;
	}

	/**
	 * Postavlja JLabel komponentu za prikaz greske pri unosu imena
	 *
	 * @param lblErrorIme JLabel komponenta za prikaz greske pri unosu imena
	 */
	public void setLblErrorIme(JLabel lblErrorIme) {
		this.lblErrorIme = lblErrorIme;
	}

	/**
	 * Postavlja JLabel komponentu za prikaz greske pri unosu prezimena
	 *
	 * @param lblErrorPrezime JLabel komponenta za prikaz greske pri unosu prezimena
	 */
	public void setLblErrorPrezime(JLabel lblErrorPrezime) {
		this.lblErrorPrezime = lblErrorPrezime;
	}

	/**
	 * Postavlja JLabel komponentu za prikaz greske pri unosu pola
	 *
	 * @param lblPolError JLabel komponenta za prikaz greske pri unosu pola
	 */
	public void setLblPolError(JLabel lblPolError) {
		this.lblPolError = lblPolError;
	}

	/**
	 * Postavlja JLabel komponentu za prikaz greske pri unosu telefona
	 *
	 * @param lblTelefonError JLabel komponenta za prikaz greske pri unosu telefona
	 */
	public void setLblTelefonError(JLabel lblTelefonError) {
		this.lblTelefonError = lblTelefonError;
	}

	/**
	 * Postavlja JTextField komponentu za unos emaila
	 *
	 * @param txtEmail JTextField komponenta za unos emaila
	 */
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	/**
	 * Postavlja JTextField komponentu za unos imena
	 *
	 * @param txtIme JTextField komponenta za unos imena
	 */
	public void setTxtIme(JTextField txtIme) {
		this.txtIme = txtIme;
	}

	/**
	 * Postavlja JTextField komponentu za unos prezimena
	 *
	 * @param txtPrezime JTextField komponenta za unos prezimena
	 */
	public void setTxtPrezime(JTextField txtPrezime) {
		this.txtPrezime = txtPrezime;
	}

	/**
	 * Postavlja JTextField komponentu za unos telefona
	 *
	 * @param txtTelefon JTextField komponenta za unos telefona
	 */
	public void setTxtTelefon(JTextField txtTelefon) {
		this.txtTelefon = txtTelefon;
	}

	/**
	 * Vraca JButton dugme za brisanje
	 *
	 * @return JButton dugme za brisanje
	 */
	public JButton getBtnObrisi() {
		return btnObrisi;
	}

	/**
	 * Postavlja JButton dugme za brisanje koja se koristi u formi
	 *
	 * @param btnObrisi JButton dugme za brisanje
	 */
	public void setBtnObrisi(JButton btnObrisi) {
		this.btnObrisi = btnObrisi;
	}

	/**
	 * Dodaje ActionListener na dugme btnInsert
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnInsertActionListener(ActionListener actionListener) {
		btnInsert.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnReset
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnResetActionListener(ActionListener actionListener) {
		btnReset.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnSetChangeMode
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnSetChangeModeActionListener(ActionListener actionListener) {
		btnSetChangeMode.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnSaveChanges
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnSaveChangesModeActionListener(ActionListener actionListener) {
		btnSaveChanges.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnObrisi
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnObrisiActionListener(ActionListener actionListener) {
		btnObrisi.addActionListener(actionListener);
	}
}
