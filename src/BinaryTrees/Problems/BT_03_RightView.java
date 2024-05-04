package BinaryTrees.Problems;

import java.util.ArrayList;
import java.util.List;

/*          TREE:
                                          Level      Height
                           2                1
                        /    \                         1
                       6      5             2
                     /  \      \                       2
                   10    13     11          3
                    \    /                             3
                    14  16                  4

            RIGHT VIEW = 2 5 11 16;
            LEFT VIEW = 2 6 10 14;
       */
public class BT_03_RightView {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){this.val = val;}
    }
    private static int height(Node root){
        if(root == null || root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private static void helper(Node root, int curr_lvl, int max_lvl, int[] arr){
        //1. Use preorder traversal to achieve this.
        if(root == null) return;

        arr[curr_lvl-1] = root.val;

       if(curr_lvl == max_lvl) return; //3. when max lvl reached just return

       //2. add the element of current lvl in it's index
       helper(root.left, curr_lvl+1, max_lvl, arr);
       helper(root.right, curr_lvl+1, max_lvl, arr);
       /*
        FOR LEFT VIEW:
         helper(root.right, curr_lvl+1, max_lvl, arr);
         helper(root.left, curr_lvl+1, max_lvl, arr);
       */

       //when this function is completed at last, only the last elements of the particular lvl will be left out in the array
    }
    public static int[] rightView(Node root){
        //THE LOGIC IS THAT AT EVERY LEVEL GET THE LAST ELEMENT.
        //1. Find no of levels
        int lvl = height(root) + 1;
        //2. create an array with lvls as length
        int[] arr = new int[lvl];
        //3. Now at every lvl add the last element of the lvl in the respective idx, i.e the last element of lvl 2 shld be at index 1.
        helper(root, 1, lvl, arr);
        return arr;

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
        n2.right = n5;

        int[] ans = rightView(root);
        for(int n: ans) System.out.print(n + " ");
    }
}
