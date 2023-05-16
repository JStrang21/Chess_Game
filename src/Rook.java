public class Rook extends Piece {
    String name = "Rook";

    @Override
    boolean canMove(int desX, int desY) {
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
