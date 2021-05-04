//package gr11review.part2;
import java.io.*;

public class Utility {

    public static String zipZap(String str){
        for(char i='a';i<'z';i++){
            str = str.replaceAll("z"+String.valueOf(i)+"p", "zp");
        }
        return str;
    }
}
