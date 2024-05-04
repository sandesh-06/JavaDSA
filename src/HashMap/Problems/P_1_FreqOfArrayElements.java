package HashMap.Problems;

import java.util.HashMap;
import java.util.Map;

public class P_1_FreqOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 3, 4, 1};

        Map<Integer, Integer> mp = new HashMap<>();

        for (int n: arr){
            if(!mp.containsKey(n)){
                mp.put(n, 1);
            }
            else{
                mp.put(n, mp.get(n)+1);
            }
        }
        System.out.println(mp);

        //find the highest frequency
        int max = 0;
        int val = 0;
        for(var entry: mp.entrySet()){
            if(entry.getValue() > max){
                val = entry.getKey();
                max = entry.getValue();
            }
        }
        System.out.println(val);
    }
}
