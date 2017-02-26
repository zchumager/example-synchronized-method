package net.mazatlab.dev.example_synchronized_method.entities;

public class ATM implements Runnable {

	private Account account;
	private int withdrawal;
	
	public ATM(Account account) {
		this.account = account;
	}
	
	public synchronized void requestWithdrawal(int withdrawal) {
		this.withdrawal = withdrawal;
	}
	
	public void run() {
		while(!this.account.isPenniless()){
			this.account.makeWithdrawal(this.withdrawal);
		}
			
	}

}