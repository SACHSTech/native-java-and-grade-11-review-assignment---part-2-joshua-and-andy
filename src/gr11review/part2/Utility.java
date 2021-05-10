package gr11review.part2;
import java.io.*;
public class Utility {
  public static int sumNumbers(String str){
    /**
    * Given a string, return the sum of the numbers appearing in the string
    * Ignoring all other characters
    * @author: A. Shan
    */

    // declear the varaibles
    int wordLength;
    int number = 0;
    int i;
    int j = 0;
    String WordNums;
    //find the length of the word
    wordLength = str.length();
    // First for loop that check each character and put them in a char
    for (i = 0; i < wordLength; i++){
      char digit = str.charAt(i);
      // Check if the char character is a digit or not
      if (Character.isDigit(digit)){
        //if it is a digit check for the digit after it
        for (j = i + 1; j < wordLength; j++){
          char AnotherDigit = str.charAt(j);
          // if it is not a digit the second for loop breaks
          if (!Character.isDigit(AnotherDigit)){
            break;
          }
        }
        // Now we use the first count and the second count as the positon of the number start and ends. We take the number as string and convert them into integer before adding them togther.
        WordNums = str.substring(i, j);
        number += Integer.parseInt(WordNums);
        // When finding the next number, we need to start where it ended in the string
        i = j;
     }
    }
    //return the sum
    return number;
  }

  public static String alphaWord(String filenametxt) throws IOException{
    /**
    * Given the name of a file
    * Compare each word on each line of the file
    * Return the word that is alphabetically first 
    * @author: A. Shan
    */

    //declearing the variables
    String FirstWord; 
    String comparison = "";
    BufferedReader thefile = new BufferedReader(new FileReader(filenametxt));
    // giving values to variables
    FirstWord = thefile.readLine(); 
    // A while loop to compare two words' alphabetical order. When loop won't stop until it reaches the bottom of the list
    while (comparison != "null"){
      comparison = thefile.readLine();
      if (FirstWord.compareTo(comparison) > 0){
        FirstWord = comparison;
      }
    }
    thefile.close();
    return FirstWord;
  } 
    public static int[] notAlone(int[] nums, int value){
     /**
    * If an element in an array is "alone" if there are values before and after it,
    * and those values are different from it. 
    * Return a array where every instance of the given value which is alone is 
    *replaced by whichever value to its left or right is larger 
    * @author: A. Shan
    */

     // set the array
     int myArray[] = new int [nums.length];
     //declear the variables
     int count;
     // Check if theres only one digit in the array, if they are, nothing changed
     if (nums.length >= 1){
            myArray[0] = nums[0];
            myArray[nums.length - 1] = nums[nums.length - 1];
    }
    // A for loop that will run until the count is equal to its length
    for (count = 1; count < nums.length - 1; count++){
      // an if statement that will check if the count is the same as the given value and if it is equal to its left side or right side
     if (nums[count] == value && nums[count] != nums[count+1] && nums[count] != nums[count-1]){
       // makes the alone number equal to whichever value to its left or right is larger 
       myArray[count] = Math.max(nums[count+1], nums[count-1]);
      }else {
        // if there's no alone value, nothing changed
        myArray[count] = nums[count];
     }
    }
    return myArray;
  }
  public static boolean canBalance(int[] nums){
    /**
    * Given a non-empty array 
    * Return true if there is a way to split the array so that the 
    * sum of the numbers are the same for both sides
    * If it cannot, returns false
    * @author: A. Shan
    */
   
    //declear the variables
    int leftSum = 0;
    int rightSum = 0;
    int count;
    int countAlt;

    //Set a for loop that will calculate left sum
    for (count = 0; count < nums.length; count++){
      leftSum += nums[count];
      rightSum = 0;
      // Another loop that will calculate the right sum based on where  the left sum ended
      for (countAlt = nums.length - 1; countAlt > count; countAlt--){
        rightSum += nums[countAlt];
      }
      // it checks if the left sum and right sum are the same. If they are, return true
      if (leftSum == rightSum){
        return true;
      }
    }
    // Since there are not spot that can have the same right sum and the left sum, therefore false is returned
    return false;
  }
  public static void diagonal(int n) throws IOException{
    /**
    * Given a integer n
    * outputs a two-dimensional array of size (nxn) to a text file
    * with a comma between each number
    * @author: A. Shan
    */
    // declearing the variables
    int i;
    int j;

    PrintWriter theout = new PrintWriter(new FileWriter("diagonalOut.txt", true));
    for (i = 0; i < n; i++){
      for (j = 0; j < n; j++){
        if ((i+j) == n - 1){
          theout.print("1");
        }else if((i+j) < n - 1){
          theout.print("0");
        }else{
          theout.print("2");
         }
         if (j != n-1){
           theout.print(",");
         }
      }
      theout.println("");
    }
    theout.close();
  }
}

