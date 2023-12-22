package day11;

import java.util.Stack;

public class vaildParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0;i<s.length();i++){

//            adding in stack id done:
            char curr = s.charAt(i);
            if(curr == '('){
                stack.add(curr);
            }else if (curr == '{'){
                stack.add(curr);
            } else if (curr == '[') {
                stack.add(curr);
            }


//            checking and validating:

            if (stack.empty()){
                return false;
            }else {
                char ch  = stack.peek();
                if (curr == ')'){
                    if (ch != '(') return false;
                    stack.pop();

                }else  if (curr == '}'){
                    if (ch != '{') return false;
                    stack.pop();

                }else  if (curr == ']'){
                    if (ch != '[') return false;
                    stack.pop();

                }
            }

        }

        return true;

    }
    public static void main(String[] args) {
        String str = "{[]}";
        System.out.println(isValid(str));
    }
}