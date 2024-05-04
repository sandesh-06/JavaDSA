package BinaryTrees.Traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
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
public class BT_03_BFS {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
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

    //BFS USING QUEUE
    private static void BFS(Node root){
        Queue<Node> q = new LinkedList<>();

        //first add the root element to the queue
        if(root != null) q.add(root);

        //traverse the queue until empty
        while(q.size() > 0){
            Node temp = q.peek(); //take the peek element of the queue
            //add left and right node of the peek element to the queue
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
            System.out.print(temp.val + " "); //print the value of current node
            q.remove(); //remove the node
        }
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

        //1. First find the levels of the tree
        int level = findHeight(root) + 1;

        //2. Now print the level elements of the tree using for loop
        System.out.println("Using level method: ");
        for(int i = 1; i<=level; i++){
            levelElements(root, i);
        }

        // THIS APPROACH IS HAS A HIGHER TIME COMPLEXITY, WE CAN OPTIMIZE IT USING QUEUE
        System.out.println("\n\nUsing Queue: ");
        BFS(root);
    }
}

