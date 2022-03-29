import java.util.Arrays;

public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start, end;

    
    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        start = data.length/2;
        end = data.length/2;
        size = 0;
    }

    public MyDeque(int initialCapacity){  
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        start = data.length/2;
        end = start + 1;
        size = 0;
    }

    public int size(){ 
        return size;
    }
    public String toString(){ 
        String s = "[";
        int i = start;
        for (int times = 0; times < size(); times ++){
            if (i >= data.length){
                i = 0;
            }
            s += data[i];
            if (i != end){
                s += ", ";
            }
            i++;
        }
        return s + "]";
    }
    public void addFirst(E element){ 
        if (element == null){
            throw new NullPointerException();
        }
        if (size() == data.length){
            reisze();
        }
        if (start == 0){
            start = data.length;
        }
        if (size() == 0){
            data[start] = element;
            size++;
        } else {
            start--;
            data[start] = element;
            size++;
        }
    }
    public void addLast(E element){ 
        if (element == null){
            throw new NullPointerException();
        }
        if (size() == data.length){
            reisze();
        }
        if (end == data.length-1){
            end = -1;
        }
        if (size() == 0){
            data[end] = element;
            size++;
        } else {
            end++;
            data[end] = element;
            size++;
        }
    }
    public E removeFirst(){ 
        E temp = data[start];
        data[start] = null;
        start++;
        size--;
        if (start == data.length){
            start = 0;
        }
        return temp;
    }
    public E removeLast(){
        E temp = data[end];
        data[end] = null;
        end--;
        size--;
        if (end == -1){
            end = data.length-1;
        }
        return temp;
    }
    public E getFirst(){
        return data[start];
    }
    public E getLast(){ 
        return data[end];
    }

    private void reisze(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[data.length*2+1];
        int i = start;
        start = (d.length - data.length)/2;
        for (int times = 0; times < data.length; times ++){
            if (i >= data.length){
                i = 0;
            }
            d[start+times] = data[i];
            i++;
            end = start + times;
        }
        data = d;
    }

    public void printDebug(){
        System.out.println(Arrays.toString(data));
    }
}
