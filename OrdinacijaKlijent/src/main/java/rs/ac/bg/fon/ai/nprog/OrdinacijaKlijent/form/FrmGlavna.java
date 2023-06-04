package rs.ac.bg.fon.ai.nprog.OrdinacijaKlijent.form;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Glavna forma klijent strane aplikacije
 * 
 * Nutricionista kada se uloguje omoguceno mu je da pretrazuje i unosi jela, kreira, menja i brise planove ishrane
 * 
 * @author Iva Stanisic
 */
public class FrmGlavna extends javax.swing.JFrame {

	/**
	 * Kreira novu instancu klase FrmGlavna
	 * 
	 */
	public FrmGlavna() {
		initComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * Inicijalizuje komponente forme.
	 * 
	 * WARNING: Ne menjaj kod. Sadrzaj ove metode uvek automatski generise Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		lblIme = new javax.swing.JLabel();
		txtIme = new javax.swing.JTextField();
		lblPrezime = new javax.swing.JLabel();
		lblOrdinacija = new javax.swing.JLabel();
		txtPrezime = new javax.swing.JTextField();
		txtOrd = new javax.swing.JTextField();
		menuBar = new javax.swing.JMenuBar();
		jPacijent = new javax.swing.JMenu();
		jMenuItemDodajP = new javax.swing.JMenuItem();
		jMenuItemIzmeniP = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItemDodajJ = new javax.swing.JMenuItem();
		jMenuItemPretragaJ = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		jMenuItemKreirajPI = new javax.swing.JMenuItem();
		jMenuItemManipulacijaPl = new javax.swing.JMenuItem();
		jMenuItemPretragaPlana = new javax.swing.JMenuItem();
		jMenu6 = new javax.swing.JMenu();
		jMenuItemOdjava = new javax.swing.JMenuItem();

		jMenu3.setText("File");
		jMenuBar1.add(jMenu3);

		jMenu4.setText("Edit");
		jMenuBar1.add(jMenu4);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Glavna forma");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray,
						java.awt.Color.darkGray, null, null),
				"Nutricionista:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12),
				new java.awt.Color(255, 0, 0))); // NOI18N

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Trenutni administrator: ");

		lblIme.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblIme.setText("Ime");

		txtIme.setText(" ");

		lblPrezime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblPrezime.setText("Prezime");

		lblOrdinacija.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		lblOrdinacija.setText("Ordinacija");

		txtPrezime.setText(" ");

		txtOrd.setText(" ");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(71, 71, 71).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(23, 23, 23)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(lblIme, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblOrdinacija, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(33, 33, 33)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 282,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 282,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 282,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(79, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblIme, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblOrdinacija, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(174, Short.MAX_VALUE)));

		jPacijent.setText("Pacijent");
		jPacijent.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jPacijentActionPerformed(evt);
			}
		});

		jMenuItemDodajP.setText("Dodaj pacijenta");
		jMenuItemDodajP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemDodajPActionPerformed(evt);
			}
		});
		jPacijent.add(jMenuItemDodajP);

		jMenuItemIzmeniP.setText("Manipulacija pacijenata");
		jMenuItemIzmeniP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemIzmeniPActionPerformed(evt);
			}
		});
		jPacijent.add(jMenuItemIzmeniP);

		menuBar.add(jPacijent);

		jMenu2.setText("Jelo");

		jMenuItemDodajJ.setText("Dodaj jelo");
		jMenuItemDodajJ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemDodajJActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItemDodajJ);

		jMenuItemPretragaJ.setText("Pretraga jela");
		jMenuItemPretragaJ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemPretragaJActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItemPretragaJ);

		menuBar.add(jMenu2);

		jMenu1.setText("Plan Ishrane");

		jMenuItemKreirajPI.setText("Kreiraj plan ishrane");
		jMenuItemKreirajPI.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemKreirajPIActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemKreirajPI);

		jMenuItemManipulacijaPl.setText("Manipulacija planom");
		jMenuItemManipulacijaPl.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemManipulacijaPlActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemManipulacijaPl);

		jMenuItemPretragaPlana.setText("Pretraga plana");
		jMenuItemPretragaPlana.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemPretragaPlanaActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItemPretragaPlana);

		menuBar.add(jMenu1);

		jMenu6.setForeground(new java.awt.Color(255, 0, 0));
		jMenu6.setText("Odjavi se");

		jMenuItemOdjava.setText("Odjava");
		jMenuItemOdjava.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemOdjavaActionPerformed(evt);
			}
		});
		jMenu6.add(jMenuItemOdjava);

		menuBar.add(jMenu6);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(23, 23, 23)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jMenuItemDodajPActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jMenuItemIzmeniPActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jMenuItemDodajJActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jMenuItemPretragaJActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jPacijentActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jMenuItemKreirajPIActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jMenuItemManipulacijaPlActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jMenuItemOdjavaActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jMenuItemPretragaPlanaActionPerformed(java.awt.event.ActionEvent evt) {
	}

	/*
	/**
	 * Argumenti komandne linije
	 * 
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku.
	 */
	private javax.swing.JLabel jLabel1;

	/**
	 * Referenca na JMenu objekat koji predstavlja meni 1.
	 */
	private javax.swing.JMenu jMenu1;

	/**
	 * Referenca na JMenu objekat koji predstavlja meni 2.
	 */
	private javax.swing.JMenu jMenu2;

	/**
	 * Referenca na JMenu objekat koji predstavlja meni 3.
	 */
	private javax.swing.JMenu jMenu3;

	/**
	 * Referenca na JMenu objekat koji predstavlja meni 4.
	 */
	private javax.swing.JMenu jMenu4;

	/**
	 * Referenca na JMenu objekat koji predstavlja meni 6.
	 */
	private javax.swing.JMenu jMenu6;

	/**
	 * Referenca na JMenuBar objekat koji predstavlja traku sa menijima.
	 */
	private javax.swing.JMenuBar jMenuBar1;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za dodavanje jela.
	 */
	private javax.swing.JMenuItem jMenuItemDodajJ;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za dodavanje pacijenta.
	 */
	private javax.swing.JMenuItem jMenuItemDodajP;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za izmenu pacijenta.
	 */
	private javax.swing.JMenuItem jMenuItemIzmeniP;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za kreiranje plana ishrane.
	 */
	private javax.swing.JMenuItem jMenuItemKreirajPI;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za manipulaciju planovima ishrane.
	 */
	private javax.swing.JMenuItem jMenuItemManipulacijaPl;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za odjavu.
	 */
	private javax.swing.JMenuItem jMenuItemOdjava;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za pretragu jela.
	 */
	private javax.swing.JMenuItem jMenuItemPretragaJ;

	/**
	 * Referenca na JMenuItem objekat koji predstavlja stavku menija za pretragu plana ishrane.
	 */
	private javax.swing.JMenuItem jMenuItemPretragaPlana;

	/**
	 * Referenca na JMenu objekat koji predstavlja meni pacijent.
	 */
	private javax.swing.JMenu jPacijent;

	/**
	 * Referenca na JPanel objekat koji predstavlja panel.
	 */
	private javax.swing.JPanel jPanel1;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za ime.
	 */
	private javax.swing.JLabel lblIme;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za ordinaciju.
	 */
	private javax.swing.JLabel lblOrdinacija;

	/**
	 * Referenca na JLabel objekat koji predstavlja oznaku za prezime.
	 */
	private javax.swing.JLabel lblPrezime;

	/**
	 * Referenca na JMenuBar objekat koji predstavlja traku sa menijima.
	 */
	private javax.swing.JMenuBar menuBar;

	/**
	 * Referenca na JTextField objekat koji predstavlja tekstualno polje za ime.
	 */
	private javax.swing.JTextField txtIme;
	/**
	 * Referenca na JTextField objekat koji predstavlja tekstualno polje za ordinaciju.
	 */
	private javax.swing.JTextField txtOrd;
	/**
	 * Referenca na JTextField objekat koji predstavlja tekstualno polje za prezime.
	 */
	private javax.swing.JTextField txtPrezime;
	// End of variables declaration

	/**
	 * Dodaje ActionListener za opciju "Dodaj pacijenta" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Dodaj pacijenta"
	 */
	public void jMenuItemDodajacijentaAddActionListener(ActionListener actionListener) {
		jMenuItemDodajP.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener za opciju "Izmeni pacijenta" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Izmeni pacijenta"
	 */
	public void jMenuItemIzmeniPacijentaAddActionListener(ActionListener actionListener) {
		jMenuItemIzmeniP.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener za opciju "Dodaj jelo" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Dodaj jelo"
	 */
	public void jMenuItemDodajJeloAddActionListener(ActionListener actionListener) {
		jMenuItemDodajJ.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener za opciju "Pretraga jela" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Pretraga jela"
	 */
	public void jMenuItemPretragaJelaAddActionListener(ActionListener actionListener) {
		jMenuItemPretragaJ.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener za opciju "Kreiraj plan ishrane" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Kreiraj plan ishrane"
	 */
	public void jMenuItemKreirajPlanIshraneAddActionListener(ActionListener actionListener) {
		jMenuItemKreirajPI.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener za opciju "Prikazi plan ishrane" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Prikazi plan ishrane"
	 */
	public void jMenuItemManipulacijaPlanIshraneAddActionListener(ActionListener actionListener) {
		jMenuItemManipulacijaPl.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener za opciju "Pretraga plana ishrane" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Pretraga plana ishrane"
	 */
	public void jMenuItemPretragaPlanaAddActionListener(ActionListener actionListener) {
		jMenuItemPretragaPlana.addActionListener(actionListener);
	}
	/**
	 * Dodaje ActionListener za opciju "Odjavi se" u meniju
	 *
	 * @param actionListener ActionListener za opciju "Odjavi se"
	 */
	public void jMenuItemOdjavaAddActionListener(ActionListener actionListener) {
		jMenuItemOdjava.addActionListener(actionListener);
	}

	/**
	 * Vraca JLabel komponentu za prikazivanje imena
	 *
	 * @return JLabel komponenta za prikazivanje imena
	 */
	public JLabel getLblIme() {
		return lblIme;
	}
	/**
	 * Vraca JLabel komponentu za prikazivanje ordinacije
	 *
	 * @return JLabel komponenta za prikazivanje ordinacije
	 */
	public JLabel getLblOrdinacija() {
		return lblOrdinacija;
	}
	/**
	 * Vraća JLabel komponentu za prikazivanje prezimena
	 *
	 * @return JLabel komponenta za prikazivanje prezimena
	 */
	public JLabel getLblPrezime() {
		return lblPrezime;
	}
	/**
	 * Vraća JTextField komponentu za unos imena
	 *
	 * @return JTextField komponenta za unos imena
	 */
	public JTextField getTxtIme() {
		return txtIme;
	}
	/**
	 * Vraća JTextField komponentu za unos ordinacije.
	 *
	 * @return JTextField komponenta za unos ordinacije
	 */
	public JTextField getTxtOrd() {
		return txtOrd;
	}
	/**
	 * Vraća JTextField komponentu za unos prezimena
	 *
	 * @return JTextField komponenta za unos prezimena
	 */
	public JTextField getTxtPrezime() {
		return txtPrezime;
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
	 * Postavlja JTextField komponentu za unos ordinacije
	 *
	 * @param txtOrd JTextField komponenta za unos ordinacije
	 */
	public void setTxtOrd(JTextField txtOrd) {
		this.txtOrd = txtOrd;
	}
	/**
	 * Postavlja JTextField komponentu za unos prezimena
	 *
	 * @param txtPrezime JTextField komponenta za unos prezimena
	 */
	public void setTxtPrezime(JTextField txtPrezime) {
		this.txtPrezime = txtPrezime;
	}

}
