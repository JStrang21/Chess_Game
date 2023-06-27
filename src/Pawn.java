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
        return false;
        /*if (isFirstMove) {
            //If not using diagonal attack: Y will stay the same
            if (desY == curY) {
                //Loop through squares moved
                for (int i = curX + 1; i < desX; i++) {
                    //If path to destination is empty but destination square occupied by opposite color then okay
                    if ((i + 1 == desX) && (b[i + 1][curY].isOccupied)) {
                        Piece occupyingPiece = b[i + 1][curY].getPiece();
                        //If color of piece occupying square is opposite piece moving than move okay
                        if (occupyingPiece.getColorInt() != this.color) {
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                    //If any square other than destination is occupied than cannot move
                    if (b[i][curY].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }*/
        /*if (isFirstMove) {
            //If not using diagonal attack: Y will stay the same
            if (desY == curY) {
                //If moving two squares
                if (desX - curX == 2) {
                    //If first square occupied by either color or second square occupied by same color, then cannot move to second square
                    if (b[curX + 1][curY].isOccupied) {
                        return false;
                    }

                }
                //If moving one square
                if (desX - curX == 1) {

                }
            }
        }
        //Else it moves one square
        else {
            if ((curX == desX) && (curY + 1 == desY)) {
                return true;
            }
            else {
                return false;
            }
        }*/
    }

    @Override
    String getName() {
        return name;
    }
}
