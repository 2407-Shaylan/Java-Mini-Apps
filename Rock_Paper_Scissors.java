import java.util.Random;
import java.util.Scanner;

public class RPS {
    public static void main(String[] args) {

        Random number = new Random();

        Scanner input = new Scanner(System.in);

        int userChoice, computerChoice;

        System.out.println("Enter choice(0 = Rock; 1 = Paper; 2= Scissors):");
        userChoice = input.nextInt();

        if(userChoice < 0 || userChoice > 2)
        {
            System.out.println("Invalid Choice, Ending Program.");
            System.exit(0);
        }
        computerChoice = number.nextInt(3);

        if(userChoice == computerChoice)
        {
            if (userChoice == 0)
            {
                System.out.println("It's a tie as both players chose rock!");
            }
            else if (userChoice == 1)
            {
                System.out.println("It's a tie as both players chose paper!");
            }
            else
            {
                System.out.println("It's a tie as both players chose scissors!");
            }

            System.exit(0); //exit.program

        }
        if(userChoice == 0) //user_chooses_rock
        {
            if (computerChoice == 1) {
                System.out.println("You chose rock; Computer chose paper");
                System.out.println("The computer wins!");
            } else
                {
                System.out.println("You chose rock, computer chose scissors");
                System.out.println("You win this round!");
            }
        }
        else if(userChoice == 1) //user_chooses_paper
        {
            if(computerChoice == 0)
            {
                System.out.println("You chose paper; Computer chose rock!");
                System.out.println("You win this round!");
            }
            else
            {
                System.out.println("You chose paper; Computer chose scissors");
                System.out.println("The computer wins!");
            }
        }
        else
        {
            if (computerChoice == 0)
            {
                System.out.println("You chose scissors; Computer chose rock;");
                System.out.println("The computer wins!");
            }
            else
            {
                System.out.println("You chose scissors; Computer chose rock");
                System.out.println("You win this round!");
            }
        }

        input.close();
    }
}
