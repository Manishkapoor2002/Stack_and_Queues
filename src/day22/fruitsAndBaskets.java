package day22;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class fruitsAndBaskets {

    public static int findMaxFruits(int []arr, int n) {
        int max = 2;
        if (n <= 2) return n;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0,total = 0;

        for (int i = 0;i<n;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
            total++;
                while (map.size()>2){
                    map.put(arr[l],map.get(arr[l])-1);
                    total--;
                    if (map.get(arr[l])<=0){
                        map.remove(arr[l]);
                    }
                    l++;


                }
            max = Math.max(max,total);
        }

        return max;


    }
    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        int n = nums.length;
        int ans = findMaxFruits(nums,n);
        System.out.println(ans);
    }
}