/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package tempconvertor;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
	  

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Gui();
				
			}
		});
  }
}
