import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Silver {
    public static long solve(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner scan = new Scanner(filename);
        int r = scan.nextInt();
        int c = scan.nextInt();
        int[][] map = new int[r][c];
        int t = scan.nextInt();
        for (int i = 0; i < r; i ++){
            String[] currentline = scan.nextLine().split("");
            for (int j = 0; j < currentline.length; j ++){
                if (currentline[j].equals("*")){
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        int y1 = scan.nextInt();
        int x1 = scan.nextInt();
        int y2 = scan.nextInt();
        int x2 = scan.nextInt();    
    }

    private static void step(int[][] a){
        int[][] copy = copyMap(a);
        for (int i = 0; i < a.length; i ++){
            for (int j = 0; j < a[i].length; j ++){
                int[][] dir = {{i+1,j},{i-1,j},{i,j+1},{i,j-1}};
                if (copy[i][j] > 0){
                    for (int d = 0; d < dir.length; d ++){
                        int ycor = dir[d][0];
                        int xcor = dir[d][1];
                        if (copy[ycor][xcor] != -1){
                            a[ycor][xcor]
                        }
                    }
                }
            }
        }
    }

    private static int[][] copyMap(int[][] a){
        int[][] copy = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i ++){
            for (int j = 0; j < a[i].length; j ++){
                copy[i][j] = a[i][j]; 
            }
        }
        return copy;
    }

}
