package Recursion.RecursionInArrays;
import java.util.*;
public class sample {
        // Function to find GCD
        static int gcd(int a, int b)
        {
            if (b == 0)
            {
                return a;
            }
            return gcd(b, a % b);
        }

        static List<Integer> findMaxGCD(List<Integer> arr, int n)
        {

            // To store the maximum GCD
            int maxGCD = 0;
            int maxLen = 0;
            List<Integer> al = new ArrayList<>();
            // Traverse the array
            for(int i = 0; i < n - 1; i++)
            {
                int val = gcd(arr.get(i), arr.get(i+1));

                if (val > maxGCD)
                {
                    maxGCD = val;
                    maxLen = 2;
                }
                else if(val == maxGCD) maxLen++;
            }
            al.add(maxGCD);
            al.add(maxLen);
            return al;

        }

        // Driver Code
        public static void main(String[] args)
        {
           List<Integer> arr = new ArrayList<>();
           arr.add(4);
           arr.add(3);
           arr.add(6);
           arr.add(4);
           arr.add(12);
           arr.add(16);
           int n = arr.size();

            // Function call
            System.out.println(findMaxGCD(arr, n));
        }

}
