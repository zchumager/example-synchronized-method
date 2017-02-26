package net.mazatlab.dev.example_synchronized_method.entities;

public class Account {

	private String accountNumber;
	private double founds;
	private boolean penniless;
	
	public Account(String number) {
		this.accountNumber = number;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setFounds(double founds) {
		this.founds = founds;
		
		if(this.founds>0) {
			this.penniless = false;
		} else {
			this.penniless = true;
		}
	}
	
	public double getFounds() {
		return this.founds;
	}
	
	
	public boolean isPenniless(){
		return this.penniless;
	}
	
	public synchronized void makeWithdrawal(int withdrawal) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nWelcome to the "+Thread.currentThread().getName()+" ATM");
		
		if(!this.isPenniless()) {
			if(this.getFounds()>=withdrawal) {
				double founds = this.getFounds();
				
				System.out.println("Your current founds are: "+founds);
				System.out.println("The requested withdrawal is: "+withdrawal);
				
				founds -= withdrawal;
				
				System.out.println("The new founds are "+founds);
				this.setFounds(founds);
			}else{
				System.out.println("Your current founds of"+founds+" are not enough for the requested withdrawal of "+withdrawal);
			}
		} else {
			System.out.println("The Account is Penniless");
		}
	}
}