package myphotobrowser;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;

public class GraphicsBrowserFrame extends JFrame{

	private ImagePanel panel;

	public GraphicsBrowserFrame() throws InterruptedException {
	    panel = new ImagePanel();
	        
	    
	    add(panel);
	    pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Dimension screenSize = getToolkit().getScreenSize();		
		this.setSize(new Dimension(screenSize.width, screenSize.height - 50));
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setLocationRelativeTo(null);
	    setVisible(true);
	  }

	public void runSlides(String folderName, int time, int fontSize) throws InterruptedException {
		panel.setFontSize(fontSize);
		
		File folder = new File(folderName);
	    File[] listOfFiles = folder.listFiles();
	    
	    for (File file : listOfFiles) {
	        if (file.isFile() && 
	        		(file.getName().toLowerCase().endsWith("jpg") || 
	        		file.getName().toLowerCase().endsWith("png") || 
	        		file.getName().toLowerCase().endsWith("gif"))) {
	        	System.out.println(file.getName());
	            panel.setImage(file.getAbsolutePath());
	            panel.repaint();
	            Thread.sleep(time*1000);
	        }
	    }
	    panel.setMessage("Koniec prezentacji");
	    panel.repaint();
	}
	
	
}
