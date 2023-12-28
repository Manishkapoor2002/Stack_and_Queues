package day17;

import java.util.Stack;

public class largestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(heights.length == 1){
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
//        finding prev smallest idx :
        for (int i = 0;i<n;i++){
            int curr = heights[i];
            while (!stack.empty() && heights[stack.peek()]>=curr){
                stack.pop();
            }
            if (stack.empty()){
                left[i] = -1;
            }else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

//        finding the next smallest idx:


        for (int i = n-1;i>=0;i--){
            int curr = heights[i];
            while (!stack.empty() && heights[stack.peek()]>=curr){
                stack.pop();
            }
            if (stack.empty()){
                right[i] = n;
            }else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        int maxArea = Integer.MIN_VALUE;


        for (int i = 0;i<n;i++){
            int currArea = heights[i] * ((i - left[i]) + (right[i] - i) - 1);
            maxArea = Math.max(maxArea,currArea);
        }

        return maxArea;


    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int ans = largestRectangleArea(arr);
        System.out.println(ans);
    }
}