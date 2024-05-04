package Queue.CircularQueue;

// 1 2 3 4 5 6 7 8 9 10
// pop 2 elements : 3 4 5 6 7 8 9 10
// add 2 elements: 11 12 3 4 5 6 7 8 9 10
//this is circular queue

public class CQ_1_UsingArray {
    public static class CircularQ{
        int[] arr = new int[10];
        int front = -1;
        int rear = -1;
        private static int size = 0;

        //1. To add elements
        void add(int val){
            if(size == 0){
                front = rear = 0;
                arr[0] = val;
            }
            else if(size == arr.length){
                System.out.println("Queue is full");
                return;
            }
            else if(rear == arr.length-1){
                rear = 0;
                arr[0] = val;
            }
            else{
                arr[++rear] = val;
            }

            size++;
        }

        //2. To remove elements
        int remove(){
            int ele = 0;
            if(size == 0){
                System.out.println("Queue is empty");
                return -1;
            }
            else if(front == arr.length-1){
                ele = arr[front];
                front = 0;
            }
            else{
                ele = arr[front++];
            }
            size--;
            return ele;
        }

        void display(){
            if(front <= rear){
                for(int i = front; i<=rear; i++){
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            else{
                //a loop from, front to len-1
                for(int i = front; i<arr.length; i++){
                    System.out.print(arr[i] + " ");
                }
                //a loop from, 0 to rear
                for(int i = 0; i<=rear; i++){
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }

        int size(){
            return size;
        }
    }
    public static void main(String[] args) {
        CircularQ cq = new CircularQ();

        cq.add(30);
        cq.add(31);
        cq.add(32);
        cq.add(33);
        cq.add(34);
        cq.add(35);
        cq.add(36);
        cq.add(37);
        cq.add(38);
        cq.add(39);
        cq.display();
        System.out.println(cq.size());
        cq.remove();
        cq.display();
//
        cq.add(40); //the element is added at index 0, but while displaying it's displayed correctly
        cq.display();

        //printing the actual array
        System.out.println("The actual array: ");
        for(int i = 0; i<cq.arr.length; i++){
            System.out.print(cq.arr[i] + " ");
        }
    }
}
