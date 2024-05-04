package BinaryTrees.Problems;

import BinaryTrees.Traversals.BT_03_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BT_02_ConstructTree {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){this.val = val;}
    }
    public static Node constructTree(String[] arr){
        Node root = new Node(Integer.parseInt(arr[0])); //1. first create a node for root element
        Queue<Node> q = new LinkedList<>(); //2. create a queue and add the root element
        q.add(root);

        //3. Initialize a for loop and run it until last 2nd element, also increment it by 2.
        for(int i = 1; i<= arr.length-2; i+=2){
            //4. check if the peek of q is a node, if yes attach the current i and i+1 element to the node.
            Node curr_node = q.peek();
            if(!arr[i].equals("")){
                Node l = new Node(Integer.parseInt(arr[i]));
                curr_node.left = l;
                q.add(l);
            } else if (arr[i].equals("")) {
                curr_node.left = null;
            }
            if(!arr[i+1].equals("")){
                Node r = new Node(Integer.parseInt(arr[i+1]));
                curr_node.right = r;
                q.add(r);
            } else if (arr[i+1].equals("")) {
                curr_node.right = null;
            }
            q.remove(); //5. Remove the peek of q, once the work is done
        }
        return root;
    }

    private static void levelElements(Node root, int level){
        if(root == null) return;
        if(level == 1){ //when the level becomes 1 print the values
            System.out.print(root.val + " ");
            return;
        }

        levelElements(root.left, level-1);
        levelElements(root.right, level-1);
    }
    private static int findHeight(Node root){
        if(root == null || root.left == null && root.right == null) return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "", "6", "7", "", "", "8", "", "", "", "9", ""};
        Node root = constructTree(arr);
        int lvl = findHeight(root) + 1;
        for(int i = 1; i<=lvl; i++){
            levelElements(root, i);
            System.out.println();
        }
    }
}
