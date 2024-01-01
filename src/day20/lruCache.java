package day20;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class lruCache {
    public static void main(String[] args) {
        System.out.println("manish kapoor");

//        [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]

        l1 l = new l1(2);
        l.put(2,1);
        l.put(2,2);
        System.out.println(l.get(2));
        l.put(1,1);
        l.put(4,1);
        System.out.println(l.get(2));



    }
}


class Node {

    int data;
    int k;
    Node next;
    Node prev;

    Node(int key,int val) {
        k = key;
        data = val;
        next = null;
        prev = null;
    }

}
class l1 {

    HashMap<Integer,Node> map;
    Node LRU;
    Node MRU;
    int capacity;
    l1(int capacity) {
        this.capacity = capacity;
         map = new HashMap<>();
//         left node:
         LRU = new Node(-1,-1);
//         right Node:
         MRU = new Node(-1,-1);

         LRU.next = MRU;
         MRU.prev = LRU;

     }


//     remove:
    void remove(Node curr){
        map.remove(curr.k);

        Node N = curr.next;
        Node P = curr.prev;

        P.next = N;
        N.prev = P;

    }


//    insert: just before MRU

    void insert(int key,int val){
    Node curr = new Node(key,val);
    map.put(key,curr);

    Node pre = MRU.prev;
    pre.next = curr;
    curr.prev = pre;
    curr.next = MRU;
    MRU.prev = curr;


    }


     int get(int key) {
        if (map.containsKey(key)){
            int tempVal = map.get(key).data;
            remove(map.get(key));
            insert(key,tempVal);
            return tempVal;
        }else {
           return  -1;
        }

    }

     void put(int key, int value) {
        if (map.containsKey(key)){
//            map.get(key).data = value;
            remove(map.get(key));
        }

            if (map.size()==capacity){
                map.remove(LRU.next.k);
                remove(LRU.next);
            }

            insert(key,value);

    }
}
