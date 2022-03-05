import java.util.ArrayList;
import java.util.Arrays;

public class MazeGenerator {

    public static void main(String[] args) {
        printarl(makeDir(5, 3));
    }

    public static void generate(char[][] maze,int row,int col){
        generate(maze, row, col, 0, 0, false);
    }

    public static void generateAnimate(char[][] maze,int row, int col){
        clearTerminal();
        generate(maze, row, col, 0, 0, true);
    }
    public static void generate(char[][] maze,int row, int col, int prevrow, int prevcol, boolean animate){
        if (maze[row][col] == '#' && isValid(maze, row, col, prevrow, prevcol)){
            //System.out.println("passes: [" + row + ", " + col + "]");
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

    //Method to randomly put the four directions in an array
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

    //checks if space is out of bounds or has less than two blanks around it
    public static boolean isValid(char[][]m,int r,int c,int pr,int pc){
        boolean bool = true;
        bool = r != 0 && 
        r != m.length-1 && 
        c != 0 && 
        c != m[0].length-1;
        int countspace = 0;
        if (bool) {
            for (int incr = -1; incr < 2; incr ++){
                for (int incc = -1; incc < 2; incc ++){
                    //System.out.println("check: [" + (r + incr) + ", " + (c + incc) + "]" + m[r + incr][c + incc]);
                    if (!(r + incr == pr && c + incc == pc)){
                        if(m[r + incr][c + incc] == ' '){
                            countspace ++;
                        } 
                    }
                }
            }
        }
        //System.out.println(countspace);
        return bool && countspace < 2;
    }
    
    //prints array list (testing makeDir)
    private static void printarl(ArrayList<int[]> a){
        for (int i = 0; i < a.size(); i ++){
            System.out.println(Arrays.toString(a.get(i)));;
            System.out.println(" ");
        }
    }

    //animate methods
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
