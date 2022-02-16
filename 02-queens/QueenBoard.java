public class QueenBoard {

    private int[][] board;
    
    private boolean animated;
    private int delay;
    
    public void setAnimate(boolean bool){
        animated = bool;
    }

    public void setDelay(int d){
        delay = d;
    }

    public QueenBoard(int size){
        board = new int[size][size];
    }

    /**
    *@return The output string formatted as follows:
    *All numbers that represent queens are replaced with 'Q'
    *all others are displayed as underscores '_'
    *There are spaces between each symbol:
    *_ _ Q _
    *Q _ _ _
    *_ _ _ Q
    *_ Q _ _
    *excludes the characters up to the comment(*)
    */
    public String toString(){
        String all = "";
        for (int i = 0; i < board.length; i ++){
            String row = "";
            for (int j = 0; j < board[i].length; j ++){
                if (board[i][j] == -1){
                    row += "Q ";
                } else {
                    row += "_ ";
                }
            }
            all += row + "\n";
        }
        return all;
    }

    public void toStringTesting(){
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] == -1){
                    System.out.print("Q ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }



    /**
     *@return true when the queen added correctly, false Otherwise
    *@precondition r and c are valid indices of the board array
    *@postcondition the board is only changed when the function returns true
    * in which case the queen is added and all it's threatened positions are incremented
    */
    private boolean addQueen(int r, int c){
        return modifyQueen(r, c, 1);
    }

    private boolean modifyQueen(int r, int c, int inc){
        if (board[r][c] == 0 || inc == -1) {
            board[r][c] -= inc;
            for (int horz = -1; horz < 2; horz ++) {
                int rcopy = r;
                int ccopy = c;
                while (inBounds(rcopy+1, ccopy+horz, board)){
                     rcopy++;
                     ccopy+=horz;
                     board[rcopy][ccopy] += inc;
                }
            }
            return true;
        }
        return false;
    }

    private boolean inBounds(int r, int c, int[][] board){
        int side = board.length;
        if (r < side && c > -1 && c < side) return true;
        return false;
    }
    /**Remove the queen that was added to r,c
     *@precondition r and c are valid indices of the board array and there is a queen at position r,c
    *@postcondition the board is modified to remove that queen and all it's
    *threatened positions are decremented
    */
    private void removeQueen(int r, int c){
        modifyQueen(r, c, -1);
    }

    /**Find the first solution configuration possible for this size board. Start by placing
     *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
    *  move the previous queen to the next valid space. This means everyone will generate the same
    *  first solution.
    *@postcondition: the board remains in a solved state.
    *@return false when the board is not solveable and leaves the board filled with zeros;
    *        returns true when the board is solveable, and leaves the board in a solved state
    *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
    */
    public boolean solve(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j]!=0){
                    throw new IllegalStateException();
                }
            }
        }
        return solve(0);
    }

    public boolean solve(int r){
        if (r == board.length){
            return true;
        } else {
            for (int c = 0; c < board.length; c++){
                if (addQueen(r, c)){
                    if(animated){
                        System.out.println(Text.go(1,1));
                        System.out.println(this);//can modify here
                        Text.wait(delay);
                    }
                    if(solve(r+1)) return true;
                    removeQueen(r, c);
                }
            }
            return false;
        }
    }


    /**Find all possible solutions to this size board.
     *@return the number of solutions found, and leaves the board filled with only 0's
    *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
    */
    public int countSolutions(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j]!=0){
                    throw new IllegalStateException();
                }
            }
        }
        return countSolutions(0);
    }

    public int countSolutions(int r){
        if (r == board.length){
            return 1;
        } else {
            int count = 0;
            for (int c = 0; c < board.length; c++){
                if (addQueen(r, c)){
                    count += countSolutions(r+1);
                    removeQueen(r, c);
                }
            }
            return count;
        }
    }
}
