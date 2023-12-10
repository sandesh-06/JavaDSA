package Stack.Implementation;

public class Using_Array_1 {
    public static class Stack{
       private int[] arr = new int[5]; //give some length
       private int curr_idx = 0;

       void push(int x){
           arr[curr_idx] = x; //push the element at curr idx
           curr_idx++; //inc idx
       }

       int peek(){
           if(curr_idx == 0){
               System.out.println("Stack is empty!");
               return Integer.MIN_VALUE; //not compulsory
           }
           return arr[curr_idx-1];
       }

       int pop(){
           if(curr_idx == 0){
               System.out.println("Stack is empty!");
               return Integer.MIN_VALUE; //not compulsory
           }
           curr_idx--;
           int ele = arr[curr_idx];
           arr[curr_idx] = 0;
           return ele;
       }

        int size(){
           return curr_idx;
        }

       void display(){
           for(int i = 0; i<curr_idx; i++){
               System.out.print(arr[i] + " ");
           }
           System.out.println();
       }

       boolean isEmpty(){
           return curr_idx == 0;
       }

       boolean isFull(){
           return curr_idx == arr.length;
       }

       int capacity(){
           return arr.length;
       }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        System.out.println("The size is: " + st.size());

        st.pop();
        st.display();

        System.out.println("The peek ele is: " + st.peek());

        st.push(4);
        st.push(5);
        st.display();
        System.out.println("Is the stack full: "+ st.isFull());
        st.pop();

        st.display();
        System.out.println("Is the stack full: "+ st.isFull());


    }
}
