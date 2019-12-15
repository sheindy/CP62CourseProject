/*Part B - Wallet class
Write a class called Wallet to store information about the current
state of a wallet. A wallet has different compartments for the dollar bills,
loose change, credit / debit cards and ID cards.
*/

import java.util.*;

public class Wallet {

/*Data Members should include:
• Amount of cash - keep track of value of dollar bills and value of change separately.
• Array of ChargeCards – it can contain both CreditCards and DebitCards.
• Array of ID cards – this can be simply an array of Strings.
It’s up to you how to store this information.
*/

    private int    amountInBills = 0;
    private double amountInCoins = 0;

    // using array list in order to be able to add and remove elements
    // arrayList<ChargeCard> type<oftype>
    private ArrayList< ChargeCard > chargeCards = new ArrayList< ChargeCard >();

    private ArrayList< String > idCards = new ArrayList< String >();
    // Create an ArrayList object

    /*Methods should include:
    • at least two constructors
    */

    // overloading = two or more methods w same name but different parameters or different return type
    public Wallet () { }

    public Wallet ( int amountInBills, double amountInCoins ) {
        this.amountInBills = amountInBills;
        this.amountInCoins = amountInCoins;
    }

    //• accessor methods
    public ArrayList<ChargeCard> getChargeCards() {
        return chargeCards;
    }
    public int getAmountInBills () {
        return amountInBills;
    }

    public double getAmountInCoins () {
        return amountInCoins;
    }

    //  mutator methods
    public void setAmountInBills ( int amountInBills ) {
        this.amountInBills = amountInBills;
    }

    public void setAmountInCoins ( double amountInCoins ) {
        this.amountInCoins = amountInCoins;
    }

    public double totalCashOnHand() {
        return amountInBills + amountInCoins;
    }

    public double totalCanSpend(){
        double total = totalCashOnHand();
        for (int i = 0; i < chargeCards.size(); i++) {
            total += chargeCards.get(i).amntAvailToSpend();
        }
        return total;
    }

    public boolean purchaseWithCash(double purchaseAmnt ) {
        if (purchaseAmnt > totalCashOnHand()) return false;
        amountInBills -= purchaseAmnt;
        if (amountInBills < 0) {
            amountInCoins += amountInBills;
            amountInBills = 0;
        }
        amountInCoins -= purchaseAmnt % 1;
        return  true;
    }

    public int amntOfIDcards(){
        return idCards.size();
    }

    public int amntOfChargeCards(){
        return chargeCards.size();
    }

    // add card to charge card array list (ChargeCard is the type, chargeCard is the name) things
    // in parentheses are the parameters
    public void addChargeCard(ChargeCard chargeCard) {
        chargeCards.add(chargeCard);
    }

    public void addIDcard(String idCard){
        idCards.add(idCard);
    }

    // Render the state of a wallet as a String
    public String toString () {
        // write out amount of cash
        String stuffInWallet = "The total amount of Bills in your wallet is: $" + getAmountInBills() + "\n" +
                               "The total amount of Coins in your wallet is: $" + getAmountInCoins() + "\n";

        // add in the charge (credit and debit) cards
        // for each element in the chargeCards list, calls its toString method
        for ( int i = 0; i < chargeCards.size(); i++ ) {
            stuffInWallet += chargeCards.get( i ) + "\n";
        }

        for ( int i = 0; i < idCards.size(); i++ ) {
            stuffInWallet += idCards.get( i ) + "\n";
        }

        return stuffInWallet;
    }
}