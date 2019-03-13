package shop;

public class Lilac extends Flowers{

	public Lilac(int ilosc) {
		super(ilosc);
	}

	@Override
	public String name() {
		return "bez";
	}

	@Override
	public String color() {
		return "bialy";
	}
}
