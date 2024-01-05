package day24;

import java.util.HashMap;
import java.util.Objects;

public class minimumWindowSubString {

    public static String subString(String s,int i,int j){
        StringBuilder str = new StringBuilder();
        while (i<=j){
            str.append(s.charAt(i));
            i++;
        }

        return str.toString();

    }

    public static String minWindow(String s, String t) {

//        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();

        for (int i = 0;i<t.length();i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0)+1);
        }

        int need = mapT.size();
        int have = 0;
        int start = 0,end = 0,left =0;
        int length = Integer.MAX_VALUE;

//        for (int right = 0;right<s.length();right++){
//            char ch = s.charAt(right);
//            if (mapT.containsKey(ch)){
//                mapS.put(ch, mapS.getOrDefault(ch,0)+1);
//                if (mapT.get(ch).equals(mapS.get(ch))) {
//                    have++;
//                }
//
//
//                while (need == have){
//                    int tempLength =right-left+1;
//
//                if (length>(tempLength)){
//                    start = left;
//                    end = right;
//                    length = tempLength;
//                }
//
//                    if (mapT.containsKey(s.charAt(left))){
//                        mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);
//
//                        if (mapS.get(s.charAt(left)) < mapT.get(s.charAt(left))) {
//                            have--;
//                        }
//
//                        if (mapS.get(s.charAt(left)) <= 0) {
//                            mapS.remove(s.charAt(left));
//                        }
//                    }
//
//                    left++;
//                }
//
//
//            }
//        }

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if (mapT.containsKey(ch)){
                mapT.put(ch,mapT.get(ch)-1);
                if (mapT.get(ch) == 0){
                    have++;
                }

                while (need == have){
                   int tempLength = (i-left+1);
                    if (length>tempLength){
                        start = left;
                        end = i;
                        length = tempLength;
                    }

                    if (mapT.containsKey(s.charAt(left))){
                        mapT.put(s.charAt(left),mapT.get(s.charAt(left))+1);
                        if (mapT.get(s.charAt(left))>0){
                            have--;
                        }
                    }
                    left++;
                }
            }
        }

        if (length == Integer.MAX_VALUE){
            return "";
        }else {
            return subString(s,start,end);
        }



    }
    public static void main(String[] args) {
        String str ="aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        String ans = minWindow(str,t);
        System.out.println(ans);
    }
}
