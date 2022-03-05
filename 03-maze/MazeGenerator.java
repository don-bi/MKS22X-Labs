import java.util.ArrayList;
import java.util.Arrays;

public class MazeGenerator {

    public static void main(String[] args) {
        printarl(makeDir(5, 3));
    }

    public static void generate(char[][] maze,int row,int col){
        maze[row][col] = 'S';
        generate(maze, row, col, 0, 0, false);
        addEnd(maze,row,col);
    }

    public static void generateAnimate(char[][] maze,int row, int col){
        clearTerminal();
        generate(maze, row, col, 0, 0, true);
    }
    private static void generate(char[][] maze,int row, int col, int prevrow, int prevcol, boolean animate){
        if (maze[row][col] == '#' && isValid(maze, row, col, prevrow, prevcol)){
            //System.out.println("passes: [" + row + ", " + col + "]");
            if (maze[row][col] != 'S'){
                maze[row][col] = ' ';
            }
            if(animate){
                gotoTop();
                printMaze(maze);
                wait(200);
            }
            ArrayList<int[]> dir = makeDir(row, col);
            for (int i = 0; i < dir.size(); i ++){
                generate(maze, dir.get(i)[0], dir.get(i)[1], row, col, animate);
            } 
        }
    }

    private static void addEnd(char[][] maze, int row, int col){
        int[] furthest = {0,0};
        int highestcount = 0;
        for (int i = 0; i < maze.length; i ++){
            for (int j = 0; j < maze[i].length; j ++){
                if (maze[i][j] != '#'){
                    maze[i][j] = 'E';
                    if (solve(maze, row, col) > highestcount){
                        furthest = new int[]{i,j};
                    }
                    maze[i][j] = ' ';
                }
            }
        }
        maze[furthest[0]][furthest[1]] = 'E';
    }

    private int solve(char[][] maze, int row, int col){
        if (maze[row][col] != 'S' && maze[row][col] != ' '){
            if (maze[row][col] == 'E') return 0;
            return -1; 
        } else {
            maze[row][col] = '@';
 
            int[][] dir = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
            for (int i = 0; i < dir.length; i ++){
                int s = solve(maze, dir[i][0],dir[i][1]);
                if (s > -1) {
                    return s + 1;
                }
            }
            maze[row][col] = '.';
            return -1;
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
    private static boolean isValid(char[][]m,int r,int c,int pr,int pc){
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
                        if(m[r + incr][c + incc] == ' ' || m[r +incr][c + incc] == 'S'){
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

    private static void printMaze(char[][] maze){
        for (int i = 0; i < maze.length; i ++){
            for (int j = 0; j < maze[i].length; j ++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
