package teksteditor;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class EditMenu {

	String adresPraca = "ul.Poznańska 2/5, Warszawa";
	String adresDom = "ul. Stalowa 3, Warszawa";
	String adresSzkola = "ul.Koszykowa 1, Warszawa";
	private JTextArea textArea;
	
	
	public EditMenu(JMenuBar menuBar, JTextArea textArea) {
		this.textArea = textArea;
		JMenu edit = new JMenu("Edit");
		JMenu adresy = new JMenu("Adresy");
		adresy.setBorder(BorderFactory.createRaisedBevelBorder());
		edit.add(adresy);
		MenuItemCreator.mi("Praca", 'p', "control shift P", adresy, (ActionEvent e) -> {
			handleAdress(adresPraca);
		});

		MenuItemCreator.mi("Szkoła", 's', "control shift S", adresy, (ActionEvent e) -> {
			handleAdress(adresSzkola);
		});

		MenuItemCreator.mi("Dom", 'd', "control shift D", adresy, (ActionEvent e) -> {
			handleAdress(adresDom);
		});
		menuBar.add(edit);
	}
	
	private void handleAdress(String adress) {
		int cartePos = textArea.getCaretPosition();
		String text = textArea.getText();
		String beg = text.substring(0, cartePos);
		String end = text.substring(cartePos);
		text = beg + " " + adress + " " + end;
		textArea.setText(text);
	}
}
