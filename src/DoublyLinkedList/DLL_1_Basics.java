package DoublyLinkedList;

public class DLL_1_Basics {

    /*
            DOUBLY LINKED LIST:
            LL: null <=> 3 <=> 2 <=> 7 <=> 13 <=> 9 <=> null

            IT OVERCOMES THE LIMITATION OF SINGLY LINKED LIST. EACH NODE IS CONNECTED TO THE NEXT NODE AND PREV NODE AS WELL.

    */
    public static class Node{
        Node prev;
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }

        static void display(Node head){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        static void displayRev(Node tail){
            Node temp = tail;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
            System.out.println();
        }

        static void displayFromNode(Node random_node){
            Node temp = random_node;
            //move the temp from random_node to head. Head is the only node which will have null as prev, and tail will have next has null.
            while(temp.prev!=null){
                temp = temp.prev;
            }

            //now using the head node print the list.
            display(temp);
        }
    }
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(2);
        Node c = new Node(7);
        Node d = new Node(13);
        Node e = new Node(9);

        //declaring next nodes
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        //declaring prev nodes
        a.prev = null;
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;

        Node.display(a);
        Node.displayRev(e);
        Node.displayFromNode(d); //give any random node

    }
}
