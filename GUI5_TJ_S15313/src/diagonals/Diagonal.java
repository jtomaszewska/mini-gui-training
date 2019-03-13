package diagonals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Diagonal extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		Dimension size = this.getSize();
		g.drawLine(0, 0, size.width, size.height);
		g.drawLine(size.width - 1, 0, 0, size.height - 1);

	}
}
