package PriorityQueue.Problems;

import java.util.*;

/*
    You are given a set of points in a XY plane. You need to find the k closest points from the origin using manhattan distance.
    eg: n = 6, k = 3
    points:         output:
    5 3             1 2
    1 2             3 4
    3 4             5 3
    5 6
    7 8
    9 10
*/
public class P_2_KPointsFromOrigin {
    public static int manhattanDistance(int x1, int y1){
        int dist = (int) Math.sqrt((x1 * x1) + (y1 * y1)); //since x2 and y2 are 0,
        return dist;
    }
    private static class DistComparator implements Comparator<List<Integer>>{
        @Override
        public int compare(List<Integer> arr1 ,List<Integer> arr2){
            int dist1 = manhattanDistance(arr1.get(0), arr1.get(1));
            int dist2 = manhattanDistance(arr2.get(0), arr2.get(1));

            if(dist1 > dist2) return 1;
            else if(dist1 < dist2) return -1;
            else return 0;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> ls = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            List<Integer> innerls = new ArrayList<>();
            innerls.add(n1);
            innerls.add(n2);
            ls.add(innerls);
        }
        int k = 3;

        //1. Intialize a PQ with a custom comparator that should compare the distance.
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new DistComparator());

        //2. Traverse through the 2d list of points
        for(int i = 0; i < ls.size(); i++){
            //3. calculate the distance between points and origin
            int curr_dist = manhattanDistance(ls.get(i).get(0), ls.get(i).get(1));

            //4. If the size reaches k, check the distance of peek point of PQ and current point
            if(pq.size() == k){
                int peek_dist = manhattanDistance(pq.peek().get(0), pq.peek().get(1));
                if(curr_dist < peek_dist){ //if the curr distance < peek distance swap
                    pq.remove();
                    pq.add(ls.get(i));
                } else continue;
            }else{ //5. if the size hasn't reached, simply add
                pq.add(ls.get(i));
            }
        }

        System.out.println(pq);
    }
}
