package shop;

import java.util.ArrayList;

public class FlowersContainer extends ArrayList<Flowers>{

	Customer owner;

	public FlowersContainer(Customer owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		String string = "";		
		if (this.isEmpty()){
			string = " -- pusto";
		}
		for (Flowers flowers : this) {
			string = string + flowers.toString();
		}
		return string;
	}
	
	
}
