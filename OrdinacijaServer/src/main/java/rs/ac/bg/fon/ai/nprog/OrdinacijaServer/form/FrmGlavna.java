package rs.ac.bg.fon.ai.nprog.OrdinacijaServer.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Glavna forma server strane aplikacije
 * 
 * Administrator sistema moze da podesi parametre za povezavanje na serverski
 * soket, da vidi sve ulogovane nutricioniste za vreme rada servera kao i
 * trenutno ulogovane nutricioniste na sistem
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

		lblServer = new javax.swing.JLabel();
		btnStart = new javax.swing.JButton();
		btnStop = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblLogovani = new javax.swing.JTable();
		pnlAktivniKorisnici = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblAktivni = new javax.swing.JTable();
		btnPodesiKonekciju = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Server");

		lblServer.setText(" ");

		btnStart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnStart.setText("POKRENI");
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnStartActionPerformed(evt);
			}
		});

		btnStop.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnStop.setText("ZAUSTAVI");
		btnStop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnStopActionPerformed(evt);
			}
		});

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ulogovani korisnici:",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 12), new java.awt.Color(51, 0, 204))); // NOI18N

		tblLogovani.setBackground(new java.awt.Color(255, 255, 204));
		tblLogovani.setForeground(new java.awt.Color(153, 153, 153));
		tblLogovani
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tblLogovani);

		pnlAktivniKorisnici.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray,
						java.awt.Color.darkGray, null, null),
				"Aktivni korisnici", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12),
				new java.awt.Color(255, 255, 204))); // NOI18N

		tblAktivni
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(tblAktivni);

		javax.swing.GroupLayout pnlAktivniKorisniciLayout = new javax.swing.GroupLayout(pnlAktivniKorisnici);
		pnlAktivniKorisnici.setLayout(pnlAktivniKorisniciLayout);
		pnlAktivniKorisniciLayout.setHorizontalGroup(
				pnlAktivniKorisniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlAktivniKorisniciLayout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(38, Short.MAX_VALUE)));
		pnlAktivniKorisniciLayout.setVerticalGroup(
				pnlAktivniKorisniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnlAktivniKorisniciLayout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
								.addContainerGap()));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pnlAktivniKorisnici, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1))
						.addContainerGap(25, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(pnlAktivniKorisnici, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		btnPodesiKonekciju.setBackground(new java.awt.Color(255, 255, 204));
		btnPodesiKonekciju.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnPodesiKonekciju.setText("Podesi konekciju");
		btnPodesiKonekciju.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPodesiKonekcijuActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(70, 70, 70)
												.addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(28, 28, 28).addComponent(btnStop,
														javax.swing.GroupLayout.PREFERRED_SIZE, 210,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addContainerGap().addComponent(
														btnPodesiKonekciju, javax.swing.GroupLayout.PREFERRED_SIZE, 569,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(109, 109, 109).addComponent(lblServer,
										javax.swing.GroupLayout.PREFERRED_SIZE, 347,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(21, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(31, 31, 31)
				.addComponent(
						lblServer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGap(18, 18, 18).addComponent(btnPodesiKonekciju, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(20, 20, 20)));

		pack();
	}// </editor-fold>

	private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnPodesiKonekcijuActionPerformed(java.awt.event.ActionEvent evt) {
	}

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	/**
	 * Dugme za podesavanje konekcije
	 */
	private javax.swing.JButton btnPodesiKonekciju;

	/**
	 * Dugme za pokretanje servera
	 */
	private javax.swing.JButton btnStart;

	/**
	 * Dugme za zaustavljanje servera
	 */
	private javax.swing.JButton btnStop;

	/**
	 * Panel na kojem se prikazuju svi nutricionisti
	 */
	private javax.swing.JPanel jPanel1;

	/**
	 * jScrollPane1 za jPanel1
	 */
	private javax.swing.JScrollPane jScrollPane1;

	/**
	 * jScrollPane2 za jPanel2
	 */
	private javax.swing.JScrollPane jScrollPane2;

	/**
	 * Labela za server
	 */
	private javax.swing.JLabel lblServer;

	/**
	 * Panel za aktivne nutricioniste na sistemu
	 */
	private javax.swing.JPanel pnlAktivniKorisnici;

	/**
	 * Tabela za aktivne nutricioniste
	 */
	private javax.swing.JTable tblAktivni;

	/**
	 * Tabela za sve nutricioniste
	 */
	private javax.swing.JTable tblLogovani;
	// End of variables declaration

	/**
	 * Referenca na JButton objekat koji predstavlja dugme za podesavanje parametra
	 * server soketa
	 *
	 * @return btnPodesiKonekciju dugme za podesavanje parametra servera
	 */
	public JButton getBtnPodesiKonekciju() {
		return btnPodesiKonekciju;
	}

	/**
	 * Vraca dugme za pokretanje servera
	 * 
	 * @return btnStart dugme za pokretanje servera
	 */
	public JButton getBtnStart() {
		return btnStart;
	}

	/**
	 * Vraca dugme za zaustavljanje servera
	 * 
	 * @return btnStop dugme za zaustavljanje servera
	 */
	public JButton getBtnStop() {
		return btnStop;
	}

	/**
	 * Vraca panel na kojem se prikazuju svi nutricionisti
	 * 
	 * @return jPanel1 sa nutricionistima
	 */
	public JPanel getjPanel1() {
		return jPanel1;
	}

	/**
	 * Vraca JScrollPane na kojem je postavljen jPanel1
	 * 
	 * @return jScrollPane1 scroll panel
	 */
	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	/**
	 * Vraca JLabel komponentu za prikazivanje statusa servera
	 *
	 * @return JLabel komponenta za prikazivanje statusa servera
	 */
	public JLabel getLblServer() {
		return lblServer;
	}

	/**
	 * Vraca tabelu ulogovanih nutricionista
	 * 
	 * @return tblLogovani tabela ulogovanih nutricionista
	 */
	public JTable getTblLogovani() {
		return tblLogovani;
	}

	/**
	 * Postavlja dugme za podesavanje parametara serverskog soketa
	 * 
	 * @param btnPodesiKonekciju dugme za podesavanje parametara serverskog soketa
	 */
	public void setBtnPodesiKonekciju(JButton btnPodesiKonekciju) {
		this.btnPodesiKonekciju = btnPodesiKonekciju;
	}

	/**
	 * Postavlja dugme za pokretanje serverskog soketa
	 * 
	 * @param btnPodesiKonekciju dugme za pokretanje serverskog soketa
	 */
	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}

	/**
	 * Postavlja dugme za zaustavljanje serverskog soketa
	 * 
	 * @param btnPodesiKonekciju dugme za zaustavljanje serverskog soketa
	 */
	public void setBtnStop(JButton btnStop) {
		this.btnStop = btnStop;
	}

	/**
	 * Postavlja jPanel sa nutricionistima
	 * 
	 * @param jPanel1 panel sa svim nutricionistima
	 */
	public void setjPanel1(JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	/**
	 * Postavlja JScrollPane objekat na formu
	 * 
	 * @param jScrollPane1 scroll panel
	 */
	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	/**
	 * Postavlja labelu sa statusom servera
	 * 
	 * @param lblServer labela za status servera
	 */
	public void setLblServer(JLabel lblServer) {
		this.lblServer = lblServer;
	}

	/**
	 * Postavlja tabelu sa ulogavanim nutricionistima
	 * 
	 * @param tblLogovani tabela sa ulogovanim nutricionistima
	 */
	public void setTblLogovani(JTable tblLogovani) {
		this.tblLogovani = tblLogovani;
	}

	/**
	 * Vraca panel sa aktivnim nutricionistima
	 * 
	 * @return pnlAktivniKorisnici panel sa aktivnim nutricionistima
	 */
	public JPanel getPnlAktivniKorisnici() {
		return pnlAktivniKorisnici;
	}

	/**
	 * Vraca tabelu sa aktivnim nutricionistima
	 * 
	 * @return tblAktivni tabela sa aktivnim nutricionistima
	 */
	public JTable getTblAktivni() {
		return tblAktivni;
	}

	/**
	 * Postavlja tabelu sa aktivnim nutricionistima
	 * 
	 * @param tblAktivni tabela sa aktivnim nutricionistima
	 */
	public void setTblAktivni(JTable tblAktivni) {
		this.tblAktivni = tblAktivni;
	}

	/**
	 * Dodaje ActionListener na dugme btnStart
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnStartActionListener(ActionListener actionListener) {
		btnStart.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnStop
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnStopActionListener(ActionListener actionListener) {
		btnStop.addActionListener(actionListener);
	}

	/**
	 * Dodaje ActionListener na dugme btnPodesiKonekciju
	 *
	 * @param actionListener ActionListener koji treba dodati
	 */
	public void addbtnPodesiKonekcijuActionListener(ActionListener actionListener) {
		btnPodesiKonekciju.addActionListener(actionListener);
	}

}
