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
}
