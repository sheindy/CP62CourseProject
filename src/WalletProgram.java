/*Part C - Menu Driven Program
Write a menu-driven program that allows the user to interact with a single Wallet object.
1. Print all information about Wallet. [This should call the toString method of the Wallet
class.]
2. Add a Credit Card. [Prompt the user for information about the Credit Card]
3. Add a Debit Card. [Prompt the user for information about the Debit Card.]
4. Add an ID Card. [Prompt the user for information about the ID card.]
5. Add Cash. [Prompt the user for the value of additional coins or dollar bills.]
6. Make a purchase. [Should ask for purchase amount. Then let the user choose whether to
pay with cash or charge card. If cash, make sure there is sufficient cash in the wallet to
cover the purchase, and then deduct accordingly. If charge card, there should be a
submenu in which the user chooses a card from the list to use. Then the system should
check that the card can be used for that purchase, i.e., that there are sufficient funds
available on that card, and actually process the purchase on the selected ChargeCard.]
*/

import java.util.*;

public class WalletProgram {
    static Scanner console = new Scanner( System.in );
    static Wallet  wallet  = new Wallet();

    public static void main ( String[] args ) {

        while ( true ) {

            System.out.println( "1. Print all information about Wallet.\n" +
                                "2. Add a Credit Card.\n" +
                                "3. Add a Debit Card.\n" +
                                "4. Add an ID Card.\n" +
                                "5. Add Cash.\n" +
                                "6. Make a purchase.\n" );

            int input;
            try {
                input = console.nextInt();
            } catch ( InputMismatchException e ) {
                System.out.println( "You were supposed to enter an integer" );
                continue;
            }
            System.out.println();
            if ( input == 1 ) viewWallet();
            else if ( input == 2 ) addCreditCard();
            else if ( input == 3 ) addDebitCard();
            else if ( input == 4 ) addIDcard();
            else if ( input == 5 ) addCash();
            else if ( input == 6 ) makePurchase();
            else
                System.out.println( "Not a valid entry." );
            System.out.println();
        }
    }

    static void viewWallet () {
        System.out.println( wallet );
    }

    static void addCreditCard () {
        System.out.println( "What is the name on the credit card you are adding? " );
        String name = console.next();
        System.out.println( "Please enter the digits of the credit card you are adding. " );
        String ccNum = console.next();
        try {
            CreditCard creditCard = new CreditCard( name, ccNum );
            wallet.addChargeCard( creditCard );
        } catch ( IllegalArgumentException e ) {
            System.out.println( e.getMessage() );
        }
    }

    static void addDebitCard () {
        System.out.println( "What is the name on the debit card you are adding? " );
        String name = console.next();
        System.out.println( "Please enter the digits of the debit card you are adding. " );
        String ccNum = console.next();
        try {
            DebitCard debitCard = new DebitCard( name, ccNum );
            wallet.addChargeCard( debitCard );
        } catch ( IllegalArgumentException e ) {
            System.out.println( e.getMessage() );
        }
    }

    static void addIDcard () {
        System.out.println( "What is the name on the ID card you are adding? " );
        String name = console.next();
        wallet.addIDcard( name );
    }

    static void addCash () {
        System.out.println( "What is the amount in bills you will be adding today?" );
        int bills;
        try {
            bills = console.nextInt();
        } catch ( InputMismatchException e ) {
            System.out.println( "You were supposed to enter an integer" );
            return;
        }

        System.out.println( "What is the amount in coins you will be adding today?" );
        int coins;
        try {
            coins = console.nextInt();
        } catch ( InputMismatchException e ) {
            System.out.println( "You were supposed to enter an integer" );
            return;
        }
        wallet.setAmountInBills( wallet.getAmountInBills() + bills );
        wallet.setAmountInCoins( wallet.getAmountInCoins() + coins / 100.0 );
    }

    static void makePurchase () {
        System.out.println( "How much does this purchase amount to? " );
        double purchaseAmnt;
        try {
            purchaseAmnt = console.nextDouble();
        } catch ( InputMismatchException e ) {
            System.out.println( "You were supposed to enter a number!" );
            return;
        }
        System.out.println( "Enter 1 for cash, 2 for Debit/Credit: " );
        int input;
        try {
            input = console.nextInt();
        } catch ( InputMismatchException e ) {
            System.out.println( "You were supposed to enter an integer" );
            return;
        }
        if ( input == 1 ) purchaseWithCash( purchaseAmnt );
        if ( input == 2 ) purchaseWithCard( purchaseAmnt );
        else {
            System.out.println( "That is not a valid entry." );
        }

    }

    static void purchaseWithCash ( double purchaseAmnt ) {
        if ( wallet.purchaseWithCash( purchaseAmnt ) )
            System.out.println( "Your cash balance is now: $" + wallet.totalCashOnHand() );
        else System.out.println(
                "Sorry, you do not have enough cash on hand, you might wanna go rob a bank. \n" +
                "This is the cash " +
                "amount you have on hand: $" +
                wallet.totalCashOnHand() );
    }

    static void purchaseWithCard ( double purchaseAmnt ) {
        System.out.println( ("Choose which card you would like yo! By entering the number next to it.\n") );
        ArrayList< ChargeCard > chargeCards = wallet.getChargeCards();
        Collections.sort( chargeCards );
        for ( int i = 0; i < chargeCards.size(); i++ ) {
            ChargeCard chargeCard = chargeCards.get( i );
            System.out.println( i+ " - Your " + chargeCard.cardType() + " card, number " + chargeCard.getCardNumber() +
                                " has this spending power: $" + chargeCard.amntAvailToSpend() );
        }
        int input;
        try {
            input = console.nextInt();
        } catch ( InputMismatchException e ) {
            System.out.println( "You were supposed to enter an integer" );
            return;
        }
        ChargeCard chargeCard;
        try {
            chargeCard = chargeCards.get( input );
        } catch ( IndexOutOfBoundsException e ) {
            System.out.println( "You were supposed to enter a number based just on the choices provided ya moron!" );
            return;
        }
        if (chargeCard.purchase( purchaseAmnt )) {
            System.out.println( "This cards spending power has been reduced to: $" + chargeCard.amntAvailToSpend() );
        }
        else System.out.println( "This card does not have enough spending power for this purchase. BooHoo" );
    }

}
