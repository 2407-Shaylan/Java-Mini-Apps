import java.io.*;//imports all Input/Output methods using the astrix(*)
import java.util.*;//imports all utility methods using the astrix(*)

public class ascendingOrder {
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a text file for sorting its words in alphabetical order.");
        System.out.println("User must enter complete file location!");
        System.out.println("Eg: C:/Users/Username/Desktop/File.txt");
        System.out.println("_______________________________________________________");


        String text = input.nextLine();
        File f = new File(text); //creates a file from what the user inputs
        //returns output if file does not exist
        if (!f.exists())
            System.out.println("The input file you have entered does not exist or is not in the right location.");
        //creates an empty BufferReader to read all characters, strings or arrays from the given file
        BufferedReader charRead = new BufferedReader(new FileReader(text));

        //creates an ArrayList which will be uses to store a string of words from the given file
        List<String> words = new ArrayList<>();

        String nextSentence;
        //reads every line of the sentence
        while ((nextSentence = charRead.readLine()) != null) {
            words.addAll(Arrays.asList(nextSentence.split("\\b+")));
            //assigns all words to ArrayList
        }

        Collections.sort(words);
        for (String allWords: words)
        {
            assert allWords != null;
            if (!allWords.equals(""))
                if (Character.isLetter(allWords.charAt(0)))
                    System.out.println(allWords);
        }
        charRead.close();
    }
}