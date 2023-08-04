import java.lang.Math;

public class App {
    public static void main(String[] args) {
        Game g = new Game(1);
        //Mixed up X and Y coords initially
//          y  y  y  y  y  y  y  y
//          0  1  2  3  4  5  6  7
// x      0
// x      1
// x      2 wB
// x      3
// x      4
// x      5          bB
// x      6
// x      7


        //Knight tests
        Piece bBishop = new Bishop(2);
        Piece wBishop = new Bishop(1);
        g.board.board[5][3].addPiece(bBishop);
        bBishop.setCoords(5,3);
        g.board.board[2][0].addPiece(wBishop);
        wBishop.setCoords(2,0);

        Piece wPawn = new Pawn(1);
        Piece bPawn = new Pawn(2);
        g.board.board[7][1].addPiece(bPawn);
        bPawn.setCoords(7,1);

        g.board.movePiece(5,3,1,0);


        //After move
        bBishop.print();
        wBishop.print();
        bPawn.print();

















    }
}
