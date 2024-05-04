package BST.Problems;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

public class P_10_AllElementsInTwoBST {

//    class Solution {
//        public void morrisTraversal(TreeNode root, List<Integer> arr){
//            TreeNode curr = root;
//            TreeNode pred = root;
//
//            while(curr != null){
//                if(curr.left != null){
//                    pred = curr.left;
//                    while(pred.right!=null && pred.right!=curr) pred = pred.right;
//
//                    if(pred.right!=curr){
//                        pred.right = curr;
//                        curr = curr.left;
//                    }else{
//                        pred.right = null;
//                        arr.add(curr.val);
//                        curr = curr.right;
//                    }
//                }else{
//                    arr.add(curr.val);
//                    curr = curr.right;
//                }
//            }
//        }
//        public void merge( List<Integer> l1,  List<Integer> l2,  List<Integer> ans){
//            int i = 0, j = 0; //i - l1, j - l2
//            while(i < l1.size() && j < l2.size()){
//                if(l1.get(i) <= l2.get(j)){
//                    ans.add(l1.get(i));
//                    i++;
//                }else{
//                    ans.add(l2.get(j));
//                    j++;
//                }
//            }
//
//            //for the remaining elements in l1 and l2
//            while(i < l1.size())  ans.add(l1.get(i++));
//            while(j < l2.size())  ans.add(l2.get(j++));
//        }
//        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
//            //1. CREATE 2 LISTS AND ADD THE VALUES OF BOTH THE TREES TO THIER RESPECTIVE LISTS
//            //2. NOW WE HAVE 2 SORTED LISTS, THE BEST WAY TO SORT TWO SORTED LIST IS MERGE SORT.
//            List<Integer> l1 = new ArrayList<>();
//            List<Integer> l2 = new ArrayList<>();
//            morrisTraversal(root1, l1);
//            morrisTraversal(root2, l2);
//
//            List<Integer> ans = new ArrayList<>();
//            merge(l1, l2, ans);
//            return ans;
//        }
//    }
}
