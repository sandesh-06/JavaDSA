package LinkedLists.Problems;

//TO RETURN THE NODE, WHERE THE TAIL NODE POINTS / TO RETURN THE NODE WHERE CYCLE STARTS
//APPROACH: initialize slow, fast and temp as head;
/*
    LL:  1 2 3 4 5 6        1 2 3 4 5 6         1 2 3 4 5 6           1 2 3 4 5 6          1 2 3 4 5 6
         t   |_ _ _|            |_ _ _|             |_ _ _|               |_ _ _|              |_ _ _|
         s                  t s f               t   s   f             t   f s              t       s
         f                                                                                         f

         When slow == fast: run a while loop until temp != slow
         1 2 3 4 5 6         1 2 3 4 5 6         1 2 3 4 5 6
             |_ _ _|             |_ _ _|             |_ _ _|
         t       s             t       s             t
                                                     s

         when temp becomes equal to slow, that NODE is the required NODE.
*/
public class P_8_Cycle2 {
//    public ListNode detectCycle(ListNode head) {
//        if(head==null||head.next==null) return null;
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode temp = head;
//
//        while(fast.next!=null && fast.next.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow == fast){
//                while(temp!=slow){
//                    slow = slow.next;
//                    temp = temp.next;
//                }
//                return temp;
//            }
//        }
//
//        return null;
//    }
}
