public class challenges {
    public static void main(String[] args) {
        
    }

    public static String toWords(int n){
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
    }
}
