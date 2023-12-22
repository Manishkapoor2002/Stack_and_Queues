package day11;

import java.util.LinkedList;
import java.util.Queue;

public class implementingStackUsingQueue {
    public static void main(String[] args) {

        MyStack ms = new MyStack();

        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.pop());
        System.out.println(ms.top());
        System.out.println(ms.pop());


    }
}
//using 2 Queues: -
//class MyStack {
//
//
//    Queue<Integer> q1 = new LinkedList<>();
//    Queue<Integer> q2 = new LinkedList<>();
//
//
//    void MyStack() {
//
//    }
//
//
//
//
//     void push(int x) {
//        q2.add(x);
//        while(!q1.isEmpty()){
//            int temp = q1.peek();
//            q2.add(temp);
//            q1.poll();
//        }
//
//        while (!q2.isEmpty()){
//            int temp = q2.peek();
//            q1.add(temp);
//            q2.poll();
//        }
//    }
//
//     int pop() {
//        int temp= q1.peek();
//        q1.poll();
//        return temp;
//
//     }
//
//     int top() {
//
//        return q1.poll();
//
//    }
//
//    boolean empty() {
//        return q1.isEmpty();
//
//    }
//}


//using 1 queues: -
class MyStack {


    Queue<Integer> q1 = new LinkedList<>();

    void MyStack() {

    }




    void push(int x) {
        if (q1.isEmpty()){
            q1.add(x);
        }else {
            q1.add(x);
            for (int i = 0;i<q1.size()-1;i++){
                q1.add(q1.peek());
                q1.poll();
            }
        }

    }

    int pop() {
        int temp = q1.peek();
        q1.poll();
        return temp;


    }

    int top() {

    return q1.peek();

    }

    boolean empty() {

        return q1.isEmpty();


    }
}