package LinkedLists.Problems;

public class P_11_RandomPointers {
    public static class Node{
        int val;
        Node next;
        Node random;
        //creating a constructor to set the data value
        public Node(int data){
            this.val = data;
        }
    }

    public static void recursionDisplayLL(Node head){
        if(head == null)return;
        System.out.print(head.val + " -> ");
        recursionDisplayLL(head.next);
    }
    public Node copyRandomList(Node list1) {

        //1. create a deep copy of the list:
        Node list2 = new Node(0); //create a new list with any head value

        //point temp1 - head of list1, temp2 - head of list2
        Node temp1 = list1;
        Node temp2 = list2;

        while(temp1!=null){
            Node n = new Node(temp1.val);
            temp2.next = n;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        list2 = list2.next;
        //shallow copy done.

        //2. create alternate connections between list1 and list2.
        Node temp = new Node(0);
        temp1 = list1;
        temp2 = list2;

        while(temp1!=null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        //alternate connection done.

        //3. assign random pointers in list2 just like list1.
        temp1 = list1;
        temp2 = list2;
        while(temp1!=null){
            if(temp1.random == null) temp2.random = null;
            else temp2.random = temp1.random.next;

            temp1 = temp1.next.next;
            temp2 = temp2.next.next;
        }
        //assinging random pointers done.

        //4. separate both the lists like before.
        temp1 = list1;
        temp2 = list2;

        while(temp1!=null){
            temp1.next = temp2.next;
            temp1 = temp1.next;

            if(temp1== null) break;
            temp2.next = temp1.next;
            if(temp2.next==null) break;
            temp2 = temp2.next;
        }

        return list2;
    }

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;




    }
}
