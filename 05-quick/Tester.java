import java.util.Arrays;
public class Tester {
    public static void main(String[] args) {
        if (args.length > 2){
            int[] n = new int[args.length];
            for (int i = 0; i < args.length; i ++){
                n[i] = Integer.parseInt(args[i]);
            }
        } else {
            int [] n = new int[300];
            for (int i = 0; i < n.length; i ++){
                n[i] = (int)(Math.random()*50);
            }
            if (args[0].equals("partition")){
                int a = Quick.partition(n,0,n.length-1);
                boolean bool = true;
                for (int i = 0; i < n.length; i ++){
                    if (i < a){
                        bool = n[i] <= n[a];
                    } else if (i > a){
                        bool = n[i] >= n[a];
                    }
                }
                if (bool){
                    System.out.println("regular partition works");
                } else {
                    System.out.println("XXX regular partition sucks");
                    System.out.println(Arrays.toString(n));
                }
            } else if (args[0].equals("dutch")){
                int[] a = Quick.partitionDutch(n, 0, n.length-1);
                boolean bool = true;
                for (int i = 0; i < n.length; i ++){
                    if (i < a[0]){
                        bool = n[i] < n[0];
                    } else if (i > a[1]){
                        bool = n[i] > n[1];
                    } else {
                        bool = n[i] == n[0];
                    }
                }
                if (bool){
                    System.out.println("dutch partition works");
                } else {
                    System.out.println("XXX dutch partition sucks");
                    System.out.println(Arrays.toString(n));
                }
            } else if (args[0].equals("quicksort")){
                int[] b = Arrays.copyOf(n, n.length);
                Arrays.sort(b);
                Quick.quicksort(n);
                boolean bool = true;
                for (int i = 0; i < n.length; i ++){
                    if (b[i] != n[i]){
                        bool = false;
                    }
                }
                if (bool){
                    System.out.println("quicksort works");
                } else {
                    System.out.println("XXX quicksort sucks");
                    System.out.println(Arrays.toString(n));
                }
            } else if (args[0].equals("select")){
                int[] b = Arrays.copyOf(n, n.length);
                Arrays.sort(b);
                int rand = (int)(Math.random()*n.length);
                if (Quick.quickselect(n, rand) == b[rand]){
                    System.out.println("quickselect works");
                } else {
                    System.out.println("XXX quickselect sucks");
                    System.out.println(Arrays.toString(n));
                }
            }
        }
    }
    
}
