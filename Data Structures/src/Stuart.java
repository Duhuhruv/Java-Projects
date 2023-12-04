import java.io.*;
import java.util.*;
//Dhruv Chaudhary
//Data Structures Project
//Period 8 Adv CS Topics and Principles
/*The main function fo this program is to take an inputted text (The stuart little script) and output the word count and number of unique words,
It also lets the user search for a word in the text and remove it. This could be used to censor words for example a
swear word could be removed and the user would then get the text without it.
 */
public class Stuart {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nStuart Little Script:");          //prints the title of the script
        System.out.println("---------------------------");
        File stuartLittle = new File("D:/online school 2/Adv CS/StuartLittle.txt");     //grabs the fiel from it's folder
        Scanner print = new Scanner(stuartLittle);      //creates a scanner to help print the script initially
        while(print.hasNext()){         //while loop that prints the script
            System.out.println(print.nextLine());
        }
        Scanner console = new Scanner(stuartLittle).useDelimiter("(\\B+-\\B+|[.,:;()?!\" \t|])+");      //these scanners use delimiters to cut the script into only words
        Scanner console1 = new Scanner(stuartLittle).useDelimiter("(\\B+-\\B+|[.,:;()?!\" \t|])+");     //there is a new scanner for each data structure so they can change them individually
        Scanner console2 = new Scanner(stuartLittle).useDelimiter("(\\B+-\\B+|[.,:;()?!\" \t|])+");
        //these are the 3 Data structures used in the program
        LinkedList<String> findWord = new LinkedList<>();       //uses a linkedlist to easily parse through the data and change it
        HashSet<String> unique = new HashSet<>();               //uses a Hashset to easily sort out the duplicates to find the number of unique words
        Queue<String> wordList = new LinkedList<>();            //uses a queue to easily sort the number of unique words without changing them
        while(console2.hasNext()) {             //these while loops add the script into the different data structures
            findWord.add(console2.next());
        }
        while(console.hasNext()) {
            wordList.add(console.next());
        }
        while(console1.hasNext()){
            unique.add(console1.next());
        }
        System.out.println("-----------------------");
        System.out.println("Number of Words: " + wordList.size());          //returns the number of words in the script
        System.out.println("Number of unique words: " + unique.size());     //returns the number of unique words in the script
        Scanner input = new Scanner(System.in);             //this scanner takes user input to find out how many words to get rid of
        System.out.println("How many words would you like to omit?");
        int numWords = input.nextInt();
        removeWords(numWords, input, findWord);     //calls the removewords method with the right parameters
    }
    public static void removeWords(int x, Scanner input, LinkedList<String> words){     //removes the words the user chooses from the script and returns it
        for(int i =0; i< x;i ++){           //first for loop for number of different words
            System.out.println("Word "+(i+1)+": ");
            String omit = input.next();
            int count = 0;
            for(int a = 0; a<words.size();a++){         //second for loop to go through each section of the linked list
                if(words.get(a).equalsIgnoreCase(omit)){
                    count++;            //counts up to give the user the instances of the removed words
                    words.remove(a);
                }
            }
            System.out.println("New Script: ");         //prints the changed script after the words are removed
            System.out.println(words.toString());
            System.out.println("----------------------------");
            System.out.println("'"+omit+"' appeared "+count+" times and was removed from the text.");
        }
    }
}
