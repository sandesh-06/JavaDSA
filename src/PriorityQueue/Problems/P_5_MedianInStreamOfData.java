package PriorityQueue.Problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
    Find the median at any given point with incoming stream of datas.
    eg:
        11, 82, 19 => median = 82
        11, 82, 19, 21, 29, 12 => median = 19+21/2 = 20

     This is a question related to real life example where we keep getting real time datas every second and you need to find the median
     while the data keeps growing

     INTUTION:
        1. We can sort the array and find the median, but we need to sort the array everytime a data comes in and becomes more complex
        with large no of datas

        2. Using PQ:
            1. We can have 2 Priority Queues, one max heap and other min heap
            2. We need to split the data and store it in the 2 heaps
            3. Why 2 PQ?
                Eg: data = {5, 1, 15, 6, 8, 10, 11}
                max heap (leftPQ)   |   min heap (rightPQ)
               [1, 5, 6, 8] |  [11, 10, 15]
               Now for the above data the median will be 8 which is the peek of max heap
               if the data is even then the median will be (maxHeap.peek() + minHeap.peek()) / 2
           4. Adding data conditions:
              1. If the data < leftPQ.peek() add to the left
              2. else add to right
              3. while adding make sure the splitting condition is maintained.
           5. Splitting condition:
              1. The first data should be inserted in left PQ (max heap)
              2. The difference between the sizes of the two heap should not be more than 1.
              3. Size of leftPQ can be 1 more than right PQ size but not vice versa.
              Eg: leftPQ size = 3, rightPQ size = 2 (allowed)
              Eg: leftPQ size = 3, rightPQ size = 3 (allowed)
                  leftPQ size = 3, rightPQ size = 4 (not allowed)
                  because for odd nos of data the median should lie on peek of leftPQ.

 */
public class P_5_MedianInStreamOfData {
    private static void addData( PriorityQueue<Integer> leftPQ,  PriorityQueue<Integer> rightPQ, int data){
        //1. If leftPQ is empty, add data to leftPQ
        if(leftPQ.isEmpty()) leftPQ.add(data);

        //2. leftPQ not empty
        else{
            //3. check if data is lesser than max element of leftPQ
            if(data < leftPQ.peek()){
                //4. Check if the size of both the PQ are equal
                //5. If size is equal and data should be added to left, it's not a problem
                if(leftPQ.size() == rightPQ.size()) leftPQ.add(data);

                //6. if the size is not equal that means left is bigger, so we can't add data directly (since size diff becomes > 1)
                else{
                    //7. Inorder to maintain the size diff 1, shift the max of leftPQ to rightPQ and add data to left
                    rightPQ.add(leftPQ.remove());
                    leftPQ.add(data);
                }
            }
            //8. If the data is greater than max element of leftPQ, add it to rightPQ
            else{
                //9. check if the size of both PQ is equal
                //10. if equal you can't add the data to right PQ, as size of rightPQ cannot be > size of leftPQ
                if(leftPQ.size() == rightPQ.size()){
                    //11. shift the min ele from rightPQ to leftPQ and add data to right
                    leftPQ.add(rightPQ.remove());
                    rightPQ.add(data);
                }
                //12. If the size is not equal, it means right is smaller so we can add without a problem
                else rightPQ.add(data);
            }
        }
    }
    private static double getMedian(PriorityQueue<Integer> leftPQ,  PriorityQueue<Integer> rightPQ){
        if(leftPQ.isEmpty()) return -1;
        else if(leftPQ.size() > rightPQ.size()) return (double) leftPQ.peek();
        else return (double) (leftPQ.peek() + rightPQ.peek()) / 2;
    }
    public static void main(String[] args) {

        PriorityQueue<Integer> leftPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
        addData(leftPQ, rightPQ, 15);
        System.out.println("Median: " + getMedian(leftPQ, rightPQ)); //Median: 15

        addData(leftPQ, rightPQ, 10);
        addData(leftPQ, rightPQ, 5);
        System.out.println("Median: " + getMedian(leftPQ, rightPQ)); //Median: 10

        addData(leftPQ, rightPQ, 20);
        System.out.println("Median: " + getMedian(leftPQ, rightPQ)); //Median: 12.5

        addData(leftPQ, rightPQ, 25);

    }
}
