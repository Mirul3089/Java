

public class bank {

	private double balance;

	public bank(double b) {
		balance = b;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double interest) 
	
	{
		balance = balance + interest;
	}
}
