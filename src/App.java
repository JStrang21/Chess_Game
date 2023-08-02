import java.lang.Math;

public class App {
    public static void main(String[] args) {
        Game g = new Game(1);
        //Mixed up X and Y coords initially
//          y  y  y  y  y  y  y  y
//          0  1  2  3  4  5  6  7
// x      0
// x      1
// x      2 wR                   bR
// x      3
// x      4
// x      5
// x      6
// x      7


        //Rook tests
        Piece bRook = new Rook(2);
        Piece wRook = new Rook(1);
        Piece wPawn = new Pawn(1);
        Piece bPawn = new Pawn(2);

        g.board.board[2][0].addPiece(wRook);
        wRook.setCoords(2,0);
        g.board.board[2][7].addPiece(bRook);
        bRook.setCoords(2,7);
        g.board.board[2][1].addPiece(wPawn);
        wPawn.setCoords(2,1);
        /*g.board.board[2][6].addPiece(bPawn);
        bPawn.setCoords(2,6);*/

        //Before move
        Piece rookOne = g.board.getPiece(2, 0);
        Piece rookTwo = g.board.getPiece(2, 7);
        //Piece wPawn = g.board.getPiece(2, 3);
        //Piece pTwo = g.board.getPiece(2, 4);


        //Left to right
        //g.board.movePiece(2, 0, 2, 7);
        //Top to bottom
        //g.board.movePiece(2,0,5,0);
        //Left to right with piece inbetween
        g.board.movePiece(2,7,3,0);


        //After move
        System.out.println(rookOne.getX() + " " + rookOne.getY() + " " + rookOne.getColor() + " " + rookOne.getName());
        System.out.println(rookTwo.getX() + " " + rookTwo.getY() + " " + rookTwo.getColor() + " " + rookTwo.getName());

















    }
}
