import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class maze {
    public static void main(String[] args) {
        System.out.println(twoToString(fileToMap("Maze1.txt")));
    }

    public static char[][] solve(char[][] map, int r, int c){
        if (map[r][c] == 'E'){
            return map;
        } else {
            
        }
    }

    public static void move(char[][] map, int r, int c){
        if (map[r][c] == ' ') {
            return true;
        }
    }
    public static char[][] fileToMap(String f){
        char[][] map = new char[countLines(f)][];
        try {
            File file = new File(f);
            Scanner scan = new Scanner(file);
            int r = 0;}
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] row = line.split("");
                char[] rowchar = stringArrToChar(row);
                map[r] = rowchar;
                r ++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("no file bruh");
        }
        return map;
    }

    public static int countLines(String f){
        int count = 0;
        try {
            File file = new File(f);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                count ++;
                scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("no file bruh");
        }
        return count;
    }

    public static String twoToString(char[][] a){
        String result = "[";
        for (int i = 0; i < a.length; i ++) {
            result += Arrays.toString(a[i]);
            if (i != a.length-1) result += ",\n";
        }
        return result += "]";
    }

    public static char[] stringArrToChar(String[] a){
        char[] ans = new char[a.length];
        for (int i = 0; i < a.length; i ++) {
            ans[i] = a[i].charAt(0);
        }
        return ans;
    }

    public static int[] findCords(char[][] a, char target){
        int[] cords = new int[2];
        for (int i = 0; i < a.length; i ++){
            for (int j = 0; j < a.length; j ++){
                if (a[i][j] == target){
                    cords[0] = i;
                    cords[1] = j;
                }
            }
        }
        return cords;
    }
}
