/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package threadwithblockingqueue;

import java.util.ArrayList;
import java.util.Arrays;

public class Author implements Runnable {

	Teksty txtArea;
	private String[] slowa;

	  Author(String[] slowa)  {     
	    ArrayList<String> slowaTablica = new ArrayList<>(Arrays.asList(slowa));
	    slowaTablica.add(null);
	    this.slowa = slowaTablica.toArray(new String[0]);
		txtArea= new Teksty();
		
	  }
	  
	@Override
	public void run() {
		
		//String[] s = { "Pies", "Kot", "Zebra", "Lew", "Owca", "S�o�", null };
	    for (int i=0; i<slowa.length; i++) {
//	     try {
//	        Thread.sleep((int)(Math.random() * 1000)); 
//	      } catch(InterruptedException exc) { }
//	
	      txtArea.setTextToWrite(slowa[i]);
	    }
	}
}  
