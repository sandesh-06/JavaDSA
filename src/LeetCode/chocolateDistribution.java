package LeetCode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*Given an array of N integers where each value represents the number of chocolates in a packet.
 Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:
Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.*/

public class chocolateDistribution {
    public static int solveChocDistribution(int noOfStd, ArrayList<Integer> arr){
        int min, minDiff = arr.size()-1;
        for(int i = 0; i+noOfStd < arr.size(); i++){
            min = arr.get(i+(noOfStd-1)) - arr.get(i);
            if(min < minDiff ){
                minDiff = min;
            }
        }
        return minDiff;
    }

    public static int solveOneLine(int noOfStd, ArrayList<Integer> arr){
        int minDiff = Integer.MAX_VALUE; //this is the maximum possible number in computer language
        for(int i = 0; i+noOfStd-1 < arr.size(); i++){
            minDiff = Math.min(arr.get(1+(noOfStd-1))-arr.get(1), minDiff );
        }
        return minDiff;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int noOfStd, noOfPackets;
        System.out.println("Enter no.of students: ");
        noOfStd = sc.nextInt();
        System.out.println("Enter no.of packets: ");
        noOfPackets = sc.nextInt();

        System.out.println("Enter the packets containing no.of chocolates: ");
        for(int i = 0; i<noOfPackets; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        System.out.println(arr);

        System.out.println("The minimum diff is: ");
        System.out.println(solveChocDistribution(noOfStd, arr));

        System.out.println("Using one line code: ");
        System.out.println(solveOneLine(noOfStd, arr));
    }
}
