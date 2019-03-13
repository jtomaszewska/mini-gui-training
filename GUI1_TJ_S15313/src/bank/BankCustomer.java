package bank;

public class BankCustomer {

	public Person customer;
	private Account account;
	
	public BankCustomer(Person customer){
		this.customer = customer;
		account = new Account();
	}

	public Account getAccount() {
		return account;
	}

	@Override
	public String toString() {
		return "Klient: " + customer + account;
	}
	
}
