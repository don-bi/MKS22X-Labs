import java.util.ArrayList;
import java.util.Arrays;

public class MazeGenerator {

    public static void main(String[] args) {
        printarl(makeDir(5, 3));
    }

    public static void generate(char[][] maze,int row, int col){
        clearTerminal();
        generate(maze, row, col, 0, 0, true);
    }
    public static void generate(char[][] maze,int row, int col, int prevrow, int prevcol, boolean animate){
        if (maze[row][col] == '#' && checkConditions(maze, row, col, prevrow, prevcol)){
            maze[row][col] = ' ';
            if(animate){
                gotoTop();
                printMaze(maze);
                wait(200);
            }
            ArrayList<int[]> dir = makeDir(row, col);
            for (int i = 0; i < dir.size(); i ++){
                generate(maze, dir.get(i)[0], dir.get(i)[1], row, col, true);
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
        for (int i = 4; i > 0; i --){
            int rand = (int)(Math.random()*i);
            int[] coords = dir.remove(rand);
            randdir.add(coords);
        }
        return randdir;
    }

    private static boolean checkConditions(char[][]m,int r,int c,int pv,int pc){
        boolean bool = true;
        bool = r != 0 && 
        r != m.length-1 && 
        c != 0 && 
        c != m[0].length-1;
        if (bool) {
            int[][] dirs = {{r+1,c},{r-1,c},{r,c+1},{r,c-1},{r+1,c+1},{r+1,c-1},{r-1,c+1},{r-1,c-1}};
            for (int i = 0; i < dirs.length; i ++){
                if (dirs[i][0] != pv && dirs[i][1] != pc){
                    bool = m[dirs[i][0]][dirs[i][1]] != ' ';
                }
            }
        }
        return bool;
    }
    
    private static void printarl(ArrayList<int[]> a){
        for (int i = 0; i < a.size(); i ++){
            System.out.println(Arrays.toString(a.get(i)));;
            System.out.println(" ");
        }
    }

    private static void wait(int millis){
        try {
        Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    
    
    public static void clearTerminal(){
        //erase terminal
        System.out.println("\033[2J");
    }
    public static void gotoTop(){
        //go to top left of screen
        System.out.println("\033[1;1H");
    }

    public static void printMaze(char[][] maze){
        for (int i = 0; i < maze.length; i ++){
            for (int j = 0; j < maze[i].length; j ++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
