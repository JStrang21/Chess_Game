public class Bishop extends Piece {
    String name = "Bishop";

    public Bishop(int c) {
        //Constructor to specify color
        color = c;
    }

    @Override
    boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();
        int disX = Math.abs(desX - curX);
        int disY = Math.abs(desY - curY);

        if (disX != disY) {
            return false;
        }

        //Moving down
        if (desX > curX) {
            //int larger = getLarger(disX, disY);
            //Moving down & right
            if (desY > curY) {
                for (int i = 1; i < disX; i++) {
                    if (b[curX + i][curY + i].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
            //Moving down and left
            if (curY > desY) {
                for (int i = 1; i < disX; i++) {
                    if (b[curX + i][curY - i].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
        }
        //Moving up
        if (desX < curX) {
            //Moving up and left
            if (desY < curY) {
                for (int i = 1; i < disX; i++) {
                    if (b[curX - i][curY - i].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
            //Moving up and right
            if (desY > curY) {
                for (int i = 1; i < disX; i++) {
                    if (b[curX - i][curY + i].isOccupied) {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }

    public int getLarger(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    @Override
    String getName() {
        return name;
    }
}
