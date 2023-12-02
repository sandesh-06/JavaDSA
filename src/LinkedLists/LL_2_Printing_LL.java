package LinkedLists;

public class LL_2_Printing_LL {
    public static void displayLL(Node head){
        //here head already points to a, so no need of separate temp var
        while(head!=null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

    public static void recursionDisplayLL(Node head){
        if(head == null)return;
        System.out.print(head.data + " -> ");
        recursionDisplayLL(head.next);
    }

    public static void reverseLL(Node head){
        if(head == null)return;
        reverseLL(head.next);
        System.out.print(head.data + " -> ");
    }

    public static class Node{
    int data;
    Node next;
    //creating a constructor to set the data value
    public Node(int data){
        this.data = data;
    }
}
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);
        Node e = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        //to print the linked list using for loop. You need to access all the elements using the head element only
        System.out.println("Displaying using for loop: ");
        Node temp1 = a; //initially temp point to a.
        for(int i = 1; i<=5; i++){
            System.out.print(temp1.data + " -> ");
            temp1 = temp1.next; //temp = b ( because temp.next means a.next )
        }
        System.out.println();

        //using while loop, because we don't know the size of the list - THIS IS THE CORRECT WAY FOR PRINTING LL
        System.out.println("Displaying using while loop: ");
        Node temp2 = a;
        while(temp2!=null){
            System.out.print(temp2.data + " -> ");
            temp2 = temp2.next;
        }
        System.out.println();

        //displaying using function
        System.out.println("Displaying using a function: ");
        displayLL(a);
        System.out.println();

        //displaying using recursion
        System.out.println("Displaying using recursion: ");
        recursionDisplayLL(a);
        System.out.println();

        //display reverse of LL
        System.out.println("Reverse LL: ");
        reverseLL(a);
        System.out.println();

    }
}
