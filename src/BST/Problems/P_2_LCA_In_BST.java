package BST.Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_2_LCA_In_BST {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){this.val = val;}
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
    public static int LCA(Node root, int p, int q){
        if(root.val == p || root.val == q) return root.val;

        if(p < root.val && q > root.val) return root.val;
        else if(p < root.val && q < root.val) return LCA(root.left, p, q);
        else return LCA(root.right, p, q);
    }
    public static void main(String[] args) {
        String[] nodes = {"10", "5", "17", "3", "6", "", "19", "", "4", "", "", "18", "20"};
        Node tree = constructTree(nodes);
        printTree(tree);

        System.out.println("Enter the two values to find their LCA: ");
        Scanner sc = new Scanner(System.in);
        int val1 = sc.nextInt();
        int val2 = sc.nextInt();

        System.out.println("The LCA is: " + LCA(tree, val1, val2));
    }
}
