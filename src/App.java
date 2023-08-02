import java.lang.Math;

public class App {
    public static void main(String[] args) {
        Game g = new Game(1);
        //Mixed up X and Y coords initially
//          y  y  y  y  y  y  y  y
//          0  1  2  3  4  5  6  7
// x      0
// x      1
// x      2       wK
// x      3
// x      4    bK    bP
// x      5
// x      6
// x      7


        //Knight tests
        Piece bKnight = new Knight(2);
        Piece wKnight = new Knight(1);
        Piece wPawn = new Pawn(1);
        Piece bPawn = new Pawn(2);

        g.board.board[2][2].addPiece(wKnight);
        wKnight.setCoords(2,2);
        g.board.board[1][4].addPiece(bKnight);
        bKnight.setCoords(1,4);
        g.board.board[1][2].addPiece(bPawn);
        wPawn.setCoords(3,4);

        g.board.movePiece(2,2,1,4);


        //After move
        wKnight.print();
        bKnight.print();
        bPawn.print();

















    }
}
