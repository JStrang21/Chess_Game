public class Player {
    //If player object is human than game will wait for player to make move
    public boolean human;
    int color;
    boolean turn;

    public Player(int i) {
        //If player is instantiated with i as paramater rather than no parameter than that object is human playable
        human = true;
    }

    public boolean isTurn() {
        if (turn) {
            return true;
        }
        return false;
    }

    public boolean inCheck(Chessboard board, int color) {
        //Get king
        King king = null;
        if (color == 1) {
            king = board.getWhiteKing();
        }
        else if (color == 2) {
            king = board.getBlackKing();
        }
        int kingColor = color;
        //Iterate through board and to find enemy pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //Check if square has piece occupying it
                if (board.board[i][j].isOccupied) {
                    //If there is a piece
                    Piece targetPiece = board.board[i][j].getPiece();
                    //If piece is opposite of king's color and can move to king position then king cannot move to spot
                    if (targetPiece.getColorInt() != kingColor && targetPiece.canMove(board.board, king.curX, king.curY)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Player() {
        human = false;
    }
}
