package tempconvertor;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Gui extends JFrame implements ActionListener {

	JList list;

	public Gui() {

		list = new JList<>(new TemperatureList());
		
		JScrollPane sP = new JScrollPane(list);
		this.add(sP);
		
		Dimension prefSize = new Dimension(200, 100);
		setPreferredSize(prefSize);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
