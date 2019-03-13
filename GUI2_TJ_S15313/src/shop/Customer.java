package shop;

import java.util.ArrayList;

public class Customer {

	String name;
	double money;
	private ShoppingCart shoppingCart;

	public Customer(String name, double money) {
		this.name = name;
		this.money = money;
		this.shoppingCart = new ShoppingCart(this);
	}

	public double getCash() {
		return money;
	}

	public void get(Flowers bukiet) {
		shoppingCart.add(bukiet);
	}

	public void pay() {
		ArrayList<Flowers> elementsToRemove = new ArrayList<>();
		for (Flowers flowers : shoppingCart) {
			if (PriceList.getInstance().containsKey(flowers.name())
					&& money > (flowers.ilosc * PriceList.getInstance().get(flowers.name()))) {
				money -= (flowers.ilosc * PriceList.getInstance().get(flowers.name()));
			} else {
				elementsToRemove.add(flowers);
			}

		}
		shoppingCart.removeAll(elementsToRemove);
	}

	public void pack(Box box) {
		for (Flowers flowers : shoppingCart) {
			box.add(flowers);
		}
		shoppingCart.clear();
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

}
