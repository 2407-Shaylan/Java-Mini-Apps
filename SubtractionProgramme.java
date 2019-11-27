import java.util.Scanner;

public class SubtractionProgramme
{
//This programme will give you 10 different subtraction questions

    public static void main(String[] args)
    {
        System.out.println("In this programme you will be given 10 subtraction questions, best of luck!");
        System.out.println("_____________________________________");

        final int num = 10; //how many questions will be asked to the user
        int num1 = 0;
        Scanner string2 = new
                        Scanner(System.in); //takes in user input via terminal

                while (num1<num)
                {
                    int numb1 = (int)(Math.random() * 10);
                    int numb2 = (int)(Math.random() * 10);

                    if (numb1 < numb2)
                    {
                        numb1 = numb2;
                    }

                    System.out.println("What is " + numb1 + " - " + numb2 +" " + "=");
                    int answer = string2.nextInt();

                    //num2++ adds to the counter for correct input

                    if (numb1 - numb2 == answer)
                    {
                        System.out.println("That is correct!");
                    }
                    else
                        System.out.println("Incorrect.\n" + numb1 + " - " + numb2 + " should be " + (numb1 - numb2));
                    num1++;
                    //num1++ adds to the counter for incorrect input
                }

            }
}
