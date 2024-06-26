import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;
  private Queue<int[]> frontier;
  private int firecount; 

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    return frontier.size() == 0;
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    int tempfirecount = 0;
    for (int burn = 0; burn < firecount; burn ++){
        int[] coords = frontier.remove();
        int r = coords[0];
        int c = coords[1];
        map[r][c] = ASH;
        int[][] directions = {{r+1,c},{r-1,c},{r,c+1},{r,c-1}};
        for (int i = 0; i < 4; i ++){
            int newr = directions[i][0];
            int newc = directions[i][1];
            if (inbounds(newr,newc) && map[newr][newc] == TREE){
                map[newr][newc] = FIRE;
                frontier.add(new int[]{newr, newc});
                tempfirecount++;
            }
        }
    }
    firecount = tempfirecount;
  }

  private boolean inbounds(int r,int c){
      return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
  }
  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     frontier = new ArrayDeque<int[]>();
     firecount = 0;
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        frontier.add(new int[]{i,0});
        firecount++;
      }
    }
  }



    public static void main(String[]args){
      if(args.length == 0){
        printTable();
      } else {
        int WIDTH = 20;
        int HEIGHT = 20;
        int DELAY = 200;
        double DENSITY = .7;
        if(args.length > 1){
          WIDTH = Integer.parseInt(args[0]);
          HEIGHT = Integer.parseInt(args[1]);
          DENSITY = Double.parseDouble(args[2]);
        }
        if(args.length > 3){
          DELAY = Integer.parseInt(args[3]);
        }
        BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


        int ans = b.animate(DELAY);//animate all screens
        System.out.println(ans);//print the final answer
      }

      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer
    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }

  //Stats stuff
  public static double averageOfNRuns(int n, double density, int size){
    double[] runs = new double[n];
    for (int iter = 0; iter < n; iter ++ ){
        BurnTrees b = new BurnTrees(size, size, density);
        runs[iter] = b.run();
    }
    double sum = 0;
    for (int i = 0; i < runs.length; i ++){
        sum += runs[i];
    }
    return sum/n;
}

public static void printTable(){
    int[] reps = {25};
    int[] sizes = {500};
    String s = "";
    String s2 = "";
    for (int rep : reps){
        for (int size : sizes){
            Hashtable<Double,Double> data = new Hashtable<Double,Double>();
            s += rep + " repititions " + size + " x " + size + " table\n\n";
            s += "density\t|\tticks\n";
            s += "-------------------------\n";
            double density = 0.0;
            while (density <= 1){
                Double avg = averageOfNRuns(rep, density, size);
                String avgst = String.format("%.2f",avg);
                s += String.format("%.2f",density) + "\t|\t" + avgst + "\n";
                density += 0.05;
                data.put(density, avg);
            }
            s += "\n\n\n";
            //below is 1% increments at maximum areas
            s2 += rep + " repititions " + size + " x " + size + " table\n\n";
            s2 += "density\t|\tticks\n";
            s2 += "-------------------------\n";
            density = 0.55;
            while (density <= 0.65){
                Double avg = averageOfNRuns(rep, density, size);
                String avgst = String.format("%.2f",avg);
                s2 += String.format("%.2f",density) + "\t|\t" + avgst + "\n";
                density += 0.01;
                data.put(density, avg);
            }
            s2 += "\n\n\n";

        }
    }
    System.out.println(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+s+s2);
}


}