public class codingbat {
    public static void main(String[] args) {
        System.out.println(groupSum6(0, new int[]{5,6,2}, 7));
    }

    public static boolean groupSum(int start, int[] nums, int target){
        if (0 == target){
            return true;
        } else if (start >= nums.length){
            return false;
        } else {
            return groupSum(start+1, nums, target-nums[start]) ||
                groupSum(start+1, nums, target);
        }
    }

    //splitarray ------
    public static boolean splitArray(int[] nums){
        return splitArray(0, nums, 0);
    }

    public static boolean splitArray(int start, int[] nums, int value){
        if (start == nums.length){
            if (value == 0){
                return true;
            }
            return false;
        } else {
            return splitArray(start+1, nums, value+nums[start]) ||
                splitArray(start+1, nums, value-nums[start]);
        }
    }

    //groupsum6------
    public static boolean groupSum6(int start, int[] nums, int target){
        if (start >= nums.length){
            if (0 == target) return true;
            return false;
        } else if (nums[start] == 6) {
            return groupSum6(start+1, nums, target-nums[start]);
        } else if (0 == target){
            return true;
        } else {
                return groupSum6(start+1, nums, target-nums[start]) ||
                groupSum6(start+1, nums, target);
        }
    }
}
