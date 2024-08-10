package net.mazatlab.dev.example_synchronized_method.entities;

public class Account {

	private final String accountNumber;
	private double founds;
	
	public Account(String number) {
		this.accountNumber = number;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setFounds(double founds) {
		this.founds = founds;
	}
	
	public double getFounds() {
		return this.founds;
	}

	// All methods that are using attributes to be shared for a thread pool needs to use synchronized keyword
	public synchronized boolean isNotPenniless(){
		return this.founds > 0;
	}
	
	public synchronized void makeWithdrawal(int withdrawal) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.fillInStackTrace();
		}
		
		System.out.printf("Applying payment with name %s%n", Thread.currentThread().getName());
		
		if(this.isNotPenniless()) {
			if(this.getFounds()>=withdrawal) {
				double founds = this.getFounds();
				
				System.out.println("Your current founds are: " + founds);
				System.out.println("The requested withdrawal is: "+ withdrawal);
				
				founds -= withdrawal;
				
				System.out.println("The new founds are "+ founds);
				this.setFounds(founds);
			}else{
				System.out.println("Your current founds of "+ founds +" are not enough for the requested withdrawal of "+withdrawal);
			}
		} else {
			System.out.println("The Account is Penniless");
		}
	}
}