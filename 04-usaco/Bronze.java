import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze {
    public static void main(String[] args) {
        System.out.println(solve(args[0]));
    }

    public static long solve(String filename){
        long[][] field = new long[0][0];
        int elevation = 0;
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            int r = scan.nextInt();
            int c = scan.nextInt();
            field = new long[r][c];
            elevation = scan.nextInt();
            int inputs = scan.nextInt();
            for (int i=0; i < r; i++){
                for (int j=0; j < c; j++){
                    field[i][j]  = scan.nextInt();
                }
            }
            for (int times = 0; times < inputs; times ++){
                int Rs = scan.nextInt()-1;
                int Cs = scan.nextInt()-1;
                int Ds = scan.nextInt();
                stomp(field, Rs, Cs, Ds);
            }
            scan.close();
        } catch (FileNotFoundException e){
            return -1;
        }
        return depthFinder(field, elevation);
    }

    private static void stomp(long[][] field, int r, int c, int d){
        long num = findHighest(field, r, c) - d;
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j ++){
                if (field[r+i][j+c] > num){
                    field[r+i][j+c] = num;
                }
            }
        }
    }

    private static long findHighest(long[][] field, int r, int c){
        long highest = 0;
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j ++){
                long current = field[r+i][c+j];
                if (current > highest){
                    highest = current;
                }
            }
        }
        return highest;
    }

    private static long depthFinder(long[][] field, int elevation){
        long totaldeph = 0l;
        for (int i = 0; i < field.length; i ++){
            for (int j = 0; j < field[i].length; j ++){
                if (field[i][j] < elevation){
                    totaldeph += (elevation - field[i][j]);
                }
            }
        }
        return totaldeph * 72 * 72;
    }
    public static void printar(long[][]a ){
        for (long[] ar : a){
            for (long n : ar){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

