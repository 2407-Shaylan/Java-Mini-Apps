import java.util.Arrays;
import java.util.Scanner;

public class identicalArrays {

    public static void main(String[] args) {

        //Declaration of arrays with 3 elements
        int [] array1 = new int[5];
        int [] array2 = new int[5];

        //Storing the user's input for the first array
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter five integer values (press enter after typing each integer): ");
        System.out.println("________________________________________________________________________");
        System.out.print("Integer 1: "); array1[0] = scan.nextInt();
        System.out.print("Integer 2: "); array1[1] = scan.nextInt();
        System.out.print("Integer 3: "); array1[2] = scan.nextInt();
        System.out.print("Integer 3: "); array1[3] = scan.nextInt();
        System.out.print("Integer 3: "); array1[4] = scan.nextInt();

        System.out.println("___________________________________________________");
        System.out.println("Please enter a second set of five integer values: ");
        System.out.println("___________________________________________________");
        ////Storing the user's input for the second array
        System.out.print("Integer 1: "); array2[0] = scan.nextInt();
        System.out.print("Integer 2: "); array2[1] = scan.nextInt();
        System.out.print("Integer 3: "); array2[2] = scan.nextInt();
        System.out.print("Integer 4: "); array2[3] = scan.nextInt();
        System.out.print("Integer 5: "); array2[4] = scan.nextInt();

        //Displaying what the user typed
        //System.out.println("______________________");
        System.out.println("First array = ["+array1[0]+", "+array1[1]+", "+array1[2]+", "+array1[3]+", "+array1[4]+".]");
        //System.out.println("_______________________");
        System.out.println("Second array = ["+array2[0]+", "+array2[1]+", "+array2[2]+", "+array2[3]+", "+array2[4]+".]");
        System.out.println("___________________________________");

        //Comparing the first array to the second array
        if (Arrays.equals(array1, array2))
            System.out.println("The two arrays are identical");
        else
            System.out.println("The two arrays are not identical");
    }
}