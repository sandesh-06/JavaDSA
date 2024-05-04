package BST.Problems;

import java.util.LinkedList;
import java.util.Queue;

public class P_9_MORRIS_TRAVERSAL {
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

    private static void morrisTraversal(Node root){
        Node curr = root;
        Node pred = root;

        while(curr != null){
            if(curr.left != null){
                pred = curr.left;
                while(pred.right != null && pred.right != curr) pred = pred.right;

                if(pred.right!=curr){ //if pred is not connect to curr, then connect it.
                    pred.right = curr;
                    curr = curr.left;
                }else{ //if pred is connected to curr, disconnect it.
                    pred.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }else{
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }
    public static void main(String[] args) {
        String[] nodes1 = {"20", "10", "30", "5", "15", "", "40", "", "", "12", "18", "", "", "", "13", "16", ""};
        Node root = constructTree(nodes1);
        printTree(root);

        morrisTraversal(root);
    }
}
