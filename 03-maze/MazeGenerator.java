public class MazeGenerator {
    public static void generate(char[][]maze,int startrow, int startcol){
        if (maze[row][col] != '#'){
            
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
            return -1;
        }
    }
}
