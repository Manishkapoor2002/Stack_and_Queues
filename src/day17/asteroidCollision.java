package day17;

import java.util.Stack;

public class asteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
      Stack<Integer> stack = new Stack<>();
//      stack.push(asteroids[0]);

        for (int curr : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && curr < 0) {
                int diff = stack.peek() + curr;
                if (curr<0) {
                    stack.pop();
                } else if (curr>0) {
                    curr = 0;
                } else {
                curr = 0;
                stack.pop();
                }
            }
          if (curr != 0){
                stack.push(curr);
          }


        }

      int[] ans = new int[stack.size()];
      int idx = 0;
      for (int st : stack){
          ans[idx] = st;
          idx++;
      }
      return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,-5,-8};
        int[] ans = asteroidCollision(arr);
        for (int i : ans){
            System.out.print(i +" , ");
        }
    }
}