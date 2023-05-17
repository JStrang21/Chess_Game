public class Queen extends Piece {
    String name = "Queen";

    public Queen(int c) {
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
