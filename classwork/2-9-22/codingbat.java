public class codingbat {
    public static void main(String[] args) {
        
    }

    public static boolean groupSum(int start, int[] nums, int target){
        if (0 == target){
            return true;
        } else if (start >= nums.length){
            return false;
        } else {
            return partialSum(start+1, nums, target-nums[start]) ||
                partialSum(start+1, nums, target);
        }
    }
}
