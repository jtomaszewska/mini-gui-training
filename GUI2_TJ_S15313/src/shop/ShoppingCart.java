package shop;

public class ShoppingCart extends FlowersContainer{
	


	public ShoppingCart(Customer owner) {
		super(owner);
	}

	@Override
	public String toString() {
		return "Wózek właściciel " + owner.name + super.toString() ;
	}

}
