package Queue.Basics;

import java.util.LinkedList;

public class Q_4_LinkedListImplementation {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
    public static class queueLinkedList{
      Node head;
      Node tail;
      private static int size;
      void add(int val){
          Node t = new Node(val);
          if(head == null){
              head = tail = t;
          }
          else {
              tail.next = t;
              tail = t;
          }
          size++;
      }

      int remove(){
          int ele = head.data;
          head  = head.next;
          size--;
          return ele;
      }

      void display(){
          Node temp = head;
          while(temp!=null){
              System.out.print(temp.data + " ");
              temp = temp.next;
          }
          System.out.println();
      }

      int peek(){
          return head.data;
      }

      int size(){
          return size;
      }
    }
    public static void main(String[] args) {
        queueLinkedList q = new queueLinkedList();
        q.add(10);
        q.add(11);
        q.add(12);
        q.add(13);
        q.display();

        q.remove();
        q.display();

        System.out.println(q.size());
        System.out.println(q.peek());
    }
}
