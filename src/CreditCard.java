
public class CreditCard extends ChargeCard {
    // member variables
    private double spendingLimit;
    private double balance;


    // constructor
    public CreditCard(String name, String cardNumber) {
        // setting other variables to default values
        super(name, cardNumber);
        this.spendingLimit = 2000;


    }
    // list of accessors
    // names of accessors

    // accessor for credit card limit
    public double getSpendingLimit() {
        return spendingLimit;
    }

    // accessor for balance
    public double getBalance() {
        return balance;
    }

    //  mutator adds purchase amount to balance
    // if it doesn't place it over the limit
    public boolean purchase(double purchaseAmnt) {
        balance += purchaseAmnt;
        if (balance > spendingLimit) {
            balance -= purchaseAmnt;
            return false;
        }
        return true;
    }

    // increases the spending limit by $50 each time it is called
    public void increaseSpendingLimit() {
        spendingLimit += 50;
    }

    // mutator changes the state of the credit card
    // state that it changes is the balance
    public void payBill() {
        balance = 0;
    }

    // creates string representation of credit card object
    public String toString() {
        return getName() + "\nBalance $" + balance + "\nSpending Limit $" +
                spendingLimit + "\n" +
                getCardNumber() + "\n" + cardType();
    }

}
