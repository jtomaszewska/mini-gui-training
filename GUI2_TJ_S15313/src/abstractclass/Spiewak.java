/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package abstractclass;

public abstract class Spiewak {
	String nazwisko;
	int nrStartowy;
	static int licznikNumerow = 0;
	
	public Spiewak(String nazwisko) {
		this.nazwisko = nazwisko;
		this.nrStartowy = ++licznikNumerow;
	}
	
	abstract String spiewaj();
	
	public String toString(){
		return "("+nrStartowy+")"+nazwisko + ": "+this.spiewaj();
	}
	
	static Spiewak najglosniej(Spiewak[] tablicaSpiewakow){
		int indeksNajglosniejszego = 0;
		for (int i = 0; i < tablicaSpiewakow.length-1; i++) {
			if(ileDuzychLiter(tablicaSpiewakow[i+1].spiewaj()) > 
				ileDuzychLiter(tablicaSpiewakow[i].spiewaj())){
				indeksNajglosniejszego = i+1;
			}
		}
		return tablicaSpiewakow[indeksNajglosniejszego];
	}
	
	private static int ileDuzychLiter(String slowo){
		int ileDuzychLiter = 0;
		for (int i = 0; i < slowo.length(); i++) {
			if (slowo.charAt(i) >= 'A' && slowo.charAt(i) <= 'Z')
				ileDuzychLiter++;
		}
		return ileDuzychLiter;
	}
}
