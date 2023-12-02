package LinkedLists.Problems;

import java.util.LinkedList;

public class P_1_Delete_Node {
    public static class Node{
        int data;
        Node next;

        public Node(){}

        public Node(int data){
            this.data = data;
        }
    }
    public static void deleteNode(Node node) {
        //now to delete a node, i need it's prev node which is not possible in this case.
        //so the approach would be:

        //cur node.data = next node.data
        node.data = node.next.data;
        //assign node.next as node.next.next
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
