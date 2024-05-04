package LinkedLists;

public class LL_4_Length_Of_LL {
    //iterative approach
    public static int iterativeLength(Node head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }

    //recursive approach
    public static int recursiveApproach(Node head, int count){
        if(head == null) return count;
        return recursiveApproach(head.next, count+1);

    }
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
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

        //find length of the LL iteratively
        System.out.println("Length using iterative approach: " + iterativeLength(a));

        //find length of the LL recursively
        System.out.println("Length using recursive approach: " + recursiveApproach(a, 0));
    }
}
