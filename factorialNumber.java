import java.util.Scanner;

public class factorialNumber {

    public static void main(String[] args)
    {
        int num;
        int factorial = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a positive number!: ");
        num = input.nextInt();
        for (int i = 2 ; i <= num; i++)
        {
            factorial = factorial * i;
        }

        System.out.println("The factorial of your chosen number is: " + factorial);
    }
}
