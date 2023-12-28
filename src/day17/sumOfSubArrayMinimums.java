//not done yet
//not clear all test cases:


package day17;

import java.util.Stack;

public class sumOfSubArrayMinimums {

    static int mod = 1000000007;
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        stack.push(0);
        left[0] = 1;
        for (int i = 1;i<n;i++){
            int curr = arr[i];
            while (!stack.empty() && arr[stack.peek()]>curr){
                stack.pop();
            }

            if (stack.empty()){
                left[i] = i + 1;
            }else {
                left[i] = i - stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        stack.push(n-1);
        right[n-1] = 1;

        for (int i = n-2;i>=0;i--){
            int curr = arr[i];

            while (!stack.empty() && arr[stack.peek()]>curr){
                stack.pop();
            }

            if (stack.empty()){
                right[i] = n - i;
            }else {
                right[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        long res = 0;
        for (int i = 0;i<n;i++){
            long prod = (long) (left[i] * right[i]) % mod;
            long net = (long) arr[i] * prod;
            res = (res + net) % mod;
        }

        return (int)res;

    }
    public static void main(String[] args) {
        int[] arr = {71,55,82,55};
        int ans = sumSubarrayMins(arr);
        System.out.println(ans);
    }
}