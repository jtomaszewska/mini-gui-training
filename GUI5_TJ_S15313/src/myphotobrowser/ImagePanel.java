package myphotobrowser;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;

class ImagePanel extends JPanel {

	Image img;
	boolean loaded = false; // czy obrazek został załadowany?
	int fontSize = 14;
	String message = null;

	public void setImage(String imgFileName) {
		loadImage(imgFileName);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, getFontSize()));

		if (message != null) {
			g.drawString(message, (getWidth() - g.getFontMetrics().stringWidth(message)) / 2, getHeight() / 2);
			return;
		}
		if (img != null && loaded) {

			float aspect = (float) img.getHeight(this) / img.getWidth(this);

			int drawingWidth = 0, drawingHeight = 0;

			if (img.getWidth(this) > this.getWidth() || img.getHeight(this) > this.getHeight()) {
				drawingWidth = this.getWidth();
				drawingHeight = this.getHeight();
			} else {
				drawingWidth = img.getWidth(this);
				drawingHeight = img.getHeight(this);
			}
			if (this.getHeight() >= this.getWidth()) {
				g.drawImage(img, (this.getWidth() - drawingWidth) / 2, (this.getHeight() - drawingHeight) / 2,
						drawingWidth, (int) (drawingWidth * aspect), this);
			} else if (this.getHeight() < this.getWidth()) {
				g.drawImage(img, (this.getWidth() - drawingWidth) / 2, (this.getHeight() - drawingHeight) / 2,
						(int) (drawingHeight / aspect), drawingHeight, this);
			}

		} else {
			String s = "Brak obrazka";
			g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2, getHeight() / 2);
		}

	}

	private void loadImage(String imgFileName) {
		loaded = false;
		img = Toolkit.getDefaultToolkit().getImage(imgFileName);
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try {
			mt.waitForID(1);
		} catch (InterruptedException exc) {
		}
		if (mt.isErrorAny()) {
			System.out.println("error");
			return;
		}
		loaded = true;

	}

	/**
	 * @return the fontSize
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * @param fontSize
	 *            the fontSize to set
	 */
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
