package teksteditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class MyIcon implements Icon{
	
	private Color color;

	public MyIcon(Color color){
		this.color = color;
		
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillOval(5, 5, 10, 10);
		g.setColor(Color.black);
		g.drawOval(5, 5, 10, 10);
		
	}

	@Override
	public int getIconWidth() {
		return 10;
	}

	@Override
	public int getIconHeight() {
		return 10;
	}

}
