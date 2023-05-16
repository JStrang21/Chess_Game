public class Pawn extends Piece {
    String name = "Pawn";

    public Pawn(int c) {
        //Constructor to specify color
        color = c;
    }
    @Override
    boolean canMove(int desX, int desY) {
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
