package Backtracking;

//RAT IN A MAZE WITH 2 DIRECTIONS - RIGHT AND DOWN

public class P_1a_RatInAMaze_Recursion {
    private static int rimTwoDirection(int sr, int sc, int er, int ec){
//        if(sr < 0 || sc < 0) return 0;
        if(sr > er || sc > ec) return 0;
        if(sr == er && sc == ec) return 1;

        int right = rimTwoDirection(sr,sc+1, er, ec);
        int up = rimTwoDirection(sr+1, sc, er, ec);

        return right+up;
    }

    private static void pathOfMaze(int sr, int sc, int er, int ec, String s){
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec){
            System.out.println(s);
            return;
        }
        //if you go right
        pathOfMaze(sr, sc+1, er, ec, s+"R");
        //if you go down
        pathOfMaze(sr+1, sc, er, ec, s+"D");
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 3;

        System.out.println("total directions: " + rimTwoDirection(1, 1, row, col));
        System.out.println("Paths:");
       pathOfMaze(1, 1, row, col, "");
    }
}
