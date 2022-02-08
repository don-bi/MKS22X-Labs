public class challenges {
    public static void main(String[] args) {
        System.out.println(partialSum(new int[]{5,2,3,4,7}, 299));
    }

    /*public static String toWords(int n){
        String[] ones = {"zero","one","two","three","four","five",
                        "six","seven","eight","nine","ten"};
        String[] tens = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen",
                        "seventeen","eighteen","nineteen","twenty"};
        if (n == 0){
            return ones[n];
        } else if (n <= 10 && n > 0){
            return ones[n];
        } else if (n > 10 && n <= 20){
            return tens[n - 10];
        } else if (n > 20 && m < 30){
            return "twenty" 
        }
            else {
            return n%10 + sumDigits(n/10);
        }
    }*/

    public static boolean partialSum(int[] arr,int targetValue){
        return partialSum(0, arr, targetValue);
    }

    public static boolean partialSum(int start,int[] arr,int targetValue){
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
