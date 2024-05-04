package BinaryTrees.Traversals;

/*          CONSTRUCT AND DISPLAY THE FOLLOWING TREE
                                          Level      Height
                           2                1
                        /    \                         1
                       6      5             2
                     /  \      \                       2
                   10    13     11          3
                                  \                    3
                                   15       4

       */
public class BT_01_Pre_In_Post {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static void preorder(Node root){
        //root left right
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root){
        //left root right
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    private static void postorder(Node root){
        //left right root
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
    public static void main(String[] args) {
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
        Node n6 = new Node(15);
        n2.right = n5;
        n5.right = n6;
        System.out.print("PREORDER: " );
        preorder(root);
        System.out.println();
        System.out.print("INORDER: " );
        inorder(root);
        System.out.println();
        System.out.print("POSTORDER: " );
        postorder(root);

    }
}
