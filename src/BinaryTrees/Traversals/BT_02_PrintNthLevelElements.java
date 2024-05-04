package BinaryTrees.Traversals;

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

       */
public class BT_02_PrintNthLevelElements {
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

        System.out.println("Which level elements do you need?: ");
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();

        System.out.println("Elements: ");
        levelElements(root, level);
    }
}
