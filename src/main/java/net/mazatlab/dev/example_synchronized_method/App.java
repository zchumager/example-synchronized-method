package net.mazatlab.dev.example_synchronized_method;

import net.mazatlab.dev.example_synchronized_method.entities.ATM;
import net.mazatlab.dev.example_synchronized_method.entities.Account;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Synchronized Method Demo" );
        
        Account account = new Account("10-98765432-1");
        account.setFounds(1000);
        
        ATM atm1 = new ATM(account);
        ATM atm2 = new ATM(account);
        atm1.requestWithdrawal(100);
        atm2.requestWithdrawal(300);
        
        Thread t1 = new Thread(atm1, "Santa Fe");
        Thread t2 = new Thread(atm2, "Juarez");
        
        t1.start();
        t2.start();
    }
}
