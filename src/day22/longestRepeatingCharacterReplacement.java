package day22;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class longestRepeatingCharacterReplacement {

    public static int maxFreq(int[] arr){
        int max = 0;
        for (int i = 0;i<arr.length;i++){
            if (max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static int characterReplacement(String s, int k) {

        int l =0,max=0;
        int[] arr = new int[26];

        for (int i = 0;i<s.length();i++){
            int currInt = s.charAt(i) - 'A';
            arr[currInt]++;

            while ((i-l+1) - maxFreq(arr) > k){
                arr[s.charAt(l) - 'A']--;
                l++;
            }

            max = Math.max(max,(i-l+1));

        }

        return max;
    }
    public static void main(String[] args) {
        String str = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int k = 4;
        int ans = characterReplacement(str,k);
        System.out.println(ans);
    }
}