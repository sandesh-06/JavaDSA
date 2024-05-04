package BST.Problems;

//CONSTRUCT A BST FOR GIVEN PREORDER TRAVERSAL.
//NOTE: YOU CAN CONSTRUCT A BST IF ANY ORDER IS GIVEN, BECAUSE IT IS JUST INSERTING A NODE IN A BST
public class P_6_ConstructBST_GivenPreorder {
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

    public static Node insertInBST(Node root, int val){
        if(root == null) return null;

        if(val <= root.val){
            if(root.left == null) root.left = new Node(val);
            else insertInBST(root.left, val);
        }else{
            if(root.right == null) root.right = new Node(val);
            else insertInBST(root.right, val);
        }
        return root;
    }
    public static Node constructBST(int[] arr){
        //1. Take the first element as root value
        Node root = new Node(arr[0]);
        //2. Perform insertion into BST for other elements
        for(int i = 1; i<arr.length; i++){
            root = insertInBST(root, arr[i]);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        Node tree = constructBST(preorder);
        printTree(tree);
    }
}
