package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form;

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Login forma klijent strane aplikacije
 * 
 * Pri prijavljivanju na formi potrebno je popuniti oba polja i za username i za
 * password
 * 
 * @author Iva Stanisic
 */
public class FrmPrijava extends javax.swing.JFrame {

	/**
	 * Kreira novu instancu klase FrmPrijava
	 */
	public FrmPrijava() {
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

		lblUsername = new javax.swing.JLabel();
		lblPassword = new javax.swing.JLabel();
		txtKorisnickoIme = new javax.swing.JTextField();
		txtLozinka = new javax.swing.JPasswordField();
		btnLogin = new javax.swing.JButton();
		lblUsernameError = new javax.swing.JLabel();
		lblPasswordError = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Prijava");
		setBackground(new java.awt.Color(204, 255, 255));

		lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblUsername.setForeground(new java.awt.Color(51, 0, 255));
		lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblUsername.setText("Korisničko ime:");

		lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblPassword.setForeground(new java.awt.Color(51, 0, 255));
		lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblPassword.setText("Lozinka:");
		lblPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		txtKorisnickoIme.setBackground(new java.awt.Color(204, 255, 255));
		txtKorisnickoIme.setText(" ");

		txtLozinka.setBackground(new java.awt.Color(204, 255, 255));

		btnLogin.setBackground(new java.awt.Color(255, 255, 204));
		btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnLogin.setForeground(new java.awt.Color(255, 51, 51));
		btnLogin.setText("Prijavi se");
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLoginActionPerformed(evt);
			}
		});

		lblUsernameError.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
		lblUsernameError.setForeground(new java.awt.Color(255, 0, 51));
		lblUsernameError.setText(" ");

		lblPasswordError.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
		lblPasswordError.setForeground(new java.awt.Color(255, 0, 51));
		lblPasswordError.setText(" ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(17, 17, 17)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE,
														396, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE,
														396, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGap(103, 103, 103).addComponent(
										lblPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 396,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 396,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnLogin,
								javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(19, 19, 19)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblUsernameError)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblPasswordError)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnLogin,
								javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(52, 52, 52)));

		pack();
	}// </editor-fold>

	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
	}
	/*
	 * /**
	 * 
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton btnLogin;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JLabel lblPasswordError;
	private javax.swing.JLabel lblUsername;
	private javax.swing.JLabel lblUsernameError;
	private javax.swing.JTextField txtKorisnickoIme;
	private javax.swing.JPasswordField txtLozinka;
	// End of variables declaration

	/**
	 * Dodaje ActionListener na dugme za prijavu
	 * 
	 * @param actionListener Action Listener koji ce biti dodat na dugme za prijavu
	 */
	public void prijavaAddActionListener(ActionListener actionListener) {
		btnLogin.addActionListener(actionListener);
	}

	/**
	 * Vraca JLabel objekat koji prikazuje oznaku za polje za unos lozinke
	 * 
	 * @return JLabel objekat za prikaz greske polja za unos lozinke
	 */
	public JLabel getLblPassword() {
		return lblPassword;
	}

	/**
	 * Vraca JLabel objekat koji prikazuje gresku za polje za unos lozinke
	 * 
	 * @return JLabel objekat za prikaz greske polja za unos lozinke
	 */

	public JLabel getLblPasswordError() {
		return lblPasswordError;
	}

	/**
	 * Vraca JLabel objekat koji prikazuje oznaku za polje za unos korisnickog imena
	 * 
	 * @return JLabel objekat za oznaku polja za unos korisnickog imena
	 */
	public JLabel getLblUsername() {
		return lblUsername;
	}

	/**
	 * Vraca JLabel objekat koji prikazuje gresku za polje za unos korisnickog imena
	 * 
	 * @return JLabel objekat za prikaz greske polja za unos korisnickog imena
	 */
	public JLabel getLblUsernameError() {
		return lblUsernameError;
	}

	/**
	 * Postavlja JLabel objekat za prikaz korisnicke lozinke
	 * 
	 * @param lblPassword JLabel objekat za prikaz korisnicke lozinke
	 */
	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	/**
	 * Postavlja JLabel objekat za prikaz greske pri unosu korisnicke lozinke
	 * 
	 * @param lblPasswordError JLabel objekat za prikaz greske pri unosu korisnicke
	 *                         lozinke
	 */
	public void setLblPasswordError(JLabel lblPasswordError) {
		this.lblPasswordError = lblPasswordError;
	}

	/**
	 * Postavlja JLabel objekat za prikaz korisnickog imena
	 * 
	 * @param lblUsername JLabel objekat za prikaz korisnickog imena
	 */
	public void setLblUsername(JLabel lblUsername) {
		this.lblUsername = lblUsername;
	}

	/**
	 * Postavlja JLabel objekat za prikaz greske pri unosu korisnickog imena
	 * 
	 * @param lblUsernameError JLabel objekat za prikaz greske pri unosu korisnickog
	 *                         imena
	 */
	public void setLblUsernameError(JLabel lblUsernameError) {
		this.lblUsernameError = lblUsernameError;
	}

	/**
	 * Vraca JTextField objekat za unos korisnickog imena
	 * 
	 * @return JTextField objekat za unos korisnickog imena
	 */
	public JTextField getTxtKorisnickoIme() {
		return txtKorisnickoIme;
	}

	/**
	 * Vraca JPasswordField objekat za unos lozinke
	 * 
	 * @return JPasswordField objekat za unos lozinke
	 */
	public JPasswordField getTxtLozinka() {
		return txtLozinka;
	}

	/**
	 * Postavlja JTextField objekat za unos korisnickog imena
	 * 
	 * @param txtKorisnickoIme JTextField objekat za unos korisnickog imena
	 */
	public void setTxtKorisnickoIme(JTextField txtKorisnickoIme) {
		this.txtKorisnickoIme = txtKorisnickoIme;
	}

	/**
	 * Postavlja JPasswordField objekat za unos lozinke
	 * 
	 * @param txtLozinka JPasswordField objekat za unos lozinke
	 */
	public void setTxtLozinka(JPasswordField txtLozinka) {
		this.txtLozinka = txtLozinka;
	}

}
