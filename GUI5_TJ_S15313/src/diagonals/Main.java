/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package diagonals;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Okno z przekątnymi");
		Diagonal d = new Diagonal();
		frame.add(d);

		Dimension preferredSize = new Dimension(400, 400);
		frame.setPreferredSize(preferredSize);
	
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
