package GenericTrees.Basics;

import java.util.ArrayList;
import java.util.List;

/*
        Generic Trees is also known as "n-array tree". Unlike Binary Trees, Generic Trees can have any number of child

        Let's implement the following generic tree.

                        30
               /        |       \
              10       21       43
          /   |  \    |  \    /  |  \
         2   15  6    9  13  7   45  76
*/
public class B_1_TreeImplementation {
    public static class Node{
        int val;
        List<Node> child = new ArrayList<>();

        public Node(int val){this.val = val;}
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
    public static void main(String[] args) {
        Node root = new Node(30);
        buildTree(root);
    }
}
