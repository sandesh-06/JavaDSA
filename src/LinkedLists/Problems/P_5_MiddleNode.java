package LinkedLists.Problems;

public class P_5_MiddleNode {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //FOR ODD ELEMENTS
    //LL: 1 3 5 7 9 - the middle is 5
    //FOR EVEN: LL: 1 3 5 7 9 11 - left middle is 3 and right middle is 5. FIND BOTH
    public static Node leftMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

        /*
            FOR ODD ELEMENTS STOP AT TAIL.
            LL: 1 3 5 7 9 null      1 3 5 7 9 null      1 3 5 7 9 null
                s                     s f                   s   f
                f

            FOR EVEN ELEMENTS (LEFT MIDDLE), stop at fast.next.next = null
            LL: 1 3 5 7 9 11 null     1 3 5 7 9 11 null    1 3 5 7 9 11 null
                s                       s f                    s   f
                f

        */
    }

    public static Node rightMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

        /*
            FOR ODD IT'S THE SAME

            FOR EVEN ELEMENTS (RIGHT MIDDLE), stop when fast = null
            1 3 5 7 9 11 null     1 3 5 7 9 11 null    1 3 5 7 9 11 null    1 3 5 7 9 11 null
            s                       s f                    s   f                  s        f
        */

    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);
        Node e = new Node(9);
        Node f = new Node(11);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

       //PRINT LEFT MIDDLE FOR EVEN
        System.out.println("Left middle is: " + leftMiddle(a).data);

        //PRINT RIGHT MIDDLE FOR EVEN
        System.out.println("Right middle is: " + rightMiddle(a).data);

    }
}
