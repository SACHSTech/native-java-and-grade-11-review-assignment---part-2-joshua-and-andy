package gr11review.part2;
import java.io.*;

public class Utility {
  public static int sumNumbers(String str){
    int wordLength;
    int number;
    wordLength = str.length();
    for (int count = 0; count < wordLength; count++){
      char digit = str.charAt(count);
      if (Character.isDigit(digit) == true){
       int Start 
         
     }
    }
  }
    public static int[] notAlone(int[] nums, int value){
     int myArray[] = new int [nums.length];
     if (nums.length >= 1){
            myArray[0] = nums[0];
            myArray[nums.length - 1] = nums[nums.length - 1];
    }
    for (int count = 1; count < nums.length - 1; count++){
     if (nums[count] == value && nums[count] != nums[count+1] && nums[count] != nums[count-1]){
       myArray[count] = Math.max(nums[count+1], nums[count-1]);
      }else {
        myArray[count] = nums[count];
     }
    }
    return myArray;
  }
  public static boolean canBalance(int[] nums){
    int LeftSum = 0;
    int rightSum = 0;
    int count;
    int countAlt;
    for (count = 0; count < nums.length; count++){
      leftSum += nums[count];
      rightSum = 0;
      for (countAlt = nums.length - 1; countAlt > count; countAlt--){
        rightSum += nums[countAlt];
      }
    }
  }
}

