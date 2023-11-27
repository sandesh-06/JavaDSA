package Arrays;
import java.util.Scanner;

public class MaxElement {

   public static int findMax(int[] myArr){ //90 2 1
        int maxEle = myArr[0];
        for(int i=0; i<myArr.length; i++){
            if(myArr[i] > maxEle){
                maxEle = myArr[i];
            }
        }
        return maxEle;
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
        int arraySize, maxArrayElement;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the arary: ");
        arraySize = sc.nextInt();
        int[] myArr = new int[arraySize];
        //to add elements in the array
        addElementsInArray(myArr);

        //to find max element in the array
        maxArrayElement = findMax(myArr);
        System.out.println("The maximum element of the array is: " + maxArrayElement);
    }
}
