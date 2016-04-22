package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Kontroler {
	
	private static MenjacnicaGUI gui;
	private static DodajKursGUI dodajKursGui;
	
	
	public static void exit() {
		int izbor = JOptionPane.showConfirmDialog(gui.getContentPane(), "Da li zelite da izadjete iz programa?", "Izlaz", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (izbor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void about() {
		String poruka = "Autor: Edis Šarda";
		JOptionPane.showMessageDialog(gui.getContentPane(), poruka, "Podaci o autoru", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void dodajUPoljeZaIspis(String tekst) {
		gui.getTextArea().append(tekst);
	}
	
	
	public static void izaberiFajl() {
		JFileChooser fc = new JFileChooser();
		int izbor = fc.showOpenDialog(gui.getContentPane());
		
		if (izbor == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			
			String tekst = "Ucitan fajl: " +  f.getAbsolutePath() + System.lineSeparator();
			dodajUPoljeZaIspis(tekst);
		}
	}
	
	public static void sacuvajFajl() {
		JFileChooser fc = new JFileChooser();
		int izbor = fc.showSaveDialog(gui.getContentPane());
		
		if (izbor == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			
			String tekst = "Sacuvan fajl: " + f.getAbsolutePath() + System.lineSeparator();
			dodajUPoljeZaIspis(tekst);
		}
		
	}
	
	
	public static void prikaziDodajKursGui() {
		if (otvorenDodajKursGui()) {
			dodajKursGui.toFront();
			return;
		}
		
		dodajKursGui = new DodajKursGUI();
		dodajKursGui.setVisible(true);
		dodajKursGui.setLocationRelativeTo(null);
	}
	
	public static void zatvoriDodajKursGui() {
		if (dodajKursGui != null) {
			dodajKursGui.dispose();
			dodajKursGui = null;
		}
	}
	
	private static boolean otvorenDodajKursGui() {
		return (dodajKursGui != null);
	}
	
	public static void dodajKurs(String sifra, String naziv, double prodajniKurs, double kupovniKurs,
			double srednjiKurs, String skraceniNaziv) {

		String tekst = "Sifra: " + sifra + ", Naziv: " + naziv + 
				", prodajni kurs: " + prodajniKurs + ", kupovni kurs: " + kupovniKurs + ", srednji kurs: " + srednjiKurs + 
				", skraceni naziv: " + skraceniNaziv + System.lineSeparator();
		
		dodajUPoljeZaIspis(tekst);
		
		DefaultTableModel dtm = (DefaultTableModel) gui.getTable().getModel();
		
		dtm.addRow(new Object[] {sifra, naziv, prodajniKurs, srednjiKurs, kupovniKurs, skraceniNaziv});
		dtm.fireTableDataChanged();
		
		zatvoriDodajKursGui();
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui = new MenjacnicaGUI();
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}
