import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze {
    public static void main(String[] args) {
        System.out.println(solve("makelake.in"));
    }

    public static long solve(String filename){
        int[][] field = new int[0][0];
        int elevation = 0;
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            int r = scan.nextInt();
            int c = scan.nextInt();
            field = new int[r][c];
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
            System.out.println("lol");
        }
        return depthFinder(field, elevation);
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

    private static int findHighest(int[][] field, int r, int c){
        int highest = 0;
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j ++){
                int current = field[r+i][c+j];
                if (current > highest){
                    highest = current;
                }
            }
        }
        return highest;
    }

    private static long depthFinder(int[][] field, int elevation){
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
    public static void printar(int[][]a ){
        for (int[] ar : a){
            for (int n : ar){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

