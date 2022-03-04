import java.util.ArrayList;

public class MazeGenerator {
    public static void generate(char[][] maze,int row, int col){
        if (maze[row][col] == '#' && checkConditions(maze, row, col)){
            maze[row][col] = ' ';
            ArrayList<int[]> dir = makeDir(row, col);
            for (int i = 0; i < dir.size(); i ++){
                generate(maze, dir.get(i)[0], dir.get(i)[1]);
            } 
        } 
    }
    private static ArrayList<int[]> makeDir(int row, int col){
        ArrayList<int[]> dir = new ArrayList<int[]>();
        dir.add(new int[]{row+1,col});
        dir.add(new int[]{row-1,col});
        dir.add(new int[]{row,col+1});
        dir.add(new int[]{row,col-1});
        ArrayList<int[]> randdir = new ArrayList<int[]>();
        for (int i = 4; i > -1; i --){
            int rand = (int)(Math.random()*i);
            randdir.add(dir.get(rand));
        }
        return randdir;
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
