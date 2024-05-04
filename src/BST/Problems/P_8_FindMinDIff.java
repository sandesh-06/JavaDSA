package BST.Problems;

import java.util.LinkedList;
import java.util.Queue;

//Find the minimum difference between 2 nodes in a BST

//TO FIND THE MIN DIFF IN AN ARRAY, ARRANGE THE ELEMENTS IN ASCENDING ORDER AND FIND THE DIFFERENCE BETWEEN ADJACENT ELEMENTS
//Eg: arr = {2, 6, 7, 18, 19, 21}
//    min = {4, 1, 11, 1, 3}, so the min diff is 1.

//LET'S USE THE SAME CONCEPT IN BST. IN BST LET'S TRAVERSE IN INORDER TO ACHIEVE THIS WITH HELP OF GLOBAL PREV NODE VALUE AND MIN VALUE.
public class P_8_FindMinDIff {
    static Node prev = null;
    static int min = Integer.MAX_VALUE;
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){this.val = val;}
    }
    public static void printTree(Node root){
        if(root == null) return;
        System.out.print(root.val + " -> ");
        if(root.left!=null) System.out.print(root.left.val + " ");
        else if(root.left == null) System.out.print("null ");
        if(root.right!=null) System.out.print(root.right.val + " ");
        else if(root.right == null) System.out.print("null ");
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
    public static Node constructTree(String[] nodes){
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        q.add(root);

        for(int i = 1; i<=nodes.length-2; i+=2){
            Node currNode = q.remove();
            //left node
            if(!nodes[i].equals("")){
                Node n = new Node(Integer.parseInt(nodes[i]));
                currNode.left = n;
                q.add(n);
            } else if(nodes[i].equals("")) {
                currNode.left = null;
            }
            //right node
            if(!nodes[i+1].equals("")){
                Node n = new Node(Integer.parseInt(nodes[i+1]));
                currNode.right = n;
                q.add(n);
            } else if(nodes[i+1].equals("")) {
                currNode.right = null;
            }
        }

        return root;
    }
    public static void findMinDiff(Node root){
        if(root == null) return;

        findMinDiff(root.left);
        if(prev!=null){ //TO AVOID CALCULATION OF DIFFERENCE FOR THE FIRST NODE, BECAUSE IT WILL GIVE 0.
            int diff = Math.abs(prev.val - root.val);
            if(diff < min) min = diff;
        }
        prev = root;
        findMinDiff(root.right);
    }
    public static void main(String[] args) {
        String[] nodes1 = {"1", "5", "48", "", "", "12", "49"};
        Node root = constructTree(nodes1);

        findMinDiff(root);
        System.out.println("The min diff is: " + min);
    }
}
