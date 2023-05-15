public class App {
    public static void main(String[] args) {
        Game g1 = new Game(1);
        // g1.board.movePiece(0, 0, 0, 1);
        Piece p = g1.board.getPiece(0, 0);
        System.out.println(p);
    }
}
