package shop;

public class Box extends FlowersContainer {
	

	
	public Box(Customer owner) {
		super(owner);
	}

	@Override
	public String toString() {
		return "Pudełko właściciel " + owner.name+super.toString();
	}

	
}
