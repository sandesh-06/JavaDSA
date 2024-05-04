package BST.Problems;

//GIVEN AN ARRAY WITH NUMBERS IN ASC ORDER CONSTRUCT A BST
public class P_5_ConstructBST_SortedArray {
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
    public static Node constructBST(int[] arr, int low, int high){
        if(low > high) return null;

        int mid = (low+high)/2;
        Node currNode = new Node(arr[mid]);
        currNode.left = constructBST(arr, low, mid-1);
        currNode.right = constructBST(arr, mid+1, high);

        return currNode;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node tree = constructBST(arr, 0, arr.length-1);
        printTree(tree);
    }
}
