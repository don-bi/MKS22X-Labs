public class codingbat {
    public static void main(String[] args) {
        
    }

    public static boolean groupSum(){
        if (0 == targetValue){
            return true;
        } else if (start >= arr.length){
            return false;
        } else {
            return partialSum(start+1, arr, targetValue-arr[start]) ||
                partialSum(start+1, arr, targetValue);
        }
    }
}
