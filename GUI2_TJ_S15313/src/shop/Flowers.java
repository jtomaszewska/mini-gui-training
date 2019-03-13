package shop;

public abstract class Flowers {
	
	int ilosc;
	
	public Flowers(int ilosc) {
		this.ilosc = ilosc;
	}
	public abstract String name();
	public abstract String color();
	
	public String toString(){
		double cena = -1;
		if (PriceList.getInstance().get(this.name()) != null){
			cena = PriceList.getInstance().get(this.name());
		}
		
		return "\n"+this.name()+", kolor: "+this.color()+", ilość: "+this.ilosc+", cena: "+cena;
	}

}
