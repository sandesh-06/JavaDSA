package BinaryTrees.Traversals;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BT_04_DFS {
    public static class Node{
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
    }
    }
    //DFS INORDER
    private static List<Integer> DFS_Inorder(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ls = new ArrayList<>();
        //Inorder: Left Root Right
        st.push(root);
        while(st.size() > 0){
            Node temp = st.peek();
           if(temp.left != null){
               st.push(temp.left);
               temp.left = null; //IT IS VERY IMPORTANT TO BREAK THE CONNECTION, OR ELSE IT WILL KEEP LOOPING
           }
           else{ //if left doesn't exist
               st.pop();  //first pop the node from stack
               ls.add(temp.val); //add the node val to array
               if(temp.right != null){ //check if right exist
                   st.push(temp.right);
                   temp.right = null;
               }
           }
        }
        return ls;
    }

    //DFS PREORDER
    private static List<Integer> DFS_Preorder(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ls = new ArrayList<>();
        //PREORDER: Root Left Right
        st.push(root);
        while(!st.isEmpty()){
            Node temp = st.peek();
            ls.add(temp.val);
            st.pop();

            //if the node temp has left and right children add them to the stack
            if(temp.right != null) st.push(temp.right); //first push the right element
            if(temp.left != null) st.push(temp.left);
        }

        return ls;
    }

    //DFS POSTORDER
    private static List<Integer> DFS_Postorder(Node root){
        List<Integer> ls = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node temp = st.peek();
            if(temp.right!=null){
                st.push(temp.right);
                temp.right = null;
            }
            if(temp.left != null){
                st.push(temp.left);
                temp.left = null;
            }
            else if(temp.left == null && temp.right == null){
                ls.add(temp.val);
                st.pop();
            }
        }
        return ls;
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

//        System.out.println("DFS Inorder: " + DFS_Inorder(root));
//        System.out.println("Preorder: " + DFS_Preorder(root));
        System.out.println("Postorder: " + DFS_Postorder(root));
    }
}
