public class Rook extends Piece {
    String name = "Rook";

    public Rook(int c) {
        //Constructor to specify color
        color = c;
    }
    @Override
    boolean canMove(Square[][] b, int desX, int desY) {
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
