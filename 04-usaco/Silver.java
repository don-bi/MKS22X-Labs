import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Silver {
    public static void main(String[] args) {
        try{
        System.out.println(solve("ctravel.in"));
        }catch(FileNotFoundException e){
            System.out.println("lol");
        }
    }
    public static long solve(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int r = scan.nextInt();
        int c = scan.nextInt();
        int[][] map = new int[r][c];
        int t = scan.nextInt();
        scan.nextLine();
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
        int y1 = scan.nextInt()-1;
        int x1 = scan.nextInt()-1;
        map[y1][x1] = 1;
        for(int times = 0; times < t; times ++){
            //clearTerminal();
            step(map);
            /*gotoTop();
            printar(map);
            wait(2000);*/
        }
        int y2 = scan.nextInt()-1;
        int x2 = scan.nextInt()-1;
        scan.close();
        return map[y2][x2];
    }

    private static void step(int[][] a){
        int[][] copy = copyMap(a);
        //goes through every erea
        for (int i = 0; i < a.length; i ++){
            for (int j = 0; j < a[i].length; j ++){
                int[][] dir = {{i+1,j},{i-1,j},{i,j+1},{i,j-1}};
                //makes four direction of a square that is stepped on stepped on
                if (copy[i][j] > 0){
                    for (int d = 0; d < dir.length; d ++){
                        int ycor = dir[d][0];
                        int xcor = dir[d][1];
                        if (inBounds(copy,ycor,xcor) && copy[ycor][xcor] != -1){
                            a[ycor][xcor] += copy[i][j];
                        }
                    }
                    a[i][j] = 0;
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

    public static void printar(int[][]a ){
        for (int[] ar : a){
            for (int n : ar){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static boolean inBounds(int[][] map, int r,int c){
        return r >= 0 && c >= 0 && r < map.length && c < map[0].length;
    }

    private static void wait(int millis){
        try {
        Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    
    
    public static void clearTerminal(){
        //erase terminal
        System.out.println("\033[2J");
    }
    public static void gotoTop(){
        //go to top left of screen
        System.out.println("\033[1;1H");
    }
}
