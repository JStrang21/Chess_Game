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

        g.board.board[2][0].addPiece(wRook);
        wRook.setCoords(2,0);
        g.board.board[2][7].addPiece(bRook);
        bRook.setCoords(2,7);

        //Before move
        Piece rookOne = g.board.getPiece(2, 0);
        Piece rookTwo = g.board.getPiece(2, 7);

        System.out.println(rookOne.getX() + " " + rookOne.getY() + " " + rookOne.getColor() + " " + rookOne.getName());
        System.out.println(rookTwo.getX() + " " + rookTwo.getY() + " " + rookTwo.getColor() + " " + rookTwo.getName());

        g.board.movePiece(2, 0, 2, 7);

        //After move
        System.out.println(rookOne.getX() + " " + rookOne.getY() + " " + rookOne.getColor() + " " + rookOne.getName());
        System.out.println(rookTwo.getX() + " " + rookTwo.getY() + " " + rookTwo.getColor() + " " + rookTwo.getName());

















    }
}
