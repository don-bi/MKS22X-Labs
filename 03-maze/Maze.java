import java.util.*;
import java.io.*;
public class Maze{
private char[][]maze;
private boolean animate;//false by default
private int startRow,startCol;

/*Constructor loads a maze text file, and sets animate to false by default.
When the file is not found then:
throw a FileNotFoundException

You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
'#' - Walls - locations that cannot be moved onto
' ' - Empty Space - locations that can be moved onto
'E' - the location of the goal if any (0 or more per file)
'S' - the location of the start(exactly 1 per file)

You may also assume the maze has a border of '#' around the edges.
So you don't have to check for out of bounds!
Some text editors always include a newline at the end of a file, but that is not always present.
Make sure your file reading is able to handle this.
*/
public Maze(String filename) throws FileNotFoundException{
    //COMPLETE CONSTRUCTOR
    ArrayList<char[]> tempmap = new ArrayList<char[]>(); 
    File file = new File(filename);
    Scanner scan = new Scanner(file);
    while(scan.hasNextLine()){
        String line = scan.nextLine();
        String[] row = line.split("");
        char[] rowchar = stringArrToChar(row);
        tempmap.add(rowchar);
    }
    maze = alistToArray(tempmap);
    animate = false;
    int[] cords = findCords(maze, 'S');
    startRow = cords[0];
    startCol = cords[1];
}

public static char[] stringArrToChar(String[] a){
    char[] ans = new char[a.length];
    for (int i = 0; i < a.length; i ++) {
        if (a[i].length() > 0){
            ans[i] = a[i].charAt(0);
        }
    }
    return ans;
}

public static char[][] alistToArray(ArrayList<char[]> a){
    char[][] map = new char[a.size()][];
    for (int i = 0; i < a.size(); i ++){
        map[i] = a.get(i);
    }
    return map;
}

public static int[] findCords(char[][] a, char target){
    int[] cords = new int[2];
    for (int i = 0; i < a.length; i ++){
        for (int j = 0; j < a[i].length; j ++){
            if (a[i][j] == target){
                cords[0] = i;
                cords[1] = j;
            }
        }
    }
    return cords;
}

private void wait(int millis){
    try {
    Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
}

public void setAnimate(boolean b){
    animate = b;
}

public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
}
public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
}

/*Return the string that represents the maze.
It should look like the text file with some characters replaced.
*/
public String toString(){
    String result = "";
    for (int i = 0; i < maze.length; i ++){
        for (int j = 0; j < maze[i].length; j ++){
            result += maze[i][j];
        }
        if (i != maze.length - 1){
            result += "\n";
        }
    }
    return result;
}

/*Wrapper Solve Function returns the helper function
Note the helper function has the same name, but different parameters.
Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
*/
public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
    clearTerminal();
    }
    //start solving at the location of the s.
    return solve(startRow,startCol);

}

/*
Recursive Solve function:

A solved maze has a path marked with '@' from S to E.

Returns the number of @ symbols from S to E when the maze is solved,
Returns -1 when the maze has no solution.

Postcondition:
The 'S' is replaced with '@'
The 'E' remain the same
All visited spots that were not part of the solution are changed to '.'
All visited spots that are part of the solution are changed to '@'
*/
private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if (maze[row][col] != 'S' && maze[row][col] != ' '){
        if (maze[row][col] == 'E') return 0;
        return -1; 
    } else {
        maze[row][col] = '@';
        if(animate){
            gotoTop();
            System.out.println(this);
            wait(50);
        }
        int[][] dir = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
        for (int i = 0; i < dir.length; i ++){
            int s = solve(dir[i][0],dir[i][1]);
            if (s > -1) {
                return s + 1;
            }
        }
        maze[row][col] = '.';
        if(animate){
            gotoTop();
            System.out.println(this);
            wait(50);
        }
        return -1;
    }
    //COMPLETE SOLVE
}
}