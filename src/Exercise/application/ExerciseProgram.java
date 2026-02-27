package Exercise.application;

import Exercise.model.entities.Account;
import Exercise.model.exceptions.ExerciseExceptions;

import java.util.Locale;
import java.util.Scanner;

public class ExerciseProgram {
    public static void main (String[] Args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter account data");
            System.out.print("Account number: ");
            Integer accountNumber = sc.nextInt();
            System.out.print("Holder name: ");
            sc.nextLine();
            String holderName = sc.nextLine();
            System.out.print("Initial balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(accountNumber, holderName, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount to withdraw: ");
            account.withdraw(sc.nextDouble());

            System.out.printf("New balance: %.2f\n", account.getBalance());
        }
        catch(ExerciseExceptions e){
            System.out.println("Withdraw error: " + e.getMessage());
        }

        sc.close();
    }
}
