import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[][]ary = new int[100000][32];
        for (int i = 0; i < ary.length; i ++) {
            for (int j = 0; j < ary[i].length; j ++){
                ary[i][j] = (int)(Math.random()*1000);
            }
        }
        //System.out.println("pivots: " + Arrays.toString(partitionDutch(ary,0,ary.length-1)));
        for (int i = 0; i < ary.length; i ++){
            quicksort(ary[i]);
        }
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
        if (hi - lo < 32){
            insertionSort(data, lo, hi);
        } else if (lo < hi){
            int[] p = partitionDutch(data, lo, hi);
            quicksort(data,lo,p[0]-1);
            quicksort(data,p[1]+1,hi);
        }
    }

    public static int[] partitionDutch(int[] data,int lo, int hi){
        int lt = lo;
        int i = lo+1;
        int rt = hi;
        //random value to beginning
        int rand = (int)(Math.random()*(hi-lo+1))+lo;
        int temp = data[lo];
        data[lo] = data[rand];
        data[rand] = temp;

        while (i <= rt){
            if (data[i] < data[lt]){
                temp = data[i];
                data[i] = data[lt];
                data[lt] = temp;
                lt++;
                i++;
            } else if (data[i] > data[lt]){
                temp = data[i];
                data[i] = data[rt];
                data[rt] = temp;
                rt--;
            } else {
                i++;
            }
        }
        return new int[]{lt,rt};

    }
    public static void insertionSort(int[]data, int start, int end) {
        /*Your implementation here*/
        for (int i = start+1; i < end; i ++) {
          //System.out.print(Arrays.toString(data));
          int temp = data[i];
          int predIndex = i - 1;
          while (predIndex != -1 && data[i] < data[predIndex]) {
            predIndex --;
          }
          predIndex ++;
          //System.out.println(predIndex + " " + i);
          for (int k = i; k > predIndex; k --) {
            data[k] = data[k - 1];
          }
          data[predIndex] = temp;
        }
       }

}
