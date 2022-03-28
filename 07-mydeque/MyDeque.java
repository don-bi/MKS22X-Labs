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

    public int size(){ }
    public String toString(){ }
    public void addFirst(E element){ }
    public void addLast(E element){ }
    public E removeFirst(){ }
    public E removeLast(){ }
    public E getFirst(){ }
    public E getLast(){ }

    private void reisze(){

    }
  }
