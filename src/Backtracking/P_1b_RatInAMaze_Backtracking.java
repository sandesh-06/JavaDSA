package Backtracking;

//WHEN YOU NEED TO MOVE IN ALL 4 DIRECTIONS, WE NEED BACKTRACKING
/*
    IN BACKTRACKING YOU NEED TO LEAVE A CHECK SAYING THAT THIS BLOCK HAS BEEN VISITED
*/
public class P_1b_RatInAMaze_Backtracking {
    //1ST TRY: THIS FUNCTION WILL BE STUCK IN A INFINITE LOOP, BECAUSE THE RAT MAY KEEP VISITING THE BLOCK IT HAS ALREADY EXPLORED
//    private static void pathInMaze(int sr, int sc, int er, int ec, String s){
//        if(sr > er || sc > ec) return;
//        if(sr < 1 || sc < 1) return;
//        if(sr == er && sc == ec){
//            System.out.println(s);
//            return;
//        }
//
//        //right
//        pathInMaze(sr, sc+1, er, ec, s+"R");
//        //down
//        pathInMaze(sr+1, sc, er, ec, s+"D");
//        //left
//        pathInMaze(sr, sc-1, er, ec, s+"L");
//        //up
//        pathInMaze(sr-1, sc, er, ec, s+"U");
//    }

    //2nd TRY: KEEP A CHECK TO VISITED BLOCK SO THAT THE RAT DOESN'T VISIT IT AGAIN
    //TO DO THAT YOU NEED AN 2D MATRIX OF THE SAME SIZE AS THE MAZE
//    private static void pathInMaze(int sr, int sc, int er, int ec, String s,  boolean[][] keepTrack){
//        if(sr > er || sc > ec) return;
//        if(sr < 0 || sc < 0) return;
//        if(sr == er && sc == ec){
//            System.out.println(s);
//            return;
//        }
//        //2. WHEN THE BLOCK IS TRUE, JUST RETURN
//        if(keepTrack[sr][sc] == true) return;
//
//        //1. WHEN YOU ARE ON (sr, sc) MAKE IT TRUE, SO THAT IT IS NOT VISITED AGAIN
//        keepTrack[sr][sc] = true;
//        //right
//        pathInMaze(sr, sc+1, er, ec, s+"R", keepTrack);
//        //down
//        pathInMaze(sr+1, sc, er, ec, s+"D", keepTrack);
//        //left
//        pathInMaze(sr, sc-1, er, ec, s+"L", keepTrack);
//        //up
//        pathInMaze(sr-1, sc, er, ec, s+"U", keepTrack);
//    }

    //3rd TRY: SINCE ARRAY IS PASSED BY REFRENCE, WHEN WE CHANGE A VALUE TO TRUE, FOR THE NEXT PATH THE BLOCK WILL STILL BE TRUE WHICH IS NOT RIGHT
    //WHEN WE TRY ANOTHER PATH WE NEED EVERY PATH TO BE FALSE AGAIN
    //SO ONCE YOU'VE EXPLORED ONE PATH, MAKE THE BLOCKS OF THE PATH AS FALSE AGAIN
    private static void pathInMaze(int sr, int sc, int er, int ec, String s,  boolean[][] keepTrack){
        if(sr > er || sc > ec) return;
        if(sr < 0 || sc < 0) return;
        if(sr == er && sc == ec){
            System.out.println(s);
            return;
        }
        //2. WHEN THE BLOCK IS TRUE, JUST RETURN
        if(keepTrack[sr][sc] == true) return;

        //1. WHEN YOU ARE ON (sr, sc) MAKE IT TRUE, SO THAT IT IS NOT VISITED AGAIN
        keepTrack[sr][sc] = true;
        //right
        pathInMaze(sr, sc+1, er, ec, s+"R", keepTrack);
        //down
        pathInMaze(sr+1, sc, er, ec, s+"D", keepTrack);
        //left
        pathInMaze(sr, sc-1, er, ec, s+"L", keepTrack);
        //up
        pathInMaze(sr-1, sc, er, ec, s+"U", keepTrack);

        //3. ONCE THE PATH IS FOUND, MAKE IT FALSE AGAIN
        keepTrack[sr][sc] = false;
    }
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        //1ST TRY:
//        pathInMaze(1, 1, row, col, "");

        boolean[][] keepTrack = new boolean[row][col];

        //2ND TRY:
//        pathInMaze(0, 0, row-1, col-1, "", keepTrack);

        //3rd TRY:
        pathInMaze(0, 0, row-1, col-1, "", keepTrack);
    }
}
