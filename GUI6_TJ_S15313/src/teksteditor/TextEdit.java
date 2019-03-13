package teksteditor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEdit extends JFrame {

	JTextArea textArea;

	public TextEdit() {

		JFrame frame = new JFrame("Prosty edytor - bez tytułu");

		textArea = new JTextArea();

		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		frame.add(panel);
		JMenuBar menuBar = new JMenuBar();

		new FileMenu(frame, menuBar, textArea);

		new EditMenu(menuBar, textArea);

		new OptionsMenu(menuBar, textArea);

		frame.setJMenuBar(menuBar);

		Dimension preferredSize = new Dimension(400, 400);
		frame.setPreferredSize(preferredSize);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
