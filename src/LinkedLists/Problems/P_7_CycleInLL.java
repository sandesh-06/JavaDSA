package LinkedLists.Problems;


// TO DETECT WHETHER THERE IS A CYCLE IN LL OR NOT
// eg: LL: 1 - 2 - 3 - 4 - 5 - 2, the last Node stores the address of 2nd Node. So the Linked List never ends
//APPROACH USING SLOW AND FAST:
/*
         1 - 2 - 3 - 4 - 5      1 - 2 - 3 - 4 - 5       1 - 2 - 3 - 4 - 5      1 - 2 - 3 - 4 - 5        1 - 2 - 3 - 4 - 5
             |_ _ _ _ _ _|          |_ _ _ _ _ _|           |_ _ _ _ _ _|          |_ _ _ _ _ _|            |_ _ _ _ _ _|
         s                          s   f                       s       f              f   s                            s
         f                                                                                                              f

         FROM THIS WE CAN NOTE THAT WHEN A LINKED LIST HAS CYCLE, THE FAST AND SLOW NODE BECOMES EQUAL AT A NODE (THE NODE CAN BE BE ANYTHING)
         SO IF IT BECOMES EQUAL, AT THAT TIME RETURN TRUE

*/
public class P_7_CycleInLL {
//    public boolean hasCycle(ListNode head) {
//        if(head == null || head.next == null) return false;
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while(fast!=null && fast.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if(fast == slow) return true;
//        }
//
//        return false;
//    }
}
