/*import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;*/
import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        //launch(args);
        Game g = new Game(1);
        //Mixed up X and Y coords initially
        //White top of board/Black bottom of board
//          a  b  c  d  e  f  g  h
//          0  1  2  3  4  5  6  7    y
// 8      0
// 7      1
// 6      2
// 5      3
// 4      4
// 3      5
// 2      6
// 1      7

//        x

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

            //TODO: make inCheckBlock and nonCheckBlock return src and des moves to moves[]
            String[] moves = new String[2];
            //TODO account for wrong input: crashes when input is wrong
            //Check logic: iterate through all possible moves for all pieces and check which moves get king out of check->if inputed move is same as one in list then acceptable move
            //List possible moves for piece that threatens king and possible moves for king and the spots king can move are available
            if (g.white.isTurn()) {
                g.white.isInCheck(g.board);
                if (g.white.inCheck) {
                    while (g.white.inCheck) {
                        //g.inCheckBlock(1, src, des, input);
                        System.out.println("White King in check, must get king out of check");
                        System.out.println("White player enter originating piece square: ");
                        src = input.next();
                        System.out.println("Enter destination square: ");
                        des = input.next();
                        if (g.board.movedOutOfCheck(src, des)) {
                            g.white.inCheck = false;
                            g.board.movePiece(src, des);
                            g.board.printBoard();
                            gameWon = g.checkWin();
                        }
                        else {
                            src = null;
                            des = null;
                        }
                    }
                }
                else {
                    //g.nonCheckBlock(1, src, des, input, gameWon);
                    System.out.println("White player enter originating piece square: ");
                    src = input.next();
                    System.out.println("Enter destination square: ");
                    des = input.next();
                    g.board.movePiece(src, des);
                    g.board.printBoard();
                    gameWon = g.checkWin();
                }
            }
            else if (g.black.isTurn()) {
                g.black.isInCheck(g.board);
                if (g.black.inCheck) {
                    while (g.black.inCheck) {
                        //g.inCheckBlock(2, src, des, input);
                        System.out.println("Black King in check, must get king out of check");
                        System.out.println("Black player enter originating piece square: ");
                        src = input.next();
                        System.out.println("Enter destination square: ");
                        des = input.next();
                        if (g.board.movedOutOfCheck(src, des)) {
                            g.black.inCheck = false;
                            g.board.movePiece(src, des);
                            g.board.printBoard();
                            gameWon = g.checkWin();
                        }
                        else {
                            src = null;
                            des = null;
                        }
                    }
                }
                else {
                    //g.nonCheckBlock(2, src, des, input, gameWon);
                    System.out.println("Black player enter originating piece square: ");
                    src = input.next();
                    System.out.println("Enter destination square: ");
                    des = input.next();
                    g.board.movePiece(src, des);
                    g.board.printBoard();
                    gameWon = g.checkWin();
                }
            }
            //TODO: add stalemate, checkMate logic

            /*g.board.movePiece(src, des);
            g.board.printBoard();
            gameWon = g.checkWin();
            //g.printRemovedPieces();

             */
        }
        if (gameWon) {
            System.out.println(g.board.winner + " wins the game");
        }
    }
}


