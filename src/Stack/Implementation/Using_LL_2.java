package Stack.Implementation;

public class Using_LL_2 {
    public static class Node{
        int data;
        Node next;

        public Node(){}
        public Node(int data){this.data = data;}
    }
    public static class Stack{
        private Node head = null;
        private int size = 0;

        void push(int x){
            Node t = new Node(x);
            t.next = head;
            head = t;
            size++;
        }

        //DISPLAY FUNCTION
        private void displayHelper(Node h){
            if(h == null) return;
            displayHelper(h.next);
            System.out.print(h.data + " ");
        }
        void display(){ //SINCE WE NEED THE HEAD NODE TO PRINT THE LINKED LIST, BUT WE CAN'T PASS IT FROM OBJECT. SO USE THE HELPER FUNCTION
          displayHelper(head);
          System.out.println();
        }

        int pop(){
            if(head == null){
                System.out.println("Stack is empty");
                return -1;
            }
            int x = head.data;
            head = head.next;
            size--;
            return x;
        }

        int peek(){
            if(head == null){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }

        boolean isEmpty(){
           return head==null;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        //push
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);

        st.display();

        //pop
        st.pop();
        st.display();
        System.out.println(st.size);
    }
}
