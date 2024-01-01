package day21_Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class longestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();

        int l = 0,r = 0;

        while (r<s.length()){
            char ch = s.charAt(r);
           if (map.containsKey(ch)){
               l = Math.max(l,map.get(ch) + 1);
           }
           map.put(ch,r);
           max = Math.max(max,(r-l+1));
           r++;
        }
        return max;



    }
    public static void main(String[] args) {
        String str = "abcaaefgabdes";
        int ans = lengthOfLongestSubstring(str);
        System.out.println(ans);

    }
}