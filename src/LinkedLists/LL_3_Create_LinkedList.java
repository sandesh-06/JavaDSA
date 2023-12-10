package LinkedLists;

public class LL_3_Create_LinkedList {
    public static class Node{ //USER DEFINED DATA TYPE
        int data;
        Node next;

        public Node(){}

        public Node(int data){
            this.data = data;
        }
    }
    public static class linkedlist{ //USER DEFINED DATA STRUCTURE
        //initially
        Node head = null;
        Node tail = null;
        int size=0; //everytime some element is inserted, increase the size by 1 to improve time complexity
        //1. METHOD TO INSERT AT END OF LL
        void insertAtEnd(int val){
            //create a Node containing val
            Node new_node = new Node(val);
            //if the linked list is empty, the first element is the head and tail both
            if(head == null){
                head = new_node;
                tail = new_node;
            }
            else{
                tail.next = new_node; //store the new node's address in present tail's
                tail = new_node; //now new node becomes the tail
            }
            size++;
        }

        //2. METHOD TO INSERT AT BEGINNING OF LL
        void insertAtBeginning(int val){
            Node new_node = new Node(val);
            if(head == null){
               insertAtEnd(val); //ykiyk
            }
            else{
                new_node.next = head;
                head = new_node;
            }
            size++;
        }

        //3. METHOD TO INSERT AT A PARTICULAR INDEX
        void insertAt(int idx, int val){
            if(idx > size() || idx < 0){//if size is 5, idx = 6. That is not possible
                System.out.println("Invalid index!!");
                return;
            }
            else if (idx == size()) { //if size is 5, idx = 5. Then insert at end
                insertAtEnd(val);
                return;
            } else if (idx == 0) { //if this is ignored, the val won't be added at the beginning
                insertAtBeginning(val);
                return;
            }
            Node new_node = new Node(val);
            //create a temp node
            Node temp = head;
            for(int i = 1; i<idx; i++){
                temp= temp.next; //now temp will point at idx-1 list
            }
            new_node.next = temp.next;
            temp.next = new_node;

            size++;
        }

        //4. METHOD TO GET ELEMENT AT PARTICULAR INDEX
        int getElementAt(int idx){
            if(idx > size() || idx < 0){//if size is 5, idx = 6. That is not possible
                System.out.println("Invalid index!!");
                return -1;
            }
            Node temp = head;
            for(int i = 0; i<idx; i++){
                temp = temp.next;
            }
            return temp.data;
        }

        //5. DELETE ELEMENT AT AN INDEX
        void deleteAt(int idx){
            if(idx == 0){
                head = head.next;
                size--;
                return;
            }
            Node temp = head;
            for(int i = 0; i<idx-1; i++){
                temp = temp.next;
            }
            if(idx == size-1){ //if you delete the last element, then update the tail to the prev element
                tail = temp;
            }
            temp.next = temp.next.next;
            size--; //very important bro
        }

        int size(){
            return size;
//            int count = 0; //this function gives a time comp of O(n)
//            Node temp = head;
//            while(temp!=null){
//                count++;
//                temp = temp.next;
//            }
//            return count;
        }

        void display(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.insertAtEnd(5);
        ll.insertAtEnd(12);
        ll.insertAtEnd(15);
        ll.insertAtEnd(17);

        System.out.println("1. Size of linked list: " + ll.size());
        System.out.print("2. Insert at end: ");
        ll.insertAtEnd(22);
        ll.display();

        System.out.print("3. Insert at beginning: ");
        ll.insertAtBeginning(19);
        ll.display();

        System.out.print("4. Insert at a index 3: ");
        ll.insertAt(3, 6);
        ll.display();

        System.out.println("5. Element at index 2: " + ll.getElementAt(2));

        System.out.print("6. LL after deleting element at index 6: ");
        ll.deleteAt(6);
        ll.display();
        System.out.println("7. The tail has been changed to: " + ll.tail.data);

        System.out.print("8. LL after deleting element at index 0: ");
        ll.deleteAt(0);
        ll.display();

    }
}
