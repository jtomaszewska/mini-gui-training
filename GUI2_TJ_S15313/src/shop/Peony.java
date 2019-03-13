package shop;

public class Peony extends Flowers{

	public Peony(int ilosc) {
		super(ilosc);
	}

	@Override
	public String name() {
		return "piwonia";
	}

	@Override
	public String color() {
		return "czerwony";
	}
}
