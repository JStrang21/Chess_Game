public class Game {
    Player white;
    Player black;
    Chessboard board;
    boolean won = false;

    public Game(int i) {
        //Substantiate playerOne with 1 as paramater to indicate that it's the human player
        if (i == 1) {
            //One player game
            white = new Player(i);
            black = new Player();
            //int 1 represents white && int 2 represents black
            white.color = 1;
            white.turn = true;
            black.color = 2;
            black.turn = false;

            board = new Chessboard(white, black);
        }
        else if (i == 2) {
            //Two player game
            white = new Player(i);
            black = new Player(i);
        }
    }

    /*public void printRemovedPieces() {
        for (Piece p : board.removedPieces) {
            System.out.println(p.getColor() + " " + p.getNameString());
        }
    }*/

    public boolean checkWin() {
        //printRemovedPieces();
        //TODO: Checkmate logic
        //If either list of removed pieces has 16 that means all pieces of that side have been taken
        if (board.removedPiecesWhite.size() == 16) {
            won = true;
            board.winner = "White";
            return true;
        }
        if (board.removedPiecesBlack.size() == 16) {
            won = true;
            board.winner = "Black";
            return true;
        }

        //TODO: not working
        /*if (board.inCheckMate()) {
            won = true;
            if (board.black.isTurn()) {
                board.winner = "White";
            }
            else {
                board.winner = "Black";
            }
            return true;
        }*/
        //Check for king in lists
        if (board.checkForRemovedKing()) {
            won = true;
            return true;
        }


        return false;
    }
}
