package shop;

public class Rose extends Flowers{



	public Rose(int ilosc) {
		super(ilosc);
	}

	@Override
	public String name() {
		return "róża";
	}

	@Override
	public String color() {
		return "czerwony";
	}


}
