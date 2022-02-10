public class challenges {
    public static void main(String[] args) {
        System.out.println(toWords(76245));
    }

    public static String toWords(int n){
        String[] ones = {"one","two","three","four","five",
                        "six","seven","eight","nine","ten"};
        String[] tens = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen",
                        "seventeen","eighteen","nineteen"};
        String[] tensbegin = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        if (n == 0){
            return "zero";
        } else if (n <= 10 && n > 0){
            return ones[n - 1];
        } else if (n > 10 && n < 20){
            return tens[n%10-1];
        } else if (n >= 20 && n < 100){
            if (n%10==0){
                return tensbegin[n/10-2];
            } else {
                return tensbegin[n/10-2] + "-" + toWords(n-n/10*10);
            }
        } else if (n >= 100 && n < 1000){
            if (n%10==0){
                return ones[n/100-1] + " hundred ";
            }
            return ones[n/100-1] + " hundred " + toWords(n-n/100*100);
        } else if (n >= 1000 && n < 1000000){
            if (n%10==0){
                return toWords(n/1000) + " thousand ";
            }
            return toWords(n/1000) + " thousand " + toWords(n-n/1000*1000);
        } return "";
    }

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
