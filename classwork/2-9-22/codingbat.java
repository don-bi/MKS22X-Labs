public class codingbat {
    public static void main(String[] args) {
        System.out.println(split53(new int[]{5,3,8}));
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
        } else {
            if (nums[start] == 6) {
                return groupSum6(start+1, nums, target-nums[start]);
            } else {
                return groupSum6(start+1, nums, target-nums[start]) ||
                groupSum6(start+1, nums, target);
            }
        }
    }

    //groupnoadj
    public static boolean groupNoAdj(int start, int[] nums, int target){
        if (0 == target) return true;
        else if (start >= nums.length){
            return false;
        } else {
            return groupNoAdj(start+2, nums, target-nums[start]) ||
            groupNoAdj(start+1, nums, target) ;
        }
    }

    public static boolean splitOdd10(int[] nums){
        return splitOdd10(0, nums, 0, 0);
    }

    public static boolean splitOdd10(int start, int[] nums, int group1, int group2){
        if (start >= nums.length){
            if (group1 % 10 == 0 && group2 % 2 == 1) return true;
            return false;
        } else {
            return splitOdd10(start+1, nums, group1 + nums[start], group2) ||
                splitOdd10(start+1, nums, group1, group2 + nums[start]);
        }
    }

    public static boolean split53(int[] nums){
        return split53(0, nums, 0);
    }
    public static boolean split53(int start, int[] nums, int value){
        if (start >= nums.length){
            if (0 == value) return true;
            return false;
        } else {
            if (nums[start]%5==0){
                return split53(start+1, nums, value+nums[start]);
            } else if (nums[start]%3==0){
                return split53(start+1, nums, value-nums[start]);
            } else {
                return split53(start+1, nums, value+nums[start]) ||
                split53(start+1, nums, value-nums[start]);
            }
        }
    }
}
