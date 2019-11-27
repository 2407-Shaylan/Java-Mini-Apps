import java.util.Scanner; //input


public class averageNumber { //creating  a class
    public static void main(String[] args) { //psvm
        int counter = 0; //counter
        int number = 1; //integer
        double averageNum = 0.0;
        int total = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Type out an integer, If you wish to stop enter 0 to end this process."); //This will begin the input process

        do {
            number = input.nextInt();
            total = total + number; //calculation
            counter++; //add to counter
        }while (number != 0); //while number not equal to 0

        averageNum = total / (counter);
        System.out.println("The sum of the numbers you have entered are:" + " " + total + "!"); //total in string
        System.out.println("The average of the numbers you have entered are:" + " " + averageNum + "!"); //average in string

    }
}
