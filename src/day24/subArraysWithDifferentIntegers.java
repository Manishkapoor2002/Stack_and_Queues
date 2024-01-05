package day24;

import java.util.HashMap;

public class subArraysWithDifferentIntegers {

    public static int atMostElement(int[] arr,int k){
        int left =0,count=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }


            while (map.size()>k){
                map.put(arr[left],map.get(arr[left])-1);
                if (map.get(arr[left])<=0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            count += (i-left+1);
        }

        return count;
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {

        return atMostElement(nums,k) - atMostElement(nums,k-1);

    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4};
        int k = 3;
        int ans = subarraysWithKDistinct(arr,k);
        System.out.println(ans);

    }
}