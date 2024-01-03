package day22;

import java.util.HashMap;


public class binaryWithSumK {

    public static int numSubarraysWithSum(int[] nums, int goal) {
    int count = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i : nums){
        sum +=i;


        if (sum == goal) count++;

        if (map.containsKey(sum-goal)){
            count += map.get(sum-goal);
        }

        if (!map.containsKey(sum)){
            map.put(sum,1);
        }else {
            map.put(sum,map.get(sum)+1);
        }
    }

    return count;

    }
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        int k = 0;
        int ans = numSubarraysWithSum(nums,k);
        System.out.println(ans);

    }
}