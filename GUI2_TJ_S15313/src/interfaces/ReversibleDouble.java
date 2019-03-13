package interfaces;

public class ReversibleDouble implements Reversible {

	double number;
	
	
	public ReversibleDouble(double number) {
		this.number = number;
	}


	@Override
	public void reverse() {
		number = 1/number;
	}


	@Override
	public String toString() {
		return ""+number;
	}
	

}
