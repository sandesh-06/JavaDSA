package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;

/*          TREE:
                                          Level      Height
                           2                1
                        /    \                         1
                       6      5             2
                     /  \      \                       2
                   10    13     11          3
                    \    /        \                    3
                    14  16         15       4
                                  /
                                20

       */
public class BT_05_BoundaryTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){this.val = val;}
    }

    public static void leftBoundary(Node root, List<Integer> ls){
        if(root == null || root.left == null && root.right == null) return;
        ls.add(root.val);

        if(root.left!=null) leftBoundary(root.left, ls);
        else if(root.right!=null) leftBoundary(root.right, ls);

    }
    public static void leafNodes(Node root, List<Integer> ls){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ls.add(root.val);
            return;
        }
        leafNodes(root.left, ls);
        leafNodes(root.right, ls);
    }
    public static void rightBoundary(Node root, List<Integer> temp){
        if(root.left == null && root.right == null) return;
//        temp.add(root.val);
        if(root.right!=null) rightBoundary(root.right, temp);
        else if (root.left!=null) rightBoundary(root.left, temp);

        temp.add(root.val);

    }

    public static void boundaryTraversal(Node root){
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);

        leftBoundary(root.left, ans);
        leafNodes(root, ans);

//        List<Integer> temp = new ArrayList<>();
//        rightBoundary(root.right, temp);
//        //add the elements of right boundary list to the main list in reverse order
//        for(int i = temp.size()-1; i>=0; i--) ans.add(temp.get(i));
        //INSTEAD OF CREATING ANOTHER LIST TO REVERSE, DO THE WORK AFTER RECURSION CALL. RECURSION WILL AUTOMATICALLY ADD THE ELEMENTS IN REVERSE
        rightBoundary(root.right, ans);
        System.out.println(ans);
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

        n3.right = new Node(14);
        n4.left = new Node(16);

        Node n5 = new Node(11);
        Node n6 = new Node(15);
        n2.right = n5;
        n5.right = n6;

        n6.left = new Node(20);

        boundaryTraversal(root);
    }
}
