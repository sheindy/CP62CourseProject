import java.util.Scanner;

public class DebitCardProgram {

    // static member variables placed outside of main so that methods could access
    // these member variables
    static Scanner console = new Scanner(System.in);
    // type    variable name  new object of this type
    static DebitCard debitCard = new DebitCard("Hunchback of Notre Dame",
            "4060000000000");

    public static void main(String[] args) {
        // infinite loop
        while (true) {
            System.out.println("1. View Card Information.\n" +
                    "2. Purchase an Item:\n" +
                    "3. Make Deposit:\n" +
                    "4. Increase Overdraft Limit:\n" +
                    "5. Pay Fees:");
            int input = console.nextInt();
            System.out.println();
            if (input == 1) viewCard();
            else if (input == 2) purchase();
            else if (input == 3) depositFunds();
            else if (input == 4) increaseOverdraftLimit();
            else if (input == 5) payfees();
            else
                System.out.println("Not a valid entry.");
            System.out.println();
        }
    }

    private static void payfees() {
        debitCard.payOverdraftFees();
        System.out.println("Thank you, your payment has been processed.");
    }

    private static void increaseOverdraftLimit() {
        debitCard.increaseOverdraftLimit();
        System.out.println("Your overdraft limit is now: $" + debitCard.getOverdraftLimit());

    }

    // static method prints credit card info
    static void viewCard() {
        System.out.println(debitCard);
    }

    // static method to record purchase amount and add to bill amount
    static void purchase() {
        System.out.println("How much does this purchase amount to.");
        double input = console.nextDouble();
        if (debitCard.purchase(input))
            System.out.println("Your new balance amount is now: $" + debitCard.getBankBalance());
        else
            System.out.println("Transaction denied.");
    }
    static void depositFunds() {
        System.out.println("How much does was the deposit amount? ");
        double input = console.nextDouble();
        debitCard.depositFunds(input);
        System.out.println("Your balance has now been increased to: " +debitCard.getBankBalance());
    }

}
