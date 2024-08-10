package net.mazatlab.dev.example_synchronized_method.entities;

public class Payment implements Runnable {

	private final Account account;
	private int withdrawal;
	
	public Payment(Account account) {
		this.account = account;
	}
	
	public synchronized void setFee(int withdrawal) {
		this.withdrawal = withdrawal;
	}
	
	public void run() {
		this.account.makeWithdrawal(this.withdrawal);
	}

}