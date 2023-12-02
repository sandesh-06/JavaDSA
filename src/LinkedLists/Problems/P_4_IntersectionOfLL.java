package LinkedLists.Problems;

public class P_4_IntersectionOfLL {
    //LL1 : 1 3 2 5 9 3
    //LL2 : 4 0 6 2 5 9 3
    //Now both the list is intersected at node 2. So return the Node

//    public int findSize(ListNode head){
//        int cnt = 0;
//        while(head!=null){
//            cnt++;
//            head = head.next;
//        }
//        return cnt;
//    }
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1. FIND SIZE OF BOTH THE LISTS
//        int size_a = findSize(headA);
//        int size_b = findSize(headB);

        //GET THEIR ABSOLUTE DIFFERENCE
//        int size_diff = Math.abs(size_a - size_b);
//
//        ListNode tempA = headA;
//        ListNode tempB = headB;

        /*
         WHICHEVER LIST IS GREATER IN SIZE, MOVE THE TEMP OF THE LIST FROM HEAD TO DIFF IN THEIR SIZE.
         BUY DOING THIS BOTH THE TEMP WILL POINT TO THAT NODE WHICH IS EQUALLY DISTANT FROM THE INTERSECTING NODE
         */
//        if(size_a > size_b){
//            for(int i = 0; i<size_diff; i++){
//                tempA = tempA.next;
//            }
//        }
//        else{
//            for(int i = 0; i<size_diff; i++){
//                tempB = tempB.next;
//            }
//        }
//
            //NOW MOVE BOTH THE TEMP, UNTIL THEY REACH THE INTERSECTION AND RETURN THE INTERSECTING NODE
//        while(tempA!=tempB){
//            tempA = tempA.next;
//            tempB = tempB.next;
//        }
//
//        return tempA;
//    }
}
