public class Queen extends Piece {
    String name = "Queen";

    public Queen(int c) {
        //Constructor to specify color
        color = c;
    }

    @Override
    boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();

        //If movement is like rook
        if (desX == curX || desY == curY) {
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
                if (curX > desX) {
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
            return false;
        }

        //If movement is like bishop
        if (desX != curX && desY != curY) {
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
        }
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}
