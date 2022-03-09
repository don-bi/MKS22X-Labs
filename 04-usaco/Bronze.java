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
            int r = scan.nextInt();
            int c = scan.nextInt();
            int[][] field = new int[r][c];
            int elevation = scan.nextInt();
            int inputs = scan.nextInt();
            for (int i=0; i < r; i++){
                for (int j=0; j < c; j++){
                    field[i][j] = scan.nextInt();
                }
            }
            int Rs = scan.nextInt();
            int Cs = scan.nextInt();
            int Ds = scan.nextInt();


        } catch (FileNotFoundException e){
            System.out.println("lol");
        }

    }

    private static void stomp(int[][] field, int r, int c, int d){
        int num = findHighest(field, r, c) - d;
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j ++){
                if (field[r+i][j+c] > num){
                    field[r+i][j+c] = num;
                }
            }
        }
    }

    private static int findHighest(int f, int r, int c){
        int highest = 0;
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j ++){
                int current = field[r+i][j+c];
                if (current > highest){
                    highest = current;
                }
            }
        }
        return highest;
    }
}
