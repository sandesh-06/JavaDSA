package Queue.Basics;

import java.util.LinkedList;
import java.util.Queue;

public class Q_2_PrintQueue {
    static void printQueue(Queue<Integer> q){
        Queue<Integer> temp = new LinkedList<>();
        while(!q.isEmpty()){
            int ele = q.remove();
            System.out.print(ele + " ");
            temp.add(ele);
        }
        System.out.println();
        while (!temp.isEmpty()){
            q.add(temp.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        printQueue(q);
        System.out.println(q);
    }
}
