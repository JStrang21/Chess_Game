public class App {
    public static void main(String[] args) {
        Game g = new Game(1);
//          0 1 2 3 4 5 6 7
//        0
//        1
//        2
//        3
//        4
//        5
//        6
//        7





    //Additional pawns to add
        Piece blackPawn = new Pawn(2);
        Piece whitePawn = new Pawn(1);
        //Add pawn to square
        //g.board.board[2][0].addPiece(whitePawn);
        //whitePawn.setCoords(2,0);
        g.board.board[3][0].addPiece(blackPawn);
        blackPawn.setCoords(3,0);

        //System.out.println(blackPawn.getX() + " " + blackPawn.getY() + " " + blackPawn.getColor());

        //Test Pawn movement
        g.board.movePiece(1, 0, 2, 0);
        g.board.movePiece(2, 0, 3, 0);


        Piece pawn = g.board.getPiece(3, 0);
        System.out.println(pawn.getX() + " " + pawn.getY() + " " + pawn.getColor());

        Piece pawnTwo = g.board.getPiece(2, 0);
        System.out.println(pawnTwo.getX() + " " + pawnTwo.getY() + " " + pawnTwo.getColor());

        Piece pawnThree = g.board.getPiece(1, 0);
        //System.out.println(pawnThree.getX() + " " + pawnThree.getY() + " " + pawnThree.getColor());


















        //Print Test
        /*Piece WhiteQueen = g1.board.getPiece(0, 3);
        Piece BlackBishopRight = g1.board.getPiece(7, 5);
        System.out.println(WhiteQueen.getColor() + " " + WhiteQueen.getName());
        System.out.println(BlackBishopRight.getColor() + " " + BlackBishopRight.getName());*/

    }
}
