package Backtracking;

//1 MEANS YOU CAN GO THAT WAY, 0 MEANS THAT WAY IS BLOCKED.
public class P_1c_RatInAMaze_GFG {
    private static void findRoutes(int sr, int sc, int er, int ec, int[][] maze, String s){
        //1. USE THE BACKTRACKING APPROACH, BUT INSTEAD OF USING ANOTHER ARRAY, MAKE CHANGES TO THE SAME ARRAY.
        //2. IF THE PATH HAS 0, JUST RETURN
        //3. ONCE THE PATH IS EXPLORED, CHANGE IT TO -1

        if(sr > er || sc > ec) return;
        if(sr < 0 || sc < 0) return;
        if(sr == er && sc == ec){
            System.out.println(s);
            return;
        }
        if(maze[sr][sc] == 0) return;
        if(maze[sr][sc] == -1) return;

        maze[sr][sc] = -1;

        //right
        findRoutes(sr, sc+1, er, ec, maze, s+"R");
        //down
        findRoutes(sr+1, sc, er, ec, maze, s+"D");
        //left
        findRoutes(sr, sc-1, er, ec, maze, s+"L");
        //up
        findRoutes(sr-1, sc, er, ec, maze, s+"U");

        maze[sr][sc] = 1;
    }
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};

        int sr = 0, sc = 0, er = maze.length, ec = maze[0].length;
        System.out.println("rows: " + maze[0].length);
        findRoutes(sr, sc, er-1, ec-1, maze, "");
    }
}
