import java.util.Scanner;

public class HexToDecimal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Asking for user input of a number
        System.out.println("Enter a hex number: \n");
        System.out.println("________________________");

        String hex = input.nextLine();

        try
        {
            System.out.println("The decimal value for the number chosen hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    //adding the number exception
    private static int hexToDecimal(String hex) throws NumberFormatException
    {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            if (!(hex.charAt(i) >= '0' && hex.charAt(i) <= '9') ||
                    !(hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F')) {
                throw new NumberFormatException("String is not a hex string, try again!");
            }
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }

        return decimalValue;
    }

    private static int hexCharToDecimal(char xy)
    {
        if (xy >= 'A' && xy <= 'F')
            return 10 + xy - 'A';
        else
            {
            return xy - '0';
        }
    }
}