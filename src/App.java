import java.lang.Math;

public class App {
    public static void main(String[] args) {
        Game g = new Game(1);
//          y y y y y y y y
//          0  1  2  3  4  5  6  7
// x      0
// x      1
// x      2 wP w1
// x      3 bP b1
// x      4
// x      5
// x      6
// x      7

    //Additional pawns to add
        Piece blackPawn = new Pawn(2);
        Piece whitePawn = new Pawn(1);
        Piece w1 = new Pawn(1);
        Piece b1 = new Pawn(2);
        //Add pawn to square
        g.board.board[2][0].addPiece(whitePawn);
        whitePawn.setCoords(2,0);
        g.board.board[3][0].addPiece(blackPawn);
        blackPawn.setCoords(3,0);
        g.board.board[2][1].addPiece(w1);
        w1.setCoords(2, 1);
        g.board.board[3][1].addPiece(b1);
        b1.setCoords(3, 1);

        //Test Pawn movement
        g.board.movePiece(2, 0, 3, 1);


        Piece pawn = g.board.getPiece(2, 0);
        System.out.println(pawn.getX() + " " + pawn.getY() + " " + pawn.getColor() + " " + pawn.getName());

        Piece pawnTwo = g.board.getPiece(3, 1);
        System.out.println(pawnTwo.getX() + " " + pawnTwo.getY() + " " + pawnTwo.getColor() + " " + pawnTwo.getName());

        //Piece pawnThree = g.board.getPiece(1, 0);
        //System.out.println(pawnThree.getX() + " " + pawnThree.getY() + " " + pawnThree.getColor());


















        //Print Test
        /*Piece WhiteQueen = g1.board.getPiece(0, 3);
        Piece BlackBishopRight = g1.board.getPiece(7, 5);
        System.out.println(WhiteQueen.getColor() + " " + WhiteQueen.getName());
        System.out.println(BlackBishopRight.getColor() + " " + BlackBishopRight.getName());*/

    }
}
