package GenericTrees.Traversals;
import java.util.ArrayList;
import java.util.List;
import static GenericTrees.Basics.B_1_TreeImplementation.buildTree;

/*
                        20
               /        |       \
              10       21       43
          /   |  \    |  \    /  |  \
         2   15  6    9  13  7   45  76
*/
public class T_1_DFS {
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

    //PREORDER - ROOT  CHILD
    public static void preOrder(Node root){
        if(root.child.isEmpty()){
            //if you've reached leaf node, print the value and return.
            System.out.print(root.val + " ");
            return;
        }

        //print the root value - ROOT
        System.out.print(root.val + " ");

        //traverse through the children of the root and perform preorder on them - CHILD
        for(int i = 0; i < root.child.size(); i++){
            preOrder(root.child.get(i));
        }
    }

    //POSTORDER - CHILD  ROOT
    public static void postOrder(Node root){
        if(root.child.isEmpty()){
            //print the leaf node.
            System.out.print(root.val + " ");
            return;
        }

        //traverse through the children of the root - CHILD
        for(int i = 0; i < root.child.size(); i++){
            postOrder(root.child.get(i));
        }

        //print the root value - ROOT
        System.out.print(root.val + " ");
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        buildTree(root);

        System.out.println("Preorder: ");
        preOrder(root);

        System.out.println("\nPostorder: ");
        postOrder(root);
    }
}
