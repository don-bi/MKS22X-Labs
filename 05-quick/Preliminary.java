import java.util.Arrays;

public class Preliminary {
    public static void main(String[] args) {
        int[] a = {999,999,999,4,3,2,1,0,5,6,3,4,3,2,999,999,999};
        System.out.println(partition(a, 3, 13));
        System.out.println(Arrays.toString(a));
    }
    public static int partition ( int [] data, int start, int end){
        int rand = (int)(Math.random()*(end-start+1))+start;
        //System.out.println(rand);
        int temp = data[start];
        data[start] = data[rand];
        data[rand] = temp;
        int P = start;
        int equaltimes = 0;
        //System.out.println(data[start]);
        start++;
        while (start < end) {
            //System.out.println("before: " + Arrays.toString(data));
            //System.out.println(P + " start: " + start + " end: " + end);
            if (data[start] < data[P] || (equaltimes % 2 == 0 && data[start] == data[P])){
                if (data[start] == data[P]){
                    equaltimes ++;
                }       
                start++;
            } else if (data[start] > data[P] || (equaltimes % 2 == 1 && data[start] == data[P])){
                if (data[start] == data[P]){
                    equaltimes ++;
                }
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
                end--;
            }
            //System.out.println("after: " + Arrays.toString(data));
            //System.out.println(P + " start: " + start + " end: " + end);
        }
        temp = data[start];
        data[start] = data[P];
        data[P] = temp;
        return end;
    }

}
