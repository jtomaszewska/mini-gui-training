package teksteditor;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class MenuItemCreator {

	public static JMenuItem mi(String text, char mnemo, String accel, JMenuItem parent, ActionListener handler) {
		JMenuItem item = mi(text, mnemo, accel);
		item.addActionListener(handler);
		parent.add(item);
		return item;
	}

	public static JMenuItem mi(String text, JMenuItem parent, ActionListener handler) {
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(handler);
		item.setBorder(BorderFactory.createRaisedBevelBorder());
		parent.add(item);
		return item;
	}

	public static JMenuItem mi(String text, MyIcon icon, char mnemo, String accel, JMenuItem parent, ActionListener handler) {
		JMenuItem item = mi(text, mnemo, accel);
		item.setIcon(icon);
		item.addActionListener(handler);
		item.setHorizontalTextPosition(SwingConstants.RIGHT);
		parent.add(item);
		return item;
	}

	private static JMenuItem mi(String text, char mnemo, String accel) {
		JMenuItem item = new JMenuItem(text);
		item.setMnemonic(mnemo);
		item.setAccelerator(KeyStroke.getKeyStroke(accel));
		item.setBorder(BorderFactory.createRaisedBevelBorder());
		return item;
	}
}
