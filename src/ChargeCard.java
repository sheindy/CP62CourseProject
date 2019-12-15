// abstract class can have abstract method
// needed an abstract method. see purchaseAmnt()

public abstract class ChargeCard implements Comparable<ChargeCard>{
    private String name;
    private String cardNumber;

    //
    public int compareTo(ChargeCard other) {
        if (other.amntAvailToSpend() > amntAvailToSpend()) {
            return -1;
        }
        if (other.amntAvailToSpend()< amntAvailToSpend()) {
            return 1;
        }
        return 0;
    }

    // abstract method only contains a header and the concrete subclass
    // MUST override the abstract method and provide a body
    // in this case I made the purchase method abstract because the instructions
    // for purchase amnt is different for each subclass
    // return type is boolean because if the return was true then the purchase went through
    // and if it returned false the purchase didn't go through and it was declined
    public abstract boolean purchase(double purchaseAmnt);

    //
    public abstract double amntAvailToSpend();

    // constructor
    public ChargeCard(String name, String cardNumber) {
        // setting other variables to default values
        this.name = name;
        this.cardNumber = cardNumber;

        // checking the cardnumber digit amounts
        if (cardNumber.length() < 13)
            // i don't understand why I wrote this next line. deduct points if appropriate
            throw new IllegalArgumentException("Credit card number must be at least 13 digits");
        if (cardNumber.length() > 16)
            throw new IllegalArgumentException("Credit card number must be at most 16 digits");
        if (cardType() == null)
            throw new IllegalArgumentException("Not a valid card.");
        if (!mod10check())
            throw new IllegalArgumentException("Not a valid credit card number");
    }

    // method/function using the Lhun check algorithm to see if the number
    // is a valid credit card number
    private boolean mod10check() {
        int evenSum = 0;
        // knows to start on the right of the number because i = cardNumber.length().
        // checks only every second number in the even space of the number because of the -2
        // after cardNumber.length() and it's checking every 2nd number based off i -= 2
        for (int i = cardNumber.length() - 2; i >= 0; i -= 2) {

            char numChar = cardNumber.charAt(i);
            // something about ascii code. ascii code is in # form. different characters are stored
            // in each ascii space. we need to get the character stored in the ascii space by
            // subtracting 48 because ascii code space # 48 stores the int 0, ascii code space
            // # 49 stores int 1 and so on.
            int num = numChar - 48;
            num *= 2;
            if (num > 9) {
                num = num / 10 + num % 10;
            }
            evenSum += num;
        }
        int oddSum = 0;
        // knows to start on the right of the number because i = cardNumber.length().
        // checks only every second number in the odd space of the number because of the -1
        // after cardNumber.length() and it's checking every 2nd number based off i -= 2
        for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
            char numChar = cardNumber.charAt(i);
            // something about ascii code. ascii code is in # form. different characters are stored
            // in each ascii space. we need to get the character stored in the ascii space by
            // subtracting 48 because ascii code space # 48 stores the int 0, ascii code space
            // # 49 stores int 1 and so on.
            int num = numChar - 48;
            oddSum += num;
        }
        int evenAndOddSums = evenSum + oddSum;
        return evenAndOddSums % 10 == 0;
    }
    // method/function what type of card it is based on the first two digits
    protected String cardType () {
        char numChar = cardNumber.charAt(0);
        int num = numChar - 48;
        if (num == 4)
            return "Visa";
        if (num == 5)
            return "Master";
        if (num == 6)
            return "Discover";
        if (num == 3) {
            numChar = cardNumber.charAt(1);
            num = numChar - 48;
            if (num == 7)
                return "American Express";
        }
        // if the first or first two digits are not any of those specified above
        return null;
    }

    // accessor for card number
    public String getCardNumber() {
        return cardNumber;
    }


    // accessor for name
    public String getName() {
        return name;
    }
}