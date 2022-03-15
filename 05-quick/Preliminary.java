import java.util.Arrays;

public class Preliminary {
    public static void main(String[] args) {
        int[] a = {999,999,999,4,3,2,1,0,999,999,999};
        System.out.println(partition(a, 3, 7));
        System.out.println(Arrays.toString(a));
    }
    public static int partition ( int [] data, int start, int end){
        int rand = (int)(Math.random()*(end-start+1))+start;
        //System.out.println(rand);
        int temp = data[start];
        data[start] = data[rand];
        data[rand] = temp;
        //System.out.println(data[start]);
        start++;
        while (start <= end) {
            //System.out.println("before: " + Arrays.toString(data));
            int P = data[start-1];
            //System.out.println(P + " start: " + start + " end: " + end);
            if (data[start] < P){
                data[start-1] = data[start];
                data[start] = P;
                start++;
            } else if (data[start] > P){
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
                end--;
            }
            //System.out.println("after: " + Arrays.toString(data));
            //System.out.println(P + " start: " + start + " end: " + end);
        }
        return end;
    }

}
