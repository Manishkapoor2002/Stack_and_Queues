package day18;

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {

       Stack<Integer> s = new Stack<>();

       for (int i = 0;i<num.length();i++){
           int n = num.charAt(i) - '0';
           while (!s.empty() && k>0 && s.peek()>n){
               k--;
               s.pop();
           }
           s.push(n);
       }

       while (k>0) {
           s.pop();
           k--;
       }

       StringBuilder ans = new StringBuilder();

        for (int i : s){
            ans.append(i);
        }

        int a = 0;
        for (int i = 0;i<ans.length();i++){
            a = a*10 + (ans.charAt(i) - '0');
        }
        ans = new StringBuilder(String.valueOf(a));

        if (ans.toString().isEmpty()){
            return "0";
        }else {
          return ans.toString();
        }

    }
    public static void main(String[] args) {
        String str = "1200345000";
        int k = 1;
        String ans = removeKdigits(str,k);
        System.out.println(ans);

    }
}