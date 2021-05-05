//package gr11review.part2;
import java.io.*;
import java.util.Scanner;
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
    // I wanted to use a recursive binary search but I kinda gave up
    /*private static int binarySearch(int l, int r, int x, int comparisons, int[] num){
	    if (r >= l){
			int mid = l + (r - l) / 2;
			if (num[mid] == x){
				return comparisons;
			}
			if (num[mid] > x){
				return binarySearch(l, mid - 1, x, comparisons + 1, num);
			}
			return binarySearch(mid + 1, r, x, comparisons + 1, num);
		}
		return -1;
	}*/
}
