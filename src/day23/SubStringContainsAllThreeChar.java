package day23;

import java.util.Arrays;
import java.util.HashMap;

public class SubStringContainsAllThreeChar {
    public static int min(int[] arr){
        int least = Integer.MAX_VALUE;
        for (int i = 0;i<arr.length;i++){
            least = Math.min(least,arr[i]);
        }
        return least;
    }

    public static int numberOfSubstrings(String s) {
        int count = 0;

        int[] arr = new int[3];
        Arrays.fill(arr, -1);

        for (int i =0;i<s.length();i++){
            int currIdx = s.charAt(i)-'a';
            arr[currIdx] = i;
            count += min(arr)+1;
        }
        return count;



    }

    public static void main(String[] args) {
        String str = "abcabc";
        int ans = numberOfSubstrings(str);
        System.out.println(ans);
    }
}