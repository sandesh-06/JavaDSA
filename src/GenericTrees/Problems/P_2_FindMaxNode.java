package GenericTrees.Problems;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/*
                        20
               /        |       \
              10       21       43
          /   |  \    |  \    /  |  \
         2   15  6    9  13  7   45  76
*/

public class P_2_FindMaxNode {
    private static class Node{
        int val;
        List<Node> child = new ArrayList<>();

        Node(int val){this.val = val;}
    }
    public static void buildTree(Node root){
        root.child.add(new Node(10));
        root.child.add(new Node(21));
        root.child.add(new Node(43));

        //now add child for node 10, which is at 0th index
        root.child.get(0).child.add(new Node(2));
        root.child.get(0).child.add(new Node(15));
        root.child.get(0).child.add(new Node(6));

        //for node 21 at 1st index
        root.child.get(1).child.add(new Node(9));
        root.child.get(1).child.add(new Node(13));

        //for node 43, at 2nd index
        root.child.get(2).child.add(new Node(7));
        root.child.get(2).child.add(new Node(45));
        root.child.get(2).child.add(new Node(76));
    }

    public static void findMax1(Node root, int[] maxEle){
        //let's traverse preorder and compare every element with the maxEle.
        if(root.child.isEmpty()){
            maxEle[0] = Math.max(maxEle[0], root.val);
            return;
        }
        //comapre root - ROOT
        maxEle[0] = Math.max(maxEle[0], root.val);
        //compare children - CHILD
        for(int i = 0; i<root.child.size(); i++) findMax1(root.child.get(i), maxEle);

    }
    public static int findMax2(Node root){
        if(root.child.isEmpty()) return root.val;

        int currMax = root.val;
        //find the max from the children nodes
        for(int i = 0; i<root.child.size(); i++){
            int childMax = findMax2(root.child.get(i)); //this will return the max node among the children nodes of curr root
            currMax = Math.max(childMax, currMax);
        }

        return currMax;
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        buildTree(root);

        int[] maxEle = {root.val};
        findMax1(root, maxEle);
        System.out.println("Max element is using 1st Method: " + maxEle[0]);

        findMax2(root);
        System.out.println("Max element is using optimized method: " + maxEle[0]);
    }
}
