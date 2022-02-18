import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
        try{
            System.out.println(twoToString(fileToMap("Maze1.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("no file bruh");
        }
    }

    public static boolean solve(char[][] map, int r, int c){
        if (map[r][c]=='E'){
            return true;
        } else {
            if ()
        }
        
    }
    public static char[][] fileToMap(String f) throws FileNotFoundException{
        ArrayList<char[]> tempmap = new ArrayList<char[]>(); 
        File file = new File(f);
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] row = line.split("");
            char[] rowchar = stringArrToChar(row);
            tempmap.add(rowchar);
        }
        return alistToArray(tempmap);
    }

    public static String twoToString(char[][] a){
        String result = "[";
        for (int i = 0; i < a.length; i ++) {
            result += "[";
            for (int j = 0; j < a[i].length; j ++){
                result += a[i][j];
                if (i != a[i].length-1) result += ",";
            }
            if (i != a.length-1) result += "],\n";
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

    public static char[][] alistToArray(ArrayList<char[]> a){
        char[][] map = new char[a.size()][];
        for (int i = 0; i < a.size(); i ++){
            map[i] = a.get(i);
        }
        return map;
    }
}
