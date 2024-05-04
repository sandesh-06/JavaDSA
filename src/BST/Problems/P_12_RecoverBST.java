package BST.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_12_RecoverBST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){this.val = val;}
    }
    public static void helper( TreeNode root, ArrayList<TreeNode> swappedNodes){
        TreeNode curr = root;
        TreeNode pred = root;

        TreeNode prev = null;
        TreeNode prevprev = null;

        while(curr!=null){
            if(curr.left!=null){
                pred = curr.left;
                while(pred.right!=null && pred.right!=curr) pred = pred.right;

                if(pred.right!=curr){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    pred.right = null;

                    if(prev!=null && prevprev!=null){
                        if(prev.val > prevprev.val && prev.val > curr.val) swappedNodes.add(prev);
                        else if(prev.val < prevprev.val && prev.val < curr.val) swappedNodes.add(prev);
                    }
                    prevprev = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }else{
                if(prev!=null && prevprev!=null){
                    if(prev.val > prevprev.val && prev.val > curr.val) swappedNodes.add(prev);
                    else if(prev.val < prevprev.val && prev.val < curr.val) swappedNodes.add(prev);
                }
                prevprev = prev;
                prev = curr;
                curr = curr.right;
            }
        }
    }
    public static void recoverTree(TreeNode root) {
        ArrayList<TreeNode> swappedNodes = new ArrayList<>();
        helper(root, swappedNodes);
        for(TreeNode node: swappedNodes){
            System.out.print(node.val + " ");
        }

        int temp = swappedNodes.get(0).val;
        swappedNodes.get(0).val = swappedNodes.get(1).val;
        swappedNodes.get(1).val = temp;

    }
    public static void printTree(TreeNode root){
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
    public static TreeNode constructTree(String[] nodes){
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);

        for(int i = 1; i<=nodes.length-2; i+=2){
            TreeNode currNode = q.remove();
            //left node
            if(!nodes[i].equals("")){
                TreeNode n = new TreeNode(Integer.parseInt(nodes[i]));
                currNode.left = n;
                q.add(n);
            } else if(nodes[i].equals("")) {
                currNode.left = null;
            }
            //right node
            if(!nodes[i+1].equals("")){
                TreeNode n = new TreeNode(Integer.parseInt(nodes[i+1]));
                currNode.right = n;
                q.add(n);
            } else if(nodes[i+1].equals("")) {
                currNode.right = null;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        String[] nodes1 = {"1", "3", "", "", "2"};
        TreeNode root = constructTree(nodes1);

        printTree(root);
        recoverTree(root);
        System.out.println();
        printTree(root);
    }
}
