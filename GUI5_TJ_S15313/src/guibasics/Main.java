/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package guibasics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Elementarne właściwości komponentów");

		JTextArea mTA = new JTextArea();
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(mTA);
		panel.add(scrollPane);
		
		mTA.setForeground(Color.YELLOW);
		mTA.setBackground(Color.BLUE);
		mTA.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		frame.add(panel);

		Dimension preferredSize = new Dimension(400, 400);
		frame.setPreferredSize(preferredSize);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
