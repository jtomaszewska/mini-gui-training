package teksteditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class OptionsMenu {

	
	public static HashMap<String, Color> colors = new HashMap<>();
	private JTextArea textArea;

	static {
		colors.put("Blue", Color.BLUE);
		colors.put("Yellow", Color.YELLOW);
		colors.put("Orange", Color.ORANGE);
		colors.put("Red", Color.RED);
		colors.put("White", Color.WHITE);
		colors.put("Black", Color.BLACK);
		colors.put("Green", Color.GREEN);
	}
	
	public OptionsMenu(JMenuBar menuBar, JTextArea textArea) {
		this.textArea = textArea;
		JMenu options = new JMenu("Options");

		JMenu foreground = new JMenu("Foreground");
		foreground.setBorder(BorderFactory.createRaisedBevelBorder());
		options.add(foreground);

		colorsMenu(foreground, (ActionEvent e) -> {
			JMenuItem item = (JMenuItem) e.getSource();
			Color labelColor = (Color) item.getClientProperty("color");
			textArea.setForeground(labelColor);
		});

		JMenu background = new JMenu("Background");
		background.setBorder(BorderFactory.createRaisedBevelBorder());
		options.add(background);
		colorsMenu(background, (ActionEvent e) -> {
			JMenuItem item = (JMenuItem) e.getSource();
			Color labelColor = (Color) item.getClientProperty("color");
			textArea.setBackground(labelColor);
		});
		JMenu font = new JMenu("Font");
		font.setBorder(BorderFactory.createRaisedBevelBorder());
		options.add(font);
		fontSizes(font, (ActionEvent e) -> {
			JMenuItem item = (JMenuItem) e.getSource();
			int fontSize = (int) item.getClientProperty("fontSize");
			textArea.setFont(new Font(fontSize+" pts", Font.PLAIN, fontSize));
		});
		menuBar.add(options);
	}
	
	private void fontSizes(JMenuItem parent, ActionListener aL) {
		for (int i = 8; i < 26; i += 2) {
			MenuItemCreator.mi(i + " pts", parent, aL).putClientProperty("fontSize", i);
		}
	}

	private void colorsMenu(JMenuItem parent, ActionListener aL) {
		for (Map.Entry<String, Color> mapEntry : colors.entrySet()) {
			String label = mapEntry.getKey();
			Color c = mapEntry.getValue();
			MenuItemCreator.mi(label, new MyIcon(c), label.charAt(0), null, parent, aL).putClientProperty("color", c);

		}
	}
}
