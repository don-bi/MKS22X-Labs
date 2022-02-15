public class Driver {
    public static void main(String[] args) {
        QueenBoard b = new QueenBoard(8);
        b.solve();
        System.out.println(b.toString());
    }
}
