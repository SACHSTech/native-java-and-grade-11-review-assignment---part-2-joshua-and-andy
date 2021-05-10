package gr11review.part2;
import java.io.*;
public class Utility {
    /**
    * Given a string, for each ocurence of a three letter word starting
    * with z and ending with p replace it with zp.
    * @author: Joshua. S 
    */
    public static String zipZap(String str){
        // Checks for a word maching the criteria then replaces it with zp
        for(char i='a';i<'z';i++){
            str = str.replaceAll("z"+String.valueOf(i)+"p", "zp");
        }
        return str;
    }

    /**
    * Reads each line in a file and determines which word is the largest
    * then reaturns that word.
    * @author: Joshua. S 
    */
    public static String longestWord(String filenametxt) throws IOException{
        // Var declarations.
        String data,word="";
        BufferedReader br = new BufferedReader(new FileReader(filenametxt));

        // Reads each line then compares the word to the largest word
        // if it's greater it now becomes the largest word.
        while((data=br.readLine())!=null)
            if(data.length()>word.length())
                word=data;
        br.close();
        return word;
    }

    /**
    * For every number in the array that is not a multiple of 10 it
    * changes to the previous multiple of 10.
    * @author: Joshua. S 
    */
    public static int[] tenRun(int[] nums){
        // Var declarations.
        int multiple=0;

        // For each value in the array check if it's a multiple of 10 if so
        // change "multiple" to that number. If the number is not a multiple
        // of 10 replace it with "multiple"
        for(int i=0;i<nums.length;i++){
            if((nums[i]%10) == 0)
                multiple=nums[i];
            else if(multiple>0)
                nums[i]=multiple;
        }
        return nums;
    }

    /**
    * Returns true or false depending on of the inner array in contained in-
    * -side the outer array.
    * @author: Joshua. S 
    */
    public static boolean linearIn(int[] outer, int[] inner){
        // Var Declarations
        int found=inner.length,count=0;
        // Goes through the array and checks of each number exists at least
        // once.
        for(int i=0;i<outer.length;i++)
            if(count<inner.length&&outer[i]==inner[count]){
                count++; 
                found--;
            } 
        if(found==0)
            return true;
        return false;
    }

    /**
    * Writes the the spesified digets of pascals triangle into a file called
    * pascalOut.txt.
    * @author: Joshua. S 
    */
    public static void pascalTri(int i, int j) throws IOException{
        // Creates buffered writer to write to file.
        BufferedWriter bw = new BufferedWriter(new FileWriter("pascalOut.txt"));
        // Declarations of 2D array.
        int[][] triangle = new int[j][i];
        // Loops through each space in the array and if it's zero on x or y its set it
        // to 1. Then looks one space behind and one space above then adds them and
        // sets the current one space as the sum.
        for(int rcx=0;rcx<i;rcx++){
            for(int ecx=0;ecx<j;ecx++){
                if(ecx==0||rcx==0)
                    triangle[ecx][rcx]=1;
                else
                    triangle[ecx][rcx] = triangle[ecx-1][rcx]+triangle[ecx][rcx-1];
                // Writes the array value in the file
                bw.write(""+triangle[ecx][rcx]);
                if(ecx!=j-1)
                    bw.write(",");
            }
            bw.newLine();
        }
        bw.close();
    }
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
    // first for loop that adds the row and the second loop adds the column 
    for (i = 0; i < n; i++){
      for (j = 0; j < n; j++){
        // if i+j equals n - 1 (because its counts from 0), it means it is on the diagonal line which prints 1
        if ((i+j) == n - 1){
          theout.print("1");
        // if i+j is less than n - 1 , it means it is on the left side of diagonal line which prints 0
        }else if((i+j) < n - 1){
          theout.print("0");
        }else{
        // if i+j is less than n - 1 , it means it is on the left side of diagonal line which prints 2
          theout.print("2");
         }
         if (j != n-1){
           theout.print(",");
         }
      }
      // goes to the next line
      theout.println("");
    }
    // the file closes
    theout.close();
  }
}
