package BST.Problems;

import java.util.LinkedList;
import java.util.Queue;
//LC LINK: https://leetcode.com/problems/convert-bst-to-greater-tree/submissions/1245492939/

public class P_7_GreaterTree {
    static int prev = 0;
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
    public static void greaterTree(Node root){
        if(root == null) return;
        //1. The intution is to traverse in reverse inorder to access the greater elements first.
        greaterTree(root.right);
        //2. Change the root val to curr root val + prev val
        root.val = prev + root.val;
        //3. change the prev to curr root val
        prev = root.val;
        greaterTree(root.left);
    }
    public static void main(String[] args) {
        String[] nodes1 = {"4", "1", "6", "0", "2", "5", "7", "", "", "", "3", "", "", "", "8"};
        Node root = constructTree(nodes1);
//        printTree(root);

        greaterTree(root);
        printTree(root);
    }
}
