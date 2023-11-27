package Recursion.Assignment;

public class DecimalToBinary_3 {
    static int findBinary(int decNo){   //7
        if(decNo == 0){
            return 0;
        }
               //7 % 2 = 1 + (10 * 11)
       return ((decNo % 2) + (10 * findBinary(decNo/2)));
    }
    public static void main(String[] args) {
        System.out.println(findBinary(7));
//        System.out.println(7/2);
    }
}
