package LinkedLists.Problems;


public class P_3_DeleteNthFromLast {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;

        for(int i = 0; i<n; i++){
            fast = fast.next;
        }

        if(fast == null) {
            head = head.next;
            return head;
        }

        while(fast.next!=null){ //stop at the last element
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        //Even if i wanna do it you can never do it, but then what's the use. Okay so the use is that you actually have to ready but then come
        return head;
    }

    public static void recursionDisplayLL(Node head){
        if(head == null)return;
        System.out.print(head.data + " -> ");
        recursionDisplayLL(head.next);
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

        Node ans = removeNthFromEnd(a, 5);
        recursionDisplayLL(ans);
    }
}
