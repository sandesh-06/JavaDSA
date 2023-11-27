package BinarySearch;

import java.util.Scanner;

public class FindNearestRootValue {
    static int findRoot(int num){
       int start = 0, end = num;
       int ans = 0;
       while(start<=end){
           int mid = start + (end -start)/2;
           int val = mid*mid;
           if(val == num) return mid;
           else if(val>num) end = mid-1;
           else{
              ans = mid;
              start = mid+1;
           }
       }
       return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find it's nearest root value: ");
        int num = sc.nextInt();
        System.out.printf("The nearest sqroot of %d is %d", num, findRoot(num));
    }
}
