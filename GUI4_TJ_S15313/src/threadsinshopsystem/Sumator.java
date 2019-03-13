package threadsinshopsystem;

public class Sumator implements Runnable {

	private DaneDzielone dD;

	public Sumator(DaneDzielone dD) {
		this.dD = dD;
	}

	@Override
	public void run() {
		double zsumowanaWaga = 0;
		int counter = 0;
		Towary t = dD.takeTowar();
		while (t != Towary.PILL) {
			zsumowanaWaga += t.waga;
			counter++;
			if (counter % 100 == 0) {
				System.out.println("Policzono wagę " + counter + " towarów");
			}
			t = dD.takeTowar();
		}

		System.out.println("waga wszystkich towarów to " + zsumowanaWaga + "kg");
	}

}
