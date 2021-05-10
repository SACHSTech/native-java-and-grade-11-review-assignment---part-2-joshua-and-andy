//package gr11review.part2;
import java.io.*;
public class Main{

    public static void main(String[] args) throws IOException{

        // Methods 1
        System.out.println(Utility.zipZap("zipXzap"));

        // File IO - Read 1
        System.out.println(Utility.longestWord("words.txt"));

        // Array 1 - One Dimensional
        int ar[]= {2, 10, 3, 4, 20, 5};
        ar = Utility.tenRun(ar);
        for(int i=0;i<ar.length;i++){
            System.out.println(ar[i]);
        }

        // Array 3 - One Dimensional - Two Loops
        int ar2[]= {1, 2, 4, 4, 6};
        int ar3[]= {2, 3, 4};
        System.out.println(Utility.linearIn(ar2,ar3));

        Utility.pascalTri(4,5);
    }
}