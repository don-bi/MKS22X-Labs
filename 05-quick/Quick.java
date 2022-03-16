import java.lang.reflect.Array;
import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        /*int [] data = new int[] {997,998,999,4,3,2,1,0};
        System.out.println("Original: "+Arrays.toString(data));
        int pivot = partition( data , 3, 7);
        System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
        System.out.println("Modified: "+Arrays.toString(data));
        System.out.println();*/
        //sorted(ary): {0, 2, 5, 10, 15, 23}
        int[]ary = new int[20];
        for (int i = 0; i < ary.length; i ++) {
            ary[i] = (int)(Math.random()*20);
        }
        System.out.println(Arrays.toString(ary));
        quicksort(ary);
        System.out.println(Arrays.toString(ary));
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
        while (start <= end) {
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
        temp = data[end];
        data[end] = data[P];
        data[P] = temp;
        return end;
    }


    /*return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array may be modified. */
    public static int quickselect(int []data, int k){
        //System.out.println(Arrays.toString(data));
        int start = 0;
        int end = data.length-1;
        int indexP = partition(data, start, end);
        //System.out.println("indexP: " + indexP + " " + Arrays.toString(data));
        while (indexP != k){
            if (indexP < k){
                start = indexP+1;
                indexP = partition(data, start, end);
                //System.out.println("start: " + start + " indexP: " + indexP + " " + Arrays.toString(data));
            } else if (indexP > k){
                end = indexP-1;
                indexP = partition(data, start, end);
                //System.out.println("end: " + end + " indexP: " + indexP + " " + Arrays.toString(data));
            }
        }
        return data[indexP];
    }

    public static void quicksort(int[]data){
        quicksort(data,0,data.length-1);
      }
      
    public static void quicksort(int[]data,int lo,int hi){
        //your code.
        if (lo < hi){
            int p = partition(data, lo, hi);
            quicksort(data,lo,p-1);
            quicksort(data,p+1,hi);
        }
    }

}
