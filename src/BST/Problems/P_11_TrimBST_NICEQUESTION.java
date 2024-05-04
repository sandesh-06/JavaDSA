package BST.Problems;

public class P_11_TrimBST_NICEQUESTION {

//    class Solution {
//        public void helper(TreeNode root, int low, int high){
//            if(root == null) return;
//
//            // while(root.left!=null && (root.left.val < low)){ //
//            //     root.left = root.left.right;
//            // }
//
//            // while(root.right!=null && (root.right.val < low)){
//            //     root.right = root.right.left;
//            // }
//
//            while(root.left != null){
//                if(root.left.val < low) root.left = root.left.right; //dicard whole left subtree of root.left
//                else if(root.left.val > high) root.left = root.left.left; //discard whole right subtree of root.right
//                else break;
//            }
//            while(root.right != null){
//                if(root.right.val < low) root.right = root.right.right; //dicard whole left subtree of root.left
//                else if(root.right.val > high) root.right = root.right.left; //discard whole right subtree of root.right
//                else break;
//            }
//
//            helper(root.left, low, high);
//            helper(root.right, low, high);
//        }
//        public TreeNode trimBST(TreeNode root, int low, int high) {
//
//            //THE INTUTION IS THAT, WHEN A NODE IS LESS THAN LOW THEN IT'S WHOLE LEFT SUBTREE IS LESS THAN LOW, SO WE CAN REMOVE THE WHOLE SUBTREE
//            //SAME WITH THE RIGHT SUBTREE AS WELL.
//            //TO REMOVE THE WHOLE LEFT SUBTREE, WE ATTACH THE RIGHT SUBTREE OF THE NODE WITH THE CURRENT NODE AND SAME FOR THE RIGHT AS WELL.
//            //THEN WE CAN USE RECURSION TO CHECK FOR OTHER NODES AS WELL
//        /*
//            CHECK EXAMPLE 2:
//                3 IS THE CURRENT NODE, SO root.left.val is < low, so attach root.left = root.left.right
//         */
//
//            //UNTIL NOW WE WERE CHECKING ONLY FOR LEFT OF ROOT AND RIGHT OF ROOT, BUT WHAT IF THE ROOT VALUE IS < low or > high. IN THIS CASE LET'S USE A DUMMY NODE
//            //ALSO THERE CAN BE A CASE WHERE ROOT.LEFT > high, SO WE NEED TO HANDLE SUCH CASES AS WELL
//            TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
//            dummy.left = root;
//            helper(dummy, low, high);
//            return dummy.left;
//        }
//    }
}
