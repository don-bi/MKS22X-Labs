public class Preliminary {
    
    public static int partition ( int [] data, int start, int end){
        int rand = (int)(Math.random()*(end-start+1))+start;
        int temp = data[start];
        data[start] = data[rand];
        data[rand] = temp;
        start++;
        while (start != end) {
            int P = data[start-1];
            if (data[start] < P){
                data[start-1] = data[start];
                data[start] = P;
                start++;
            }
            if (data[start] > P){
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
                end++;
            }
        }
        return data[start];
    }

}
