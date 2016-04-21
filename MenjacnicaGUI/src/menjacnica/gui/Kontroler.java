package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Kontroler {
	
	private static MenjacnicaGUI gui;
	
	
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
	
	public static void izaberiFajl() {
		JFileChooser fc = new JFileChooser();
		int izbor = fc.showOpenDialog(gui.getContentPane());
		
		if (izbor == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			
			String tekst = "Ucitan fajl: " +  f.getAbsolutePath() + System.lineSeparator();
			gui.getTextArea().append(tekst);
		}
	}
	
	public static void sacuvajFajl() {
		JFileChooser fc = new JFileChooser();
		int izbor = fc.showSaveDialog(gui.getContentPane());
		
		if (izbor == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			
			String tekst = "Sacuvan fajl: " + f.getAbsolutePath() + System.lineSeparator();
			gui.getTextArea().append(tekst);
		}
		
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
