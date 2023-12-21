package day10;

import java.util.LinkedHashSet;
import java.util.LinkedList;

//LIFO DataStructure:
public class implementingStackInArray {



    public static void main(String[] args) {

        stack s = new stack();
//        top();
        s.empty();
    }
}

class stack{
     int[] arr = new int[10];
     int top = -1;


    void push(int num){
        top++;
        if (top< arr.length){
            arr[top] = num;
        }else {
            System.out.println("Stack out of bound");
        }
    }

     void top(){
        if (top>=0){
            System.out.println(arr[top]);
        }else {
            System.out.println("Stack is empty!!");
        }
    }


    void size(){
        System.out.println(top+1);
    }


     void pop(){
        if (top >= 0) {
            System.out.println(arr[top] +" is removed from stack!!");
            arr[top] = 0;
            top--;
        }else {
            System.out.println("Stack is empty!!");
        }
    }

     void empty(){
        if(top == -1){
            System.out.println("Yes Stack is empty!!");
        }else {
            System.out.println("No !!");
        }
    }

}
