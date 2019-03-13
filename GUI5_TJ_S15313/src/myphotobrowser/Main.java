/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package myphotobrowser;


/*
 * parametry : ścieżka, czas w sekundach, rozm czcionki
 * obrazki wyświetlamy w oryginalnych rozmiarach jeśli jest mały
 * jeśli obr duży to przeskalować do okna, zachowując proporcje
 * można reskalować obrazek w oknie - czy bedzie zachowywał proporcje 
 * to zależy od nas
 * brak obrazka - należy wyśrodkowac
 * obrazek można zepsuć otwierając w paintcie?
 * napis koniec prezentacji ma być wyświetlony wyśrodkowany, wycentrowany
 * i wielkości podanej w argumencie
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		String folder = ".";
		int time = 1;
		int fontSize = 20;
		
		if (args.length == 3){
			folder = args[0];
			time = Integer.parseInt(args[1]);
			fontSize = Integer.parseInt(args[2]);
		}
		
		GraphicsBrowserFrame gBF = new GraphicsBrowserFrame();
		gBF.runSlides(folder, time, fontSize);
	}
}
