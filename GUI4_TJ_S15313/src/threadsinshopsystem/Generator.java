package threadsinshopsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Generator implements Runnable {

	private DaneDzielone dD;

	public Generator(DaneDzielone dD) {
		this.dD = dD;
	}

	@Override
	public void run() {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("../Towary.txt"));
			scanner.useLocale(Locale.ENGLISH);
			int iloscGotowychEl = 0;
			while (scanner.hasNextLine() && scanner.hasNextInt()) {
				Towary t = new Towary(scanner.nextInt(), scanner.nextDouble());
				dD.putTowar(t);
				iloscGotowychEl++;

				if (iloscGotowychEl % 200 == 0) {
					System.out.println("Utworzono " + iloscGotowychEl + " obiektów.");
				}
			}
			dD.putTowar(Towary.PILL);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
