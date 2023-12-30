package day19;

import java.util.Stack;

public class maximalRectangle {

    public static int maxArea(int[] baseArray){
        int max = 0;
        Stack<Integer> s = new Stack<>();
        int[] leftArea = new int[baseArray.length];
        int[] rightArea = new int[baseArray.length];

//            left Area calculate:

        for (int k = 0;k<baseArray.length;k++){
            while (!s.empty() && baseArray[s.peek()]>=baseArray[k]){
                s.pop();
            }
            if(s.empty()){
                leftArea[k] = -1;
            }else {
                leftArea[k] = s.peek();
            }
            s.push(k);
        }

        s.clear();

//            right Area calculate:

        for (int k= baseArray.length-1;k>=0;k--){
            while (!s.empty() && baseArray[s.peek()]>=baseArray[k]){
                s.pop();
            }
            if(s.empty()){
                rightArea[k] = baseArray.length;
            }else {
                rightArea[k] = s.peek();
            }
            s.push(k);
        }

//            calculating next Area:


        for (int l =0;l< baseArray.length;l++){
            if (baseArray[l]!= 0){
                int area  = baseArray[l] * (l - leftArea[l] + rightArea[l] - l - 1);
                max = Math.max(max,area);
            }

        }

        return max;

}

    public static int maximalRectangle(char[][] matrix) {
        int max = -1;
        int[] baseArray = new int[matrix[0].length];

        for(int i = 0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int num = matrix[i][j] - '0';
                if (num == 0) {
                    baseArray[j] = 0;
                } else {
                    baseArray[j] += num;
                }
            }
            int area = maxArea(baseArray);
            max = Math.max(max,area);
        }


        return max;

    }
    public static void main(String[] args) {
        char[][] arr = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int ans = maximalRectangle(arr);
        System.out.println(ans);
    }
}