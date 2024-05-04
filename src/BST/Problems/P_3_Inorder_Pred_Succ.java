package BST.Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//WE KNOW TO FIND THE INORDER PREDECESSOR FOR NODE WITH CHILD, BUT WHAT ABOUT THE NODE WITHOUT CHILD? HERE'S A CODE TO FIND INORDER PRED FOR ALL THE NODES
public class P_3_Inorder_Pred_Succ {
    static int pred = -1;
    static int succ = -1;
    static Node temp = null;
    static boolean flag = false;
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
   public static void findInorderPredSucc(Node root, int val){
        if(root == null) return;
       //1. Traverse Inorder
       findInorderPredSucc(root.left, val);
       //Main operation
       if(root.val < val) temp = root;
       else if(root.val == val){
           pred = temp.val;
           flag = true;
       }
       else if(root.val > val && flag == true){
           succ = root.val;
           flag = false;
           return;
       }
       findInorderPredSucc(root.right, val);
   }
    public static void main(String[] args) {
        String[] nodes = {"10", "5", "17", "3", "6", "", "19", "", "4", "", "", "18", "20"};
        Node tree = constructTree(nodes);
        printTree(tree);

        System.out.println("Enter the node to find Inorder Pred and Succ: ");
        Scanner sc = new Scanner(System.in);
        int val1 = sc.nextInt();

       findInorderPredSucc(tree, val1);
        System.out.println("Pred: " + pred + "\n" + "Succ: " + succ);
    }
}
