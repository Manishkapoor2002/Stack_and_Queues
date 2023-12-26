package day15;

import java.util.Stack;

public class nextGreaterElement2 {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i =  2*n;i>=0;i--){
            while (!stack.empty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }

            if (stack.empty()){
                ans[i%n] = -1;
            }else {
                ans[i%n] = stack.peek();
            }

            stack.push(nums[i%n]);
        }

        return ans;

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] ans = nextGreaterElements(nums);
        for (int i : ans){
            System.out.print(i + " , ");
        }
    }
}