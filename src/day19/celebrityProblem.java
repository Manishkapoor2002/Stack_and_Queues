package day19;

import java.util.Stack;

public class celebrityProblem {

    private static boolean know(int[][] arr,int a,int b){
        return arr[a][b] == 1;
    }
    public static int celebrity(int[][] arr,int n){
        Stack<Integer> s = new Stack<>();

        for (int i = 0;i<n;i++){
            s.push(i);
        }

        while (s.size() > 1){
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();

            if (know(arr,a,b)){
                s.push(b);
            }else {
                s.push(a);
            }
        }


        int candidate = s.peek();

//        checking row:

        for (int i = 0;i<n;i++){
            if (arr[candidate][i] == 1){
                return -1;
            }
        }

//        checking cols:
        for (int i = 0;i<n;i++){
            if (i != candidate && arr[i][candidate] == 0){
                return -1;
            }
        }

        return candidate;


    }
    public static void main(String[] args) {
        int[][] arr= {{0,1,0},{0,0,0},{0,1,0}};
        int n = 3;
        int ans = celebrity(arr,n);
        System.out.println(ans);
    }
}