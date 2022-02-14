public class Driver {
    public static void main(String[] args) {
        QueenBoard b = new QueenBoard(7);
        b.addQueen(0,2);
        b.addQueen(0,0);
        b.removeQueen(0,2);
        b.toStringTesting();   
    }
}
