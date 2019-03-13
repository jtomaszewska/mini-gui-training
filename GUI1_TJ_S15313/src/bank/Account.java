package bank;

public class Account {

	private double balance;
	private static double interestRate;
	
	public static void setInterestRate(double interestRate) {
		Account.interestRate = interestRate;
	}

	public Account() {
		balance = 0;
	}
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount){
		if (amount <= 0 ){
			System.out.println("Amount must be positive");
			return;
		}
		balance += amount;
	}
	
	public void withdraw(double amount){
		if (amount <= 0 ){
			System.out.println("Amount must be positive");
			return;
		}
		if (balance < amount){
			System.out.println("Insufficient founds");
			return;
		}
		balance -= amount;
	}
	
	public void transfer(Account targetAccount, double amount){
		if (amount <= 0 ){
			System.out.println("Amount must be positive");
			return;
		}
		if (balance < amount){
			System.out.println("Insufficient founds");
			return;
		}
		balance -= amount;
		targetAccount.balance += amount;
	}
	
	public void addInterest(){
		balance += balance*(interestRate/100);
	}

	@Override
	public String toString() {
		return " stan konta " + balance;
	}
	
}
