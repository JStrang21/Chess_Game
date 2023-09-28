import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        //launch(args);
        Game g = new Game(1);
        //Mixed up X and Y coords initially
        //White top of board/Black bottom of board
//          a  b  c  d  e  f  g  h
//          0  1  2  3  4  5  6  7
// 8      0
// 7      1
// 6      2
// 5      3
// 4      4
// 3      5
// 2      6
// 1      7
        /*
        Bugs:
        -Crashes when pawn moves diagonal to space with no piece:illegal move but don't want crashing
         */
        System.out.println("Enter original piece square, space, where you want piece to move");
        System.out.println("Ex: b7 b6");
        //While game has not been won continue game
        boolean gameWon = false;
        while (!gameWon) {
            Scanner input = new Scanner(System.in);
            String src = null;
            String des = null;
            //TODO account for wrong input: crashes when input is wrong
            if (g.white.isTurn()) {
                System.out.println("White player enter originating piece square: ");
                src = input.next();
                System.out.println("Enter destination square: ");
                des = input.next();
            }
            else if (g.black.isTurn()) {
                System.out.println("Black player enter originating piece square: ");
                src = input.next();
                System.out.println("Enter destination square: ");
                des = input.next();
            }

            g.board.movePiece(src, des);
            g.board.printBoard();
            gameWon = g.checkWin();
            g.printRemovedPieces();
        }
        //g.board.movePiece("b7", "b6");
        g.board.printBoard();
    }

}

