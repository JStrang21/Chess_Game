public class Knight extends Piece {
    String name = "Knight";

    public Knight(int c) {
        //Constructor to specify color
        color = c;
    }

    @Override
    boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();

        //if (desX )
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
