/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package layouts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {

		String val = "", msg = "Wybierz sposób układania komponentów wpisując odpowiednią literę z przedziału A - G";

		LayoutManager layoutManager = null;

		while ((val = (String) JOptionPane.showInputDialog(null, msg, "", JOptionPane.QUESTION_MESSAGE, null, null,
				null)) != null) {

			String st = val;
			boolean error = false;
			if (st.length() != 1)
				error = true;
			try {
				switch (st) {
				case "A":
					layoutManager = new BorderLayout();
					break;
				case "B":
					layoutManager = new FlowLayout();
					break;
				case "C":
					layoutManager = new FlowLayout(FlowLayout.LEFT);
					break;
				case "D":
					layoutManager = new FlowLayout(FlowLayout.RIGHT);
					break;
				case "E":
					layoutManager = new GridLayout(1, 5);
					break;
				case "F":
					layoutManager = new GridLayout(5, 1);
					break;
				case "G":
					layoutManager = new GridLayout(3, 2);
					break;
				default:
					break;
				}

			} catch (Exception exc) {
				error = true;
			}
			if (error)
				msg = "<html>Nieprawidłowa wartość . " + "Wpisz literę z zakresu<font color=red> A-G</font></html>";
			else
				break;
		}
		JFrame frame = new JFrame("Okno z przyciskami");
		JPanel panel = new JPanel(layoutManager);
		frame.add(panel);
		String[] buttonsNames = { "Przycisk 1", "P 2", "Większy przycisk numer 3", "Przycisk 4", "P5" };
		String[] borderLay = { "North", "East", "West", "Center", "South"};
		for (int i = 0; i < buttonsNames.length; i++) {
			JButton b = new JButton(buttonsNames[i]);
			panel.add(b, borderLay[i]);
		}

		Dimension preferredSize = new Dimension(800, 600);
		frame.setPreferredSize(preferredSize);
		frame.setMinimumSize(preferredSize);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}