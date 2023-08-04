import java.lang.Math;

public class App {
    public static void main(String[] args) {
        Game g = new Game(1);
        //Mixed up X and Y coords initially
//          y  y  y  y  y  y  y  y
//          0  1  2  3  4  5  6  7
// x      0
// x      1
// x      2 bP       wB
// x      3
// x      4
// x      5 bB       wP
// x      6
// x      7

        //Queen tests
        Piece bQueen = new Queen(2);
        Piece wQueen = new Queen(1);
        g.board.board[5][0].addPiece(bQueen);
        bQueen.setCoords(5,0);
        g.board.board[2][3].addPiece(wQueen);
        wQueen.setCoords(2,3);

        Piece wPawn = new Pawn(1);
        Piece bPawn = new Pawn(2);
        g.board.board[5][3].addPiece(wPawn);
        wPawn.setCoords(5,3);
        g.board.board[2][0].addPiece(bPawn);
        bPawn.setCoords(2,0);

        g.board.movePiece(2,3,5,0);

        //After move
        wQueen.print();
        bQueen.print();
        //bPawn.print();
        //wPawn.print();
        System.out.println();



















    }
}
