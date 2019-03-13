package teksteditor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class FileMenu {

	private JFrame frame;
	private JMenuBar menuBar;
	String openFilePath;
	private JTextArea textArea;

	public FileMenu(JFrame frame, JMenuBar menuBar, JTextArea textArea) {
		this.frame = frame;
		this.menuBar = menuBar;
		this.textArea = textArea;
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem open = MenuItemCreator.mi("Open", 'o', "control O", file, (ActionEvent e) -> {
			handleOpen();
			frame.setTitle("Prosty edytor - " + openFilePath);
		});

		JMenuItem save = MenuItemCreator.mi("Save", 's', "control S", file, (ActionEvent e) -> {
			handleSave();
		});

		MenuItemCreator.mi("Save as ...", 'a', "control A", file, (ActionEvent e) -> {
			handleSaveAs();
		});

		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
		sep.setBackground(Color.RED);
		file.add(sep);// sep.setMinimumSize(new Dimension(200, 100));
		JMenuItem exit = MenuItemCreator.mi("Exit", 'e', "control X", file, (ActionEvent e) -> {
			frame.dispose();
		});

	}

	private void handleSave() {
		if (openFilePath != null) {
			try {
				FileManager.saveFile(openFilePath, textArea.getText());
			} catch (IOException e) {
				showMessage("Podczas zapisywania pliku wystąpił problem");
				return;
			}

		} else {
			handleSaveAs();
		}

	}

	private void handleSaveAs() {
		JFileChooser fc = new JFileChooser(new File("."));
		String approveButt = "OK";
		int retVal = fc.showDialog(null, approveButt);
		if (retVal != JFileChooser.APPROVE_OPTION) {
			return;
		}
		String path = fc.getSelectedFile().getAbsolutePath();
		try {
			FileManager.saveFile(path, textArea.getText());
		} catch (IOException e) {
			showMessage("Podczas zapisywania pliku wystąpił problem");
			return;
		}
	}

	private void handleOpen() {
		JFileChooser fc = new JFileChooser(new File("."));
		String approveButt = "OK";
		int retVal = fc.showDialog(null, approveButt);
		if (retVal != JFileChooser.APPROVE_OPTION) {
			return;
		}

		String path = fc.getSelectedFile().getAbsolutePath();
		String text = null;
		try {
			text = FileManager.readFile(path);

		} catch (IOException e1) {
			showMessage("Podczas otwierania pliku wystąpił problem");
			return;
		}
		openFilePath = path;
		this.textArea.setText(text);
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, // okno-własciciel
				message, // komunikat
				"Błąd", // tytuł
				JOptionPane.WARNING_MESSAGE, // rodzaj komnunikatu
				null // ikona
		);
	}
}