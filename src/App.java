public class App {
    public static void main(String[] args) {
        Game g = new Game(1);



        //Additional pawns to add
        Piece blackPawn = new Pawn(2);
        Piece whitePawn = new Pawn(1);
        //Add pawn to square
        //g.board.board[3][0].addPiece(blackPawn);
        g.board.board[3][0].addPiece(whitePawn);
        //Test Pawn movement
        g.board.movePiece(1, 0, 3, 0);

        Piece pawn = g.board.getPiece(3, 0);
        System.out.println(pawn.getX() + " " + pawn.getY() + " " + pawn.getColor());













        //Print Test
        /*Piece WhiteQueen = g1.board.getPiece(0, 3);
        Piece BlackBishopRight = g1.board.getPiece(7, 5);
        System.out.println(WhiteQueen.getColor() + " " + WhiteQueen.getName());
        System.out.println(BlackBishopRight.getColor() + " " + BlackBishopRight.getName());*/

    }
}
