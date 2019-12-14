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

public class WalletProgram {
    public static void main(String[] args) {
        //typeofvariable, nameofvariable,   assign object on right hand side to the variable,  typeofobject
        Wallet            wallet            = new                                              Wallet();

        System.out.println("New wallet = " + wallet);
    }

}
