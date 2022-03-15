import java.util.Arrays;

public class Preliminary {
    public static void main(String[] args) {
        /*int [] data = new int[] {997,998,999,4,3,2,1,0};
        System.out.println("Original: "+Arrays.toString(data));
        int pivot = partition( data , 3, 7);
        System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
        System.out.println("Modified: "+Arrays.toString(data));
        System.out.println();*/
        int[] ary = {2, 10, 15, 23, 0, 5};
        //sorted(ary): {0, 2, 5, 10, 15, 23}
        System.out.println(quickselect(ary, 1));
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
        int start = 0;
        int end = data.length-1;
        int indexP = partition(data, start, end);
        while (indexP != k){
            if (indexP < k){
                start = indexP+1;
                indexP = partition(data, start, end);
            } else if (indexP > k){
                end = indexP-1;
                indexP = partition(data, start, end);
            }
        }
        return indexP;
    }

}
