package LinkedLists.Problems;



public class P_9_SplitOddEven {

    public static class Node{
        int data;
        Node next;
        //creating a constructor to set the data value
        public Node(int data){
            this.data = data;
        }
    }

    public static void recursionDisplayLL(Node head){
        if(head == null)return;
        System.out.print(head.data + " -> ");
        recursionDisplayLL(head.next);
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        recursionDisplayLL(a);
        System.out.println();
        Node odd = new Node(100);
        Node even = new Node(100);
        Node odd_temp = odd;
        Node even_temp = even;
        Node temp = a;

        while(temp!=null){
            if(temp.data % 2 != 0){
                odd_temp.next = temp;
                odd_temp = temp;
                temp = temp.next;
                odd_temp.next = null;
            }
            else{
                even_temp.next = temp;
                even_temp = temp;
                temp = temp.next;
                even_temp.next = null;
            }
        }

        recursionDisplayLL(odd.next);
        System.out.println();
        recursionDisplayLL(even.next);
    }
}
