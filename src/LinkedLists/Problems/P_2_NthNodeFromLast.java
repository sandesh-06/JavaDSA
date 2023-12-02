package LinkedLists.Problems;


public class P_2_NthNodeFromLast {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node bruteForce(Node head, int n){
        int size = 0;
        Node temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        //from start is 1 2 3 4 5 6
        //from end   is 6 5 4 3 2 1
        //the formula is (m-n+1) - m: total elements, n: element from end
        //if i need 3rd element from the end, (6-3+1) = 4th element from start

        int idx = size - n + 1;
        temp = head;
        for(int i = 0; i<idx-1; i++){
            temp = temp.next;
        }

        return temp;
    }

    // THE OPTIMIZED APPROACH IS USING 'SLOW' AND 'FAST' POINTERS
    /*
        n = 3;
        LL : 1 3 5 7 9 null
             s
             f

             1 3 5 7 9 null
             s     f

             1 3 5 7 9 null
                 s      f
    */

    public static Node optimizedApproach(Node head, int n){
        Node slow = head;
        Node fast = head;

        //move the fast pointer 1st n times
        for(int i = 0; i<n; i++){
            fast = fast.next;
        }

        //now move both slow and fast
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);
        Node e = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Node ans = bruteForce(a, 3);
        System.out.println(ans.data);

        Node ans1 = optimizedApproach(a, 3);
        System.out.println(ans1.data);
    }
}
