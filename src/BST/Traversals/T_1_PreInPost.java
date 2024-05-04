package BST.Traversals;

import java.util.LinkedList;
import java.util.Queue;

public class T_1_PreInPost {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node constructTree(String[] arr) {
        Node root = new Node(Integer.parseInt(arr[0])); //1. first create a node for root element
        Queue<Node> q = new LinkedList<>(); //2. create a queue and add the root element
        q.add(root);

        //3. Initialize a for loop and run it until last 2nd element, also increment it by 2.
        for (int i = 1; i <= arr.length - 2; i += 2) {
            //4. check if the peek of q is a node, if yes attach the current i and i+1 element to the node.
            Node curr_node = q.peek();
            if (!arr[i].equals("")) {
                Node l = new Node(Integer.parseInt(arr[i]));
                curr_node.left = l;
                q.add(l);
            } else if (arr[i].equals("")) {
                curr_node.left = null;
            }
            if (!arr[i + 1].equals("")) {
                Node r = new Node(Integer.parseInt(arr[i + 1]));
                curr_node.right = r;
                q.add(r);
            } else if (arr[i + 1].equals("")) {
                curr_node.right = null;
            }
            q.remove(); //5. Remove the peek of q, once the work is done
        }
        return root;
    }

    private static int findHeight(Node root) {
        if (root == null || root.left == null && root.right == null) return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public static void main(String[] args) {
        String[] arr = {"10", "5", "15", "2", "8", "12", "17"};
        Node root = constructTree(arr);
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        inorder(root); //INORDER TRAVERSAL ALWAYS GIVES THE ELEMENTS IN SORTED ORDER IN CASE OF A BST
        System.out.println();
    }

    private static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void postorder(Node root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");

    }

    private static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}