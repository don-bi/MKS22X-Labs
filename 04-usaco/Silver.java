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
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
    }


}
