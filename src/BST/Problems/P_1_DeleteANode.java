package BST.Problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/*          CONSTRUCT AND DISPLAY THE FOLLOWING TREE
                          10
                       /    \
                      5      17
                    /  \      \
                   3    6      19
                    \         /  \
                     4       18  20
      */
public class P_1_DeleteANode {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node constructTree(String[] arr) {
        Node root = new Node(Integer.parseInt(arr[0])); //1. first create a node for root element
        Queue<Node> q = new LinkedList<>(); //2. create a queue and add the root element
        q.add(root);

        //3. Initialize a for loop and run it until last 2nd element, also increment it by 2.
        for (int i = 1; i <= arr.length - 2; i += 2) {
            //4. check if the peek of q is a node, if yes attach the current i and i+1 element to the node.
            Node curr_node = q.peek();
            if (!arr[i].equals("")) {
                Node l = new Node(Integer.parseInt(arr[i]));
                curr_node.left = l;
                q.add(l);
            } else if (arr[i].equals("")) {
                curr_node.left = null;
            }
            if (!arr[i + 1].equals("")) {
                Node r = new Node(Integer.parseInt(arr[i + 1]));
                curr_node.right = r;
                q.add(r);
            } else if (arr[i + 1].equals("")) {
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


    public static void delete(Node root, int delVal){
        if(root == null) return;

        if(delVal < root.val){ //go left
            if(root.left.val == delVal){
                Node toDel = root.left;
                //1. checking if "toDel" is a leaf node
                if(toDel.left == null && toDel.right == null) root.left = null;
                //2. checking if "toDel" has one child
                else if(toDel.left == null || toDel.right == null){
                    if(toDel.left != null) root.left = toDel.left;
                    else root.left = toDel.right;
                }
                //3. if "to Del" has 2 child
                else{
                    //FIND THE INORDER PREDECESSOR AND ATTACH THE NODE TO THE ROOT(THE ROOT MAY VARY DUE TO RECURSION). "one position to the left, and move right until you meet null in the right". This is a shortcut to find INORDER PREDECESSOR
                    //1. Assign left to the left of toDel
                    Node left = toDel.left;
                    //2. Find the node pred
                    Node pred = left;
                    while(pred.right != null) pred = pred.right;
                    //3. The pred will have either 1 child or no child. So delete(detach the pred) from the tree using the same delete function
                    delete(root, pred.val);
                    //Now the pred node is detached from the tree, but we still have the access to pred node
                    //4. Attach left and right of toDel to pred
                    pred.left = toDel.left;
                    pred.right = toDel.right;
                    //5. Now attach the pred to curr root(note: the root may vary due to recursion, by root I don't mean the actual root value)
                    root.left = pred;
                }
            }
            else delete(root.left, delVal);
        }
        else if(delVal > root.val){ //go right
            if(root.right.val == delVal){
                Node toDel = root.right;
                //1. checking if "toDel" is a leaf node
                if(toDel.left == null && toDel.right == null) root.right = null;
                //2. checking if "toDel" has one child
                else if(toDel.left == null || toDel.right == null){
                    if(toDel.left != null) root.right = toDel.left;
                    else root.right = toDel.right;
                }
                //3. For 2 children
                else{
                    //FIND THE INORDER PREDECESSOR AND ATTACH THE NODE TO THE ROOT(THE ROOT MAY VARY DUE TO RECURSION). "one position to the left, and move right until you meet null in the right". This is a shortcut to find INORDER PREDECESSOR
                    //1. Assign left to the left of toDel
                    Node left = toDel.left;
                    //2. Find the node pred
                    Node pred = left;
                    while(pred.right != null) pred = pred.right;
                    //3. The pred will have either 1 child or no child. So delete(detach the pred) from the tree using the same delete function
                    delete(root, pred.val);
                    //Now the pred node is detached from the tree, but we still have the access to pred node
                    //4. Attach left and right of toDel to pred
                    pred.left = toDel.left;
                    pred.right = toDel.right;
                    //5. Now attach the pred to curr root(note: the root may vary due to recursion, by root i don't mean the actual root value)
                    root.right = pred;
                }
            }
            else delete(root.right, delVal);
        }
    }
    public static void main(String[] args) {
        String[] arr = {"10", "5", "17", "3", "6", "", "19", "", "4", "", "", "18", "20"};
        Node root = constructTree(arr);
        int lvl = findHeight(root) + 1;
        for(int i = 1; i<=lvl; i++){
            levelElements(root, i);
            System.out.println();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a node to delete: ");
        int nodeVal = sc.nextInt();

        //IF THE NODE TO BE DELTED IS A ROOT NODE
        if(nodeVal == root.val){
            Node temp = new Node(Integer.MAX_VALUE); //make a dummy node the root node
            temp.left = root; //since the root is always less than temp, we don't have to write a specific code to delete the root. just return temp.left after deleting
            delete(temp, nodeVal);
            root = temp.left;
        }
        else delete(root, nodeVal);

        System.out.println();
        for(int i = 1; i<=lvl; i++){
            levelElements(root, i);
            System.out.println();
        }
    }
}
