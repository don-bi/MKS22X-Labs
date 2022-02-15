public class Driver {
    public static void main(String[] args) {
        QueenBoard b = new QueenBoard(8);
        System.out.println(Text.CLEAR_SCREEN);
        System.out.println(Text.HIDE_CURSOR);
        System.out.println(Text.go(1,1));
        b.solve();
        System.out.println(Text.RESET);
    }
}
