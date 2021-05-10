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
}
