public class MazeGenerator {
    public static void generate(char[][]maze,int row, int col){
        if (maze[row][col] == '#' && checkConditions(maze, row, col)){
            maze[row][col] = ' ';
            int[][] dir = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
            int randdir = (int)(Math.random()*4);
            generate(randdir, row, col);
        } else {
        }
    }

    private static boolean checkConditions(char[][]m,int r,int c){
        return m[r+1][c] != ' ' &&
        m[r-1][c] != ' ' &&
        m[r][c+1] != ' ' &&
        m[r][c-1] != ' ' &&
        r != 0 && 
        r != m.length-1 && 
        c != 0 && 
        c != m[0].length-1; 
    }
}
