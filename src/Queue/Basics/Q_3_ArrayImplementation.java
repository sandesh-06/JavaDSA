package Queue.Basics;

import java.util.Queue;

public class Q_3_ArrayImplementation {
    public static class queue{
        int[] arr = new int[10];
        int front = -1;
        int rear = -1;
        private static int size = 0;
        public queue(){}

        void add(int data){
            if(rear == arr.length-1){
                System.out.println("The queue is full");
                return;
            }
           else if(front == -1){ //inserting first element
               rear = front = 0;
               arr[rear] = data;
           }
           else{
               arr[++rear] = data;
           }

           size++;
        }

        int peek(){
            return arr[front];
        }
        int remove(){
            int ele = arr[front];
            front++;
            size--;
            return ele;
        }

        void display(){
            for(int i = front; i<=rear; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        int size(){
            return size;
        }
    }
    public static void main(String[] args) {
        queue q = new queue();
        q.add(10);
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.display();

        q.remove();
        q.display();

        System.out.println(q.size());
    }
}
