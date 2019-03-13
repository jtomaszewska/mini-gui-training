package colourrectangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame implements ActionListener{

	Color[] colors = {
			Color.cyan,
			Color.green,
			Color.orange,
			Color.gray
	};
	int i = 0;
	JButton button = new JButton();
	
	public Gui() {
		
		button.addActionListener(this);
		add(button);
		button.setBackground(colors[i]);

		Dimension prefSize = new Dimension(200, 100);
		setPreferredSize(prefSize);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.i = (i + 1)%colors.length;
		button.setBackground(colors[i]);
	}

}
