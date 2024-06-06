package GenericTrees.Problems;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.print.DocFlavor;
import java.util.*;

/*              Normal Tree                                                         Mirror Tree
                        20                                                                   20
               /        |       \                                                   /        |       \
              10       21       43                                                 43       21        10
          /   |  \    |  \    /  |  \                                           /  |  \    |  \    /  |  \
         2   15  6    9  13  7   45  76                                        76 45  7   13  9   6  15  2

*/
public class P_3_MirrorTree {
    private static class Node{
        int val;
        List<Node> child = new ArrayList<>();

        Node(int val){this.val = val;}
    }
    public static void buildTree(Node root){
        root.child.add(new Node(10));
        root.child.add(new Node(21));
        root.child.add(new Node(43));

        //now add child for node 10, which is at 0th index
        root.child.get(0).child.add(new Node(2));
        root.child.get(0).child.add(new Node(15));
        root.child.get(0).child.add(new Node(6));

        //for node 21 at 1st index
        root.child.get(1).child.add(new Node(9));
        root.child.get(1).child.add(new Node(13));

        //for node 43, at 2nd index
        root.child.get(2).child.add(new Node(7));
        root.child.get(2).child.add(new Node(45));
        root.child.get(2).child.add(new Node(76));
    }

    public static void printTree(Node root){
        //print using level order
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.remove();
            System.out.print(curr.val + " ");
            for(int i = 0; i < curr.child.size(); i++) q.add(curr.child.get(i));
        }

    }

    public static void mirrorTree(Node root){
        //if the node has 0 or 1 child just return;
        if(root.child.size() == 0 || root.child.size() == 1) return;

        Collections.reverse(root.child); //reverse the children of curr root.
        for(int i = 0; i < root.child.size(); i++){ //perform the same for all the children as well
            mirrorTree(root.child.get(i));
        }
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        buildTree(root);
        System.out.println("Normal Tree: ");
        printTree(root);
        mirrorTree(root);
        System.out.println("\nMirrored Tree");
        printTree(root);
    }
}
