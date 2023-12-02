package LinkedLists;

/*
* Basic structure of linked list contains 2 nodes, data node and address node eg: 5|addr -> 3|addr -> 9|addr -> 12|null
* The address of the next node will be stored in the previous node
* We create our own data type Node, using class
* It contains int data and Node next. The Node next will have the address of next node
* */

public class LL_1_Basics {
    public static class Node{
        int data; // stores the data
        Node next; //stores the address

        //creating a constructor to set the data value
        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        System.out.println("Node a data: " + a.data); //will print the data
        System.out.println("Address of Node a: " + a); //this gives the address of Node a
        System.out.println("next of Node a initially: " + a.next); //initially the next will have 'null' value

        //say if I am creating another node:
        Node b = new Node(10);
        a.next = b;
        System.out.println("next of Node a: " + a.next);//$Node@7b23ec81
        System.out.println("Address of node b: " + b);//$Node@7b23ec81
        System.out.println("Accessing node b's data through a: " + a.next.data);
        //we can see that the next pointer of node 'a' has stored the address of node b.

        Node c = new Node(32);
        b.next = c; //next of node b will have address of c
        Node d = new Node(12);
        c.next = d; //next of node c will have address of d, and next of d will have null.

        System.out.println("Printing all a,b,c,d using only a: ");
        System.out.println("a: " + a.data);
        System.out.println("b: " + a.next.data);
        System.out.println("c: " + a.next.next.data);
        System.out.println("d: " + a.next.next.next.data);
        //THIS IS THE STRUCTURE AND IT'S DECLARATION IN LINKED LIST
    }
}
