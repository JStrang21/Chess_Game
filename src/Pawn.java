public class Pawn extends Piece {
    String name = "Pawn";
    boolean isFirstMove = true;

    public Pawn(int c) {
        //Constructor to specify color
        color = c;
    }
    @Override
    public boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();
        //If no occupying piece
        if (occupyingPiece == null) {
            isFirstMove = false;
            return true;
        }
        //If pieces are same color cannot move
        if (occupyingPiece.getColorInt() == color) {
            return false;
        }
        //TODO account for diagonal move to attack enemy piece
        //TODO account for en passant
        //If first move of pawn than 2 squares allowed (second condition bc only allowed when not using diagonal attack)
        if (desX - curX == 2 && desY == curY && isFirstMove) {
            //Check if other pieces between
            if (b[curX + 1][curY].isOccupied) {
                //If a piece is between than cannot move
                return false;
            }
            isFirstMove = false;
            return true;
        }
        //If just moving one square
        else if (desX - curX == 1 && desY == curY) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    String getName() {
        return name;
    }
}
