package GenericTrees.Problems;

import java.util.*;

/*
                        50
               /        |       \
              10       21       43
          /   |  \    |  \    /  |  \
         2   15  6    9  13  7   45  76
*/
public class P_1_ZigZagTraversal {
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

    public static void zigzag(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;
        //if flag is false, print curr nodes straight
        //if flag is true, print curr nodes in reverse order
        while(!q.isEmpty()){
            int elementsInCurrLvl = q.size();
            ArrayList<Node> currLvlElements = new ArrayList<>();
            while(elementsInCurrLvl > 0){
                Node curr = q.remove();
                currLvlElements.add(curr);
                if(!curr.child.isEmpty()){
                    for(int i = 0; i<curr.child.size(); i++) {
                        q.add(curr.child.get(i));
                    }
                }
                elementsInCurrLvl--;
            }
            if(!flag){
                printElements(currLvlElements);
            }else{
                Collections.reverse(currLvlElements);
                printElements(currLvlElements);
            }
            flag = !flag;
        }
    }
    public static void printElements(ArrayList<Node> arr){
        for(int i = 0; i < arr.size(); i++) System.out.print(arr.get(i).val + " ");
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        buildTree(root);
        zigzag(root);
    }
}
