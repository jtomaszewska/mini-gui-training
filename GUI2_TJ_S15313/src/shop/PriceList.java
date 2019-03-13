package shop;

import java.util.HashMap;

public class PriceList extends HashMap<String, Double> {
	
	private static PriceList instance = null;
	
	public static PriceList getInstance(){
		if (instance == null){
			instance = new PriceList();
		}
		return instance;
	}
}
