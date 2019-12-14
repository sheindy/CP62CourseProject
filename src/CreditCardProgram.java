/*Demonstrate the class in a program that creates a CreditCard object and allows the user to
 * change and view the state of the credit card with a menu driven program.
 * 1. View Card Information.
 * 2. Purchase an Item: ask the user the purchase amount and increase the card balance
 * accordingly.
 * 3. Pay Bill: call payBill method to set the balance to 0.
 * 4. Increase Spending Limit: ask the user how much the spending limit should be, and call
 * the increaseSpendingLimit method the appropriate number of times.
 * Keep in mind: input and output should not be performed directly in the CreditCard class. All
 * input and output to the user should be done in the main method (or other methods that are in a
 * separate class) to increase flexibility of the classes we will design later on in this project.
 */

// scanner for input
import java.util.Scanner;

public class CreditCardProgram {
    // static member variables placed outside of main so that methods could access
    // these member variables
    static Scanner console = new Scanner(System.in);
    // type    variable name  new object of this type
    static CreditCard creditCard = new CreditCard("Hunchback of Notre Dame", "4060000000000");

    public static void main(String[] args) {
        // infinite loop
        while (true) {
            System.out.println("1. View Card Information.\n" +
                    "2. Purchase an Item:\n" +
                    "3. Pay Bill: \n" +
                    "4. Increase Spending Limit:");

            int input = console.nextInt();
            System.out.println();
            if(input == 1) viewCard();
            else if (input == 2) purchase();
            else if (input==3) payBill();
            else if (input==4) increaseSpendingLimit();
            else
                System.out.println("Not a valid entry.");
            System.out.println();
        }
    }
    // static method prints credit card info
    static void viewCard() {
        System.out.println(creditCard);
    }
    // static method to record purchase amount and add to bill amount
    static void purchase() {
        System.out.println("How much does this purchase amount to.");
        double input = console.nextDouble();
        creditCard.purchase(input);
        System.out.println("Your new balance amount is now: $" + creditCard.getBalance());

    }
    // static method setting balance to 0
    static void payBill() {
        creditCard.payBill();
        System.out.println("Thank you for your payment.");
    }
    // static method increase spending limit by 50
    static void increaseSpendingLimit() {
        creditCard.increaseSpendingLimit();
        System.out.println("Your spending limit is now: $" + creditCard.getSpendingLimit());
    }

}
