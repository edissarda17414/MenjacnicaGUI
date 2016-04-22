package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtProdajniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSrednjiKurs;
	private JTextField txtSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;


	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Kontroler.zatvoriDodajKursGui();
			}
		});
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 357, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblSifra());
			panel.add(getLblNaziv());
			panel.add(getTxtSifra());
			panel.add(getTxtNaziv());
			panel.add(getLblProdajniKurs());
			panel.add(getLblKupovniKurs());
			panel.add(getTxtProdajniKurs());
			panel.add(getTxtKupovniKurs());
			panel.add(getLblSrednjiKurs());
			panel.add(getLblSkraceniNaziv());
			panel.add(getTxtSrednjiKurs());
			panel.add(getTxtSkraceniNaziv());
			panel.add(getBtnDodaj());
			panel.add(getBtnOdustani());
		}
		return panel;
	}

	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("\u0160ifra");
			lblSifra.setBounds(10, 23, 150, 25);
		}
		return lblSifra;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(182, 23, 150, 25);
		}
		return lblNaziv;
	}

	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setBounds(10, 59, 150, 30);
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}

	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setColumns(10);
			txtNaziv.setBounds(182, 59, 150, 30);
		}
		return txtNaziv;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(10, 112, 150, 25);
		}
		return lblProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(182, 112, 150, 25);
		}
		return lblKupovniKurs;
	}

	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setColumns(10);
			txtProdajniKurs.setBounds(10, 148, 150, 30);
		}
		return txtProdajniKurs;
	}

	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setColumns(10);
			txtKupovniKurs.setBounds(182, 148, 150, 30);
		}
		return txtKupovniKurs;
	}

	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setBounds(10, 189, 150, 25);
		}
		return lblSrednjiKurs;
	}

	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skra\u0107eni naziv");
			lblSkraceniNaziv.setBounds(182, 189, 150, 25);
		}
		return lblSkraceniNaziv;
	}

	private JTextField getTxtSrednjiKurs() {
		if (txtSrednjiKurs == null) {
			txtSrednjiKurs = new JTextField();
			txtSrednjiKurs.setColumns(10);
			txtSrednjiKurs.setBounds(10, 225, 150, 30);
		}
		return txtSrednjiKurs;
	}

	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setColumns(10);
			txtSkraceniNaziv.setBounds(182, 225, 150, 30);
		}
		return txtSkraceniNaziv;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sifra = getTxtSifra().getText();
					String naziv = getTxtNaziv().getText();
					double prodajniKurs = Double.parseDouble(getTxtProdajniKurs().getText());
					double kupovniKurs = Double.parseDouble(getTxtKupovniKurs().getText());
					double srednjiKurs = Double.parseDouble(getTxtSrednjiKurs().getText());
					String skraceniNaziv = getTxtSkraceniNaziv().getText();
					
					Kontroler.dodajKurs(sifra, naziv, prodajniKurs, kupovniKurs, srednjiKurs, skraceniNaziv);
				}
			});
			btnDodaj.setBounds(10, 283, 150, 35);
		}
		return btnDodaj;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Kontroler.zatvoriDodajKursGui();
				}
			});
			btnOdustani.setBounds(182, 283, 150, 35);
		}
		return btnOdustani;
	}
}
