package day11;

import java.util.Stack;

public class implementingQueuesUsingStack {
    public static void main(String[] args) {

        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        System.out.println(mq.peek());
        System.out.println(mq.empty());
        System.out.println(mq.pop());
        System.out.println(mq.pop());
        System.out.println(mq.peek());
    }
}

class MyQueue {


    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
     MyQueue() {

    }

     void push(int x) {
        input.add(x);
    }

     int pop() {

         if (output.empty()){
             while (!input.empty()){
                 int temp = input.peek();
                 output.add(temp);
                 input.pop();
             }
         }

         int temp = output.peek();
         output.pop();
         return temp;


    }

     int peek() {
         if (output.empty()){
             while (!input.empty()){
                 int temp = input.peek();
                 output.add(temp);
                 input.pop();
             }
         }

         return output.peek();

     }

     boolean empty() {

         return (input.empty() && output.empty());

    }
}