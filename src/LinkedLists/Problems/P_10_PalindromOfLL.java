package LinkedLists.Problems;

public class P_10_PalindromOfLL {
    public static Node findReverse(Node head){
        if(head==null || head.next==null) return head;
        Node new_head = findReverse(head.next);
        head.next.next = head;
        return new_head;
    }
    public static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean isPalindrome(Node head){
        //1. find the middle element, in case of even find the left middle
        Node middle = findMiddle(head);

        //2. find the reverse from middle.next
        Node reverse_head = findReverse(middle.next);
        middle.next = reverse_head;

        //3. initialize 2 pointers, one at the start one at middle.next. Check if st.data = middle.next.data, then move until st = middle. If no break and return false
        Node pointer1 = head;
        Node pointer2 = middle.next;

        while(pointer1!=middle){
            if(pointer1.data != pointer2.data) return false;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return true;
    }
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
        Node d = new Node(3);
        Node e = new Node(2);
        Node f = new Node(1);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(isPalindrome(a));
    }
}
