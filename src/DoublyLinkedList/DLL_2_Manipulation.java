package DoublyLinkedList;

public class DLL_2_Manipulation {
    public static class Node {
        Node prev;
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        static Node insertAtBeginning(Node head, int value){
            Node a = new Node(value);
            a.prev = null;
            a.next = head;
            head.prev = a;
            head = a;

            return head;
        }

        //if head / any other node is given, reach till tail first
        static Node insertAtEnd(Node head, int value){
            Node a = new Node(value);
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next; //reach till tail.
            }

            a.next = null;
            temp.next = a;
            a.prev = temp;
            temp = a;

            return head;
        }

        static Node insertAt(Node head, int val, int idx){
            if(idx == 0) return insertAtBeginning(head, val);
            Node a = new Node(val);
            Node temp = head;
            for(int i = 1; i<idx; i++){
                temp = temp.next;
            }

            a.next = temp.next;
            temp.next = a;
            a.next.prev = a;
            a.prev = temp;

            return head;
        }

        //deletion at any given node:
        static Node deleteAt(Node head, int idx){
            Node temp = head;
            for(int i = 1; i<=idx; i++){
                temp = temp.next;
            }

            Node t1 = temp.prev;
            Node t2 = temp.next;

            t1.next = t2;
            t2.prev = t1;

            return head;
        }
        static void display(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
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

        System.out.print("After inserting at the beginning: ");
        Node.display(Node.insertAtBeginning(a, 33));

        System.out.print("After inserting at the end: ");
        Node.display(Node.insertAtEnd(a, 99));

        System.out.print("Insert 100 at index 2: ");
        Node.display(Node.insertAt(a, 100, 2));

        System.out.print("Delete at index 2: ");
        Node.display(Node.deleteAt(a, 2));

    }
}
