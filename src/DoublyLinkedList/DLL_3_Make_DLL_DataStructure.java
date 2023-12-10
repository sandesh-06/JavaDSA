package DoublyLinkedList;

import java.util.Scanner;

public class DLL_3_Make_DLL_DataStructure {
        public static class Node{ //USER DEFINED DATA TYPE
            Node prev;
            int data;
            Node next;

            public Node(){}
            public Node(int data){
                this.data = data;
            }
        }

        public static class DoublyLinkedList{ //USER DEFINED DATA STRUCTURE
            Node head;
            Node tail;

            public DoublyLinkedList(){
                this.head = null;
                this.tail = null;
            }

            void add(int val){
                Node new_node = new Node(val);

                if(head == null){
                    head = tail = new_node;
                    head.prev = null;
                    tail.next = null;
                }
                else{
                    tail.next = new_node;
                    new_node.prev = tail;
                    tail = new_node;
                    tail.next = null;
                }
            }

            void display(){
                Node temp = head;
                while(temp!=null){
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();
            }

            void deleteAtBeginning(){
                head = head.next;
                head.prev = null;
            }
        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            DoublyLinkedList dl = new DoublyLinkedList();

            // dl.add(99);
            // dl.add(88);
            // dl.add(77);

            int n = sc.nextInt();

            //get inputs
            while(n>0){
                dl.add(sc.nextInt());
                n--;
            }

            dl.deleteAtBeginning();
            dl.display();

        }
}
