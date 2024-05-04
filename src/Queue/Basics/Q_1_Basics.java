package Queue.Basics;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q_1_Basics {
    public static void main(String[] args) {
        //declaration of STL Stack
        Stack<Integer> st = new Stack<>();

        //But declaration of STL Queue, is a bit different
//        Queue<Integer> q = new Queue<Integer>()  - this is not possible
        Queue<Integer> q = new LinkedList<>(); //this is how we are gonna use a queue
        Queue<Integer> q2 = new ArrayDeque<>(); //this is also valid

        //1. TO ADD ELEMENTS
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q);

        //2. TO REMOVE ELEMENTS
        q.remove(); //will the remove 1, as it was added first
        System.out.println(q);
        q.poll(); //will also remove element
        System.out.println(q);

        //3. TO KNOW THE TOP ELEMENT - (element in the front)
        System.out.println(q.peek());
        System.out.println(q.element()); //will also do the same

        //4. TO GET THE SIZE OF THE QUEUE
        System.out.println(q.size());

        //5. TO KNOW IF THE QUEUE IS EMPTY
        System.out.println(q.isEmpty());
    }
}
