package BinarySearch.Answer_Value_Pattern;

/*
A new racing track for kids is being built in New York with 'n' starting spots. The spots are located along a straight line at positions x1, x2... xn(xi <=10^9).
For each 'i', xi+1 > xi. At a time only 'm' children are allowed to enter the race. Since the race track is for kids, they may run into each other while running.
To prevent this, we want to choose the starting spots such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
The first line of input will contain the value of n, the number of starting spots. The second line of input will contain the n numbers denoting the location of each spot.
The third line will contain the value of m, number of children.

Input
5
1 2 4 8 9
3
Output
3
*/
public class Race_track {
    static boolean isDistancePossible(int[] arr, int kids, int min_distance_allowed){ //taking m_d_a = 3
        int kids_placed = 1; //total kids placed
        int last_kid_placed_on_track = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i]-last_kid_placed_on_track >= min_distance_allowed ){ //2-1= 1(won't work) , 4-1 = 3 (works)
                kids_placed++; //kids placed will become 2
                last_kid_placed_on_track = arr[i]; //the 2nd kid will be placed on arr[i], so now we can calculate for the 3rd kid from the position of 2nd kid.
            }
        }

       return kids_placed >= kids; //if the given kids cannot be placed according to the condition return false, if yes return true
    }
    static int findMaxDistance(int[] arr, int kids){
        int st = 1, end = (int) 1e9, ans = 0;
        while(st<=end){
            int mid = st + (end - st)/2;
            if(isDistancePossible(arr, kids, mid)){ //checking if is mid that minimum distance that the kids should maintain
                ans = mid;
                st = mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 8};
        int kids = 3;
        System.out.println(findMaxDistance(arr, kids));

    }
}
