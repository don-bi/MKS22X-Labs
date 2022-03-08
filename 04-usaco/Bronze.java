import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze {
    public static void main(String[] args) {
        
    }

    public static long solve(String filename){
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            int[] field = new int[scan.nextInt()][scan.nextInt()];
            int elevation = scan.nextInt();
            int inputs = scan.nextInt();
        } catch (FileNotFoundException e){
            System.out.println("lol");
        }

    }
}
