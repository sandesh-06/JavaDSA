package LinkedLists;

import java.util.LinkedList;

public class LL_5_Collection_Framework {
    public static class Node{
        int roll;
        String name;

        Node(int roll, String name){
            this.roll = roll;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        //1. TO ADD ELEMENTS
        ll.add(3);
        ll.add(31);
        ll.add(32);
        ll.add(33);
        ll.add(34);
        System.out.println(ll);

        //2. TO GET ELEMENTS
        System.out.println(ll.get(3)); //index 3

        //3. REMOVE ELEMENTS
        ll.remove(); //removes first element
        System.out.println(ll);
        ll.remove(3);//removes 3rd index
        System.out.println(ll);

        //4. DEFINING OWN DATATYPE
        LinkedList<Node> own_ll = new LinkedList<>();
        Node n1 = new Node(20, "Sandesh");
        own_ll.add(n1);

        Node n2 = new Node(21, "Sarah");
        own_ll.add(n2);

        System.out.println(own_ll.get(0).roll);
        System.out.println(own_ll.get(1).name);

        own_ll.get(0).roll = 33;
        System.out.println(own_ll.get(0).roll);
    }
}
