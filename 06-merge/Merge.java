public class Merge {
    public static int [] merge(int [] left, int[] right){
        //return a new array that is the merged version of left and right
        int[] temp = new int[left.length + right.length];
        int lt = 0;
        int rt = 0;
        for (int i = 0; i < temp.length; i ++){
            if (left[lt] < right[rt]){
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

      public static void mergesort(int [] data){
        int [] temp  =  mergeSortH(data);
        copy temp into data
      }

      public static int[] mergesortH(int [] data){
        if more than 1 element{
          left = copy half of data
          right = copy other half of data
          sort each half and merge them together
        }
      }
}
