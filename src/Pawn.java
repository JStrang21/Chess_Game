public class Pawn extends Piece {
    String name = "Pawn";
    @Override
    boolean canMove(int desX, int desY) {
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
