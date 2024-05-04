package Backtracking;

//RETURN THE MAX NUMBER OF KNIGHTS WHICH CAN BE PLACE IN THE BOARD, WITHOUT ATTACKING EACH OTHER
public class P_2_PlaceKnights {
    static int max_knights = 0;
    private static boolean isSafe(char[][] board, int curr_row, int curr_col){
        int len = board.length;
        //2up 1right
        int i = curr_row - 2;
        int j = curr_col + 1;
        if(i>=0 && j<len && board[i][j] == 'K') return false;

        //2up 1left
        i = curr_row - 2;
        j = curr_col - 1;
        if(i>=0 && j>=0 && board[i][j] == 'K') return false;

        //2left 1up
        i = curr_row - 1;
        j = curr_col - 2;
        if(i>=0 && j>=0 && board[i][j] == 'K') return false;

        //2right 1up
        i = curr_row - 1;
        j = curr_col + 2;
        if(i>=0 && j<len && board[i][j] == 'K') return false;

        //2down 1left
        i = curr_row + 2;
        j = curr_col - 1;
        if(i<len && j>=0 && board[i][j] == 'K') return false;

        //2down 1right
        i = curr_row + 2;
        j = curr_col + 1;
        if(i<len && j<len && board[i][j] == 'K') return false;

        //2left 1down
        i = curr_row + 1;
        j = curr_col - 2;
        if(i<len && j>=0 && board[i][j] == 'K') return false;

        //2right 1down
        i = curr_row + 1;
        j = curr_col + 2;
        if(i<len && j<len && board[i][j] == 'K') return false;

        return true;
    }
    public static void nKnights(char[][] board, int curr_row, int curr_col, int total_knights){
        int len = board.length;
        if(curr_row >= len){
            for(int i = 0; i<len; i++){
                for(int j = 0; j<len; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            max_knights = Math.max(max_knights, total_knights);
            return;
        }

        else if(isSafe(board, curr_row, curr_col)){
            board[curr_row][curr_col] = 'K';

            if(curr_col!=len-1) nKnights(board, curr_row, curr_col+1, total_knights+1); //Knights can be placed next to next, so we need to check at every col at each row, if we are at the last col we cannot call curr_col+1
            else nKnights(board, curr_row+1, 0, total_knights+1); //if you are at the last col, call the function for the next row

            board[curr_row][curr_col] = 'x'; //perform backtracking
        }
        //ONCE BACKTRACKING IS DONE, WE NEED TO CHECK FOR THE NEXT BOX, SO DEFINING IT IN ELSE STATEMENT WOULD BE WRONG.
        if(curr_col!=len-1) nKnights(board, curr_row, curr_col+1, total_knights); //you are not placing the knight, so don't increase it.
        else nKnights(board, curr_row+1, 0, total_knights);
//        else{
//            if(curr_col!=len-1) nKnights(board, curr_row, curr_col+1);
//            else nKnights(board, curr_row+1, 0);
//        }
    }
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        //fill the board with 'x'
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = 'x';
            }
        }
//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<n; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
        nKnights(board, 0, 0, 0);
        System.out.println("Max knights can be placed is: " + max_knights);
    }
}
