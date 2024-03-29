public class King extends Piece{
    String name = "King";

    public King(int c) {
        //Constructor to specify color
        color = c;
    }

    @Override
    public String getNameString() {
        return name;
    }

    public boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();
        //King can only move one space
        if (Math.abs(desX - curX) > 1 || Math.abs(desY - curY) > 1) {
            return false;
        }
        //Cant move into check
        if (isInCheck(b, desX, desY)) {
            System.out.println("Cannot move King into check");
            return false;
        }
        if (occupyingPiece == null) {
            return true;
        }
        if (occupyingPiece.getColorInt() == color) {
            return false;
        }
        return true;
    }

    public boolean isInCheck(Square[][]b, int desX, int desY) {
        //Get color of king
        int kingColor = getColorInt();
        //Iterate through board and to find enemy pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //Check if square has piece occupying it
                if (b[i][j].isOccupied) {
                    //If there is a piece
                    Piece targetPiece = b[i][j].getPiece();
                    //If piece is opposite of king's color and can move to king position then king cannot move to spot
                    if (targetPiece.getColorInt() != kingColor && targetPiece.canMove(b, desX, desY)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
