import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] one = {2,2,2,3,6,7};
        int[] two = {1,2,3,5,8,10};
        System.out.println(Arrays.toString(merge(one,two)));
    }
    public static int [] merge(int [] left, int[] right){
        //return a new array that is the merged version of left and right
        int[] temp = new int[left.length + right.length];
        int lt = 0;
        int rt = 0;
        for (int i = 0; i < temp.length; i ++){
            if (rt >= right.length){
                temp[i] = left[lt];
                lt ++;
            } else if (lt >= left.length){
                temp[i] = right[rt];
                rt ++;
            } else if (left[lt] < right[rt]){
                temp[i] = left[lt];
                lt ++;
            } else if (left[lt] > right[rt]){
                temp[i] = right[rt];
                rt ++;
            } else {
                temp[i] = left[lt];
                lt ++;
            }
        }
        return temp;
      }

      /*public static void mergesort(int [] data){
        int [] temp  =  mergeSortH(data);
        copy temp into data
      }

      public static int[] mergesortH(int [] data){
        if more than 1 element{
          left = copy half of data
          right = copy other half of data
          sort each half and merge them together
        }
      }*/
}
