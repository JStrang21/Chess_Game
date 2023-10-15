public class Knight extends Piece {
    String name = "Knight";

    public Knight(int c) {
        //Constructor to specify color
        color = c;
    }

    @Override
    public String getNameString() {
        return name;
    }

    @Override
    boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();

        //If movement(2 square movement) is above/below
        if (Math.abs(desX - curX) == 2) {
            if (Math.abs(desY - curY) == 1) {
                return true;
            }
            return false;
        }
        //If movement(2 square movement) is to right/left
        if (Math.abs(desX - curX) == 1) {
            if (Math.abs(desY - curY) == 2) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
