public class Knight extends Piece {
    String name = "Knight";

    public Knight(int c) {
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
