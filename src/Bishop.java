public class Bishop extends Piece {
    String name = "Bishop";

    @Override
    boolean canMove(int desX, int desY) {
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
