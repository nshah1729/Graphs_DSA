import java.lang.reflect.*;
import java.util.*;

public class sfg {
    public static void main(String[] args) {
//        String blocks = "WBBWWBBWBW";int k = 7;
//        String s = "0110101";
        String s = "abc"; int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
//        System.out.println(minimumRecolors(blocks,k));
//        System.out.println(secondsToRemoveOccurrences(s));
        System.out.println(shiftingLetters(s,shifts));
    }
    public static int minimumRecolors(String Blocks, int k) {
        int n=Blocks.length();
        char[] blocks=Blocks.toLowerCase().toCharArray();
        int b=0,w=0;
        for (int i = 0; i < k; i++) {
            if(blocks[i]=='w')w++;
            else b++;
        }
        int min=w;
        for (int i = k; i < n; i++) {
            if(blocks[i-k]=='w')w--;
            else b--;
            if(blocks[i]=='w')w++;
            else b++;
            min=Math.min(min,w);
        }
        return min;
    }

    public static int secondsToRemoveOccurrences(String S) {
        int ans=0;
        char[] s=S.toCharArray();
        while(String.valueOf(s).contains("01")){
            for (int i = 0; i < s.length-1; i++) {
                if(s[i]=='0'&&s[i+1]=='1'){
                    s[i]='1';
                    s[i+1]='0';
                    i++;
                }
            }
            ans++;
        }
        return ans;
    }

    public static String shiftingLetters(String S, int[][] shifts) {
        char[] s=S.toCharArray();
        StringBuilder sb=new StringBuilder();
        int n=s.length;
        char[] ans=new char[n];
        for (int i = 0; i < s.length; i++) {

        }
        return "";
    }
}
