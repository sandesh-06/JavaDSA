package GenericTrees.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
                        100
               /        |       \
              10       21       43
          /   |  \    |  \    /  |  \
         2   15  6    9  13  7   45  76
*/
public class T_2_BFS {
    private static class Node{
        int val;
        List<Node> child;

        Node(int val){
            this.val = val;
            child = new ArrayList<>();
        }
    }

    public static void levelOrder(Node root){

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.remove();
            System.out.print(curr.val + " ");
            if(!curr.child.isEmpty()){
                for(int i = 0; i < curr.child.size(); i++){
                    q.add(curr.child.get(i));
                }
            }
        }
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
    public static void main(String[] args) {
        Node root = new Node(100);
        buildTree(root);

        levelOrder(root);
    }
}
