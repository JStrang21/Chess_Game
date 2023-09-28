public class Pawn extends Piece {
    String name = "Pawn";
    boolean isFirstMove = true;
    boolean diagonalAttack = false;

    public Pawn(int c) {
        //Constructor to specify color
        color = c;
    }
    @Override
    public boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();
        if (color == 1 && desX - curX > 1) {
            return false;
        }
        if (color == 2 && desX - curX > 1) {
            return false;
        }
        //If no occupying piece
        if (occupyingPiece == null && Math.abs(curY - desY) == 0 && Math.abs(curX - desX) == 2 && isFirstMove) {
            isFirstMove = false;
            return true;
        }
        /*//White pawn
        if (color == 1 && occupyingPiece == null && Math.abs(curY - desY) == 0) {
            if (curX - desX < 1) {
                return false;
            }
        }
        if (color == 2 && occupyingPiece == null && Math.abs(curY - desY) == 0) {
            if (curX - desX > -1) {
                return false;
            }
        }
        if (occupyingPiece == null && Math.abs(curY - desY) == 0 && desX - curX 1 && color == 1) {
            return true;
        }
        if (occupyingPiece == null && Math.abs(curY - desY) == 0 && curX - desX == 1 && color == 2) {
            return true;
        }*/
        //If pieces are same color cannot move
        if (occupyingPiece.getColorInt() == color) {
            return false;
        }
        //TODO account for diagonal move to attack enemy piece
        //TODO account for en passant
        if (desY == curY) {
            //If first move of pawn than 2 squares allowed (second condition bc only allowed when not using diagonal attack)
            if (Math.abs(desX - curX) == 2 && isFirstMove) {
                //Check if other pieces between
                if (b[curX + 1][curY].isOccupied) {
                    //If a piece is between than cannot move
                    return false;
                }
                isFirstMove = false;
                return true;
            }
            else if (Math.abs(desX - curX) == 1 && occupyingPiece != null) {
                return false;
            }
            //If just moving one square
            else if (Math.abs(desX - curX) == 1) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            //Can only go one space up in en passant
            if (Math.abs(desX - curX) == 1 && Math.abs(desY - curY) == 1) {
                isFirstMove = false;
                diagonalAttack = true;
                return true;
            }
            else {
                return false;
            }
        }
    }

    @Override
    String getName() {
        return name;
    }
}
