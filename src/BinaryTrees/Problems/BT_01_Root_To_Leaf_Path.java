package BinaryTrees.Problems;

import java.util.ArrayList;
import java.util.List;

public class BT_01_Root_To_Leaf_Path {
    /*          TREE:
                                          Level      Height
                           2                1
                        /    \                         1
                       6      5             2
                     /  \      \                       2
                   10    13     11          3
                                  \                    3
                                   15       4

                BFS : 2 6 5 10 13 11 15

       */

   public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }
//    public static void helper(Node root, List<String> ans, String s){
//       if(root == null) return;
//       if(root.left == null && root.right == null){
//           s += root.val;
//           ans.add(s);
//           return;
//       }
//       helper(root.left, ans, s+root.val+"->");
//       helper(root.right, ans, s+root.val+"->");
//    }
    public static void helper(Node root, List<Integer> ans, int sum){
       if(root == null) return;
       if(root.left == null && root.right == null){
           sum += root.val;
           ans.add(sum);
           return;
       }
       helper(root.left, ans, sum+root.val);
       helper(root.right, ans, sum+root.val);
    }
    public static List<Integer> rootToLeaf(Node root){
       List<Integer> ans = new ArrayList<>();
       helper(root, ans, 0);
       return ans;
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

        System.out.println("The paths are: " + rootToLeaf(root));
    }
}
