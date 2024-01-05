package day24;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class longestSubsTringWithKMostElements {

    public static int kDistinctChars(int k, String str) {
        int left =0,ans =-1;
        HashMap<Character,Integer> map = new HashMap<>();

        for (int right = 0;right<str.length();right++){
            char ch = str.charAt(right);
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }

                while (map.size()>k){
                    map.put(str.charAt(left),map.get(str.charAt(left))-1);

                    if (map.get(str.charAt(left))==0){
                        map.remove(str.charAt(left));
                    }
                    left++;
                }

                ans = Math.max(ans,(right-left+1));
        }


        return ans;
    }
    public static void main(String[] args) {
        int k = 6;
        String str = "zcviqwyuydegijtgwxujqdn";
        int ans = kDistinctChars(k,str);
        System.out.println(ans);
    }
}