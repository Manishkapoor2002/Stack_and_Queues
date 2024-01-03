package day23;

import java.util.HashMap;

public class countNiceNumber {

    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums){
            sum +=i;


            if (sum == k) count++;

            if (map.containsKey(sum-k)){
                count += map.get(sum-k);
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
        int[] arr = {1,1,2,1,1};
        int k = 3;
        int ans =numberOfSubarrays(arr,k);
        System.out.println(ans);
    }
}