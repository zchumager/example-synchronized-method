package net.mazatlab.dev.example_synchronized_method;

import net.mazatlab.dev.example_synchronized_method.entities.Payment;
import net.mazatlab.dev.example_synchronized_method.entities.Account;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Synchronized Method Demo" );
        
        Account account = new Account("10-98765432-1");
        System.out.printf("Performing payments on account %s%n", account.getAccountNumber());
        account.setFounds(1000);
        
        Payment payment1 = new Payment(account);
        Payment payment2 = new Payment(account);
        payment1.setFee(100);
        payment2.setFee(300);



        while(account.isNotPenniless()) {
            int randomInt = (int) (Math.random() * 100);

            Thread t1 = new Thread(payment1, String.format("Electricity Service %s", randomInt));
            Thread t2 = new Thread(payment2, String.format("Internet Service %s", randomInt));

            t1.start();
            t2.start();
        }
    }
}
