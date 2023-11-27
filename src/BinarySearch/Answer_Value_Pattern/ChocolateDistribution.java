package BinarySearch.Answer_Value_Pattern;

/*
Q: There are 'n' boxes and 'm' students. each boxes consist some no.of chocolates. The boxes should be distributed among all the 'm' students
    in such a way that the among all the possible combinations the one that has the minimum of maximums.
    boxes [5, 3, 1, 2, 4], students = 3
    1st possibility: [5][3][1 2 4] - max = 7
    2nd possibility: [5] [3 1] [2 4] - max = 6
    2nd possibility: [5 3] [1] [2 4] - max = 8
    ......

    Among all the maximums possible, return the min(maximums)
*/

public class ChocolateDistribution {
    static boolean isDistributionPossible(int[] arr, int m, int maxChocolate){
        int no_of_students = 1, total_choco = 0; //initially assigning 0 chocolates for student 1
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > maxChocolate) return false; //suppose if maxChocolate = 4, and if a box contains more than 4 chocolates. Then maxChocolate cannot be 4.

            if(arr[i]+total_choco <= maxChocolate){ //if this condition is met, then the box can be given to the current student
                total_choco += arr[i];
            }
            else{ //if the maxChocolate is reached, then...
                no_of_students++; //..the next student gets the..
                total_choco = arr[i]; //..current box of chocolates
            }
        }
        return no_of_students <= m; //if the no of students exceeds the given no of students, then the distribution among the student is not possible
    }
    static int findDistribution(int[] arr, int m){
        int ans = 0, st = 1, end = (int) 1e9; //taking the range from 1 to 10^9 as given in question
        while(st<=end){
            int mid = st + (end-st)/2;
            if(isDistributionPossible(arr, m, mid)){
                ans = mid;
                end = mid-1;
            }
            else st = mid+1;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        int students = 3;
        System.out.println("The minimum of all maximums is : " + findDistribution(arr, students));
    }
}
