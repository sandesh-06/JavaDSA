package BinaryTrees.Basics;

//SIZE - NO.OF NODES IN A BT
public class BT_02_BasicBTImplementation {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    //1. TO FIND SIZE OF A BT
    private static int findSize(Node root){
        if(root == null) return 0;
        //return the root + size of left subtree + size of right subtree
        return 1 + findSize(root.left) + findSize(root.right);
    }

    //2. TO FIND SUM OF ALL THE NODES IN A BT
    private static int findSum(Node root){
        if(root == null) return 0;
        return root.val + findSum(root.left) + findSum(root.right);
        //sum = root val + sum of left subtree + sum of right subtree
    }

    //3. TO FIND THE MAXIMUM NODE IN THE BT
    private static int findMax(Node root){
//        if(root == null) return 0; //when the nodes are negative, '0' will be greater than the negative number.
        if(root == null) return Integer.MIN_VALUE;
        int max = Math.max(root.val, Math.max(findMax(root.left), findMax(root.right)));
        //get the max node from left subtree and right tree, compare it with the root node and return the max value
        return max;
    }

    //4. TO FIND HEIGHT OF THE TREE : HEIGHT = LEVEL - 1
    private static int findHeight(Node root){
        //when you encounter a leaf node the height is 0
        if(root == null || root.left == null && root.right == null) return 0;

        //get the max height between left subtree and right subtree, add 1 to it to get the overall height
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
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


        System.out.println("The size of the tree is: " + findSize(root));
        System.out.println("The sum of the tree is: " + findSum(root));
        System.out.println("The max node of the tree is: " + findMax(root));
        System.out.println("The height of the tree is: " + findHeight(root));
    }
}
