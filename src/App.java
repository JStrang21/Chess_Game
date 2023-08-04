import java.lang.Math;

public class App {
    public static void main(String[] args) {
        Game g = new Game(1);
        //Mixed up X and Y coords initially
//          y  y  y  y  y  y  y  y
//          0  1  2  3  4  5  6  7
// x      0
// x      1
// x      2
// x      3
// x      4
// x      5
// x      6
// x      7

        g.board.movePiece(7,1,5,2);
        g.board.printBoard();
        g.board.movePiece(1,1,3,1);
        g.board.printBoard();
        g.board.movePiece(5,2,3,1);
        g.board.printBoard();

    }
}
