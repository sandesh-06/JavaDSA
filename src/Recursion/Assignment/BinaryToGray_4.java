package Recursion.Assignment;

import java.util.Scanner;

public class BinaryToGray_4 {
    static int findGray(int gNo){
        //base case;
        if(gNo == 0){
            return 0;
        }

        //recursive work
        int recAns = findGray(gNo/10);
        System.out.println(recAns);
        //self work:
        int lNo, slNo;
        lNo = gNo %10;
        slNo = (gNo/10) % 10;
        if(lNo == slNo){
            return (recAns * 10);
        }else{
            return (recAns*10) + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1001;
        System.out.println(findGray(n));
//        System.out.println(1%10);
//        System.out.println((100110/10) % 10);
    }
}
