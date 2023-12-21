package day10;
public class implementingQueueInArray {
    public static void main(String[] args) {

    Queue q = new Queue();
        q.push(1);
        q.push(1);
        q.push(1);
        q.push(1);
        q.size();
        q.push(1);
        q.push(1);
        q.printAllElements();
        q.pop();
        q.pop();
        q.size();
        q.pop();
        q.pop();
        q.push(2);
        q.push(3);
        q.size();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.size();

    q.printAllElements();

    }
}

class Queue{
    int[] arr = new int[5];
    int count = 0;
    int first = 0;
    int last = 0;

    void push(int num){
        if(count<arr.length){
            arr[last%arr.length] = num;
            count++;
            last++;
        }else {
            System.out.println("Queue is full!!");
        }
    }

    void pop(){

        if (first != last && count>0){

            if (first == arr.length) {
                first = 0;
            }
            System.out.println(arr[first] +" is removed");

            arr[first] = 0;
            first++;
            count--;
        }else {
            first = 0;
            last =0;
            System.out.println("Queue is Empty!!");
        }
    }

    void peak(){
        System.out.println(arr[first]);
    }

    void printAllElements(){
        System.out.println(first + "<->" +last);
        for (int i = first;i<last;i++){
            System.out.print(arr[i%arr.length] + " , ");

        }
    }
    void size(){

        System.out.println(count);
    }
}