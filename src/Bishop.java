public class Bishop extends Piece {
    String name = "Bishop";

    public Bishop(int c) {
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
