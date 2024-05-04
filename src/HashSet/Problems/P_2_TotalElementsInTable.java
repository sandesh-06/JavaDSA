package HashSet.Problems;

import java.util.HashSet;

/*
You are given n distinct pairs. Each pair is numbered from 1 to n. All these pairs are initially put in a bag. You need to pair up each number.
You take numbers one by one from the bag and for each number you look whether the pair of this number has already been taken out of the bag, or not.
If not (that means the pair of this number is still in the bag), you put the current number on the table in front of him. Otherwise, you put both numbers from the pair aside.
Print the maximum number of numbers that were on the table at the same time.
*/
public class P_2_TotalElementsInTable {
    public static int findTableCount(int[] bag){
        HashSet<Integer> table = new HashSet<>();

        int table_size = 0;
        for(int num: bag){
            if(!table.contains(num)) { //if the number is not on the table
                table.add(num);
                table_size = Math.max(table.size(), table_size);
            }
            else{ //if the number is already on the table
                table.remove(num); //remove the number
            }
        }
        return table_size;
    }
    public static void main(String[] args) {
        int[] bag = {2, 1, 1, 4, 3, 2, 3, 4};
        System.out.println(findTableCount(bag));
    }
}
