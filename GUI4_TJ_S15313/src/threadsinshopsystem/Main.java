/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package threadsinshopsystem;

public class Main {

	public static void main(String[] args){
		
		DaneDzielone dD = new DaneDzielone();
		Generator a = new Generator(dD);
		Sumator w = new Sumator(dD);
		Thread tworzenieTowarow = new Thread(a);
		Thread zliczanieWagTowarow = new Thread(w);
		tworzenieTowarow.start();
		zliczanieWagTowarow.start();
		
	}
}
