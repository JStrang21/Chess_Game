public class Rook extends Piece {
    String name = "Rook";

    public Rook(int c) {
        //Constructor to specify color
        color = c;
    }
    @Override
    boolean canMove(Square[][] b, int desX, int desY) {
        //TODO account for swapping places with king when both haven't moved
        Piece occupyingPiece = b[desX][desY].getPiece();
        //If rook is moving down/up (yaxis)
        if (desY == curY) {
            int distance = Math.abs(desX - curX);
            /*for (int i = 1; i < distance - 1; i++) {
                if (desX > curX && b[curX + i][curY].isOccupied) {
                    return false;
                }
                if (curX < desX && b[curX - i][curY].isOccupied) {
                    return false;
                }
            }
            return true;*/
            //Moving down
            if (desX > curX) {
                //If there's a piece inbetween the current and target square then cannot move
                for (int i = 1; i < distance; i++) {
                    if (b[curX + i][curY].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
            //Moving up
            if (desX < curX) {
                for (int i = 1; i < distance; i++) {
                    if (b[curX - i][curY].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
        }

        //If rook is moving right/left (xaxis)
        if (desX == curX) {
            int distance = Math.abs(desY - curY);

            //Moving right
            if (desY > curY) {
                for (int i = 1; i < distance; i++) {
                    if (b[curX][curY + i].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
            //Moving left
            if (desY < curY) {
                for (int i = 1; i < distance; i++) {
                    if (b[curX][curY - i].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
        }
        //No occupying piece and can move is either straight x or y
        if (occupyingPiece == null && (desX == curX || desY == curY)) {

        }
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
