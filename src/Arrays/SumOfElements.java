package Arrays;
import java.util.Scanner;

public class SumOfElements {
    static int sumOfArrayElements(int[] myArr){
        int totalSum = 0;
        for(int num: myArr){
            totalSum += num;
        }
        return totalSum;
    }
    public static void addElementsInArray(int[] myArr){
        int arrayElements;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements: ");
        for(int i=0; i<myArr.length; i++){
            arrayElements = sc.nextInt();
            myArr[i] = arrayElements;
        }
    }
    public static void main(String[] args) {
        int userInp, sumOfArray;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        userInp = sc.nextInt();
        int[] myArr = new int[userInp];
        addElementsInArray(myArr);

        sumOfArray = sumOfArrayElements(myArr);
        System.out.println("The sum of the array is: " + sumOfArray);
    }
}
