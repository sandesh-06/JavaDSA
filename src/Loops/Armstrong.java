package Loops;
import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rangeNo, tempNo, remainder, result = 0;
        rangeNo = sc.nextInt();
        for(int i=1; i<rangeNo; i++){
            tempNo = i;
            while(tempNo != 0){
//                System.out.println("TempNo: " + tempNo );
                remainder = tempNo % 10;
//                System.out.println("remainder: " + remainder);
                result += Math.pow(remainder, 3);
//                System.out.println("result: " + result);
                tempNo /= 10;
//                System.out.println("tempNo: " + tempNo);
            }
            if(result == i) {
                System.out.println(i);
            }
            result = 0;
        }

    }
}
