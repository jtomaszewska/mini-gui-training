/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package threadwithblockingqueue;

public class Writer implements Runnable {

	Teksty txtArea;

	Writer(Author t) {
		txtArea = t.txtArea;
	}

	@Override
	public void run() {
		String txt = txtArea.getTextToWrite();
		while (txt != null) {
			System.out.println("-> " + txt);
			txt = txtArea.getTextToWrite();
		}
	}
}
