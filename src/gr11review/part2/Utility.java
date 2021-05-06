//package gr11review.part2;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;  
public class Utility {
    public static String zipZap(String str){
        for(char i='a';i<'z';i++){
            str = str.replaceAll("z"+String.valueOf(i)+"p", "zp");
        }
        return str;
    }
    public static String longestWord(String filenametxt) throws IOException{
        String data,word="";
        BufferedReader br = new BufferedReader(new FileReader(filenametxt));
        while((data=br.readLine())!=null)
            if(data.length()>word.length())
                word=data;
        br.close();
        return word;
    }
    public static int[] tenRun(int[] nums){
        int multiple=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]%10) == 0)
                multiple=nums[i];
            else if(multiple>0)
                nums[i]=multiple;
        }
        return nums;
    }
    public static boolean linearIn(int[] outer, int[] inner){
        int found=inner.length,count=0;
        for(int i=0;i<outer.length;i++)
            if(count<inner.length&&outer[i]==inner[count]){
                count++; 
                found--;
            } 
        if(found==0)
            return true;
        return false;
    }
    public static void pascalTri(int i, int j){
        int[][] triangle = new int[j][i];
        for(int rcx=0;rcx<i;rcx++){
            for(int ecx=0;ecx<j;ecx++){
                if(ecx==0||rcx==0)
                    triangle[ecx][rcx]=1;
                else
                    triangle[ecx][rcx] = triangle[ecx-1][rcx]+triangle[ecx][rcx-1];
                System.out.print(triangle[ecx][rcx]);
                if(ecx!=j-1)
                    System.out.print(",");
            }
            System.out.println("");
        }
    }
}
