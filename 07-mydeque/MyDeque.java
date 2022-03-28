public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start, end;

    
    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        start = data.length/2;
        end = start + 1;
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
        for (int i = start; i <= end; i ++){
            s += data[i];
            if (i != end){
                s += ", ";
            }
        }
        return s + "]";
    }
    public void addFirst(E element){ }
    public void addLast(E element){ }
    public E removeFirst(){ }
    public E removeLast(){ }
    public E getFirst(){ }
    public E getLast(){ }

    private void reisze(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[data.length*2+1];
        start = d.length/2;
        int i = start;
        for (int times = 0; times < data.length; times ++){
            if (i > data.length){
                i = 0;
            }
            d[start+times] = data[i];
            end = start + times;
        }
        data = d;
    }
}
