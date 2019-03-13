package interfaces;

public class ReversibleString implements Reversible {

	String text;
	
	
	public ReversibleString(String text) {
		this.text = text;
	}


	@Override
	public void reverse() {
		char[] resultArray = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			resultArray[text.length()-i-1] = text.charAt(i);
		}
		text = new String(resultArray);
	}


	@Override
	public String toString() {
		return text;
	}
	

}
