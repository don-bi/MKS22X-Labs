import java.util.NoSuchElementException;
import java.util.ArrayDeque;
public class Tester {
    public static void main(String[] args) {
        /*MyDeque<Integer> a = new MyDeque<Integer>(5);
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.addFirst(5);
        a.addFirst(6);
        a.addFirst(7);
        a.removeFirst();
        a.removeFirst();
        a.printDebug();
        System.out.println(a);
        System.out.println(a.getFirst());
        System.out.println(a.getLast());*/
        System.out.println(test6(50));
        MyDeque<Integer> zawarudo = new MyDeque<Integer>(1);
    }
    public static boolean equals(MyDeque<Integer>a, ArrayDeque<Integer>b){
        if(a==null && b==null)
          return true;
        if(a==null || b==null)
            return false;
        if(a.size()!=b.size())
          return false;
        if(a.size()==0 && b.size()==0)
          return true;
    
        try{
          while(b.size()>0){
            if(!a.removeFirst().equals(b.removeFirst())){
              return false;
            }
          }
        }catch(NoSuchElementException e){
          return false;
        }
        return b.size()==0;
      }
    
      public static int test6(int max){
        MyDeque<Integer> a = new MyDeque<Integer>();
        ArrayDeque<Integer>b = new ArrayDeque<Integer>();
    
        for(int i = 0; i < max; i++){
            System.out.println(a);
          int op = (int)(Math.random()*4);
          if(op == 0){
            a.addLast(i);
            b.addLast(i);
            //System.out.println("added last " + i);
          }
          try {
          if(op == 1){
            a.addFirst(i);
            b.addFirst(i);
            //System.out.println("added first " + i);
          }
          } catch (ArrayIndexOutOfBoundsException e){
              System.out.println(i);
          }
          if(op == 2){
            if(b.size()>0){
                try {
                if(! a.getLast().equals(b.getLast())){
                    System.out.println("Fail test6a last"+a.getLast()+" vs "+b.getLast());
                    a.printDebug();
                    System.out.println(b);
                    return 0;
                }
                //System.out.print("removed last ");
                //System.out.println(a.removeLast());
                a.removeLast();
                b.removeLast();
                } catch (NullPointerException e){
                    System.out.println("nullpoint");
                    a.printDebug();
                }
            }
          }
          if(op == 3){
            if(b.size()>0){
                try{
              if(! a.getFirst().equals(b.getFirst())){
                System.out.println("Fail test6a first"+a.getFirst()+" vs "+b.getFirst());
                a.printDebug();
                System.out.println(b);
                return 0;
              }
              //System.out.print("removed first ");
              //System.out.println(a.removeFirst());
              a.removeFirst();
              b.removeFirst();
            } catch (NullPointerException e){
                System.out.println("nullpoint 125");
                a.printDebug();
            }
            }
          }
        }
        if( equals(a,b) ){
          System.out.println("good");
          return 1;
        }
        System.out.println("Fail test6 end");
        return 0;
    }
}