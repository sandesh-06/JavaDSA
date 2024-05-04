package BST.Problems;

import java.util.LinkedList;
import java.util.Queue;

public class P_4_CheckIfValidBST {
    static Node temp = null;
    static boolean flag = true;
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
    public static boolean checkIfValidBST(Node root){
        //1. Traverse Inorder
        //2. Store the values in temp while traversing
        //3. We know that Inorder of BST is ascending order, so compare the prev node(temp) and curr node(root) check for their value.
        if(root == null) return false;
        checkIfValidBST(root.left);
        //main code
        if(temp == null)temp = root; //1. make the temp as root for the first time
        if(temp.val > root.val) return false; //2. if the temp value becomes greater than root, then it breaks the rule of BST.
        else temp = root;
        checkIfValidBST(root.right);
        return true; //3. If the condition is never met, It is a BST.
    }
    public static void main(String[] args) {
        String[] nodes1 = {"10", "5", "17", "3", "6", "", "19", "", "4", "", "", "18", "20"};
        String[] nodes2 = {"10", "5", "17", "3", "6", "", "19", "", "4", "", "", "7", "20"};

        Node tree1 = constructTree(nodes1);
        Node tree2 = constructTree(nodes2);

        System.out.println(checkIfValidBST(tree1));
        System.out.println(checkIfValidBST(tree2));

    }
}
