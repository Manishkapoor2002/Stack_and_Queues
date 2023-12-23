package day12;

import java.util.Map;
import java.util.Stack;

public class minStack{
    public static void main(String[] args){
        MinimumStack ms = new MinimumStack();

        ms.push(10);
        ms.push(11);
        ms.push(5);
        ms.push(2);
        ms.push(3);
        ms.push(100);
        ms.push(1);

        ms.top();
        ms.min();
        ms.pop();


    }
}


class MinimumStack{
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    int min = Integer.MAX_VALUE;

    void push(int x){
    input.add(x);
    min = Math.min(min,x);
    output.add(min);
    }
    void pop(){
        input.pop();
        output.pop();
    }
    void top(){
        System.out.print(input.peek());
    }

    void min(){
        System.out.println(output.peek());
    }
    boolean empty(){
        return input.empty();

    }

}