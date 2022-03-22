import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] one = {2};
        int[] two = {1};
        int[] test = {2,3,24,1,6,8,3,2,5,6};
        mergesort(test);
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(merge(one, two)));
        
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

      public static void mergesort(int [] data){
        int [] temp = mergesortH(data);
        for (int i = 0; i < data.length; i ++){
            data[i] = temp[i];
        }
      }

      public static int[] mergesortH(int [] data){
        if (data.length > 1){
          int[] left = new int[data.length/2];
          int[] right = new int [data.length-left.length];
          for (int i = 0; i < data.length; i++){
              if (i < left.length){
                  left[i] = data[i];
              } else {
                  right[i-left.length] = data[i]; 
              }
          }
          return merge(mergesortH(left), mergesortH(right));
        } else {
            return data;
        }
      }

      public static int[] mergesortH(int[] data, int[] temp){

      }
      public static void merge(int[]destination,int[]temp,int leftIndex,int rightIndex,int middleIndex){
        for (int i = 0; i < destination.length; i ++){
            if (leftIndex >= middleIndex){
                destination[i] = temp[rightIndex];
                rightIndex --;
            } else if (rightIndex >= middleIndex){
                destination[i] = temp[leftIndex];
                leftIndex ++;
            } else if (temp[leftIndex] < temp[rightIndex]){
                destination[i] = temp[leftIndex];
                leftIndex ++;
            } else if (temp[leftIndex] > temp[rightIndex]){
                destination[i] = temp[rightIndex];
                rightIndex --;
            } else {
                destination[i] = temp[leftIndex];
                leftIndex ++;
            }
        }
        return temp;    
      }

      
}
