package LinkedLists.Problems;

//https://leetcode.com/problems/add-two-numbers/submissions/1122365952/

public class P_12_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        int carry = 0;

        while(l1!=null || l2!=null){
            int sum = 0;
            sum = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + carry;

            if(sum > 9) carry=1;
            else carry = 0;
            ListNode n = new ListNode(sum%10);
            temp.next = n;
            temp = temp.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }

        //if carry exists
        if(carry == 1){
            ListNode c_node = new ListNode(1);
            temp.next = c_node;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode la = new ListNode(4);
        ListNode lb = new ListNode(3);
        l1.next = la;
        la.next = lb;

        ListNode l2 = new ListNode(7);
        ListNode l2a = new ListNode(0);
        ListNode l2b = new ListNode(8);
        l2.next = l2a;
        l2a.next = l2b;

        ListNode x = addTwoNumbers(l1, l2);

        ListNode temp = x;
        while(temp!=null){
            System.out.print(x.val + " ");
            temp = temp.next;
        }

    }
}
