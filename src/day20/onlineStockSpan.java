package day20;

import java.util.Stack;

public class onlineStockSpan {
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();

        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));



    }
}

class StockSpanner {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

     StockSpanner() {

    }

     int next(int price) {
         int defaultCount = 1;

        while (!s1.empty() && s1.peek()<=price){
            s1.pop();
            int tempSpan = s2.peek();
            defaultCount += tempSpan;
            s2.pop();
        }
        s1.push(price);
        s2.push(defaultCount);

        return defaultCount;

    }
}