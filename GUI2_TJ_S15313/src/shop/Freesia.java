package shop;

public class Freesia extends Flowers{

	public Freesia(int ilosc) {
		super(ilosc);
	}

	@Override
	public String name() {
		return "frezja";
	}

	@Override
	public String color() {
		return "zolty";
	}
}
