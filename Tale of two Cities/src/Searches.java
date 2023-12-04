import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*Dhruv Chaudhary
  Period 8 Adv CS

  This program reads Tale of two cities from a file and runs a sequential, binary, and recursive binary search for a word
  and returns the index and search time.
 */
public class Searches {
    public static void main(String[] args) throws Exception {
        File file = new File("D:/online school 2/Adv CS/TaleOfTwoCities.txt");  //finds file from computer
        Scanner scan = new Scanner(file);
        ArrayList<String> usedWords = new ArrayList<String>();  //initiates arraylists to use later in program
        ArrayList<String> invalidWords = new ArrayList<String>();
        int readTimeStart = (int) System.currentTimeMillis(); // calls the timer
        while (scan.hasNext()) {        //makes it so there is only 1 instance of each word
            String word = scan.next().replaceAll("\\p{P}", "").toLowerCase();
            if (!usedWords.contains(word)) {
                usedWords.add(word);
            } else {
                invalidWords.add(word);
            }
        }
        scan.close();   // closes the scanner
        Collections.sort(usedWords);    //sorts the words
        int readTimeEnd = (int) System.currentTimeMillis();
        int readTimeTotal = readTimeEnd - readTimeStart;
        System.out.println("Number of words found: " + usedWords.size());   //prints number of total words
        System.out.println("read and sorted in: " + readTimeTotal + "ms\n");    //prints how long it took to parse the file

        System.out.println("Type a word to sequential search for:");   //calls the sequential search using a word the user chooses
        sequentialSearch(usedWords);
        System.out.println("Type a word to binary search for:");   //calls the binary search using a word the user chooses
        binarySearch(usedWords);
        //start getting all the things ready for recursive search
        int min = 0;
        int max = usedWords.size() - 1;
        Scanner recursiveInput = new Scanner(System.in);    //asks the user to input a word to search
        System.out.println("Type a word to recursive search for: ");
        String recursiveWord = recursiveInput.next().toLowerCase();
        int startRecursive = (int) System.currentTimeMillis();  //starts the clock for the recursive search
        int recursiveIndex = recursiveBinarySearch(usedWords, recursiveWord, min, max); //calls the recursive method for first time and prints out the result
        if(recursiveIndex!=-1) {    //checks to make sure the word exists
            System.out.println(recursiveWord + " is at index " + recursiveIndex);
            int endRecursive = (int) System.currentTimeMillis();    //ends the timer for recursive search
            int finalRecursive = endRecursive - startRecursive;
            System.out.println("Recursive search time: " + finalRecursive + "ms\n");    //prints out the search time
        } else{
            System.out.println("word not found");   //returns error statement if word not found
        }
    }

    public static void sequentialSearch(ArrayList<String> usedWords) throws Exception {
        Scanner userInput = new Scanner(System.in);
        String word = userInput.nextLine().replaceAll("\\p{P}", "").toLowerCase();  //gets rid of punctuation within words
        int sequentialTimeStart = (int) System.currentTimeMillis(); //starts the clock for the sequential search
        int count = 0;  //checks if word exists
        for (int i = 0; i < usedWords.size(); i++) {        //this for loop goes through each part of the arraylist until it finds the target word
            if (usedWords.get(i).equals(word)) {
                System.out.println(word + " is at index " + usedWords.indexOf(word));
                count++;
            }
        }
        if(count==0){    // returns word not found if word isn't in the list
            System.out.println("word not found");
        } else {
            int sequentialTimeEnd = (int) System.currentTimeMillis();   //returns the search time
            int totalTime = sequentialTimeEnd - sequentialTimeStart;
            System.out.println("Sequential search time: " + totalTime + "ms\n");
        }
    }

    public static void binarySearch(ArrayList<String> usedWords) throws Exception {
        Scanner input2 = new Scanner(System.in);
        String word2 = input2.nextLine().replaceAll("\\p{P}", "").toLowerCase();    //gets rid of punctuation in the words list
        if(usedWords.contains(word2)) {     //if statements makes sure word exists before starting search
            int binaryTimeStart = (int) System.currentTimeMillis();
            //creates min, max, and mid for binary search
            int min = 0;
            int max = usedWords.size() - 1;
            int compare = 10;
            int binaryWordIndex = 0;
            while (compare != 0) {      //runs while loop until compare equals the index of the word searched for
                int mid = (min + max) / 2;
                compare = usedWords.get(mid).compareTo(word2);
                if (compare < 0) {  //if the index is lower it turns the min to the mid
                    min = mid;
                }
                if (compare > 0) {  //if the index is larger it turns the max to the mid
                    max = mid;
                }
                binaryWordIndex = mid;
            }

            System.out.println(word2 + " is at index: " + binaryWordIndex); //prints what index the target word is at
            int binaryTimeEnd = (int) System.currentTimeMillis();   //stops the timer and prints the time
            int binaryTotalTime = binaryTimeEnd - binaryTimeStart;
            System.out.println("Binary search time: " + binaryTotalTime + "ms\n");
        } else {
            System.out.println("word not found");   //returns error statement if word not founds
        }
    }

    public static int recursiveBinarySearch(ArrayList<String> usedWord, String target, int min, int max) {
        if (min > max) {    // if the target word doesnt exist it will end the method
            return -1;
        }
        int min1 = min; //initializes min, max, and mid for the binary search
        int max1 = max;
        int mid = (min + max) / 2;
        if (usedWord.get(mid).compareTo(target) == 0) {     //checks if the index is correct and returns it
            return mid;
        } else if (usedWord.get(mid).compareTo(target) < 0) {   //recalls the method if the mid value is too low
            min1 = mid + 1;
            return recursiveBinarySearch(usedWord, target, min1, max1);
        } else if (usedWord.get(mid).compareTo(target) > 0) {   //recalls the method if the mid value is too high
            max1 = mid - 1;
            return recursiveBinarySearch(usedWord, target, min1, max1);
        }
        return -1;  //ends method in case nothing matches
    }
}