
public class DebitCard extends ChargeCard {
    private double bankBalance;
    private double overdraftLimit;
    private double overdraftFee;
    private double overdraftFeesIncurred;

    public DebitCard(String name, String cardNumber) {
        super(name, cardNumber);
        overdraftFee = 50;
        overdraftLimit = 100;
        bankBalance = 0;

    }

    public double getBankBalance() {
        return bankBalance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getOverdraftFee() {
        return overdraftFee;
    }

    public double getOverdraftFeesIncurred() {
        return overdraftFeesIncurred;
    }

    public boolean purchase(double purchaseAmnt) {
        bankBalance -= purchaseAmnt;
        if (bankBalance < 0) {
            if (bankBalance * -1 > overdraftLimit) {
                bankBalance += purchaseAmnt;
                return false;
            }
            overdraftFeesIncurred += overdraftFee;
        }
        return true;
    }

    public void increaseOverdraftLimit() {
        overdraftLimit += 100;
    }

    public void depositFunds(double depositAmnt) {
        bankBalance += depositAmnt;
    }

    public double amntAvailToSpend(){
        return bankBalance + overdraftLimit;
    }

        public boolean withdrawFunds(double withdrawalAmnt) {
        bankBalance -= withdrawalAmnt;
        if (bankBalance < 0) {
            bankBalance += withdrawalAmnt;
            return false;
        }
        return true;
    }

    // This method should reset the feesIncurred member variable to 0.
    public double payOverdraftFees() {
        return overdraftFeesIncurred = 0;

    }

    // Render the state of a DebitCard as a String
    public String toString() {
        return getName() + "\nYour Bank Balance is $ " + bankBalance + "\nYour Overdraft Limit is $ " +
                overdraftLimit + "\nDebit Card Number: " +
                getCardNumber() + "\nCard Type: " + cardType();
    }
}



/* The balance on a debit card can become negative, so long as the
 * amount does not exceed the overdraft limit, in which case an
 * overdraft fee is applied.
 */

/* In both a credit card and debit card, it should be possible to the maximum that can be spent.
 * theres a chart here of sorts
 */


/* Do you think ChargeCard should be an abstract or a concrete class? Write a comment before the
 * class begins in which you explain your design decision.
 */

/* Make a parameterized constructor in the superclass that can be called from all of its subclasses.
 */


/* Keep in mind: input and output should not be performed in the CreditCard or DebitCard or
 * ChargeCard classes. All input and output to the user should be performed in the main method
 * method (or other methods that are in a separate class) to increase flexibility of the classes we will
 * design later on.
 */

/* Debit Card Class
 * The fields in the DebitCard class should include the following. Realize that the data members
 * that are shared with the CreditCard class should be implemented in the ChargeCard class to
 * eliminate redundancy.
 * • name. A String that holds the card holder’s name.
 * • cardNumber. A field that holds the credit card number.
 * • balance. A double that stores the current credit card balance.
 * • overdraftLimit. A double that stores the overdraft limit of the account.
 * • overdraftFee. A double that stores the fee to apply whenever expenses exceed the
 * balance.
 * • feesIncurred. A double that keeps track of fees that the account holder owes.
 * • additional fields that you can think of.
 * The DebitCard class should support (at least) the following member methods:
 * • Constructor. The constructor should accept the card holder’s name and card number and
 * assign these values to the object's corresponding member variables. The constructor
 * should initialize the overdraft fee to $50, the overdraft limit to $100, and the balance to
 * $0.
 */

