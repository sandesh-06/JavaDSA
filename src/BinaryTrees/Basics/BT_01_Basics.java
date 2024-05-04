package BinaryTrees.Basics;

public class BT_01_Basics {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    private static void display(Node root){
        if(root == null) return;
        System.out.print(root.val + "\t->\t");
        if(root.left == null || root.right == null) System.out.print("x\t");
        if(root.left != null) System.out.print(root.left.val + "\t");
        if(root.right != null) System.out.print(root.right.val);
        System.out.println();
        //display left subtree
        display(root.left);

        //display right subtree
        display(root.right);
    }
    public static void main(String[] args) {
        /*          CONSTRUCT AND DISPLAY THE FOLLOWING TREE
                            2
                         /    \
                        6      5
                      /  \      \
                    10    13     11

        */


        Node root = new Node(2);
        Node n1 = new Node(6);
        Node n2 = new Node(5);
        root.left = n1;
        root.right = n2;

        Node n3 = new Node(10);
        Node n4 = new Node(13);
        n1.left = n3;
        n1.right = n4;

        Node n5 = new Node(11);
        n2.right = n5;

        display(root);
    }
}
