/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package teksteditor;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

  public static void main(String[] args) {
	  
//	  try {
//		UIManager.setLookAndFeel(
//		            UIManager.getSystemLookAndFeelClassName());
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	  
	  SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TextEdit();
				
			}
		});
  }
}
