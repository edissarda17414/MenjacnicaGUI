package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JComboBox comboBox;
	private JTextField txtKupovniKurs;
	private JTextField txtProdajniKurs;
	private JLabel lblIznos;
	private JTextField txtIznos;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Kontroler.zatvoriIzvrsiZamenuGui();
			}
		});

		setResizable(false);
		setTitle("Izvr\u0161i zamenu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 415, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblKupovniKurs());
			panel.add(getLblProdajniKurs());
			panel.add(getComboBox());
			panel.add(getTxtKupovniKurs());
			panel.add(getTxtProdajniKurs());
			panel.add(getLblIznos());
			panel.add(getTxtIznos());
			panel.add(getLblVrstaTransakcije());
			panel.add(getRdbtnKupovina());
			panel.add(getRdbtnProdaja());
			panel.add(getSlider());
			panel.add(getBtnIzvrsiZamenu());
			panel.add(getBtnOdustani());
		}
		return panel;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(10, 32, 120, 30);
		}
		return lblKupovniKurs;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(270, 32, 120, 30);
		}
		return lblProdajniKurs;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "EUR", "USD", "CHF" }));
			comboBox.setBounds(140, 63, 120, 30);
		}
		return comboBox;
	}

	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setEditable(false);
			txtKupovniKurs.setBounds(10, 63, 120, 30);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}

	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setEditable(false);
			txtProdajniKurs.setBounds(270, 63, 120, 30);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(10, 134, 120, 30);
		}
		return lblIznos;
	}

	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setText("50");
			txtIznos.setBounds(10, 162, 190, 30);
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}

	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(231, 134, 120, 30);
		}
		return lblVrstaTransakcije;
	}

	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setSelected(true);
			buttonGroup.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(231, 166, 109, 23);
		}
		return rdbtnKupovina;
	}

	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(231, 192, 109, 23);
		}
		return rdbtnProdaja;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int val = slider.getValue();
					getTxtIznos().setText(val + "");
				}
			});
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(5);
			slider.setPaintLabels(true);
			slider.setMajorTickSpacing(10);
			slider.setBounds(10, 222, 380, 62);
		}
		return slider;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvr\u0161i zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String valuta = getComboBox().getSelectedItem().toString();
					double iznos = Double.parseDouble(getTxtIznos().getText());
					String kupovinaIliProdaja;
					
					if (getRdbtnKupovina().isSelected()) {
						kupovinaIliProdaja = "kupovina";
					} else {
						kupovinaIliProdaja = "prodaja";
					}
					
					String tekst = "[Izvrsena zamena] Valuta: " + valuta + ", iznos: " + iznos + ", kupovina/prodaja: " + kupovinaIliProdaja + System.lineSeparator();
					Kontroler.dodajUPoljeZaIspis(tekst);
					
					
				}
			});
			btnIzvrsiZamenu.setBounds(10, 304, 190, 30);
		}
		return btnIzvrsiZamenu;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Kontroler.zatvoriIzvrsiZamenuGui();
				}
			});
			btnOdustani.setBounds(210, 304, 180, 30);
		}
		return btnOdustani;
	}
}
