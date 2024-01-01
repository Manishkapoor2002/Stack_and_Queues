package day21_Sliding_Window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class maxConsecutiveOnes3{

    public static int longestOnes(int[] nums, int k) {

        if (k == 0){
//checking if there are some 1's if not return 0 else calculate!!
            boolean flag =false;

            for(int i : nums){
                if( i == 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return 0;


            int count = 0;
            int currMax = 1;
            for (int i = 0;i<nums.length-1;i++){
                if (nums[i] == 1 && nums[i+1] == 1){
                    count++;
                    currMax = Math.max(currMax,count+1);
                }else {
                    count = 0;
                }

            }
            return currMax;
        }
        Queue<Integer> q = new LinkedList<>();
        int max = 0;

        int zeroCount = 0;
        int l = 0,r=0;

        while (r<nums.length){
            if (q.size()<k){
                if (nums[r] == 0){
                    q.add(r);
                }
                max = Math.max(max,(r-l) + 1);
                r++;
            }else {
                if (nums[r] == 0){
                    l = q.remove() + 1;
                    max = Math.max(max,(r-l) + 1);
                }else {
                    max = Math.max(max,(r-l) + 1);
                    r++;
                }
            }

        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,0};
        int k = 4;
        int ans =longestOnes(nums,k);
        System.out.println(ans);

    }
}